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

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.InputMappingDefaultModel;
import models.InputMappingModel;
import services.MappingServices;

@Path("/map")
public class MappingResources {

    @Path("/carperson")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mappingDefaultDataModel(
        @DefaultValue("false") @QueryParam("sqlAsXmi") Boolean sqlAsXmi,
        InputMappingDefaultModel model) {
        return MappingServices.postOCLExpression(sqlAsXmi, model);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mapping(
        @DefaultValue("false") @QueryParam("sqlAsXmi") Boolean sqlAsXmi,
        InputMappingModel model) {
        return MappingServices.postOCLExpression(sqlAsXmi, model);
    }
}
