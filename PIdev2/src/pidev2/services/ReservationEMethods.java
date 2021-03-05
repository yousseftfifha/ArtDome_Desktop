/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev2.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pidev2.entities.reservation_expo;
import pidev2.tools.MyConnection;

/**
 *
 * @author Oumaima
 */
public class ReservationEMethods {
    
    private Connection cnx;
    private PreparedStatement ste;
    private ResultSet rs;
    private Statement st;
    
     public ReservationEMethods() {
        cnx = MyConnection.getInstance().getConnection();
    }
     
     
     
      public void AddReservationE(reservation_expo r){
        String req ="INSERT INTO reservation_expo (code_client, nom_client, prenom_client, telephone, email, nb_place, code_expo)"+"values (?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, r.getCode_client());
            ste.setString(2, r.getNom_client());
            ste.setString(3, r.getPrenom_client());
            ste.setInt(4, r.getTelephone());
            ste.setString(5, r.getEmail());
            ste.setInt(6, r.getNb_place());
            ste.setInt(7, r.getCode_expo());

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
               ReservationElist.add(new reservation_expo(rs.getInt("code_reservationE"),rs.getString("nom_client"), rs.getString("prenom_client"), rs.getInt("telephone"), rs.getString("email"), rs.getInt("nb_place")));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return ReservationElist;
    }
       
         public void DeleteExpo(int codeee){
          try {
              String req = "DELETE from reservation_expo WHERE code_reservationE=" +codeee+ " ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("Réservation d'exposition supprimée");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(ExpoMethods.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
         
           public void UpdateReservation(reservation_expo r,int codeee ){
        String req ="UPDATE reservation_expo set nom_client=? , prenom_client=? , telephone=? , email=? , nb_place=? WHERE code_reservationE =" +codeee+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, r.getNom_client());
            ste.setString(2, r.getPrenom_client());
            ste.setInt(3, r.getTelephone());
            ste.setString(4, r.getEmail());
            ste.setInt(5, r.getNb_place());
            
            ste.executeUpdate();
            System.out.println("Réservation d'exposition modifiée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
     }
    
}
