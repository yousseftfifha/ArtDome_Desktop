/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Services.EventMethods;
import Services.ReservationMethods;
import com.github.plushaze.traynotification.notification.TrayNotification;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import static Tools.Print.printNode;
import Tools.QRcode;
import Entities.Reservation;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddReservationController implements Initializable {

    @FXML
    private TextField tfnomclient;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tftelephone;
    @FXML
    private TextField tfemail;
    @FXML
    private Spinner<Integer> tfnbplace;
    @FXML
    private TableView<Reservation> tvr;
    @FXML
    private TableColumn<Reservation, Integer> colnbplace;
    @FXML
    private Button AddButton;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private TextField tfcodeeeEvent;
    @FXML
    private TextField tfcodeeereservation;
    @FXML
    private TextField tfnbpupdate;
    @FXML
    private Button ImprimerButton;

    //ObservableList<Reservation> Reservationl = FXCollections.observableArrayList();
    @FXML
    private TextField tfrech;
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
    private AnchorPane AnRes;
    @FXML
    private TableColumn<Reservation, Integer> colcoder;
    @FXML
    private JFXButton btnRechh;
    @FXML
    private JFXButton refresh;
    /**
     * Initializes the controller class.
     * 
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     //tfnbplace.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5000));
    tfnomclient.setEditable(false);
    tfprenom.setEditable(false);
    tftelephone.setEditable(false);
    tfemail.setEditable(false);
     showReservation();
    }    
    
    public void setTfcodeeeEvent(String tfcodeeeEvent) {
        this.tfcodeeeEvent.setText(tfcodeeeEvent);
    }
    
    public void setTftfnbplace(int nb) {
        this.tfnbplace.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, nb));
    }


    @FXML
    private void getfromtvr(MouseEvent event) {
            tfnomclient.setEditable(true);
    tfprenom.setEditable(true);
    tftelephone.setEditable(true);
    tfemail.setEditable(true);
            Reservation r=  tvr.getSelectionModel().getSelectedItem();
            tfcodeeereservation.setText(""+r.getCode_reservation());
            tfnomclient.setText(r.getC().getNom());
            tfprenom.setText(r.getC().getPrenom());
            tftelephone.setText(""+r.getC().getNumero());
            tfemail.setText(r.getC().getEmail());
            //tfnbplace.setValueFactory((r.getNb_place()));
            tfnbplace.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(r.getNb_place(), 5000));
            tfnbpupdate.setText(""+r.getNb_place());
                tfnomclient.setEditable(false);
    tfprenom.setEditable(false);
    tftelephone.setEditable(false);
    tfemail.setEditable(false);
 
    }

        public void showReservation(){
        ReservationMethods rm=new ReservationMethods();
        ObservableList<Reservation> Reservationlist = rm.listeResC();
        colcoder.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("code_reservation"));
        colnbplace.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("nb_place"));
        tvr.setItems(Reservationlist);
    } 
        
    @FXML
    private void AddReservation(ActionEvent event) {
        int code_event = Integer.parseInt(tfcodeeeEvent.getText().trim());
//            String nom_client = tfnomclient.getText();
//            String prenom_client = tfprenom.getText();
            int nb_place = tfnbplace.getValue();
//            //int telephone = Integer.valueOf(tftelephone.getText());
//            String email = tfemail.getText();
            ReservationMethods rm = new ReservationMethods();
//            User u=new User(nom_client, prenom_client, email, telephone);
            //Client c=new Client(u);
            Reservation r= new Reservation(nb_place,code_event);
            EventMethods em = new EventMethods();
            em.UpdatenbplaceEvent(nb_place, code_event);
            rm.AddReservation(r);
            showReservation();
            
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Réservation ajoutée");
        tray.setMessage("Une réservation a été ajoutée, veuillez la confirmer");
        //tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (5200));
        
        QRcode qrc=new QRcode();
        qrc.QRcode();
            tfnomclient.clear();
            tfprenom.clear();
            tftelephone.clear();
            tfemail.clear();
            
                  
                  
    }

    @FXML
    private void UpdateReservation(ActionEvent event) {
        
            int codeee_r = Integer.parseInt(tfcodeeereservation.getText().trim());
//            String nom_client = tfnomclient.getText();
//            String prenom = tfprenom.getText();
//            int telephone =  Integer.parseInt(tftelephone.getText().trim());
//            String email = tfemail.getText();
            int nb_place = tfnbplace.getValue();
            ReservationMethods rm = new ReservationMethods();
//            User u=new User(nom_client, prenom, email, telephone);
//            Client c=new Client(u);
            Reservation r= new Reservation( nb_place);
            rm.UpdateReservation(r,codeee_r);
            EventMethods em = new EventMethods();
            if((Integer.parseInt(tfnbpupdate.getText().trim())-nb_place)>0)
                em.UpdatenbplaceEvent((Integer.parseInt(tfnbpupdate.getText().trim())-nb_place), codeee_r);
            else
                em.UpdatenbplaceEvent((Integer.parseInt(tfnbpupdate.getText().trim())+nb_place), codeee_r);
            
            showReservation();
            
            tfnomclient.clear();
            tfprenom.clear();
            tftelephone.clear();
            tfemail.clear();
    }

    @FXML 
    private void DeleteReservation(ActionEvent event) {
        int codeee = Integer.parseInt(tfcodeeereservation.getText().trim());
        int nb_place = tfnbplace.getValue();
//        String nom_client = tfnomclient.getText();
//        String prenom = tfprenom.getText();
//        String email = tfemail.getText();
        ReservationMethods rm = new ReservationMethods();
        rm.DeleteReservation(codeee);
        EventMethods em = new EventMethods();
        em.UpdatenbplaceEvent((-nb_place), codeee);
        showReservation();            

    }
  

         @FXML
    private void Imprimer(ActionEvent event)throws IOException, DocumentException {
        try {
            printNode(AnRes);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(AddReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void EvList(ActionEvent event) {
                try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListEvent.fxml"));
            Parent root = loader.load();
            ListEventController c = loader.getController();
            tfcodeeeEvent.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SearchReservation(ActionEvent event) {
        int s= Integer.parseInt(tfrech.getText().trim());
        ReservationMethods rm=new ReservationMethods();
        ObservableList<Reservation> Reservationl = rm.SearchReservation(s);
        colcoder.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("code_reservation"));
        colnbplace.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("nb_place"));
        tvr.setItems(Reservationl);
        

    }

    @FXML
    private void refresh(ActionEvent event) {
        showReservation();
            tfnomclient.clear();
            tfprenom.clear();
            tftelephone.clear();
            tfemail.clear();
    }



}

