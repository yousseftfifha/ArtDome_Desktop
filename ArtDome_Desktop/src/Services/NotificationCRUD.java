/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Notification;
import Entities.User;
import Tools.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class NotificationCRUD {
    private Statement statement;
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    
    
    public NotificationCRUD() {
        connection = MyConnection.getInstance ().getConnection ();
    }
    
    public void AddNotif (Notification n,int id){
        String request="INSERT INTO notification(type,id_user)"+"VALUES(?,?) ";
try {
            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString (1,n.getType());
            preparedStatement.setInt (2,id);            
            preparedStatement.executeUpdate ();
            System.out.println ("succes");

        } catch (SQLException throwables) {

            System.out.println ("Probleme");
        }
    }
    public  ObservableList<Notification> readNotif() {
        ObservableList<Notification> eventlist = FXCollections.observableArrayList();
        String req = "SELECT n.id,u.nom, u.prenom,u.email,u.role,u.numero from notification n JOIN user u ON n.id_user = u.ID";
        try {
                        statement = connection.createStatement();
             rs= statement.executeQuery(req);
            while(rs.next()){
                User u=new User(rs.getString("nom"), rs.getString("prenom"),rs.getString ("email"),rs.getString ("role"),rs.getInt ("numero"));
                eventlist.addAll(new Notification (rs.getInt ("id"), u));
            }

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return eventlist;
//        Notification n = null;
//        String req = "SELECT n.id,u.nom, u.prenom,u.email,u.role,u.numero from notification n JOIN user u ON n.id_user = u.ID";
//
//        try {
//            statement = connection.createStatement();
//             rs= statement.executeQuery(req);
//            while(rs.next()){
//                User u=new User(rs.getString("nom"), rs.getString("prenom"),rs.getString ("email"),rs.getString ("role"),rs.getInt ("numero"));
//                n=new Notification(rs.getInt ("id"),u);
//            List<Notification> notificationList=new ArrayList<> ();
//            notificationList.addAll ((Collection<? extends Notification>) n);
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Probléme");
//            System.out.println(ex.getMessage());
//        }
//
//        return notficationList;
//        String req = "SELECT * FROM notification";
//
//        List<Notification> list=new ArrayList<> ();
//        try {
//            statement = connection.createStatement();
//            rs= statement.executeQuery(req);
//            while(rs.next()){
//                list.add(new Notification(rs.getInt(1),rs.getInt(2),rs.getString(3)));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(NotificationCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
    }
    public String FindRole(int id){
        String role="";
        try {
                    String req = "SELECT type FROM notification where id='"+id+"'";

            statement = connection.createStatement();
            rs= statement.executeQuery(req);
            while(rs.next()){
                role=rs.getString ("type");
            }

        } catch (SQLException ex) {
            Logger.getLogger(NotificationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;

    }
    public void DeleteNotif (int id){
        String req="DELETE  from notification where id =?" ;
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate ();

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de la supprision de la notification");

        }
    }
       
     
}
