package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Configuration {

    public static Connection getConnectionForTTC()
        throws SQLException, NamingException {
//        return getLocalConnectionForTTC();
        return getRemoteConnection();
    }
    
    public static Connection getConnectionForSQLSI()
        throws SQLException, NamingException {
//        return getLocalConnectionForSQLSI();
        return getRemoteConnection();
    }

    @SuppressWarnings("unused")
    private static Connection getLocalConnectionForSQLSI()
        throws NamingException, SQLException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/sqlsidb");
        return ds.getConnection();
    }

    @SuppressWarnings("unused")
    private static Connection getLocalConnectionForTTC()
        throws NamingException, SQLException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/ttcdb");
        return ds.getConnection();
    }

    private static Connection getRemoteConnection() {
        if (System.getProperty("RDS_HOSTNAME") != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
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
