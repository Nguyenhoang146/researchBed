package resources;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Configuration {

    public static Connection getConnection()
            throws SQLException, NamingException {

        Context initContext = new InitialContext();
        // This is very specific to Tomcat
        Context envContext = (Context) initContext
                .lookup("java:comp/env");
        
        DataSource ds = (DataSource) envContext.lookup("jdbc/staffdb");
        return ds.getConnection();
    }
}
