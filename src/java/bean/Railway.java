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
public class Railway{
    String TrainName;
    String Route;
    Double Fare;
    String Time;
  
    public String save(){

        Connection conn;
        try {
           
        
          //  if(checkName(username)){
              conn = utils.getConnection();   
                
            // Build a Query
            String sql = "INSERT into railwayinfo (TrainName, Route, Fare,Time) values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, TrainName);
            pstmt.setString(2, Route);
            pstmt.setDouble(3, Fare);
            pstmt.setString(4, Time);
           
           int i = pstmt.executeUpdate();
            //conn.close();
            if(i>0){
             return "RailwayInfo";
            }
            else{
                return "Sucessfull Saved";
            }
            
//         
        } catch (SQLException ex) {
            Logger.getLogger(RailwayInfo.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getTrainName() {
        return TrainName;
    }

    public void setTrainName(String TrainName) {
        this.TrainName = TrainName;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String Route) {
        this.Route = Route;
    }

    public Double getFare() {
        return Fare;
    }

    public void setFare(Double Fare) {
        this.Fare = Fare;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    


    
    
    
    
}
