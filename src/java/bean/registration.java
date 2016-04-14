/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author g6-2227tu
 */
@ManagedBean
@ApplicationScoped
public class registration {
    String firstname;
    String lastname;
    String email;
    String username;
    String password;
    String cpassword;
    String address;
    String phoneno;
    
    public String save(){

        Connection conn;
        try {
           
        
          //  if(checkName(username)){
              conn = utils.getConnection();   
                
            // Build a Query
            String sql = "INSERT into registration (firstname, lastname, email,username, password, cpassword, address, phoneno) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, email);
            pstmt.setString(4, username);
            pstmt.setString(5, password);
            pstmt.setString(6, cpassword);
            pstmt.setString(7, address);
            pstmt.setString(8, phoneno);
           int i = pstmt.executeUpdate();
            //conn.close();
            if(i>0){
             return "login";
            }
            else{
                return "hello";
            }
            
//            else{
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The username already exist choose some other name"));
//                return null;
//            }
        } catch (SQLException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return null;
    }
    
//    public Boolean checkName(String user){
//        Connection con;
//        
//        try {
//            con = utils.getConnection();
//            String sql= "select username from registration where username = ?";
//            PreparedStatement pst=con.prepareStatement(sql);
//            pst.setString(1, user);
//            
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                String username1 = rs.getString("username");
//                System.out.println(username1);
//                if(user.equals(username1)){
//                    return false;
//                }
//                else
//                    return true;
//            }
//           // con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    
    
    
    
}
