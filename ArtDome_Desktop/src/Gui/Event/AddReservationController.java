/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Gui.HomeSceneController;
import Services.EventService;
import Services.ReservationMethods;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import static Tools.Print.printNode;
import Tools.QRcode;
import Entities.Reservation;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddReservationController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
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
    @FXML
    private AnchorPane holderPane;
    @FXML
    AnchorPane home,oeuvre,event,profiles,expo,blog,orders,location,login,cart;
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
        ObservableList<Reservation> Reservationlist = rm.listeReservationFront ();
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
            EventService em = new EventService ();
            em.UpdatenbplaceEvent(nb_place, code_event);
            rm.AddReservation(r);
            showReservation();

        tray.notification.TrayNotification tray = new tray.notification.TrayNotification ();
        tray.setTitle("Réservation ajoutée");
        tray.setMessage("Une réservation a été ajoutée, veuillez la confirmer");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));
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
            EventService em = new EventService ();
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
        EventService em = new EventService ();
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

