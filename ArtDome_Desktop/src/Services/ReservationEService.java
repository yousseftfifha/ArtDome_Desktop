/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Entities.User;
import Entities.reservation_expo;
import Tools.MyConnection;

/**
 *
 * @author Oumaima
 */
public class ReservationEService {
    
    private Connection cnx;
    private PreparedStatement ste;
    private ResultSet rs;
    private Statement st;
    
     public ReservationEService() {
        cnx = MyConnection.getInstance().getConnection();
    }
     
     
     
      public void AddReservationE(reservation_expo r){
        String req ="INSERT INTO reservation_expo (code_client, nb_place, code_expo)"+"values (?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, r.getCode_client());
            ste.setInt(2, r.getNb_place());
            ste.setInt(3, r.getCode_expo());

            ste.executeUpdate();
            System.out.println("Reservation d'exposition ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
       public ObservableList<reservation_expo> getReservationEList(){
        ObservableList<reservation_expo> ReservationElist = FXCollections.observableArrayList();
         String req = "SELECT * from reservation_expo ";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               ReservationElist.add(new reservation_expo(rs.getInt("code_reservationE"), rs.getInt("code_client"), rs.getInt("nb_place")));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return ReservationElist;
    }
       
       
             public ObservableList<User> getUserListe(){
        ObservableList<User> userlist = FXCollections.observableArrayList();
         String req = "SELECT * from reservation_expo JOIN user on code_client=ID";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               userlist.add(new User( rs.getInt("ID"),rs.getString("nom"), rs.getString("prenom"), rs.getDate("datenaissance"), rs.getString("ville"), rs.getString("email"), rs.getInt("numero")));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return userlist;
    }
       
         public void DeleteExpo(int codeee){
          try {
              String req = "DELETE from reservation_expo WHERE code_reservationE=" +codeee+ " ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("Réservation d'exposition supprimée");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(ReservationEService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
         
           public void UpdateReservation(reservation_expo r,int codeee ){
        String req ="UPDATE reservation_expo set code_client=? , nb_place=? WHERE code_reservationE =" +codeee+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, r.getCode_client());
            ste.setInt(2, r.getNb_place());
            
            ste.executeUpdate();
            System.out.println("Réservation d'exposition modifiée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
     }
           
               public ObservableList<User> getUserList(int code){
        ObservableList<User> userlist = FXCollections.observableArrayList();
         String req = "SELECT * from reservation_expo JOIN user on code_client=ID where ID='"+code+"'";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               userlist.add(new User( rs.getInt("ID"),rs.getString("nom"), rs.getString("prenom"), rs.getDate("datenaissance"), rs.getString("ville"), rs.getString("email"), rs.getInt("numero")));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return userlist;
    }
               
               
                          public ObservableList<reservation_expo> SearchReservation(int search ){
         ObservableList<reservation_expo> Reserlist = FXCollections.observableArrayList();
         String req ="select * from reservation_expo WHERE code_reservationE='"+search+"' or nb_place= '"+search+"'";
         try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               Reserlist.add(new reservation_expo (rs.getInt("code_reservationE"), rs.getInt("code_client"),rs.getInt("nb_place"), rs.getInt("code_expo") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return Reserlist;
     }
     
    
}
