package beans;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.vgu.ocl2psql.main.OCL2PSQL_2;
import org.vgu.ttc2020.model.TTCReturnModel;

public class Runner {
    public TTCReturnModel run(String ocl, boolean descriptionMode) throws FileNotFoundException, IOException, Exception {
        OCL2PSQL_2 ocl2psql = new OCL2PSQL_2();
        final String text = "[\r\n" + 
            "    {\r\n" + 
            "        \"class\": \"Car\",\r\n" + 
            "        \"attributes\": [\r\n" + 
            "            {\r\n" + 
            "                \"name\": \"color\",\r\n" + 
            "                \"type\": \"String\"\r\n" + 
            "            }\r\n" + 
            "        ],\r\n" + 
            "        \"ends\": [\r\n" + 
            "            {\r\n" + 
            "                \"name\": \"owners\",\r\n" + 
            "                \"target\": \"Person\",\r\n" + 
            "                \"opp\": \"ownedCars\",\r\n" + 
            "                \"mult\": \"*\"\r\n" + 
            "            }\r\n" + 
            "        ]\r\n" + 
            "    },\r\n" + 
            "    {\r\n" + 
            "        \"class\": \"Person\",\r\n" + 
            "        \"attributes\": [\r\n" + 
            "            {\r\n" + 
            "                \"name\": \"name\",\r\n" + 
            "                \"type\": \"String\"\r\n" + 
            "            }\r\n" + 
            "        ],\r\n" + 
            "        \"ends\": [\r\n" + 
            "            {\r\n" + 
            "                \"name\": \"ownedCars\",\r\n" + 
            "                \"target\": \"Car\",\r\n" + 
            "                \"opp\": \"owners\",\r\n" + 
            "                \"mult\": \"*\"\r\n" + 
            "            }\r\n" + 
            "        ]\r\n" + 
            "    }\r\n" + 
            "]";
        JSONArray json = (JSONArray) new JSONParser().parse(text);
        ocl2psql.setDataModelFromFile(json);
        ocl2psql.setDescriptionMode(descriptionMode);
        return ocl2psql.mapOCLStringToSQLString(ocl);
    }
}
