/**************************************************************************
Copyright 2020 Vietnamese-German-University

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author: ngpbh
***************************************************************************/

package services.sqlsi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;

import org.json.simple.parser.ParseException;
import org.vgu.sqlsi.main.SqlSI;
import org.vgu.sqlsi.sec.SecurityMode;

import models.ResultRow;
import models.ResultSet;
import models.sqlsi.EnrollmentModel;
import models.sqlsi.LecturerModel;
import models.sqlsi.ObjectModel;
import models.sqlsi.SQLSIQueryModel;
import models.sqlsi.StudentModel;
import resources.Configuration;

public class UniversityService {

    static Connection con;
    static SqlSI sqlSI;

    public static ResultSet executeQuery(String scenario, String policy,
        String caller, String role, SQLSIQueryModel sqlsiQueryModel)
        throws Exception {
        try {
            con = Configuration.getConnectionForSQLSI();
            con.setAutoCommit(false);
            refreshScenario(scenario);
//        refreshPolicy(policy);
            initSQLSI();
            createSecureStoredProcedure(sqlsiQueryModel);
            CallableStatement statement = con.prepareCall(
                String.format("{CALL SecQuery('%s','%s')}", caller, role));
            ResultSet resultSet = convertResultSet(statement.executeQuery());
            con.commit();
            con.close();
            return resultSet;
        } catch (Exception e) {
            con.commit();
            con.close();
            throw e;
        }
    }

    private static ResultSet convertResultSet(java.sql.ResultSet rs)
        throws SQLException {
        ResultSet actualResult = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultSetMetaData rsmd = rs.getMetaData();

        // collect column names
        List<String> columnNames = new ArrayList<>();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            columnNames.add(rsmd.getColumnLabel(i));
        }
        actualResult.setHeaders(columnNames);

//        int rowIndex = 0;
        while (rs.next()) {
//            rowIndex++;
            // collect row data as objects in a List
            List<Object> rowData = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                rowData.add(rs.getObject(i));
            }
            // for test purposes, dump contents to check our results
            // (the real code would pass the "rowData" List to some
            // other routine)
//            System.out.printf("Row %d%n", rowIndex);
            ResultRow row = new ResultRow();
            HashMap<String, String> cols = new HashMap<String, String>();
            for (int colIndex = 0; colIndex < rsmd
                .getColumnCount(); colIndex++) {
//                String objType = "null";
                String objString = "";
                Object columnObject = rowData.get(colIndex);
                if (columnObject != null) {
                    objString = columnObject.toString();
//                    objType = columnObject.getClass().getName();
                }
//                System.out.printf("  %s: %s(%s)%n",
//                    columnNames.get(colIndex), objString, objType);
                cols.put(columnNames.get(colIndex), objString);
            }
            row.setCols(cols);
            rows.add(row);
        }
        actualResult.setRows(rows);
        return actualResult;
    }

    private static void createSecureStoredProcedure(
        SQLSIQueryModel sqlsiQueryModel) throws Exception {
        try {
            String secureStoredProcedure = sqlSI
                .getSecQuery(sqlsiQueryModel.getQuery());
            Statement stmt = con.createStatement();
            String drop = "DROP PROCEDURE IF EXISTS SecQuery;";
            secureStoredProcedure = secureStoredProcedure.replace(drop, "");
            String delimiterIn = "DELIMITER //";
            String delimiterOut = "DELIMITER ;";
            secureStoredProcedure = secureStoredProcedure.replace(delimiterIn,
                "");
            secureStoredProcedure = secureStoredProcedure.replace(delimiterOut,
                "");
            secureStoredProcedure = secureStoredProcedure.replace("//", ";");
            stmt.execute(drop);
            con.commit();
            stmt.execute(secureStoredProcedure);
            con.commit();
        } catch (Exception e) {
            con.commit();
            throw e;
        }

    }

    private static void initSQLSI()
        throws FileNotFoundException, IOException, ParseException, Exception {
        sqlSI = new SqlSI();
        sqlSI.setUpDataModelFromURL("sqlsi-resources/university-dm.json");
        sqlSI.setUpSecurityModelFromURL("sqlsi-resources/uni-policy-3.json");
        sqlSI.setMode(SecurityMode.NON_TRUMAN);
        sqlSI
            .generateSQLAuthFunctions("sqlsi-resources/sql-auth-functions.sql");
    }

    private static void refreshScenario(String scenario) throws Exception {
        CallableStatement statement;
        switch (scenario) {
        case "VGU1":
            try {
                statement = con.prepareCall("{CALL getVGU1()}");
                statement.executeQuery();
                con.commit();
            } catch (Exception e) {
                con.commit();
                throw e;
            }
            break;

        case "custom":
            break;

        default:
            try {
                statement = con.prepareCall("{CALL getVGU2()}");
                statement.executeQuery();
                con.commit();
            } catch (Exception e) {
                con.commit();
                throw e;
            }

            break;

        }
    }

    @SuppressWarnings("unused")
    private static void refreshPolicy(String policy) throws Exception {
        CallableStatement statement;
        switch (policy) {
        case "SecVGU#A":
            try {
                statement = con.prepareCall("{CALL getSecA()}");
                statement.executeQuery();
                con.commit();
            } catch (Exception e) {
                con.commit();
                throw e;
            }
            
            break;

        case "SecVGU#B":
            try {
            statement = con.prepareCall("{CALL getSecB()}");
            statement.executeQuery();
            con.commit();
            } catch (Exception e) {
                con.commit();
                throw e;
            }
            break;

        default:
            try {
            statement = con.prepareCall("{CALL getSecC()}");
            statement.executeQuery();
            con.commit();
            } catch (Exception e) {
                con.commit();
                throw e;
            }
            break;

        }
    }

    public static void insert(StudentModel studentModel)
        throws SQLException, NamingException {
        try {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String insertion = String.format(
            "INSERT INTO Student(Student_id,name,email) VALUES ('%s','%s','%s')",
            studentModel.getId(), studentModel.getName(),
            studentModel.getEmail());
        stmt.executeUpdate(insertion);
        con.commit();
        con.close();
        } catch (Exception e) {
            con.commit();
            con.close();
            throw e;
        }
    }

    public static void insert(LecturerModel lecturerModel)
        throws SQLException, NamingException {
        try {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String insertion = String.format(
            "INSERT INTO Lecturer(Lecturer_id,name,email) VALUES ('%s','%s','%s')",
            lecturerModel.getId(), lecturerModel.getName(),
            lecturerModel.getEmail());
        stmt.executeUpdate(insertion);
        con.commit();
        con.close();
        } catch (Exception e) {
            con.commit();
            con.close();
            throw e;
        }
    }

    public static void insert(EnrollmentModel enrollmentModel)
        throws SQLException, NamingException {
        try {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String insertion = String.format(
            "INSERT INTO Enrollment(students,lecturers) VALUES ('%s','%s')",
            enrollmentModel.getStudents(), enrollmentModel.getLecturers());
        stmt.executeUpdate(insertion);
        con.commit();
        con.close();
        } catch (Exception e) {
            con.commit();
            con.close();
            throw e;
        }
    }

    public static List<StudentModel> deleteStudent(String id)
        throws SQLException, NamingException {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        try {
            PreparedStatement stmt = con
                .prepareStatement("DELETE FROM Student WHERE Student_id = ?");
            stmt.setString(1, id);
            stmt.executeUpdate();
            con.commit();
            stmt.clearBatch();
            List<StudentModel> students = getStudents(stmt);
            con.commit();
            con.close();
            return students;
        } catch (SQLException e) {
            con.commit();
            con.close();
            throw e;
        }
    }

    public static List<LecturerModel> deleteLecturer(String id)
        throws SQLException, NamingException {
        try {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String deletion = String
            .format("DELETE FROM Lecturer WHERE Lecturer_id = '%s'", id);
        stmt.executeUpdate(deletion);
        con.commit();
        stmt.clearBatch();
        List<LecturerModel> lecturers = getLecturers(stmt);
        con.commit();
        con.close();
        return lecturers;
        } catch (Exception e) {
            con.commit();
            con.close();
            throw e;
        }
    }

    public static List<EnrollmentModel> delete(EnrollmentModel enrollmentModel)
        throws SQLException, NamingException {
        try {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String deletion = String.format(
            "DELETE FROM Enrollment WHERE students = '%s' AND lecturers = '%s'",
            enrollmentModel.getStudents(), enrollmentModel.getLecturers());
        stmt.executeUpdate(deletion);
        con.commit();
        stmt.clearBatch();
        List<EnrollmentModel> enrollments = getEnrollments(stmt);
        con.commit();
        con.close();
        return enrollments;
        } catch (Exception e) {
            con.commit();
            con.close();
            throw e;
        }
    }

    public static ObjectModel getAllData()
        throws SQLException, NamingException {
        try {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        ObjectModel om = new ObjectModel();
        Statement stmt = con.createStatement();
        om.setStudents(getStudents(stmt));
        om.setLecturers(getLecturers(stmt));
        om.setEnrollments(getEnrollments(stmt));
        con.commit();
        con.close();
        return om;
        } catch (Exception e) {
            con.commit();
            con.close();
            throw e;
        }
    }

    private static List<EnrollmentModel> getEnrollments(Statement stmt)
        throws SQLException {
        String enrollmentQuery = "SELECT students, lecturers FROM Enrollment";
        List<EnrollmentModel> enrollments = mapEnrollmentPOJOToModel(
            stmt.executeQuery(enrollmentQuery));
        stmt.clearBatch();
        return enrollments;
    }

    private static List<EnrollmentModel> mapEnrollmentPOJOToModel(
        java.sql.ResultSet rs) throws SQLException {
        List<EnrollmentModel> enrollments = new ArrayList<EnrollmentModel>();
        while (rs.next()) {
            EnrollmentModel enrollment = new EnrollmentModel();
            enrollment.setStudents(rs.getString("students"));
            enrollment.setLecturers(rs.getString("lecturers"));
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    private static List<StudentModel> getStudents(Statement stmt)
        throws SQLException {
        String studentQuery = "SELECT Student_id, name, email FROM Student";
        List<StudentModel> students = mapStudentPOJOToModel(
            stmt.executeQuery(studentQuery));
        stmt.clearBatch();
        return students;
    }

    private static List<StudentModel> mapStudentPOJOToModel(
        java.sql.ResultSet rs) throws SQLException {
        List<StudentModel> students = new ArrayList<StudentModel>();
        while (rs.next()) {
            StudentModel student = new StudentModel();
            student.setId(rs.getString("Student_id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            students.add(student);
        }
        return students;
    }

    private static List<LecturerModel> getLecturers(Statement stmt)
        throws SQLException {
        String lecturerQuery = "SELECT Lecturer_id, name, email FROM Lecturer";
        List<LecturerModel> lecturers = mapLecturerPOJOToModel(
            stmt.executeQuery(lecturerQuery));
        stmt.clearBatch();
        return lecturers;
    }

    private static List<LecturerModel> mapLecturerPOJOToModel(
        java.sql.ResultSet rs) throws SQLException {
        List<LecturerModel> lecturers = new ArrayList<LecturerModel>();
        while (rs.next()) {
            LecturerModel lecturer = new LecturerModel();
            lecturer.setId(rs.getString("Lecturer_id"));
            lecturer.setName(rs.getString("name"));
            lecturer.setEmail(rs.getString("email"));
            lecturers.add(lecturer);
        }
        return lecturers;
    }

    public static ObjectModel resetScenario() throws Exception {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        refreshScenario("VGU2");
        return getAllData();
    }
}
