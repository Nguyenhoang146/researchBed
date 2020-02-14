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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ttc")
public class TTCResources {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendProc()
            throws SQLException, NamingException {

        try (Connection db = Configuration.getConnection()) {
            
            JsonArrayBuilder jsonData = Json.createArrayBuilder();
            List<String> jsonQuery = new ArrayList<String>();
            List<String> jsonCaller = new ArrayList<String>();

            List<String> queries = new ArrayList<String>();
            queries.add("Q1");
            jsonQuery.add("Q1");
            queries.add("Q2a");
            jsonQuery.add("Q2a");
            queries.add("Q2b");
            jsonQuery.add("Q2b");
            queries.add("Q2c");
            jsonQuery.add("Q2c");
            queries.add("Q3a");
            jsonQuery.add("Q3a");
            queries.add("Q3b");
            jsonQuery.add("Q3b");
            queries.add("Q3d");
            jsonQuery.add("Q3d");
            queries.add("Q4");
            jsonQuery.add("Q4");
            queries.add("Q5");
            jsonQuery.add("Q5");
            queries.add("Q6");
            jsonQuery.add("Q6");
            queries.add("Q7");
            jsonQuery.add("Q7");
            queries.add("Q8b");
            jsonQuery.add("Q8b");
            queries.add("Q8c");
            jsonQuery.add("Q8c");
            queries.add("Q9");
            jsonQuery.add("Q9");
            queries.add("Q10a");
            jsonQuery.add("Q10a");
            queries.add("Q10b");
            jsonQuery.add("Q10b");
            queries.add("Q10c");
            jsonQuery.add("Q10c");
            
            
            List<String> callers = new ArrayList<String>();
            callers.add("1");
            jsonCaller.add("Alice(1)");
            callers.add("2");
            jsonCaller.add("Raul(2)");
            callers.add("3");
            jsonCaller.add("John(3)");
            callers.add("4");
            jsonCaller.add("Mary(4)");
            callers.add("5");
            jsonCaller.add("Dan(5)");
            callers.add("6");
            jsonCaller.add("Bob(6)");
            
            System.out.print(String.format("\t%1$10s", ""));
            for(int i = 0; i < callers.size(); i++) {
                System.out.print(String.format("\t%1$10s", jsonCaller.get(i)));
            }
            System.out.println();
            for(int i = 0; i < queries.size(); i++) {
                System.out.print(String.format("\t%1$10s", jsonQuery.get(i)));
                JsonArrayBuilder jsonElement = Json.createArrayBuilder();
                for(int x = 0; x < callers.size(); x++) {
                    String callStm = String.format("call %s(%s);", queries.get(i), callers.get(x));
                    PreparedStatement st = db.prepareStatement(callStm);
                    
                    try {
                        ResultSet rs = st.executeQuery();
                        ResultSetMetaData rsmd = rs.getMetaData();
                        String name = rsmd.getColumnName(1);
                        if(rs.next()) {
                            if(name.equals("@p1")) {
                                if(rs.getString(1).equals("45000")) {
                                    jsonElement.add(0);
                                    System.out.print(String.format("\t%1$10s", "-"));
                                }
                                else {
                                    jsonElement.add(-1);
                                    System.out.print(String.format("\t%1$10s", "?"));
                                }
                            }
                            else {
                                jsonElement.add(1);
                                System.out.print(String.format("\t%1$10s", "+"));
                            }
                        }
                        else {
                            jsonElement.add(1);
                            System.out.print(String.format("\t%1$10s", "+"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        jsonElement.add(-1);
                        System.out.print(String.format("\t%1$10s", "?"));
                    }
                }
                jsonData.build();
                jsonData.add(jsonElement);
                System.out.println();
            }
            
            return Response.ok().entity(jsonData.build().toString())
                    .build();
        } 
    }
}
