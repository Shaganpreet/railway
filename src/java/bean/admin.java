/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author g6-2227tu
 */
@ManagedBean
@ApplicationScoped
public class admin {
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
    
    public String doadmin() throws SQLException{
        
        FacesContext context = FacesContext.getCurrentInstance();
        Connection conn=utils.getConnection();
        Statement st=conn.createStatement();
        String query = "select password from admin where username='"+username+"';";
        ResultSet rs=st.executeQuery(query);
        if(rs.next()){
            if(password.equals(rs.getString("password"))){
                context.getExternalContext().getSessionMap().put("user_session", username);
                return "adminloggedin";
            }
            else
            {
                 context.addMessage(null, new FacesMessage("Unknown login, try again using right password  !!!!"));
                return "admin";
               
            }
        }
        else{
             context.addMessage(null, new FacesMessage("Unknown login, username not present in the database     !!!!"));
                return "admin";
        }
            
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "admin";
    }
    public void updateUsersFromDB(){
        
    }
}
