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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.InputMappingDefaultModel;
import models.ResultRow;
import models.ResultSet;
import services.TTCServices;

@Path("/ttc")
public class TTCResources {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assertStatement(
        @QueryParam("stage") Integer phase,
        @QueryParam("challenge") Integer challenge,
        InputMappingDefaultModel model) {
        Response response = TTCServices.assertStatement(phase, challenge, model);
        return response;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        try (Connection db = Configuration.getConnection()) {
            ResultSet actualResult = new ResultSet();
            List<ResultRow> rows = new ArrayList<ResultRow>();
            String callStm = "SELECT * FROM TestTable";
            PreparedStatement st = db.prepareStatement(callStm);

            java.sql.ResultSet rs = st.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            // collect column names
            List<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                columnNames.add(rsmd.getColumnLabel(i));
            }

//            int rowIndex = 0;
            while (rs.next()) {
//                rowIndex++;
                // collect row data as objects in a List
                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowData.add(rs.getObject(i));
                }
                // for test purposes, dump contents to check our results
                // (the real code would pass the "rowData" List to some
                // other routine)
//                System.out.printf("Row %d%n", rowIndex);
                ResultRow row = new ResultRow();
                HashMap<String, String> cols = new HashMap<String, String>();
                for (int colIndex = 0; colIndex < rsmd
                    .getColumnCount(); colIndex++) {
//                    String objType = "null";
                    String objString = "";
                    Object columnObject = rowData.get(colIndex);
                    if (columnObject != null) {
                        objString = columnObject.toString();
//                        objType = columnObject.getClass().getName();
                    }
//                    System.out.printf("  %s: %s(%s)%n",
//                        columnNames.get(colIndex), objString, objType);
                    cols.put(columnNames.get(colIndex), objString);
                }
                row.setCols(cols);
                rows.add(row);
            }
            actualResult.setRows(rows);
            return Response.status(200).entity(actualResult).build();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
