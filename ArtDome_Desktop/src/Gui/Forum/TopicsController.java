/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Forum;

import java.net.URL;
import java.util.ResourceBundle;

import Services.SubjectMethod;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import Entities.topic;
import Entities.User;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;



/**
 * FXML Controller class
 *
 * @author max
 */
public class TopicsController implements Initializable {
    
    private Button Retour;
    @FXML
    private Button Recherche;
   
    @FXML
    private Button Ajouter;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    
    @FXML
    private TextField id;
    
    @FXML
    private TextField sujet;
    @FXML
    private TextField auteur;
    @FXML
    private TableColumn<topic, String> titre;
    @FXML
    private TableColumn<topic, Integer> topic;
    @FXML
    private TableColumn<topic, Date> date;
    
    @FXML
    private TableView<topic> post;
    @FXML
    private TextArea description;
    @FXML
    private TextField searchTopic;
    
    
    

    /**
     * Initializes the controller class.
     */
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showtop();
    }    
    
    @FXML
    private void Addtopic(ActionEvent event) {
        
        int ide = Integer.parseInt(id.getText().trim());
        int auteeur = Integer.parseInt(auteur.getText().trim());
        String sujet1 = sujet.getText();
        String description1 = description.getText();
        SubjectMethod tope = new SubjectMethod();
        topic top = new topic(ide,auteeur,sujet1,description1);
            tope.Addtopic(top);
            showtop();
    }
    
    public void showtop(){
        SubjectMethod top=new SubjectMethod();
        ObservableList<topic> topiclist = top.getTopicList();
        titre.setCellValueFactory(new PropertyValueFactory<>("topic_subject"));
        date.setCellValueFactory(new PropertyValueFactory<>("topic_description"));
        topic.setCellValueFactory(new PropertyValueFactory<>("topic_by"));
        post.setItems(topiclist);
    }
    
    private void getfromtv(MouseEvent event) {
          topic t= (topic)post.getSelectionModel().getSelectedItem();
          
//            id.setText(""+t.getTopic_id());
            sujet.setText(""+t.getTopic_subject());
            auteur.setText(""+t.getTopic_by());
            description.setText(""+t.getTopic_description());
            
            
            
    }
    
    @FXML
    private void Updatetop(ActionEvent event) {
        int ide = Integer.parseInt(id.getText().trim());
        int auteeur = Integer.parseInt(auteur.getText().trim());

        String description1 = description.getText();
        String sujet1 = sujet.getText();

        SubjectMethod top = new SubjectMethod();
        topic t= new topic(ide,auteeur,sujet1,description1);
        top.Updatetop(t,ide);
        showtop();
    }
    
    @FXML
    private void Deletetop(ActionEvent event) {
        
        int ide = Integer.parseInt(id.getText().trim());
         int auteeur = Integer.parseInt(auteur.getText().trim());
            
            String description1 = description.getText();
            String sujet1 = sujet.getText();
        SubjectMethod top = new SubjectMethod();
            top.Deletetopic(ide);
        showtop();
    }
    
    private void ReturnToCatheg(ActionEvent event) {
       
              try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Cathegories.fxml"));
            Parent root = loader.load();
            Gui.Forum.CathegoriesController c = loader.getController();
            Retour.getScene().setRoot(root);
        } catch (IOException top) {
            Logger.getLogger(Gui.Forum.CathegoriesController.class.getName()).log(Level.SEVERE, null, top);
        }
        
    }
    
 /*   private void searchtopic(ActionEvent event) {
        
        String s= searchTopic.getText();
        
        SubjectMethod top=new SubjectMethod();
        ObservableList<topic> eventl = top.Searchtopic(s);
       
        titre.setCellValueFactory(new PropertyValueFactory<>("topic_subject"));
        topic.setCellValueFactory(new PropertyValueFactory<>("topic_by"));
        date.setCellValueFactory(new PropertyValueFactory<>("topic_date"));
       
        post.setItems(eventl);
        
        
    }*/

    

    @FXML
    private void Searchtopic(ActionEvent event) {
        String s= searchTopic.getText();
        
        SubjectMethod top=new SubjectMethod();
        ObservableList<topic> eventl = top.Searchtopic(s);
       
        titre.setCellValueFactory(new PropertyValueFactory<>("topic_subject"));
        date.setCellValueFactory(new PropertyValueFactory<>("topic_description"));
        topic.setCellValueFactory(new PropertyValueFactory<>("topic_by"));
       
        post.setItems(eventl);
    }
    /*
    public void mail(){
           
           
            int auteeur = Integer.parseInt(auteur.getText().trim());
            String sujet1 = sujet.getText();
             String mail = email.getText();
                            String msg= "Bonjour Mme/Mr "+nom_client+" "+prenom_client+","
                    + "C'est un plaisir de vous accueillir lors de notre exposition."
                    + "Vous avez bien réservé "+nb_place+ " place(s)."
                    + "Nous avons hâte de vous accueillir."
                    +"Bonne journée."
                    ;
            SendMail sm= new SendMail();
        try {
            sm.sendMail(mail, "Réservation exposition confirmée", msg);
       } catch (MessagingException ex) {
            Logger.getLogger(AddReservation_expoController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }
    
   */

    @FXML
    private void getfromtv(javafx.scene.input.MouseEvent event) {
            topic t= (topic)post.getSelectionModel().getSelectedItem();
          
            id.setText(""+t.getTopic_id());
            sujet.setText(""+t.getTopic_subject());
            auteur.setText(""+t.getTopic_by());
            description.setText(""+t.getTopic_description());
            
    }
    
}
