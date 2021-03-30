/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entite.Oeuvre;
import Entite.catégorie;
import Tools.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author user
 */
public class OeuvreCRUD implements Ioeuvre {
      private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection cnx;

    public OeuvreCRUD() {
         cnx = MyConnection.getInstance().getConnection();
    }
    
       public void AddOeuvrePst(Oeuvre o) {
         
              String req = "insert into oeuvre (ID_Oeuvre,NomOeuvre,PrixOeuvre,ID_Artiste,DateOeuvre,ImageOeuvre,NomCat,EmailArtiste) values (?,?,?,?,?,?,?,?)";
              try { 
              
              pst = cnx.prepareStatement(req);
              pst.setInt(1, o.getID_Oeuvre());
              pst.setString(2, o.getNomOeuvre());
              pst.setDouble(3, o.getPrixOeuvre());
              pst.setInt(4, o.getID_Artiste());
              pst.setDate(5,(Date) o.getDateOeuvre());
              pst.setString(6, o.getImageOeuvre());
              pst.setString(7, o.getNomCat());
              pst.setString(8, o.getEmailArtiste());
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(OeuvreCRUD.class.getName()).log(Level.SEVERE, null, ex);
          }

        

    }
    @Override
    public void insert(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    @Override
    public List readAll() {
         String req = "select * from oeuvre ORDER BY PrixOeuvre";

        List<Oeuvre> list=new ArrayList<>();
        try {
            ste = cnx.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new Oeuvre(rs.getInt("ID_Oeuvre"), rs.getString("NomOeuvre"), rs.getDouble("PrixOeuvre"),rs.getInt("ID_Artiste"),rs.getDate("DateOeuvre"),rs.getString("ImageOeuvre"),rs.getString("NomCat"),rs.getString("EmailArtiste")));
           }

        } catch (SQLException ex) {
            Logger.getLogger(OeuvreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    public catégorie readAllJ(int id) {
         String req = "select o.ID_Oeuvre, o.NomOeuvre, o.PrixOeuvre, o.ID_Artiste, o.DateOeuvre, o.ImageOeuvre, o.NomCat, o.EmailArtiste, c.Type, c.Description from oeuvre o INNER JOIN categorie c ON o.NomCat=c.NomCat WHERE ID_Oeuvre= '"+id+"'";

        catégorie list=new catégorie();
        try {
            ste = cnx.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list=new catégorie( rs.getString("Type"),rs.getString("Description"));
           }

        } catch (SQLException ex) {
            Logger.getLogger(OeuvreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        public void DeleteOeuvre(int o){
          try {
              String req = "DELETE from oeuvre  WHERE id_oeuvre =" +o+ " ";
              
              ste = cnx.createStatement();
              ste.executeUpdate(req);
              System.out.println("yeeey");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(OeuvreCRUD.class.getName()).log(Level.SEVERE, null, ex);}
          }
        
        public void UpdateOeuvre(Oeuvre o,int ov)
        { String req ="UPDATE oeuvre set Id_Oeuvre=? , nomOeuvre=? , prixOeuvre=? , id_artiste=?,DateOeuvre=?,ImageOeuvre=?,NomCat=?,EmailArtiste=? WHERE Id_Oeuvre =" +ov+ " ";
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, o.getID_Oeuvre());
            pst.setString(2, o.getNomOeuvre());
            pst.setInt(3, (int) o.getPrixOeuvre());
            pst.setInt(4, o.getID_Artiste());
            pst.setDate(5,(Date) o.getDateOeuvre());
            pst.setString(6, o.getImageOeuvre());
            pst.setString(7, o.getNomCat());
            pst.setString(8, o.getEmailArtiste());
            pst.executeUpdate();
            System.out.println("Oeuvre modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
            
        }
        public ObservableList<Oeuvre> Searcho(String search ){
         ObservableList<Oeuvre> list = FXCollections.observableArrayList();
         String req ="SELECT * FROM oeuvre WHERE ID_Oeuvre = '"+search+"' or NomOeuvre = '"+search+"' or PrixOeuvre = '"+search+"' or ID_Artiste = '"+search+"'or DateOeuvre= '"+search+"'or ImageOeuvre= '"+search+"'or NomCat= '"+search+"'or EmailArtiste= '"+search+"'";
        
        try {
            ste = cnx.createStatement();
           rs= ste.executeQuery(req);
           
           while(rs.next()){
                 list.add(new Oeuvre(rs.getInt("ID_Oeuvre"), rs.getString("NomOeuvre"), rs.getDouble("PrixOeuvre"),rs.getInt("ID_Artiste"),rs.getDate("DateOeuvre"),rs.getString("ImageOeuvre"),rs.getString("NomCat"),rs.getString("EmailArtiste")));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return list;
        
    } 
      public ObservableList<PieChart.Data> getData(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
         String req = "SELECT count(*),NomCat,ID_Oeuvre from oeuvre group by NomCat";
        try {
            ste = cnx.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               
               data.add(new PieChart.Data (rs.getString("NomCat"),rs.getInt("ID_Oeuvre")));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return data;
}
        


    @Override
    public Object readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
