/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.User;
import db.DBUtils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DataController {
    private Connection conn;
    
    public DataController(String Username, String Password, String IP) throws ClassNotFoundException, SQLException {
        this.conn = DBUtils.createConnection(Username, Password, IP);
    }
    public int AddUser(User user) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("INSERT INTO USERS(Name,Username,Password) VALUES(?,?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        
        return ps.executeUpdate();
    }
    
    public User getUserByUsername(String Username) throws SQLException {
        
        User user = null;
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE Username=?");
        ps.setString(1, Username);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user = new User(rs.getString("Name"), rs.getString("Username"), rs.getString("Password"));
        }
       return user;
    }
}
