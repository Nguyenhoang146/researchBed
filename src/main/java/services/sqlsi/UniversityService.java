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
import models.sqlsi.SQLSIQueryModel;
import models.sqlsi.StudentModel;
import resources.Configuration;

public class UniversityService {

    static Connection con;
    static SqlSI sqlSI;

    public static ResultSet executeQuery(String scenario, String policy,
        String caller, String role, SQLSIQueryModel sqlsiQueryModel)
        throws Exception {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        refreshScenario(scenario);
//        refreshPolicy(policy);
        initSQLSI();
        createSecureStoredProcedure(sqlsiQueryModel);
        ResultSet resultSet = callSecureStoredProcedure(caller, role);
        con.close();
        return resultSet;
    }

    private static ResultSet callSecureStoredProcedure(String caller,
        String role) throws SQLException, NamingException {

        ResultSet actualResult = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        CallableStatement statement = con.prepareCall(
            String.format("{CALL SecQuery('%s','%s')}", caller, role));
        java.sql.ResultSet rs = statement.executeQuery();
        con.commit();
        return convertResultSet(actualResult, rows, rs);
    }

    private static ResultSet convertResultSet(ResultSet actualResult,
        List<ResultRow> rows, java.sql.ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();

        // collect column names
        List<String> columnNames = new ArrayList<>();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            columnNames.add(rsmd.getColumnLabel(i));
        }

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
        String secureStoredProcedure = sqlSI
            .getSecQuery(sqlsiQueryModel.getQuery());
        Statement stmt = con.createStatement();
        String drop = "DROP PROCEDURE IF EXISTS SecQuery;";
        secureStoredProcedure = secureStoredProcedure.replace(drop, "");
        String delimiterIn = "DELIMITER //";
        String delimiterOut = "DELIMITER ;";
        secureStoredProcedure = secureStoredProcedure.replace(delimiterIn, "");
        secureStoredProcedure = secureStoredProcedure.replace(delimiterOut, "");
        secureStoredProcedure = secureStoredProcedure.replace("//", ";");
        stmt.execute(drop);
        con.commit();
        stmt.execute(secureStoredProcedure);
        con.commit();
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
            statement = con.prepareCall("{CALL getVGU1()}");
            statement.executeQuery();
            con.commit();
            break;

        case "custom":
            break;

        default:
            statement = con.prepareCall("{CALL getVGU2()}");
            statement.executeQuery();
            con.commit();
            break;

        }
    }

    @SuppressWarnings("unused")
    private static void refreshPolicy(String policy) throws Exception {
        CallableStatement statement;
        switch (policy) {
        case "SecVGU#A":
            statement = con.prepareCall("{CALL getSecA()}");
            statement.executeQuery();
            con.commit();
            break;

        case "SecVGU#B":
            statement = con.prepareCall("{CALL getSecB()}");
            statement.executeQuery();
            con.commit();
            break;

        default:
            statement = con.prepareCall("{CALL getSecC()}");
            statement.executeQuery();
            con.commit();
            break;

        }
    }

    public static void insert(StudentModel studentModel)
        throws SQLException, NamingException {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String insertion = String.format(
            "INSERT INTO Student(Student_id,name,age) VALUES ('%s','%s','%s')",
            studentModel.getId(), studentModel.getName(),
            studentModel.getEmail());
        stmt.executeUpdate(insertion);
        con.close();
    }

    public static void insert(LecturerModel lecturerModel)
        throws SQLException, NamingException {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String insertion = String.format(
            "INSERT INTO Lecturer(Lecturer_id,name,age) VALUES ('%s','%s','%s')",
            lecturerModel.getId(), lecturerModel.getName(),
            lecturerModel.getEmail());
        stmt.executeUpdate(insertion);
        con.close();
    }

    public static void insert(EnrollmentModel enrollmentModel)
        throws SQLException, NamingException {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String insertion = String.format(
            "INSERT INTO Enrollment(students,lecturers) VALUES ('%s','%s')",
            enrollmentModel.getStudents(), enrollmentModel.getLecturers());
        stmt.executeUpdate(insertion);
        con.close();
    }

    public static void deleteStudent(String id)
        throws SQLException, NamingException {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String deletion = String
            .format("DELETE FROM Student WHERE Student_id = '%s'", id);
        stmt.executeUpdate(deletion);
        con.close();
    }

    public static void deleteLecturer(String id)
        throws SQLException, NamingException {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String deletion = String
            .format("DELETE FROM Lecturer WHERE Lecturer_id = '%s'", id);
        stmt.executeUpdate(deletion);
        con.close();
    }

    public static void delete(EnrollmentModel enrollmentModel)
        throws SQLException, NamingException {
        con = Configuration.getConnectionForSQLSI();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        String deletion = String.format(
            "DELETE FROM Enrollment WHERE students = '%s' AND lecturers = '%s'",
            enrollmentModel.getStudents(), enrollmentModel.getLecturers());
        stmt.executeUpdate(deletion);
        con.close();
    }

}
