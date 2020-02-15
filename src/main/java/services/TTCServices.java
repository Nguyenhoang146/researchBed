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

import javax.ws.rs.core.Response;

import org.vgu.se.sql.parser.SQLParser;

import models.InputModel;
import models.OutputModel;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;

public class TTCServices {

    public static Response assertStatement(Integer phase, Integer challenge,
        InputModel model) {

        Statement inputStatement = null;
        if (model.getContentType().equals("statement/xml")) {
            final String dirPath = System.getProperty("java.io.tmpdir");
            BufferedWriter output = null;
            File file = null;
            try {
                file = new File(dirPath.concat("//").concat("sqlStatement.xmi"));
                output = new BufferedWriter(new FileWriter(file));
                output.write(model.getContent());
            } catch ( IOException e ) {
                e.printStackTrace();
            } finally {
              if ( output != null ) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    OutputModel outputModel = new OutputModel(
                        Response.Status.BAD_REQUEST.getStatusCode(), "",
                        "TODO: Add exception description");
                    return Response.status(Response.Status.BAD_REQUEST)
                        .entity(outputModel).build();
                }
              }
            }
            String filePath = file.getAbsolutePath();
            try {
                inputStatement = SQLParser.transform(SQLParser.loadEStatement(filePath));
            } catch (IOException e) {
                e.printStackTrace();
                OutputModel outputModel = new OutputModel(
                    Response.Status.BAD_REQUEST.getStatusCode(), "",
                    "TODO: Add exception description");
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(outputModel).build();
            }
        } else {
            try {
                inputStatement = CCJSqlParserUtil.parse(model.getContent());
            } catch (JSQLParserException e) {
                e.printStackTrace();
                OutputModel outputModel = new OutputModel(
                    Response.Status.BAD_REQUEST.getStatusCode(), "",
                    "TODO: Add exception description");
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(outputModel).build();
            }
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
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase9(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase9Challenge0(inputStatement);
        case 1:
            return assertPhase9Challenge1(inputStatement);
        case 2:
            return assertPhase9Challenge2(inputStatement);
        case 3:
            return assertPhase9Challenge3(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase9Challenge3(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase9Challenge2(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase9Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase9Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase8(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase8Challenge0(inputStatement);
        case 1:
            return assertPhase8Challenge1(inputStatement);
        case 2:
            return assertPhase8Challenge2(inputStatement);
        case 3:
            return assertPhase8Challenge3(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase8Challenge3(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase8Challenge2(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase8Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase8Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase7(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase7Challenge0(inputStatement);
        case 1:
            return assertPhase7Challenge1(inputStatement);
        case 2:
            return assertPhase7Challenge2(inputStatement);
        case 3:
            return assertPhase7Challenge3(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase7Challenge3(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase7Challenge2(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase7Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase7Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase6(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase6Challenge0(inputStatement);
        case 1:
            return assertPhase6Challenge1(inputStatement);
        case 2:
            return assertPhase6Challenge2(inputStatement);
        case 3:
            return assertPhase6Challenge3(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase6Challenge3(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase6Challenge2(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase6Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase6Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase5(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase5Challenge0(inputStatement);
        case 1:
            return assertPhase5Challenge1(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase5Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase5Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase4(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase4Challenge0(inputStatement);
        case 1:
            return assertPhase4Challenge1(inputStatement);
        case 2:
            return assertPhase4Challenge2(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase4Challenge2(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase4Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase4Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase3(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase3Challenge0(inputStatement);
        case 1:
            return assertPhase3Challenge1(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase3Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase3Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase2(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase2Challenge0(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase2Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase1(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase1Challenge0(inputStatement);
        case 1:
            return assertPhase1Challenge1(inputStatement);
        case 2:
            return assertPhase1Challenge2(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase1Challenge2(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase1Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase1Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase0(Integer challenge, Statement inputStatement) {
        switch (challenge) {
        case 0:
            return assertPhase0Challenge0(inputStatement);
        case 1:
            return assertPhase0Challenge1(inputStatement);
        case 2:
            return assertPhase0Challenge2(inputStatement);
        default:
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "TODO: Add exception description");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response assertPhase0Challenge2(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase0Challenge1(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }

    private static Response assertPhase0Challenge0(Statement inputStatement) {
        // TODO Auto-generated method stub
        return null;
    }
}
