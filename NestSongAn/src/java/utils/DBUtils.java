package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.servlet.ServletContext;


/**
 *
 * @author KHTN
 */
public class DBUtils {
    

    public static Connection getConnection() {
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
            if (instance == null || instance.trim().isEmpty()) {
                url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);
        } catch (SQLException ex) {
            System.out.println("Connection error! " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection error! " + ex.getMessage());
        }
        return null;
    }
    private final static String serverName = "localhost";
    private final static String dbName = "NestSongAn";
    private final static String portNumber = "1433";
    private final static String instance = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final static String userID = "sa";
    private final static String password = "12345";
    
    public static Properties getProperties(ServletContext context, String filePath){
        
        InputStream input = context.getResourceAsStream(filePath);
        Properties properties =null;
        try {
           properties=new Properties();
           properties.load(input);
        }catch(IOException ex){
            Logger.getLogger("Get properties "+ex.getMessage());
        }
        return properties;
    }
    public static void main(String[] args) {
        System.out.println(DBUtils.getConnection());
    }

}
