/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Connection;
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
public class ReservationController {
    List<Reservation> reservation;    
    Reservation res;

    public ReservationController() {
       getReservationfromDatabase();
    }

    public void getReservationfromDatabase(){
        reservation = new ArrayList<>();
        Connection conn;
        try {
            conn = utils.getConnection();
        
            String sql="select *from reservation";
            Statement st=conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            while(rs.next()){
                Reservation r = new Reservation(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneno"),
                        rs.getString("trainNo"),
                        rs.getString("source_destination"),
                        rs.getDate("date"),
                        rs.getString("time"),
                        rs.getInt("ticket_number")
                      
                        );
                reservation.add(r);
            }
         } catch (SQLException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public Reservation getRes() {
        return res;
    }

    public void setRes(Reservation res) {
        this.res = res;
    }
    
    
}
