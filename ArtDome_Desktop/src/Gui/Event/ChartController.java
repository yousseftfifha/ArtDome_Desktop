/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Services.EventService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ChartController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private PieChart pie;
    @FXML
    private JFXButton UserB;
    @FXML
    private JFXButton OeuvresB;
    @FXML
    private JFXButton EventB;
    @FXML
    private JFXButton ExpositionB;
    @FXML
    private JFXButton BlogB;
    @FXML
    private JFXButton Forum;
    @FXML
    private JFXButton OrdersB;
    @FXML
    private TextField code;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       EventService e=new EventService ();
       pie.setData(e.getData());
       
       
       
        
    }  

    @FXML
    private void EvList(ActionEvent event) {
                        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEvent.fxml"));
            Parent root = loader.load();
            AddEventController c = loader.getController();
            code.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void home(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../HomeScene.fxml")));
        dialogStage.setTitle("ArtDome - Home");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void profile(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../User/Profile.fxml")));
        dialogStage.setTitle("ArtDome - Profile");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void oeuvre(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void event(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Event/ListEvent.fxml")));
        dialogStage.setTitle("ArtDome - Event");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void expo(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/AddReservation_expo.fxml")));
        dialogStage.setTitle("ArtDome - Exposition");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void blog(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Blog/BlogShow.fxml")));
        dialogStage.setTitle("ArtDome - Blog");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void orders(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
    
    
    
}
