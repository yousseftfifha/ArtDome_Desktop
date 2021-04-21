/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Gui.HomeSceneController;
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

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import static Tools.Print.printNode;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DetailEventController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
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
    @FXML
    private AnchorPane holderPane;
    @FXML
    AnchorPane home,oeuvre,event,profiles,expo,blog,orders,location,login,cart;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            home = FXMLLoader.load(getClass().getResource("../HomeScene.fxml"));
            profiles = FXMLLoader.load(getClass().getResource("../User/Profile.fxml"));
            oeuvre = FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml"));
            event = FXMLLoader.load(getClass().getResource("ListEvent.fxml"));
            expo = FXMLLoader.load(getClass().getResource("../Exposition/AddReservation_expo.fxml"));
            blog = FXMLLoader.load(getClass().getResource("../Blog/BlogShow.fxml"));
            orders = FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml"));
            location = FXMLLoader.load(getClass().getResource("../Endroit/AfficherReservation.fxml"));
            login = FXMLLoader.load(getClass().getResource("../User/Login.fxml"));
            cart = FXMLLoader.load(getClass().getResource("../OrdersCart/CartView.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(HomeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    @FXML
    private void profile(ActionEvent actionEvent) throws IOException {
        setNode(profiles);
    }

    @FXML
    private void order(ActionEvent actionEvent) throws IOException {
        setNode(orders);
    }

    @FXML
    private void oeuvre(ActionEvent actionEvent) throws IOException {
        setNode(oeuvre);
    }

    @FXML
    private void expo(ActionEvent actionEvent) throws IOException {
        setNode(expo);
    }

    @FXML
    private void event(ActionEvent actionEvent) throws IOException {
        setNode(event);
    }

    @FXML
    private void blog(ActionEvent actionEvent) throws IOException {
        setNode(blog);

    }
    @FXML
    private void location(ActionEvent actionEvent)throws IOException {
        setNode(location);
    }
    @FXML
    private void logout(ActionEvent actionEvent) throws IOException {
        setNode(login);

    }


    @FXML
    private void cart(ActionEvent actionEvent) {
        setNode(cart);
    }

    @FXML
    private void home(ActionEvent actionEvent) {
        setNode(home);

    }










}
