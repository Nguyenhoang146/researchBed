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
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import models.ResultSet;
import models.sqlsi.EnrollmentListModel;
import models.sqlsi.EnrollmentModel;
import models.sqlsi.LecturerListModel;
import models.sqlsi.LecturerModel;
import models.sqlsi.ObjectModel;
import models.sqlsi.SQLSIQueryModel;
import models.sqlsi.StudentListModel;
import models.sqlsi.StudentModel;
import services.sqlsi.UniversityService;

@Path("/sqlsi/default")
public class UniversityResources {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllData() {
        try {
            ObjectModel om = UniversityService.getAllData();
            return Response.status(Status.ACCEPTED).entity(om).build();
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }
    
    @Path("/reset")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReset() {
        try {
            ObjectModel om = UniversityService.resetScenario();
            return Response.status(Status.ACCEPTED).entity(om).build();
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }


    @Path("/execute")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response executeQuery(@QueryParam("scenario") String scenario,
        @QueryParam("policy") String policy,
        @QueryParam("caller") String caller, @QueryParam("role") String role,
        SQLSIQueryModel sqlsiQueryModel) {
        try {
            ResultSet resultSet = UniversityService.executeQuery(scenario,
                policy, caller, role, sqlsiQueryModel);
            return Response.status(Status.ACCEPTED).entity(resultSet).build();
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("/insert/student")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertStudent(StudentModel studentModel) {
        try {
            UniversityService.insert(studentModel);
            return Response.status(Status.ACCEPTED).entity(studentModel).build();
        } catch (SQLException | NamingException e) {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @Path("/insert/lecturer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertStudent(LecturerModel lecturerModel) {
        try {
            UniversityService.insert(lecturerModel);
            return Response.status(Status.ACCEPTED).entity(lecturerModel).build();
        } catch (SQLException | NamingException e) {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @Path("/insert/enrollment")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertStudent(EnrollmentModel enrollmentModel) {
        try {
            UniversityService.insert(enrollmentModel);
            return Response.status(Status.ACCEPTED).entity(enrollmentModel).build();
        } catch (SQLException | NamingException e) {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @Path("/delete/student/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent(@PathParam("id") String id) {
        try {
            List<StudentModel> students = UniversityService.deleteStudent(id);
            return Response.status(Status.ACCEPTED)
                .entity(new StudentListModel(students)).build();
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
            List<LecturerModel> lecturers = UniversityService.deleteLecturer(id);
            return Response.status(Status.ACCEPTED)
                .entity(new LecturerListModel(lecturers)).build();
        } catch (SQLException | NamingException e) {
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
    }

    @Path("/delete/enrollment")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEnrollment(
        EnrollmentModel enrollmentModel) {
        try {
            List<EnrollmentModel> enrollments = UniversityService.delete(enrollmentModel);
            return Response.status(Status.ACCEPTED)
                .entity(new EnrollmentListModel(enrollments)).build();
        } catch (SQLException | NamingException e) {
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
    }
}
