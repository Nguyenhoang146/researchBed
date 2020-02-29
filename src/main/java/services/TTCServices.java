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
                            "TODO: Add exception description");
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
            } catch (IOException e) {
                e.printStackTrace();
                OutputMappingModel outputModel = new OutputMappingModel(
                    Response.Status.BAD_REQUEST.getStatusCode(), "",
                    "TODO: Add exception description");
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(outputModel).build();
            }
        } else if (model.getContentType().equals("statement/text")) {
            inputStatement = model.getContent();
        } else {
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
        switch (phase) {
        case 0:
            return assertPhase0(challenge, inputStatement);
        case 1:
            return assertPhase1(challenge, inputStatement);
        case 2:
            return assertPhase2(challenge, inputStatement);
        case 3:
            return assertPhase3(challenge, inputStatement);
        case 4:
            return assertPhase4(challenge, inputStatement);
        case 5:
            return assertPhase5(challenge, inputStatement);
        case 6:
            return assertPhase6(challenge, inputStatement);
        case 7:
            return assertPhase7(challenge, inputStatement);
        case 8:
            return assertPhase8(challenge, inputStatement);
        case 9:
            return assertPhase9(challenge, inputStatement);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase9(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
        case 2:
        case 3:
            return assertPhaseChallenge(inputStatement, 9, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase8(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
        case 2:
        case 3:
            return assertPhaseChallenge(inputStatement, 8, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase7(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
        case 2:
        case 3:
            return assertPhaseChallenge(inputStatement, 7, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase6(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
            return assertPhaseChallenge(inputStatement, 6, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase5(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
            return assertPhaseChallenge(inputStatement, 5, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase4(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
        case 2:
            return assertPhaseChallenge(inputStatement, 4, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase3(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
            return assertPhaseChallenge(inputStatement, 3, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase2(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhaseChallenge(inputStatement, 2, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase1(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
        case 2:
            return assertPhaseChallenge(inputStatement, 1, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase0(Integer challenge,
        String inputStatement) {
        switch (challenge) {
        case 0:
        case 1:
        case 2:
            return assertPhaseChallenge(inputStatement, 0, challenge);
        default:
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhaseChallenge(String inputStatement,
        Integer phase, Integer challenge) {
        ReportModel outputModel = assertStatement(inputStatement, phase,
            challenge);
        return Response.status(Response.Status.OK).entity(outputModel).build();
    }

    private static ReportModel assertStatement(String inputStatement,
        Integer phase, Integer challenge) {
        ReportModel outputModel = new ReportModel();
        List<ScenarioStatusModel> scenarii = new ArrayList<ScenarioStatusModel>();
        for (int i = 1; i <= 7; i++) {
            ScenarioStatusModel scenario = new ScenarioStatusModel();
            scenario.setScenario(i);
            prepareEnvironment(i);
            final long executionStartNanoTime = System.nanoTime();
            ResultSet actualResult = executeStatement(inputStatement);
            final long executionEndNanoTime = System.nanoTime();
            ResultSet expectedResult = Results.getExpectedResult(phase,
                challenge, i);
            scenario.setStatus(
                expectedResult.equals(actualResult) ? "passed" : "failed");
            scenario.setExecutionTime(executionEndNanoTime - executionStartNanoTime);
            scenarii.add(scenario);
        }
        outputModel.setScenarii(scenarii);
        return outputModel;
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
