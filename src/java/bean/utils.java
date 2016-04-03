/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author g6-2227tu
 */
public class utils {
    public static Connection getConnection() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            String host = "localhost";
            String port = "3306";
            String db = "railway";
            String user = "root";
            String pass = "";
            String jdbc = "jdbc:mysql://" + host + ":" + port + "/" + db;
            return DriverManager.getConnection(jdbc, user, pass);
        
    }
}
