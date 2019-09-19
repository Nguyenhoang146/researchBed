package bean;

import org.json.simple.parser.ParseException;
import org.vgu.ocl2psql.main.OCL2PSQL;
import org.vgu.ocl2psql.ocl.exception.OclParseException;

public class Runner {
    public String run(String ocl, boolean descriptionMode) throws OclParseException, ParseException {
        OCL2PSQL ocl2psql = new OCL2PSQL();
        ocl2psql.setPlainUMLContext("[\r\n" + 
                "{\"class\" : \"Car\",\r\n" + 
                " \"attributes\" : [{\"name\" : \"color\", \"type\" : \"String\"}]\r\n" + 
                "},\r\n" + 
                "{\"class\" : \"Person\",\r\n" + 
                " \"attributes\" : [{\"name\" : \"name\", \"type\" : \"String\"}]\r\n" + 
                " },\r\n" + 
                "{\"association\" : \"Ownership\",\r\n" + 
                " \"ends\" : [\"owners\", \"ownedCars\"],\r\n" + 
                " \"classes\" : [\"Car\", \"Person\"]\r\n" + 
                "}\r\n" + 
                "]");
        ocl2psql.setDescriptionMode(descriptionMode);
        return ocl2psql.mapToString(ocl);
    }
}
