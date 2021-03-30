/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.InputMethodEvent;
import Entities.Event;
import Entities.Reservation;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EventReservationController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private TableView tvr;
    @FXML
    private TableColumn<Event, Integer> colcodeev;
    @FXML
    private TableColumn<Event, String> colnomev;
    @FXML
    private TableColumn<Reservation, Integer> colcoderes;
    @FXML
    private TableColumn<Reservation, String> colnomclient;
    @FXML
    private TableColumn<Reservation, String> colprenom;
    @FXML
    private TableColumn<Reservation, Integer> coltelephone;
    @FXML
    private TableColumn<Reservation, String> colemail;
    @FXML
    private TableColumn<Reservation, Integer> colnbplace;
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
    private JFXButton btnPDF;
    @FXML
    private TextField code;
    @FXML
    private TextField searchRB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
//        public void showReservation(){
//        EventMethods em=new EventMethods();
//        ObservableList<Object> Reservationlist = em.getEventReservation();
//        colcodeev.setCellValueFactory(new PropertyValueFactory<Event, Integer>("code_event"));
//        
//        colcoderes.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("code_reservation"));
//        colnomclient.setCellValueFactory(new PropertyValueFactory<Reservation, Client>("c"));
//        colprenom.setCellValueFactory(new PropertyValueFactory<Reservation, Client>("c"));
//        coltelephone.setCellValueFactory(new PropertyValueFactory<Reservation, Client>("c"));
//        colemail.setCellValueFactory(new PropertyValueFactory<Reservation, Client>("c"));
//        colnbplace.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("nb_place"));
//
//        tvr.setItems(Reservationlist);
//    } 

    @FXML
    private void Ev(ActionEvent event) {
    }

    @FXML
    private void GetPDF(ActionEvent event) {
    }

    @FXML
    private void searchRB(InputMethodEvent event) {
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
