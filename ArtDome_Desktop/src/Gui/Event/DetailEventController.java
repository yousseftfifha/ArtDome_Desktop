/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaView;
import static Tools.Print.printNode;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DetailEventController implements Initializable {

    @FXML
    private Label lbartiste;
    @FXML
    private Label lbtheme;
    @FXML
    private Label lbetat;
    @FXML
    private Label lbdate;
    @FXML
    private Label lbcodeespace;
    @FXML
    private ImageView image;
    @FXML
    private MediaView video;
    @FXML
    private Label nom;
    @FXML
    private TextField codeev;
    @FXML
    private Button tfreserver;
    @FXML
    private AnchorPane AnEv;
    @FXML
    private JFXButton UserB;
    @FXML
    private JFXButton OeuvresB;
    @FXML
    private JFXButton ExpositionB;
    @FXML
    private JFXButton BlogB;
    @FXML
    private JFXButton Forum;
    @FXML
    private JFXButton OrdersB;
    @FXML
    private JFXButton EvList;
    @FXML
    private Label nbplace;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    public void setCodeev(String code) {
        this.codeev.setText(code);
    }
    
        public void setNbplace(String nbp) {
        this.nbplace.setText(nbp);
    }
    
    public void setNom(String nom) {
        this.nom.setText(nom);
    }
    
    public void setLbartiste(String lbartiste) {
        this.lbartiste.setText(lbartiste);
    }
    
    public void setLbtheme(String lbtheme) {
        this.lbtheme.setText(lbtheme);
    }
    
    public void setLbetat(String lbetat) {
        this.lbetat.setText(lbetat);
    }
    
    public void setLbdate(String lbdate) {
        this.lbdate.setText(lbdate);
    }
        
    public void setLbcodeespace(String lbcodeespace) {
        this.lbcodeespace.setText(lbcodeespace);
    }
            
    public void setImage(String image) {

            File imageFile = new File(image);
            Image i=new Image(imageFile.toURI().toString());
            this.image.setImage(i);
        }

    
                
    public void setVideo(String video) {
        final File file = new File(video); 
        final Media media = new Media(file.toURI().toString()); 
        final MediaPlayer mediaPlayer = new MediaPlayer(media); 
        //final MediaView mediaView = new MediaView(mediaPlayer);
        this.video.setMediaPlayer(mediaPlayer);
        //mediaPlayer.onRepeatProperty();
        mediaPlayer.play();
        //mediaPlayer.setVolume(50.0);
    }

    @FXML
    private void reserverE(ActionEvent event) {
                try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddReservation.fxml"));
            Parent root = loader.load();
            AddReservationController apc = loader.getController();
            apc.setTfcodeeeEvent(codeev.getText());
            apc.setTftfnbplace(Integer.parseInt(nbplace.getText().trim()));
            codeev.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EvList(ActionEvent event) {
            try {
            
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("ListEvent.fxml"));
            Parent root = loader.load();
            ListEventController c = loader.getController();
            codeev.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }





    
    
    

    
    
    
}
