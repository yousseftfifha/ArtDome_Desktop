//*
/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Oeuvre;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Tools.MyConnection;
import Entities.catégorie;
import java.util.List;
import java.util.ArrayList;

public class CatégorieCRUD {
      private Connection cnx;
    private PreparedStatement ste;
    private ResultSet rs;
    private Statement st;

    public CatégorieCRUD() {
       
       cnx = MyConnection.getInstance().getConnection();
    }
//        @Override
    public List readAll() {
         String req = "select * from categorie";

        List<catégorie> list=new ArrayList<>();
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               list.add(new catégorie(rs.getInt("ID_Cat"), rs.getString("Type"), rs.getString("Description"),rs.getString("NomCat"),rs.getInt("NbreOeuvre"), rs.getDate("DateCat")));
           }

        } catch (SQLException ex) {
            Logger.getLogger(OeuvreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;}
           
        public List<String> readName() {
         String req = "select * from categorie";

        List<String> name=new ArrayList<>();
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               name.add(rs.getString("NomCat"));
           }

        } catch (SQLException ex) {
            Logger.getLogger(OeuvreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;}

public void AddCategorie(catégorie C){
        String req ="INSERT INTO categorie (Type,Description,NomCat,DateCat) values (?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
          
            ste.setString(1, C.getType());
            ste.setString(2, C.getDescription());
            ste.setString(3, C.getNomCat());
            ste.setDate(4, (Date) C.getDateCat());
            ste.executeUpdate();
            
            System.out.println("catégorie ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }

     public void UpdateCategorie(catégorie c,int uc){ 
String req ="UPDATE categorie set  Type=? , Description=? , NomCat=?, DateCat=?  WHERE ID_Cat ="+uc+" ";
        try {
             ste = cnx.prepareStatement(req);
           //ste.setInt(1, c.getID_Cat());
             ste.setString(1, c.getType());
             ste.setString(2,  c.getDescription());
           ste.setString(3, c.getNomCat());
            ste.setDate(4, (Date) c.getDateCat());
             ste.executeUpdate();
            System.out.println("catégorie modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
            
        }
  public void Deletecategorie(int C){
          try {
              String req = "DELETE from categorie WHERE ID_Cat ="+C+" ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("yeeey");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(OeuvreCRUD.class.getName()).log(Level.SEVERE, null, ex);}
          }

    public ObservableList<catégorie> Searchc(String search) {
        
       ObservableList<catégorie> list = FXCollections.observableArrayList();
         String req ="SELECT * FROM categorie WHERE ID_Cat = '"+search+"' or Type = '"+search+"' or Description = '"+search+"' or NomCat = '"+search+"'or DateCat = '"+search+"'or NbreOeuvre = '"+search+"'";
        
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           
           while(rs.next()){
      list.add(new catégorie(rs.getInt("ID_Cat"), rs.getString("Type"), rs.getString("Description"),rs.getString("NomCat"),rs.getInt("NbreOeuvre"), rs.getDate("DateCat")));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return list;
    }
}