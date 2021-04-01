/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
import javafx.scene.chart.PieChart;
import Tools.MyConnection;

/**
 *
 * @author max
 */
public class SubjectMethod {
    private Connection cnx;
    private PreparedStatement ste;
    private ResultSet rs;
        private Statement st;

    public SubjectMethod() {
         cnx = MyConnection.getInstance().getConnection();
    }
    
    public void Addtopic(topic t){
        String req ="INSERT INTO topic (topic_subject,topic_description,topic_date,topic_by)"+"values (?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
             ste.setString(1, t.getTopic_subject());
            ste.setString(2, t.getTopic_description());
             ste.setDate(3, (Date) t.getTopic_date());
            ste.setInt(4, t.getTopic_by());
            
            ste.executeUpdate();
            System.out.println("sujet ajouté");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
    public ObservableList<topic> getTopicList(){
        ObservableList<topic> topiclist = FXCollections.observableArrayList();
         String req = "SELECT * from topic ";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               topiclist.add(new topic (rs.getInt("topic_Id"),rs.getString("topic_subject"), rs.getString("topic_description"), rs.getInt("Topic_by") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return topiclist;
    }
    
    public ObservableList<User> getUserList(int code){
        ObservableList<User> userlist = FXCollections.observableArrayList();
         String req = "SELECT * from cathegories JOIN subjet on code_oeuvre=topic_id where code_exposition='"+code+"'";
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
    
    public void Updattopic(topic t,int codeee ){
        String req ="UPDATE topic set topic_id=? , topic_subject=? , topic_description=? , topic_date=? , topic_by=? WHERE code_expo =" +codeee+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, t.getTopic_id());
            ste.setString(2, t.getTopic_subject());
            ste.setString(3, t.getTopic_description());
            ste.setDate(4, (Date) t.getTopic_date());
            ste.setInt(5, t.getTopic_by());
            ste.executeUpdate();
            System.out.println("sujet modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
     }
    
    public void Deletetopic(int codeee){
          try {
              String req = "DELETE from topic WHERE topic_Id =" +codeee+ " ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("sujet supprimé");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(SubjectMethod.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
  /**  public ObservableList<PieChart.Data> getData(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        String req = "SELECT nom_expo, nb_participant, nb_max_participant from exposition ";
        try {
            st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               float p=((rs.getInt("nb_participant")*100)/rs.getInt("nb_max_participant"));
               data.add(new PieChart.Data (rs.getString("topic_subject"),p));
           }

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
            return data;
    }*/


    
    public ObservableList<topic> Searchtopic(String search ){
         ObservableList<topic> topiclist = FXCollections.observableArrayList();
         String req ="select * from topic WHERE topic_subject='"+search+"' or topic_by= '"+search+"'";
         try {
            st = cnx.createStatement();
            rs= st.executeQuery(req);
           while(rs.next()){
               topiclist.add(new topic (rs.getInt("topic_id"), rs.getString("topic_subject"), rs.getString("topic_description"), rs.getInt("topic_by") ));
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return topiclist;
     }

    public void Deletetop(int id) {
        String req ="UPDATE reservation_expo set WHERE topic_Id =" +id+ " ";
        try {
            ste = cnx.prepareStatement(req);
            
            ste.executeUpdate();
            System.out.println("topic modifier");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
    }

    public void Updatetop(topic t, int id) {
        String req ="UPDATE topic set topic_by=? ,topic_subject=? , topic_description=? WHERE topic_Id =" +id+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, t.getTopic_by());
            ste.setString(2, t.getTopic_subject());
            ste.setString(3, t.getTopic_description());
            
            ste.executeUpdate();
            System.out.println("Topic modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
    }
    
}
