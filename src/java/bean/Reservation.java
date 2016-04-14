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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;

/**
 *
 * @author g6-2227tu
 */
@ManagedBean
@ApplicationScoped

public class Reservation {
    String firstname;
    String lastname;
    String phoneno;
    String trainNo;
    String source_destination;
    List<Reservation> reservation = new ArrayList<>();
    Date date;
    String time;
    String fare;
    int row;
    int count;
    int ticket_number;

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    
    public Reservation(String firstname, String lastname, String phoneno, String train_no, String source_destination, Date date, String time, int ticket_number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneno = phoneno;
        this.trainNo = train_no;
        this.source_destination = source_destination;
        this.date = date;
        this.time = time;
        this.ticket_number = ticket_number;
        count_tickets();
    }
    
    public Reservation(){
        count_tickets();
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCount() {
        count_tickets();
        return count;
    }

//    public void setCount(int count) {
//        this.count = count;
//    }

    public int getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }
    
    public int count_tickets(){
        Connection conn;
        try {
            conn=utils.getConnection();
         
        Statement s = conn.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM reservation");
          r.next();
          count = r.getInt("rowcount") ;
          r.close();
        }catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 50 - count;
    } 
            
    public String reserv(){
        Random rand = new Random();
        ticket_number = rand.nextInt(100);
      Connection conn;
        try {
            conn = utils.getConnection();
            
//           SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-mm-dd");
//           
//           java.util.Date date1= sdf1.parse(sdf1.format(date));
                
            
          java.sql.Date sqlDate = new java.sql.Date(date.getTime());
          
          
          if(count>50){
          
           System.out.println("reaservation has " + count + " row(s).");
           row = count;
           return "errormsg";
          }
          
        
          else{
            // Build a Query
            String sql = "INSERT into reservation (firstname, lastname, phoneno, trainNo, source_destination, date,time,ticket_number) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, phoneno);
            pstmt.setString(4, trainNo);
            pstmt.setString(5, source_destination);           
            pstmt.setDate(6, sqlDate);
            pstmt.setString(7, time);
            pstmt.setInt(8, ticket_number);
            pstmt.executeUpdate();
            return "welcome";
          }
            
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        
        } 
        return null;
    }

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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getSource_destination() {
        return source_destination;
    }

    public void setSource_destination(String source_destination) {
        this.source_destination = source_destination;
    }





    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  
   

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    
   
}