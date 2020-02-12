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

package resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.vgu.ocl2psql.main.OCL2PSQL_2;

import model.InputModel;
import model.OutputModel;

@Path("/map")
public class MappingResources {

    @Path("/carperson")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mappingDefaultDataModel(
        @DefaultValue("false") @QueryParam("oclAsXmi") Boolean oclAsXmi,
        @DefaultValue("false") @QueryParam("sqlAsXmi") Boolean sqlAsXmi,
        InputModel model) {
        if (model.getContent() == null || model.getContent().isEmpty()) {
            OutputModel outputModel = new OutputModel(
                Response.Status.BAD_REQUEST.getStatusCode(), "",
                "Empty input: The OCL expression is empty");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(outputModel).build();
        }
        if (!oclAsXmi && !sqlAsXmi) {
            if (model.getContentType().equals("expression/text")) {
                try {
                    OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
                    JSONArray json = (JSONArray) new JSONParser()
                        .parse(model.getDefaultDataModelJSON());
                    ocl2psql.setDataModelFromFile(json);
                    String output = ocl2psql
                        .mapOCLStringToSQLString(model.getContent());
                    output = output.replace("\n", " ");
                    OutputModel outputModel = new OutputModel(
                        Response.Status.OK.getStatusCode(), "statement/text",
                        output);
                    return Response.status(Response.Status.OK)
                        .entity(outputModel).build();
                } catch (Exception e) {
                    OutputModel outputModel = new OutputModel(
                        Response.Status.BAD_REQUEST.getStatusCode(), "",
                        "Invalid input: The OCL expression cannot be parsed");
                    return Response.status(Response.Status.BAD_REQUEST)
                        .entity(outputModel).build();
                }
            } else {
                OutputModel outputModel = new OutputModel(
                    Response.Status.BAD_REQUEST.getStatusCode(), "",
                    "Invalid input: Different input type is required");
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(outputModel).build();
            }
        } else if (oclAsXmi && !sqlAsXmi) {
            if (model.getContentType().equals("expression/xml")) {
                OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
                try {
                    String output = ocl2psql.mapOCLXMIToSQLString(
                        model.getDefaultDataModelName(),
                        model.getDefaultDataModelXMI(), model.getContent());
                    output = output.replace("\n", " ");
                    OutputModel outputModel = new OutputModel(
                        Response.Status.OK.getStatusCode(), "statement/text",
                        output);
                    return Response.status(Response.Status.OK)
                        .entity(outputModel).build();
                } catch (IOException e) {
                    OutputModel outputModel = new OutputModel(
                        Response.Status.BAD_REQUEST.getStatusCode(), "",
                        "Invalid input: The OCL expression cannot be parsed");
                    return Response.status(Response.Status.BAD_REQUEST)
                        .entity(outputModel).build();
                }
            } else {
                OutputModel outputModel = new OutputModel(
                    Response.Status.BAD_REQUEST.getStatusCode(), "",
                    "Invalid input: Different input type is required");
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(outputModel).build();
            }
        } else if (!oclAsXmi && sqlAsXmi) {
            if (model.getContentType().equals("expression/text")) {
                OutputModel outputModel = new OutputModel(
                    Response.Status.NOT_IMPLEMENTED.getStatusCode(), "",
                    "We are working on it");
                return Response.status(Response.Status.NOT_IMPLEMENTED)
                    .entity(outputModel).build();
            } else {
                OutputModel outputModel = new OutputModel(
                    Response.Status.BAD_REQUEST.getStatusCode(), "",
                    "Invalid input: Different input type is required");
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(outputModel).build();
            }
        } else {
            if (model.getContentType().equals("expression/xml")) {
                OutputModel outputModel = new OutputModel(
                    Response.Status.NOT_IMPLEMENTED.getStatusCode(), "",
                    "We are working on it");
                return Response.status(Response.Status.NOT_IMPLEMENTED)
                    .entity(outputModel).build();
            } else {
                OutputModel outputModel = new OutputModel(
                    Response.Status.BAD_REQUEST.getStatusCode(), "",
                    "Invalid input: Different input type is required");
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(outputModel).build();
            }
        }
    }
}
