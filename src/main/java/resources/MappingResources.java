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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.vgu.ocl2psql.main.OCL2PSQL_2;

import model.TextualModel;
import model.XMIModel;

@Path("/ocl2psql")
public class MappingResources {
    
    @Path("/test")
    @GET
    public Response testAPI(@QueryParam("test") String test) {
        return Response.status(Response.Status.ACCEPTED)
            .entity(test).build();
    }

    @Path("/text")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mappingFromOCLTextual(TextualModel model) {
        if (model.getOclExpression() == null
            || model.getOclExpression().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("OCL expression is empty.").build();
        }
        if (model.getDataModel() == null || model.getDataModel().isEmpty()) {
            model.setDataModel("[\r\n" + "    {\r\n"
                + "        \"class\": \"Car\",\r\n"
                + "        \"attributes\": [\r\n" + "            {\r\n"
                + "                \"name\": \"color\",\r\n"
                + "                \"type\": \"String\"\r\n"
                + "            }\r\n" + "        ],\r\n"
                + "        \"ends\": [\r\n" + "            {\r\n"
                + "                \"name\": \"owners\",\r\n"
                + "                \"target\": \"Person\",\r\n"
                + "                \"opp\": \"ownedCars\",\r\n"
                + "                \"mult\": \"*\"\r\n" + "            }\r\n"
                + "        ]\r\n" + "    },\r\n" + "    {\r\n"
                + "        \"class\": \"Person\",\r\n"
                + "        \"attributes\": [\r\n" + "            {\r\n"
                + "                \"name\": \"name\",\r\n"
                + "                \"type\": \"String\"\r\n"
                + "            }\r\n" + "        ],\r\n"
                + "        \"ends\": [\r\n" + "            {\r\n"
                + "                \"name\": \"ownedCars\",\r\n"
                + "                \"target\": \"Car\",\r\n"
                + "                \"opp\": \"owners\",\r\n"
                + "                \"mult\": \"*\"\r\n" + "            }\r\n"
                + "        ]\r\n" + "    }\r\n" + "]");
        }
        try {
            OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
            JSONArray json = (JSONArray) new JSONParser()
                .parse(model.getDataModel());
            ocl2psql.setDataModelFromFile(json);
            String output = ocl2psql
                .mapOCLStringToSQLString(model.getOclExpression());
            return Response.status(Response.Status.OK).entity(output).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("The input is invalid.").build();
        }
    }

    @Path("/xmi")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mappingFromOCLModel(XMIModel model) {
        if (model.getOclExpression() == null
            || model.getOclExpression().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("OCL expression is empty.").build();
        }
        if (model.getDataModel() == null || model.getDataModel().isEmpty()) {
            model.setDataModelName("CarPerson");
            model.setDataModel(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DM:EDataModel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:DM=\"http://www.example.org/ocl/dm\" xsi:schemaLocation=\"http://www.example.org/ocl/dm ocl.ecore#//dm\"> <classes name=\"Car\"> <ends name=\"owners\" mult=\"*\" target=\"//@classes.1\" opp=\"//@classes.1/@ends.0\"/> <attributes name=\"color\" type=\"String\"/> </classes> <classes name=\"Person\"> <ends name=\"ownedCars\" mult=\"*\" target=\"//@classes.0\" opp=\"//@classes.0/@ends.0\"/> <attributes name=\"name\" type=\"String\"/> </classes> </DM:EDataModel>");
        }
        OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
        try {
            String output = ocl2psql.mapOCLXMIToSQLString(
                model.getDataModelName(), model.getDataModel(),
                model.getOclExpression());
            return Response.status(Response.Status.OK).entity(output).build();
        } catch (IOException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("The input is invalid.").build();
        }
    }
}
