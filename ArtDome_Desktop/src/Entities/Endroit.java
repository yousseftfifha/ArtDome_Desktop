/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import Tools.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


/**
 *
 * @author ASUS
 */
public class Endroit {
    int id_endroit;
    String type;
    int taille;
    int prix_jour;
    int nbrch;
    String location,dispo;
    String date1,date2;

    public Endroit( String type, int taille, int prix_jour, int nbrch, String location) {
        
        this.id_endroit=0;
        this.type = type;
        this.taille = taille;
        this.prix_jour = prix_jour;
        this.nbrch = nbrch;
        this.location = location;
    }
   public Endroit(int id, String type, int taille, int prix_jour, int nbrch, String location, String dispo) {
        
        this.id_endroit=id;
        this.type = type;
        this.taille = taille;
        this.prix_jour = prix_jour;
        this.nbrch = nbrch;
        this.location = location;
        this.dispo=dispo;
    }
    public Endroit(int id, String type, int taille, int prix_jour, int nbrch, String location, String dispo,String date1,String date2) {
        
        this.id_endroit=id;
        this.type = type;
        this.taille = taille;
        this.prix_jour = prix_jour;
        this.nbrch = nbrch;
        this.location = location;
        this.dispo=dispo;
        this.date1=date1;
        this.date2=date2;
    }
      public Endroit(int id, String type, int taille, int prix_jour, int nbrch, String location) {
        
        this.id_endroit=id;
        this.type = type;
        this.taille = taille;
        this.prix_jour = prix_jour;
        this.nbrch = nbrch;
        this.location = location;
    }
   public Endroit(int id) {
       this.id_endroit=id;
   }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getDispo() {
        return dispo;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }
   
    public int getId_endroit() {
        return id_endroit;
    }

    public void setId_endroit(int id_endroit) {
        this.id_endroit = id_endroit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPrix_jour() {
        return prix_jour;
    }

    public void setPrix_jour(int prix_jour) {
        this.prix_jour = prix_jour;
    }

    public int getNbrch() {
        return nbrch;
    }

    public void setNbrch(int nbrch) {
        this.nbrch = nbrch;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
     public void supprimerEndroit() throws SQLException {
        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "DELETE FROM endroit WHERE id_endroit=" + this.id_endroit;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
         Alert a = new Alert(Alert.AlertType.INFORMATION,"Endroit Supprimé ",ButtonType.OK);
         a.showAndWait();

    }

    public void ajouterEndroit() throws SQLException {

        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "INSERT INTO endroit(type,taille,prix_jour,nbrch,location,disponibilite) "
                + "Values ('" + this.type + "','" + this.taille + "','" + this.prix_jour + "','" + this.nbrch + "','" + this.location + "','disponible')";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();}
        
         public void MAJdispo() throws SQLException {

        Connection con = config.getInstance().getConnection();
         try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE endroit SET disponibilite='Non disponible' WHERE id_endroit='"+this.id_endroit+"'";
        
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
        
        
    }
         
         public void modifierEndroit() throws SQLException {
        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE endroit SET id_endroit="+this.id_endroit+",type='"+this.type+"',taille='"+this.taille+"',prix_jour='"+this.prix_jour+"',nbrch='"+this.nbrch+"',location='"+this.location+"' WHERE id_endroit="+this.id_endroit;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();

    }

    public boolean exist() throws SQLException
    {
        Connection con = config.getInstance().getConnection();

        ResultSet rs;
        rs = con.createStatement().executeQuery("SELECT * FROM endroit WHERE id_endroit="+this.id_endroit);
        if (rs.next())
            return true;
        else return false;
    }
    
}
