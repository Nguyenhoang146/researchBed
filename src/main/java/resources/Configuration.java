package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class Configuration {

    public static Connection getConnection()
        throws SQLException, NamingException {

//        Context initContext = new InitialContext();
        // This is very specific to Tomcat
//        Context envContext = (Context) initContext.lookup("java:comp/env");

//        DataSource ds = (DataSource) envContext.lookup("jdbc/ttcdb");
//        return ds.getConnection();
        
        return getRemoteConnection();
    }

    private static Connection getRemoteConnection() {
        if (System.getProperty("RDS_HOSTNAME") != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String dbName = System.getProperty("RDS_DB_NAME");
                String userName = System.getProperty("RDS_USERNAME");
                String password = System.getProperty("RDS_PASSWORD");
                String hostname = System.getProperty("RDS_HOSTNAME");
                String port = System.getProperty("RDS_PORT");
                String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port
                    + "/" + dbName + "?user=" + userName + "&password="
                    + password;
                Connection con = DriverManager.getConnection(jdbcUrl);
                return con;
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
