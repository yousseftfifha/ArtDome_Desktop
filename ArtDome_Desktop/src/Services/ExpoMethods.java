/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
import javafx.scene.chart.PieChart;
import Entities.Exposition;
import Entities.Oeuvre;
import Tools.MyConnection;

/**
 *
 * @author Oumaima
 */
public class ExpoMethods {
      private Connection cnx;
    private PreparedStatement ste;
    private ResultSet rs;
        private Statement st;

    public ExpoMethods() {
         cnx = MyConnection.getInstance().getConnection();
    }
    
       public void AddExpo(Exposition e){
        String req ="INSERT INTO exposition (nom_expo,theme_expo,code_espace,code_artiste,date_expo,nb_participant,nb_max_participant,code_oeuvre)"+"values (?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
//            ste.setInt(1, e.getCode_expo());
            ste.setString(1, e.getNom_expo());
             ste.setString(2, e.getTheme_expo());
            ste.setInt(3, e.getCode_espace());
             ste.setInt(4, e.getCode_artiste());
            ste.setDate(5, (Date) e.getDate_expo());
             ste.setInt(6, e.getNb_participant());
            ste.setInt(7, e.getNb_max_participant());
             ste.setInt(8, e.getCode_oeuvre());
            
            ste.executeUpdate();
            System.out.println("exposition ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
        

        
    }
        public ObservableList<Exposition> getExpoList(){
        ObservableList<Exposition> expolist = FXCollections.observableArrayList();
         String req = "SELECT * from exposition ";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               expolist.add(new Exposition (rs.getInt("code_expo"), rs.getString("nom_expo"), rs.getString("theme_expo"), rs.getInt("code_espace"), rs.getInt("code_artiste"), rs.getDate("date_expo"), rs.getInt("nb_participant"), rs.getInt("nb_max_participant"), rs.getInt("code_oeuvre") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return expolist;
    }
        
        public ObservableList<Oeuvre> getOeuvreList(int code){
        ObservableList<Oeuvre> oeuvrelist = FXCollections.observableArrayList();
         String req = "SELECT * from exposition JOIN oeuvre on code_oeuvre=ID_Oeuvre where code_exposition='"+code+"'";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               oeuvrelist.add(new Oeuvre(rs.getInt("ID_Oeuvre"), rs.getString("NomOeuvre") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return oeuvrelist;
    }
     
        
        
        
        
        
           public void UpdateExpo(Exposition e,int codeee ){
        String req ="UPDATE exposition set nom_expo=? , theme_expo=? , code_espace=? , code_artiste=? , date_expo=? , nb_participant=? , nb_max_participant=? , code_oeuvre=? WHERE code_expo =" +codeee+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, e.getNom_expo());
            ste.setString(2, e.getTheme_expo());
            ste.setInt(3, e.getCode_espace());
            ste.setInt(4, e.getCode_artiste());
            ste.setDate(5, (Date) e.getDate_expo());
            ste.setInt(6, e.getNb_participant());
            ste.setInt(7, e.getNb_max_participant());
            ste.setInt(8, e.getCode_oeuvre());
            
            ste.executeUpdate();
            System.out.println("Exposition modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
     }
           
             public void DeleteExpo(int codeee){
          try {
              String req = "DELETE from exposition WHERE code_expo =" +codeee+ " ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("exposition supprimée");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(ExpoMethods.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
             
                   public ObservableList<PieChart.Data> getData(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
         String req = "SELECT nom_expo, nb_participant, nb_max_participant from exposition ";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               float p=((rs.getInt("nb_participant")*100)/rs.getInt("nb_max_participant"));
               data.add(new PieChart.Data (rs.getString("nom_expo")+ " "+ p + " %",p));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return data;
    }
                   
                   
                    public ObservableList<Exposition> SearchExpo(String search ){
         ObservableList<Exposition> expolist = FXCollections.observableArrayList();
         String req ="select * from exposition WHERE nom_expo='"+search+"' or theme_expo= '"+search+"'";
         try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               expolist.add(new Exposition (rs.getInt("code_expo"), rs.getString("nom_expo"), rs.getString("theme_expo"), rs.getInt("code_espace"), rs.getInt("code_artiste"), rs.getDate("date_expo"), rs.getInt("nb_participant"), rs.getInt("nb_max_participant"), rs.getInt("code_oeuvre") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return expolist;
     }
           
                    
//                     public ObservableList<oeuvre> Searchoeuvre(String search ){
//         ObservableList<Exposition> expolist = FXCollections.observableArrayList();
//         String req ="select * from exposition WHERE nom_expo='"+search+"' or theme_expo= '"+search+"'";
//         try {
//            st = cnx.createStatement();
//           rs= st.executeQuery(req);
//           while(rs.next()){
//               expolist.add(new Exposition (rs.getInt("code_expo"), rs.getString("nom_expo"), rs.getString("theme_expo"), rs.getInt("code_espace"), rs.getInt("code_artiste"), rs.getDate("date_expo"), rs.getInt("nb_participant"), rs.getInt("nb_max_participant"), rs.getInt("code_oeuvre") ));
//           }
//
//        } catch (SQLException ex) {
//           System.out.println("Probléme");
//            System.out.println(ex.getMessage());
//        }
//        return expolist;
//     }
       
                    
                    
                    
    
}
