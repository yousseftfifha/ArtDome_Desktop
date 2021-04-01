/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.cathegories;
import Entities.topic;
import Entities.User;
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
import Tools.MyConnection;

/**
 *
 * @author max
 */
public class CathegoryMethod {
    private Connection cnx;
    private PreparedStatement ste;
    private ResultSet rs;
    private Statement st;

    public CathegoryMethod() {
         cnx = MyConnection.getInstance().getConnection();
    }
    
    public void AddCat(cathegories cat){
        String req ="INSERT INTO cathegories (cat_id, cat_name, cat_description)"+"values (?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, cat.getCat_id());
             ste.setString(2, cat.getCat_name());
            ste.setString(3, cat.getCat_description());
            
            ste.executeUpdate();
            System.out.println("Cathegorie ajoutee");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
    
    }
    
    public ObservableList<cathegories> getCatList(){
        ObservableList<cathegories> catlist = FXCollections.observableArrayList();
         String req = "SELECT * from cathegories ";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               catlist.add(new cathegories( rs.getInt("cat_id"),rs.getString("cat_name"), rs.getString("cat_description")));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return catlist;
    }
    
    public ObservableList<User> getUserList(int id){
        ObservableList<User> userlist = FXCollections.observableArrayList();
         String req = "SELECT * from cathegories JOIN subjet on where id_client='"+id+"'";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               userlist.add(new User(rs.getInt("ID"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("datenaissance"), rs.getString("email"), rs.getString("mdp") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return userlist;
    }
    
    /*public void Updatecat(cathegories c,String nom ){
        String req ="UPDATE cathegories set cat_name=? , cat_id=? , cat_description=? WHERE cat_name =" +nom+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, c.getCat_id());
             ste.setString(2, c.getCat_name());
            ste.setString(3, c.getCat_description());
            
            ste.executeUpdate();
            System.out.println("Cathegorie modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
     }*/
    
    public void Deletecat(int nom){
          try {
              String req = "DELETE from cathegories WHERE cat_name =" +nom+ " ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("cathegories supprimée");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(CathegoryMethod.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    public ObservableList<cathegories> Searchcat(String search ){
         ObservableList<cathegories> catlist = FXCollections.observableArrayList();
         String req ="select * from cathegories  WHERE cat_name='"+search+"'";
         try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               catlist.add(new cathegories (rs.getInt("cat_id"), rs.getString("cat_name"), rs.getString("cat_description") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return catlist;
     }

    /*public void UpdateCat(cathegories c, String nom) {
        String req ="UPDATE cathegories set cathegorie name =? WHERE nom cathegorie =" +nom+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, c.getCat_name());
            ste.setString(2, c.getCat_description());
            
            ste.executeUpdate();
            System.out.println("categorie modifier");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
    }*/

    public void DeleteCat(int nom) {
        try {
              String req = "DELETE from cathegories WHERE cat_id=" +nom+ " ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("cathegorie supprimer");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(CathegoryMethod.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    public void UpdateCat(cathegories c, int nom) {
        String req ="UPDATE cathegories set cat_name=? , cat_description=? WHERE cat_id =" +nom+ " ";
        try {
            ste = cnx.prepareStatement(req);
             ste.setString(1, c.getCat_name());
            ste.setString(2, c.getCat_description());
            
            ste.executeUpdate();
            System.out.println("Cathegorie modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
    }
    
}
