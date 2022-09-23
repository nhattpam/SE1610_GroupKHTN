/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author HUNG
 */
public class DBHelper implements Serializable{
    public static Connection makeConnection() throws NamingException, SQLException {

//        try {
//            //1.load driver
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            
//            //2.create connection string String:protocol:ip:port:databaseName=db[;instanceName=name]
//            String url="jdbc:sqlserver://localhost:1433;databaseName=hungdb;instanceName=HUNGLNSE161586";
//            //3.open connection
//            Connection connection=DriverManager.getConnection(url,"sa","12345");
//            
//            return connection;
//        } catch (SQLException ex) {
//           ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        return null;
        Context context = new InitialContext();
        Context tomcatContext = (Context) context.lookup("java:comp/env"); //tomcat alias "java:comp/env"
        DataSource datasourcce = (DataSource) tomcatContext.lookup("DS01");
        Connection connection = datasourcce.getConnection();
        return connection;
    }
    
}
