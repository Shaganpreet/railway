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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author g6-2227tu
 */
@ManagedBean
@ApplicationScoped
public class InfoController {
    List<RailwayInfo> train;
    RailwayInfo railway;

    

    
    public InfoController() {
        railway = new RailwayInfo("", "", -1.0, "");
        getTrainInfoFromDB();
    }
    
    public void getTrainInfoFromDB(){
        Connection conn;
        train=new ArrayList<>();
        try {
            conn=utils.getConnection();
            String sql = "select *from railwayinfo";
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                RailwayInfo r =new RailwayInfo(
                rs.getString("TrainName"),
                rs.getString("Route"),
                rs.getDouble("Fare"),
                rs.getString("Time"));
                train.add(r);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public String save(){

        Connection conn;
        try {        
        
          //  if(checkName(username)){
              conn = utils.getConnection();   
                
            // Build a Query
            String sql = "INSERT into railwayinfo (TrainName, Route, Fare,Time) values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, railway.getTrainName());
            pstmt.setString(2, railway.getRoute());
            pstmt.setDouble(3, railway.getFare());
            pstmt.setString(4, railway.getTime());
           
           int i = pstmt.executeUpdate();
            //conn.close();
            if(i>0){
                getTrainInfoFromDB();
             return "RailwayInfo";
            }
            else{
                getTrainInfoFromDB();
                return null;
            }
            
//         
        } catch (SQLException ex) {
            Logger.getLogger(RailwayInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return null;
    }
    

    public List<RailwayInfo> getTrain() {
        return train;
    }

    public void setTrain(List<RailwayInfo> train) {
        this.train = train;
    }

    public RailwayInfo getRailway() {
        return railway;
    }

    public void setRailway(RailwayInfo railway) {
        this.railway = railway;
    }
    
    
    
}
