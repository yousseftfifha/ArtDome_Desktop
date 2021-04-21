/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Gui.HomeSceneController;
import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        }    }
    
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
    private void GetPDF(ActionEvent event) {
    }

    @FXML
    private void searchRB(InputMethodEvent event) {
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
