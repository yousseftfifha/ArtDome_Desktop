/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Tools.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.temporal.ChronoUnit;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import Entities.ReservationE;

/**
 *
 * @author ASUS
 */
public class ReservationService {
    
      public int PrixTotal() throws SQLException {
       ReservationE r = new ReservationE();
        int nbjour = (int) ChronoUnit.DAYS.between(r.getDate_debut(),r.getDate_retour());
        int nbJourRetard = (int) ChronoUnit.DAYS.between(r.getDate_fin(), r.getDate_retour());
        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "SELECT prix_jour FROM endroit WHERE id_endroit ='" + r.getMatricule() + "'";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) * nbjour ;
        } else {
            return 0;
        }
    }

    public void supprimerReservation() throws SQLException {
        Connection con = config.getInstance().getConnection();
        ReservationE r = new ReservationE();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "DELETE FROM reservation WHERE id_reservation=" + r.getId_reservation();
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
         Alert a = new Alert(Alert.AlertType.INFORMATION,"Rservation Supprimé ",ButtonType.OK);
         a.showAndWait();

    }

    public void ajouterReservation() throws SQLException {

        Connection con = config.getInstance().getConnection();
        ReservationE r = new ReservationE();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "INSERT INTO reservation(idclient,matricule,date_debut,date_fin,date_retour,Cautionnement,prix_total) "
                + "Values (" + r.getId_client() + ",'" + r.getMatricule() + "','" + r.getDate_debut() + "','" + r.getDate_fin() + "','" + r.getDate_retour() + "'," + r.getCautionnement() + "," + r.getPrix_total() + ")";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();}
        
         public void MAJdispo() throws SQLException {

        Connection con = config.getInstance().getConnection();
             ReservationE r = new ReservationE();
         try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE endroit SET disponibilite='Non disponible' WHERE id_endroit='"+r.getMatricule() +"'";
        
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
        
        
    }
         
         public void modifierReservation() throws SQLException {
             ReservationE r = new ReservationE();
        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE reservation SET idclient="+r.getId_client()+",matricule='"+r.getMatricule()+"',date_debut='"+r.getDate_debut()+"',date_fin='"+r.getDate_fin()+"',date_retour='"+r.getDate_retour()+"',Cautionnement="+r.getCautionnement()+" WHERE id_reservation="+r.getId_reservation();
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();

    }
    public boolean exist() throws SQLException
    {
        Connection con = config.getInstance().getConnection();
        ReservationE r = new ReservationE();

        ResultSet rs;
        rs = con.createStatement().executeQuery("SELECT * FROM reservation WHERE id_reservation="+r.getId_reservation());
        if (rs.next())
            return true;
        else return false;
    }
    
}
