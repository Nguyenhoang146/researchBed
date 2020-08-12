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

package resources.sqlsi;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import models.ResultSet;
import models.sqlsi.SQLSIQueryModel;
import response.sqlsi.ResultSetResponse;
import services.sqlsi.UniversityService;

@Path("/sqlsi/default")
public class UniversityResources {
    @Path("/execute")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultSetResponse executeQuery(
        @QueryParam("scenario") String scenario,
        @QueryParam("policy") String policy,
        @QueryParam("caller") String caller, @QueryParam("role") String role,
        SQLSIQueryModel sqlsiQueryModel) {
        try {
            ResultSet resultSet = UniversityService.executeQuery(scenario,
                policy, caller, role, sqlsiQueryModel);
            return new ResultSetResponse(1, resultSet);
        } catch (Exception e) {
            return new ResultSetResponse(0, e.getMessage());
        }
    }

//    @Path("/insert/student")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response insertStudent(StudentModel studentModel) {
//        return UniversityService.insert(studentModel);
//    }
//    
//    @Path("/insert/lecturer")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response insertStudent(LecturerModel lecturerModel) {
//        return UniversityService.insert(lecturerModel);
//    }
//    
//    @Path("/insert/enrollment")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response insertStudent(EnrollmentModel enrollmentModel) {
//        return UniversityService.insert(enrollmentModel);
//    }
//    
//    @Path("/delete/student/{id}")
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteStudent(@PathParam("id") Integer id) {
//        return UniversityService.deleteStudent(id);
//    }
//    
//    @Path("/delete/lecturer/{id}")
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteLecturer(@PathParam("id") Integer id) {
//        return UniversityService.deleteLecturer(id);
//    }
//    
//    @Path("/delete/enrollment")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteEnrollment(EnrollmentModel enrollmentModel) {
//        return UniversityService.delete(enrollmentModel);
//    }
}
