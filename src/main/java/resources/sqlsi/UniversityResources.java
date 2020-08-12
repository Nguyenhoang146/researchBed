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

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import models.ResultSet;
import models.sqlsi.EnrollmentModel;
import models.sqlsi.LecturerModel;
import models.sqlsi.SQLSIQueryModel;
import models.sqlsi.StudentModel;
import response.sqlsi.EnrollmentResponse;
import response.sqlsi.LecturerResponse;
import response.sqlsi.ResultSetResponse;
import response.sqlsi.StudentResponse;
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

    @Path("/insert/student")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StudentResponse insertStudent(StudentModel studentModel) {
        try {
            UniversityService.insert(studentModel);
            return new StudentResponse(1, studentModel);
        } catch (SQLException | NamingException e) {
            return new StudentResponse(0, e.getMessage());
        }
    }
    
    @Path("/insert/lecturer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LecturerResponse insertStudent(LecturerModel lecturerModel) {
        try {
            UniversityService.insert(lecturerModel);
            return new LecturerResponse(1, lecturerModel);
        } catch (SQLException | NamingException e) {
            return new LecturerResponse(0, e.getMessage());
        }
    }
    
    @Path("/insert/enrollment")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EnrollmentResponse insertStudent(EnrollmentModel enrollmentModel) {
        try {
            UniversityService.insert(enrollmentModel);
            return new EnrollmentResponse(1, enrollmentModel);
        } catch (SQLException | NamingException e) {
            return new EnrollmentResponse(0, e.getMessage());
        }
    }
    
    @Path("/delete/student/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent(@PathParam("id") String id) {
        try {
            UniversityService.deleteStudent(id);
            return Response.ok().build();
        } catch (SQLException | NamingException e) {
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
    }
    
    @Path("/delete/lecturer/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLecturer(@PathParam("id") String id) {
        try {
            UniversityService.deleteLecturer(id);
            return Response.ok().build();
        } catch (SQLException | NamingException e) {
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
    }
    
    @Path("/delete/enrollment")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EnrollmentResponse deleteEnrollment(EnrollmentModel enrollmentModel) {
        try {
            UniversityService.delete(enrollmentModel);
            return new EnrollmentResponse(1, enrollmentModel);
        } catch (SQLException | NamingException e) {
            return new EnrollmentResponse(0, e.getMessage());
        }
    }
}
