/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;

/**
 *
 * @author g6-2227tu
 */
@ManagedBean
@ApplicationScoped
public class Login {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String doLogin() throws SQLException{
        Connection conn=utils.getConnection();
        Statement st=conn.createStatement();
        String query = "select password from login where username='"+username+"';";
        ResultSet rs=st.executeQuery(query);
        if(rs.next()){
            if(password.equals(rs.getString("password"))){
                return "hello";
            }
            else
                return "error";
        }
        else
            return "error";
    }
    
    public void updateUsersFromDB(){
        
    }
}
