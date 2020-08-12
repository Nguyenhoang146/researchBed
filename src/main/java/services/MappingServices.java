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
import org.vgu.ocl2psql.OCL2PSQL;
import org.vgu.se.sql.parser.SQLParser;
import org.vgu.ttc2020.model.TTCReturnModel;

import models.InputModel;
import models.OutputMappingModel;

public class MappingServices {
    public static Response postOCLExpression(Boolean sqlAsXmi,
        InputModel model) {
        if (model.getContent() == null || model.getContent().isEmpty()) {
            OutputMappingModel outputModel = new OutputMappingModel(
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
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Invalid input: Different input type is required");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response mapOCLModelToSQLModel(InputModel model) {
        OCL2PSQL ocl2psql = new OCL2PSQL();
        ocl2psql.setContextualType("self", model.getSelf());
        ocl2psql.setContextualType("caller", model.getCaller());
        ocl2psql.setContextualType("value", model.getValue());
        ocl2psql.setContextualType("target", model.getTarget());
        try {
            TTCReturnModel output = ocl2psql.mapOCLXMIToSQLXMI(
                model.getDefaultDataModelName(), model.getDefaultDataModelXMI(),
                model.getContent());
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.OK.getStatusCode(), "statement/xml",
                SQLParser.outputEStatementAsXMI(output.getEStatement()),
                output.getOcl2sqlNanoTime());
            return Response.status(Response.Status.OK).entity(outputModel)
                .build();
        } catch (IOException e) {
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                String.format("%1$s: %2$s", e.getClass().getCanonicalName(),
                    e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response mapOCLStringToSQLModel(InputModel model) {
        try {
            OCL2PSQL ocl2psql = new OCL2PSQL();
            ocl2psql.setContextualType("self", model.getSelf());
            ocl2psql.setContextualType("caller", model.getCaller());
            ocl2psql.setContextualType("value", model.getValue());
            ocl2psql.setContextualType("target", model.getTarget());
            JSONArray json = (JSONArray) new JSONParser()
                .parse(model.getDefaultDataModelJSON());
            ocl2psql.setDataModelFromFile(json);
            TTCReturnModel output = ocl2psql
                .mapOCLStringToSQLXMI(model.getContent());
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.OK.getStatusCode(), "statement/xml",
                SQLParser.outputEStatementAsXMI(output.getEStatement()),
                output.getOcl2sqlNanoTime());
            return Response.status(Response.Status.OK).entity(outputModel)
                .build();
        } catch (Exception e) {
            e.printStackTrace();
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                String.format("%1$s: %2$s", e.getClass().getCanonicalName(),
                    e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response mapOCLModelToSQLString(InputModel model) {
        OCL2PSQL ocl2psql = new OCL2PSQL();
        ocl2psql.setContextualType("self", model.getSelf());
        ocl2psql.setContextualType("caller", model.getCaller());
        ocl2psql.setContextualType("value", model.getValue());
        ocl2psql.setContextualType("target", model.getTarget());
        try {
            TTCReturnModel output = ocl2psql.mapOCLXMIToSQLString(
                model.getDefaultDataModelName(), model.getDefaultDataModelXMI(),
                model.getContent());
            output.setStatement(output.getStatement().replace("\n", " "));
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.OK.getStatusCode(), "statement/text",
                output.getStatement(), output.getOcl2sqlNanoTime());
            return Response.status(Response.Status.OK).entity(outputModel)
                .build();
        } catch (IOException e) {
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                String.format("%1$s: %2$s", e.getClass().getCanonicalName(),
                    e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }

    private static Response mapOCLStringToSQLString(InputModel model) {
        try {
            OCL2PSQL ocl2psql = new OCL2PSQL();
            ocl2psql.setContextualType("self", model.getSelf());
            ocl2psql.setContextualType("caller", model.getCaller());
            ocl2psql.setContextualType("value", model.getValue());
            ocl2psql.setContextualType("target", model.getTarget());
            JSONArray json = (JSONArray) new JSONParser()
                .parse(model.getDefaultDataModelJSON());
            ocl2psql.setDataModelFromFile(json);
            TTCReturnModel output = ocl2psql
                .mapOCLStringToSQLString(model.getContent());
            output.setStatement(output.getStatement().replace("\n", " "));
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.OK.getStatusCode(), "statement/text",
                output.getStatement(), output.getOcl2sqlNanoTime());
            return Response.status(Response.Status.OK).entity(outputModel)
                .build();
        } catch (Exception e) {
            OutputMappingModel outputModel = new OutputMappingModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                String.format("%1$s: %2$s", e.getClass().getCanonicalName(),
                    e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
    }
}
