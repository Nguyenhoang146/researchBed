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

package beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

import org.vgu.sqlsi.main.SqlSI;
import org.vgu.sqlsi.sec.SecurityMode;

import models.ResultRow;
import models.ResultSet;
import resources.Configuration;

@ManagedBean(name = "sqlsiBean")
@SessionScoped
public class SQLSIBean {
    /**
     * 
     */
    private String sqlStm;
    private String sql;
    private boolean descriptionMode;
    private long transformationTime;
    private String caller;
    private SqlSI sqlSI;

    public String getSqlStm() {
        return sqlStm;
    }

    public void setSqlStm(String sqlStm) {
        this.sqlStm = sqlStm;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean isDescriptionMode() {
        return descriptionMode;
    }

    public void setDescriptionMode(boolean descriptionMode) {
        this.descriptionMode = descriptionMode;
    }

    @PostConstruct
    public void init() {
        sqlStm = "SELECT email FROM Lecturer";
        sql = "";
        caller = "Manuel";
        descriptionMode = false;
        transformationTime = 0L;
        sqlSI = new SqlSI();
        try {
            sqlSI.setUpDataModelFromURL("sqlsi-resources/university-dm.json");
            sqlSI.setUpSecurityModelFromURL("sqlsi-resources/uni-policy-3.json");
        } catch (Exception e) {
            sql = "<b>There is a problem while setting up: @setUpDefaultModel.</b>";
            e.printStackTrace();
        }
        sqlSI.setMode(SecurityMode.NON_TRUMAN);
        try {
            sqlSI.generateSQLAuthFunctions("sqlsi-resources/sql-auth-functions.sql");
        } catch (Exception e) {
            sql = "<b>There is a problem while setting up: @generateAuthFunction.</b>";
            e.printStackTrace();
        }
    }

    public String map() {
        String secProc = "";
        try {
            secProc = sqlSI.getSecQuery(sqlStm);
            createStoredProcedure(secProc);
        } catch (Exception e) {
            sql = String.format(
                "<b>There is a problem while generating the stored procedure: %s</b>",
                sqlStm);
            e.printStackTrace();
        }
        String callStatement = String.format("{CALL SecQuery('%s','Lecturer')}",
            caller);
        ResultSet rs = executeStatement(callStatement);
        sql = rs.toHTMLString();
        return null;
    }

    private void createStoredProcedure(String sp)
        throws SQLException, NamingException {
        Connection con = Configuration.getConnectionForSQLSI();
        Statement stmt = con.createStatement();
        String drop = "DROP PROCEDURE IF EXISTS SecQuery;";
        sp = sp.replace(drop, "");
        String delimiterIn = "DELIMITER //";
        String delimiterOut = "DELIMITER ;";
        sp = sp.replace(delimiterIn, "");
        sp = sp.replace(delimiterOut, "");
        sp = sp.replace("//", ";");
        stmt.execute(drop);
        stmt.execute(sp);
    }

    private ResultSet executeStatement(String inputStatement) {
        try (Connection db = Configuration.getConnectionForSQLSI()) {
            ResultSet actualResult = new ResultSet();
            List<ResultRow> rows = new ArrayList<ResultRow>();
            CallableStatement statement = db.prepareCall(inputStatement);
            java.sql.ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            // collect column names
            List<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                columnNames.add(rsmd.getColumnLabel(i));
            }

//            int rowIndex = 0;
            while (rs.next()) {
//                rowIndex++;
                // collect row data as objects in a List
                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowData.add(rs.getObject(i));
                }
                // for test purposes, dump contents to check our results
                // (the real code would pass the "rowData" List to some
                // other routine)
//                System.out.printf("Row %d%n", rowIndex);
                ResultRow row = new ResultRow();
                HashMap<String, String> cols = new HashMap<String, String>();
                for (int colIndex = 0; colIndex < rsmd
                    .getColumnCount(); colIndex++) {
//                    String objType = "null";
                    String objString = "";
                    Object columnObject = rowData.get(colIndex);
                    if (columnObject != null) {
                        objString = columnObject.toString();
//                        objType = columnObject.getClass().getName();
                    }
//                    System.out.printf("  %s: %s(%s)%n",
//                        columnNames.get(colIndex), objString, objType);
                    cols.put(columnNames.get(colIndex), objString);
                }
                row.setCols(cols);
                rows.add(row);
            }
            actualResult.setRows(rows);
            return actualResult;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long getTransformationTime() {
        return transformationTime;
    }

    public void setTransformationTime(long transformationTime) {
        this.transformationTime = transformationTime;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }
}
