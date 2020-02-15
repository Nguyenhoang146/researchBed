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

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.vgu.ocl2psql.main.OCL2PSQL_2;
import org.vgu.se.sql.EStatement;
import org.vgu.se.sql.parser.SQLParser;

import models.InputModel;
import models.OutputModel;

public class MappingServices {
    public static Response postOCLExpression(Boolean sqlAsXmi,
        InputModel model) {
        if (model.getContent() == null || model.getContent().isEmpty()) {
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Empty input: The OCL expression is empty");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        } else if (model.getContentType().equals("expression/text")) {
            if (!sqlAsXmi) {
                return mapOCLStringToSQLString(model);
            } else {
                return mapOCLStringToSQLModel(model);
            }

        } else if (model.getContentType().equals("expression/xml")) {
            if (!sqlAsXmi) {
                return mapOCLModelToSQLString(model);
            } else {
                return mapOCLModelToSQLModel(model);
            }
        } else {
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Invalid input: Different input type is required");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response mapOCLModelToSQLModel(InputModel model) {
        OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
        try {
            EStatement output = ocl2psql.mapOCLXMIToSQLXMI(
                model.getDefaultDataModelName(), model.getDefaultDataModelXMI(),
                model.getContent());
            OutputModel outputModel = new OutputModel(
                Response.Status.OK.getStatusCode(), "statement/xml",
                SQLParser.outputEStatementAsXMI(output));
            return Response.status(Response.Status.OK).entity(outputModel)
                .build();
        } catch (IOException e) {
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Invalid input: The OCL expression cannot be parsed");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response mapOCLStringToSQLModel(InputModel model) {
        try {
            OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
            JSONArray json = (JSONArray) new JSONParser()
                .parse(model.getDefaultDataModelJSON());
            ocl2psql.setDataModelFromFile(json);
            EStatement output = ocl2psql
                .mapOCLStringToSQLXMI(model.getContent());
            OutputModel outputModel = new OutputModel(
                Response.Status.OK.getStatusCode(), "statement/xml",
                SQLParser.outputEStatementAsXMI(output));
            return Response.status(Response.Status.OK).entity(outputModel)
                .build();
        } catch (Exception e) {
            e.printStackTrace();
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Invalid input: The OCL expression cannot be parsed");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response mapOCLModelToSQLString(InputModel model) {
        OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
        try {
            String output = ocl2psql.mapOCLXMIToSQLString(
                model.getDefaultDataModelName(), model.getDefaultDataModelXMI(),
                model.getContent());
            output = output.replace("\n", " ");
            OutputModel outputModel = new OutputModel(
                Response.Status.OK.getStatusCode(), "statement/text", output);
            return Response.status(Response.Status.OK).entity(outputModel)
                .build();
        } catch (IOException e) {
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Invalid input: The OCL expression cannot be parsed");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response mapOCLStringToSQLString(InputModel model) {
        try {
            OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
            JSONArray json = (JSONArray) new JSONParser()
                .parse(model.getDefaultDataModelJSON());
            ocl2psql.setDataModelFromFile(json);
            String output = ocl2psql
                .mapOCLStringToSQLString(model.getContent());
            output = output.replace("\n", " ");
            OutputModel outputModel = new OutputModel(
                Response.Status.OK.getStatusCode(), "statement/text", output);
            return Response.status(Response.Status.OK).entity(outputModel)
                .build();
        } catch (Exception e) {
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Invalid input: The OCL expression cannot be parsed");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }
}
