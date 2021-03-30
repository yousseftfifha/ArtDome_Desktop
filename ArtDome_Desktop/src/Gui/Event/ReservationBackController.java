/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Services.ReservationMethods;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import javafx.stage.Stage;
import jxl.write.WriteException;
import Tools.Excel;
import Tools.PDFreservation;
import Tools.SendMail;
import Entities.Reservation;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReservationBackController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private TableView<Reservation> tvr;
    @FXML
    private TableColumn<Reservation, Integer> colnbplace;
    @FXML
    private TableColumn<Reservation, Integer> colcodeev;
    @FXML
    private Button btnPDF;
    @FXML
    private TableColumn<Reservation, Integer> colcoderes;
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
    @FXML
    private TextField searchRB;
    @FXML
    private JFXButton btnRechB;
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
    private JFXButton btnExcel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfnbplace.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5000));
    tfnomclient.setEditable(false);
    tfprenom.setEditable(false);
    tftelephone.setEditable(false);
    tfemail.setEditable(false);
    tfnbplace.setEditable(false);
        showReservation();
    } 

            public void showReservation(){
        ReservationMethods rm=new ReservationMethods();
        ObservableList<Reservation> Reservationlist = rm.listeResC();
        colcoderes.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("code_reservation"));
        colnbplace.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("nb_place"));
        colcodeev.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("code_event"));
        tvr.setItems(Reservationlist);
    } 
    @FXML
    private void GetPDF(ActionEvent event) {
        try {
            PDFreservation pdf=new PDFreservation();
            pdf.ReservationPDFback();
        } catch (DocumentException ex) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Ev(ActionEvent event) {
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
    private void searchRB(ActionEvent event) {
        
        int s= Integer.parseInt(searchRB.getText().trim());
        ReservationMethods rm=new ReservationMethods();
        ObservableList<Reservation> Reservationl = rm.SearchReservationB(s);
        colcoderes.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("code_reservation"));
        colnbplace.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("nb_place"));
        colcodeev.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("code_event"));
        
        tvr.setItems(Reservationl);
    }

    @FXML
    private void getfromtvr(MouseEvent event) {

            tfnomclient.setEditable(true);
    tfprenom.setEditable(true);
    tftelephone.setEditable(true);
    tfemail.setEditable(true);
    tfnbplace.setEditable(true);
            Reservation r=  tvr.getSelectionModel().getSelectedItem();
            //tfcodeeereservation.setText(""+r.getCode_reservation());
            tfnomclient.setText(r.getC().getNom());
            tfprenom.setText(r.getC().getPrenom());
            tftelephone.setText(""+r.getC().getNumero());
            tfemail.setText(r.getC().getEmail());
            //tfnbplace.setValueFactory((r.getNb_place()));
            tfnbplace.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(r.getNb_place(), 5000));
                tfnomclient.setEditable(false);
    tfprenom.setEditable(false);
    tftelephone.setEditable(false);
    tfemail.setEditable(false);
    tfnbplace.setEditable(false);       
            String email = tfemail.getText();
            String nom_client = tfnomclient.getText();
           String prenom_client = tfprenom.getText();
           int nb_place = tfnbplace.getValue();
           if(event.getButton()== MouseButton.SECONDARY){
                        String msg= "Bonjour Mme/Mr "+nom_client+" "+prenom_client+","
                    + "C'est un plaisir de vous accueillir lors de notre événement."
                    + "Vous avez bien réservé "+nb_place+ " place(s)."
                    + "Nous avons hâte de vous accueillir."
                    +"Bonne journée."
                    ;
            SendMail sm= new SendMail();
             ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
        emailExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sm.sendMail (email, "Réservation confirmée", msg);
                } catch (AddressException e) {
                    e.printStackTrace ();
                } catch (MessagingException e) {
                    e.printStackTrace ();
                }
//        try {
//            sm.sendMail(email, "Réservation confirmée", msg);
//        } catch (MessagingException ex) {
//            Logger.getLogger(AddReservationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
   
    }});
        emailExecutor.shutdown();}
    }

    @FXML
    private void GetExcel(ActionEvent event) {
                
        try {
            Excel ex=new Excel();
            ex.Excel();
        } catch (SQLException ex1) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (WriteException ex1) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (IOException ex1) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex1);
        }
      
    }

    @FXML
    private void home(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../DashBoardScene.fxml.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("../User/User.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Oeuvre/Oeuvre.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Event/ReservationBack.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/Reservation_expoBack.fxml")));
        dialogStage.setTitle("ArtDome - Exposition");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }


    @FXML
    private void orders(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../DashOrdersCart/DashBoardOrders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }



    
}
