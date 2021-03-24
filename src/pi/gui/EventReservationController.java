/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import pi.services.EventMethods;
import pi.services.ReservationMethods;
import pidev.entities.Client;
import pidev.entities.Event;
import pidev.entities.Reservation;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EventReservationController implements Initializable {

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
    
}
