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

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/map")
@Produces("application/json")
public class MappingResources {
    @GET
    public Response mapping(@QueryParam("ocl") String ocl,
        @DefaultValue("textual") @QueryParam("format") String format){
        if(ocl == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("name parameter is mandatory")
                .build();
          }
        if(format.equalsIgnoreCase("XMI")) {
            return Response.status(Response.Status.OK).entity(new String("XMI")).build();
        } else if (format.equalsIgnoreCase("textual")){
            return Response.status(Response.Status.OK).entity(new String("TEXT")).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
