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

package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String contentType;
    private String oclExpression;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getOclExpression() {
        return oclExpression;
    }

    public void setOclExpression(String oclExpression) {
        this.oclExpression = oclExpression;
    }

    @JsonCreator
    public InputModel(
        @JsonProperty("contentType") String contentType,
        @JsonProperty("oclExpression") String oclExpression) {
        this.contentType = contentType;
        this.oclExpression = oclExpression;
    }

    public InputModel() {
    }

    public String getDefaultDataModelName() {
        return "CarPerson";
    }

    public String getDefaultDataModelJSON() {
        return "[\r\n" + "    {\r\n" + "        \"class\": \"Car\",\r\n"
            + "        \"attributes\": [\r\n" + "            {\r\n"
            + "                \"name\": \"color\",\r\n"
            + "                \"type\": \"String\"\r\n" + "            }\r\n"
            + "        ],\r\n" + "        \"ends\": [\r\n" + "            {\r\n"
            + "                \"name\": \"owners\",\r\n"
            + "                \"target\": \"Person\",\r\n"
            + "                \"opp\": \"ownedCars\",\r\n"
            + "                \"mult\": \"*\"\r\n" + "            }\r\n"
            + "        ]\r\n" + "    },\r\n" + "    {\r\n"
            + "        \"class\": \"Person\",\r\n"
            + "        \"attributes\": [\r\n" + "            {\r\n"
            + "                \"name\": \"name\",\r\n"
            + "                \"type\": \"String\"\r\n" + "            }\r\n"
            + "        ],\r\n" + "        \"ends\": [\r\n" + "            {\r\n"
            + "                \"name\": \"ownedCars\",\r\n"
            + "                \"target\": \"Car\",\r\n"
            + "                \"opp\": \"owners\",\r\n"
            + "                \"mult\": \"*\"\r\n" + "            }\r\n"
            + "        ]\r\n" + "    }\r\n" + "]";
    }

    public String getDefaultDataModelXMI() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DM:EDataModel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:DM=\"http://www.example.org/ocl/dm\" xsi:schemaLocation=\"http://www.example.org/ocl/dm ocl.ecore#//dm\"> <classes name=\"Car\"> <ends name=\"owners\" mult=\"*\" target=\"//@classes.1\" opp=\"//@classes.1/@ends.0\"/> <attributes name=\"color\" type=\"String\"/> </classes> <classes name=\"Person\"> <ends name=\"ownedCars\" mult=\"*\" target=\"//@classes.0\" opp=\"//@classes.0/@ends.0\"/> <attributes name=\"name\" type=\"String\"/> </classes> </DM:EDataModel>";
    }
}
