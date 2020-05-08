/**************************************************************************
Copyright 2019 Vietnamese-German-University

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

package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.core.Response;

import org.vgu.se.sql.parser.SQLParser;

import models.InputMappingDefaultModel;
import models.OutputMappingModel;
import models.ReportModel;
import models.ResultRow;
import models.ResultSet;
import models.ScenarioStatusModel;
import net.sf.jsqlparser.statement.Statement;
import resources.Configuration;
import utils.CallStatements;
import utils.Results;

public class TTCServices {

    public static Response assertStatement(Integer phase, Integer challenge,
        InputMappingDefaultModel model) {
        Statement statement = null;
        String inputStatement = null;
        if (model.getContentType().equals("statement/xml")) {
            final String dirPath = System.getProperty("java.io.tmpdir");
            BufferedWriter output = null;
            File file = null;
            try {
                file = new File(
                    dirPath.concat("//").concat("sqlStatement.xmi"));
                output = new BufferedWriter(new FileWriter(file));
                output.write(model.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        OutputMappingModel outputModel = new OutputMappingModel(
                            Response.Status.BAD_REQUEST.getStatusCode(), "",
                            String.format("%1$s: %2$s", e.getClass().getCanonicalName(), e.getMessage()));
                        return Response.status(Response.Status.BAD_REQUEST)
                            .entity(outputModel).build();
                    }
                }
            }
            String filePath = file.getAbsolutePath();
            try {
                statement = SQLParser
                    .transform(SQLParser.loadEStatement(filePath));
                inputStatement = statement.toString();
            } catch (Exception e) {
                e.printStackTrace();
                OutputMappingModel outputModel = new OutputMappingModel(
                    Response.Status.BAD_REQUEST.getStatusCode(), "",
                    String.format("%1$s: %2$s", e.getClass().getCanonicalName(), e.getMessage()));
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(outputModel).build();
            }
        } else if (model.getContentType().equals("statement/text")) {
            inputStatement = model.getContent();
        } else {
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Invalid content type.");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
        try {
            return assertPhaseChallenge(inputStatement, phase, challenge);
        } catch (Exception e) {
            e.printStackTrace();
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                String.format("%1$s: %2$s", e.getClass().getCanonicalName(), e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }


    private static Response assertPhaseChallenge(String inputStatement,
        Integer phase, Integer challenge) throws Exception {
        ReportModel outputModel = assertStatement(inputStatement, phase,
            challenge);
        return Response.status(Response.Status.OK).entity(outputModel).build();
    }

    private static ReportModel assertStatement(String inputStatement,
        Integer phase, Integer challenge) throws Exception {
        ReportModel outputModel = new ReportModel();
        List<ScenarioStatusModel> scenarii = new ArrayList<ScenarioStatusModel>();
        for (int i = 1; i <= 7; i++) {
            ScenarioStatusModel scenario = new ScenarioStatusModel();
            scenario.setScenario(i);
            prepareEnvironment(i);
            final long executionStartNanoTime = System.nanoTime();
            ResultSet actualResultSet = executeStatement(inputStatement);
            final long executionEndNanoTime = System.nanoTime();
//            ResultSet expectedResult = Results.getExpectedResult(phase,
//                challenge, i);
//            scenario.setStatus(
//                expectedResult.equals(actualResult) ? "passed" : "failed");
            List<String> expectedResult = Results.getExpectedResult(phase,
                challenge, i);
            List<String> actualResult = getActionResult(actualResultSet);
            scenario.setStatus(
              compare(expectedResult,actualResult) ? "passed" : "failed");
            scenario.setExecutionTime(
                executionEndNanoTime - executionStartNanoTime);
            scenarii.add(scenario);
        }
        outputModel.setScenarii(scenarii);
        return outputModel;
    }

    private static boolean compare(List<String> expectedResult,
        List<String> actualResult) {
        if(expectedResult.size() != actualResult.size())
            return false;
        else {
            Collections.sort(expectedResult);
            Collections.sort(actualResult);
            for(int i = 0; i < expectedResult.size(); i++) {
                if(!expectedResult.get(i).equals(actualResult.get(i)))
                    return false;
            }
        }
        return true;
    }

    private static List<String> getActionResult(ResultSet actualResultSet)
        throws Exception {
        List<String> actualResult = new ArrayList<String>();
        for (ResultRow row : actualResultSet.getRows()) {
            if (row.getCols().containsKey("res")) {
                actualResult.add(row.getCols().get("res"));
            } else
                throw new Exception("No res column defined in the given SQL statement");
        }
        return actualResult;
    }

    private static ResultSet executeStatement(String inputStatement) {
        try (Connection db = Configuration.getConnection()) {
            ResultSet actualResult = new ResultSet();
            List<ResultRow> rows = new ArrayList<ResultRow>();
            PreparedStatement st = db.prepareStatement(inputStatement);

            java.sql.ResultSet rs = st.executeQuery();
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

    private static void prepareEnvironment(Integer scenario) {
        String callStatement = CallStatements.get(scenario);
        try (Connection db = Configuration.getConnection()) {
            CallableStatement cs;
            cs = db.prepareCall(callStatement);
            cs.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
