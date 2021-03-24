/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.services;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pi.tools.MyConnection;
import pidev.entities.Client;
import pidev.entities.Event;
import pidev.entities.User;

/**
 *
 * @author HP
 */
public class EventMethods {
      private Connection cnx;
    private PreparedStatement ste;
    private ResultSet rs;
    private Statement st;

   
    public EventMethods() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void AddEvent(Event e){
        String req ="INSERT INTO event (nom_event, theme_event, etat, date, nb_max_part, image, video, code_espace)"+"values (?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, e.getNom_event());
            ste.setString(2, e.getTheme_event());
            ste.setString(3, e.getEtat());
            ste.setDate(4, (Date) e.getDate());
            //ste.setInt(5, e.getNb_participant());
            ste.setInt(5, e.getNb_max_part());
            ste.setString(6, e.getImage());
            ste.setString(7, e.getVideo());
            ste.setInt(8, e.getCode_espace());
            //ste.setInt(10, e.getCode_artiste());
            ste.executeUpdate();
            JOptionPane.showMessageDialog(null, "Evènement ajouté", "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Event ajouté");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
    public ObservableList<Event> getEventList(){
        ObservableList<Event> eventlist = FXCollections.observableArrayList();
         String req = "SELECT * from event ORDER BY etat";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               User u=new User(rs.getInt("code_artiste"));
               eventlist.add(new Event (rs.getInt("code_event"), rs.getString("nom_event"), rs.getString("theme_event"), rs.getString("etat"), rs.getDate("date"),rs.getInt("nb_participant"), rs.getInt("nb_max_part"), rs.getString("image"), rs.getString("video"), rs.getInt("code_espace"), u ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return eventlist;
    }
    
    
        public Event getEventDetail(int id){
         Event e = null;
         String req = "SELECT e.code_event, e.nom_event, e.theme_event, e.etat, e.date, e.nb_participant, e.nb_max_part, e.image, e.video, e.code_espace, u.nom, u.prenom from event e JOIN user u ON e.code_artiste=u.id_user";
         
         try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               User u=new User(rs.getString("nom"), rs.getString("prenom"));
               e=new Event(rs.getInt("code_event"), rs.getString("nom_event"), rs.getString("theme_event"), rs.getString("etat"), rs.getDate("date"),rs.getInt("nb_participant"), rs.getInt("nb_max_part"), rs.getString("image"), rs.getString("video"), rs.getInt("code_espace"),u);
               
               
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
         
        return e;
    }
        
                public ObservableList<Object> getEventReservation(){
        ObservableList<Object> eventlist = FXCollections.observableArrayList();
         String req = "SELECT e.code_event, e.nom_event, r.code_resrvation, r.nom_client, r.prenom_client, r.telephone, r.email, r.nbplace from event e JOIN reservation r ON e.code_event=r.code_event GROUP BY e.code_event";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               eventlist.addAll(rs.getInt("code_event"), rs.getString("nom_event"), rs.getInt("code_reservation"), rs.getString("nom_client"), rs.getString("prenom_client"),rs.getInt("telephone"), rs.getString("email"), rs.getInt("nb_place"));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return eventlist;
    }
//        public List getId(){
//        List id = new ArrayList();
//         String req = "SELECT id_client from client ";
//        try {
//            st = cnx.createStatement();
//           rs= st.executeQuery(req);
//           while(rs.next()){
//               id.add(new Event (rs.getInt("code_client")));
//           }
//
//        } catch (SQLException ex) {
//           System.out.println("Probléme");
//            System.out.println(ex.getMessage());
//        }
//        return id;
//    }
    
    
   
    public void DeleteEvent(int codeee){
          try {
              String req = "DELETE from event WHERE code_event =" +codeee+ " ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              JOptionPane.showMessageDialog(null, "Evènement supprimé", "", JOptionPane.INFORMATION_MESSAGE);
              System.out.println("Event supprimé");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(EventMethods.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
     public void UpdateEvent(Event e,int codeee ){
        String req ="UPDATE event set nom_event=? , theme_event=? , etat=? , date=? , nb_max_part=? , image=? , video=? , code_espace=? WHERE code_event =" +codeee+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, e.getNom_event());
            ste.setString(2, e.getTheme_event());
            ste.setString(3, e.getEtat());
            ste.setDate(4, (Date) e.getDate());
            //ste.setInt(5, e.getNb_participant());
            ste.setInt(5, e.getNb_max_part());
            ste.setString(6, e.getImage());
            ste.setString(7, e.getVideo());
            ste.setInt(8, e.getCode_espace());
            //ste.setInt(10, e.getCode_artiste());
            ste.executeUpdate();
            JOptionPane.showMessageDialog(null, "Evènement modifié", "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Event modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
     }
     
          public void UpdatenbplaceEvent(int nbplace,int codeee ){
        String req ="UPDATE event set nb_participant= (nb_participant + " +nbplace+ ") WHERE code_event =" +codeee+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("Event modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
     }
          
     public ObservableList<Event> SearchEvent(String search ){
         ObservableList<Event> eventlist = FXCollections.observableArrayList();
         String req ="select * from event WHERE nom_event='"+search+"' or theme_event= '"+search+"' or etat ='"+search+"'";
         try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               eventlist.add(new Event (rs.getInt("code_event"), rs.getString("nom_event"), rs.getString("theme_event"), rs.getString("etat"), rs.getDate("date"),rs.getInt("nb_participant"), rs.getInt("nb_max_part"), rs.getString("image"), rs.getString("video"), rs.getInt("code_espace") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return eventlist;
     }
     
          public ObservableList<Event> SearchEventF(String search ){
         ObservableList<Event> eventlist = FXCollections.observableArrayList();
         String req ="select * from event WHERE nom_event='"+search+"' or etat ='"+search+"'";
         try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               eventlist.add(new Event (rs.getInt("code_event"), rs.getString("nom_event"), rs.getString("theme_event"), rs.getString("etat"), rs.getDate("date"),rs.getInt("nb_participant"), rs.getInt("nb_max_part"), rs.getString("image"), rs.getString("video"), rs.getInt("code_espace") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return eventlist;
     }
     
         public ObservableList<PieChart.Data> getData(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
         String req = "SELECT nom_event, nb_participant, nb_max_part from event ";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               float p=((rs.getInt("nb_participant")*100)/rs.getInt("nb_max_part"));
               data.add(new PieChart.Data (rs.getString("nom_event")+"  "+p+" %",p));
               
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return data;
    }
 public ObservableList<Client> getArtiste(int idArtiste){   
     ObservableList<Client> infoArtiste = FXCollections.observableArrayList();
     String req ="Select nom, prenom, email, numero FROM user INNER JOIN client a ON user.ID = client.id_user WHERE client.id_user="+idArtiste+"";
   try {
           st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               User u=new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("numero") );
               infoArtiste.add(new Client (u));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }             
    return infoArtiste;
 }

}