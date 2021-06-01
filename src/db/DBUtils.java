/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class DBUtils {
    public static Connection createConnection(String Username, String Password, String IP) throws ClassNotFoundException, SQLException{

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String DB_URL = "jdbc:sqlserver://" + IP;
        
        return  DriverManager.getConnection(DB_URL, Username, Password);
    }
}
