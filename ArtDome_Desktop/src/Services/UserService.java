/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Tools.MyConnection;
import java.sql.SQLException;
import Tools.SendEmail;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.mail.MessagingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class UserService {
     private Statement statement;
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    
  
    public UserService() {
        connection = MyConnection.getInstance ().getConnection ();
    }
    
    public void AddUser (User u) throws MessagingException{
        String request="INSERT INTO user(nom,prenom,datenaissance,ville,email,numero,role,mdp)"+"VALUES(?,?,?,?,?,?,?,?) ";
        try {

            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString (1,u.getNom());
            preparedStatement.setString (2,u.getPrenom());
            preparedStatement.setString(3,String.valueOf(u.getDatenaissance()));
            preparedStatement.setString (4,u.getVille());
            preparedStatement.setString (5,u.getEmail());
            preparedStatement.setInt (6,u.getNumero());
            preparedStatement.setString (7,"user");

            preparedStatement.setString (8,u.getMdp());
            preparedStatement.executeUpdate ();
            System.out.println ("succes");
           
            
              String message="Bonjour "+u.getNom() +System.lineSeparator()+
                " Nous vous informons que vous avez creer un compte le " 
                      
                      +ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME)+
                System.lineSeparator()+
                      "\n profitez de la meilleur experience dans notre application \n"+
               
                " Cordialement "+System.lineSeparator();

        SendEmail.sendMail (u.getEmail(),"Bienvenu chez ArtDome",message);

        } catch (SQLException throwables) {

            System.out.println ("Probleme");
        }
        
    }
    
    public void UpdateUser (User u){       
        String req = "UPDATE user SET nom='"+u.getNom()+"',prenom='"+u.getPrenom()+"',datenaissance='"+u.getDatenaissance()+"',ville='"+u.getVille()+"',email='"+u.getEmail()+"',numero='"+u.getNumero()+"',mdp='"+u.getMdp()+"' WHERE ID="+u.getId();
        try {        
        Statement st= connection.createStatement();
        st.executeUpdate(req);
            
        }
         catch (SQLException ex)
         {
             System.out.println("8alit");
            System.out.println(ex);
        }
        
        
    }

        public void updateMdp (String email,String mdp){

            String req = "UPDATE user SET mdp='" + mdp + "' WHERE email='" + email + "' ";
            try {
                Statement st = connection.createStatement ();
                st.executeUpdate (req);

            } catch (SQLException ex) {

                Logger.getLogger (UserService.class.getName ()).log (Level.SEVERE, null, ex);

            }
        }
            
    public void updateImage (User u){
     String req ="UPDATE user SET image='"+u.getImage()+ "'WHERE ID="+u.getId()  ;
      try {        
        preparedStatement = connection.prepareStatement(req);
        preparedStatement.executeUpdate();
            System.out.println("update mchet");
        }
         catch (SQLException ex)
         {
             System.out.println("8alit");
            System.out.println(ex);
        }
    }
    public void DeleteUser (int id){
        String req="DELETE  from user where ID =?" ;
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate ();

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de la supprision de l'utilisateur");

        }
    }
    
    public void rechercheUser (int id){
        
    }
     public List<User> readUser() {
        String req = "SELECT ID,nom,prenom,datenaissance,ville,email,numero,mdp FROM user";

        List<User> list=new ArrayList<> ();
        try {
            statement = connection.createStatement();
            rs= statement.executeQuery(req);
            while(rs.next()){
                list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
