/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import Entities.reservation_expo;
import Services.ReservationEMethods;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class AddReservation_expoController implements Initializable {

    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TextField nom_client;
    @FXML
    private TextField prenom_client;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private Spinner<Integer> nb_place;
    @FXML
    private Button AddButtonR;
    @FXML
    private Button UpdateButtonR;
    @FXML
    private Button DeleteButtonR;
    @FXML
    private TableView<reservation_expo> tveR;
    @FXML
    private TableColumn<reservation_expo, Integer> colcode;
    @FXML
    private TableColumn<reservation_expo, String > colnomClient;
    @FXML
    private TableColumn<reservation_expo, String> colprenomClient;
    @FXML
    private TableColumn<reservation_expo, Integer> coltelephone;
    @FXML
    private TableColumn<reservation_expo, String> colemail;
    @FXML
    private TableColumn<reservation_expo, Integer> colnbPlace;
    @FXML
    private TextField codeeeExpo;
    @FXML
    private TextField codeeeReservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         nb_place.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5000));
         showReservationE(); 
    }    
    
    public void setTfcodeeeEvent(String codeeeExpo) {
        this.codeeeExpo.setText(codeeeExpo);
    }


    @FXML
    private void getfromtv(MouseEvent event) {
          reservation_expo r= (reservation_expo) tveR.getSelectionModel().getSelectedItem();
            codeeeReservation.setText(""+r.getCode_reservationE());
            nom_client.setText(r.getNom_client());
            prenom_client.setText(r.getPrenom_client());
            telephone.setText(""+r.getTelephone());
            email.setText(r.getEmail());
            nb_place.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(r.getNb_place(), 5000));
    }
    
       public void showReservationE(){
           ReservationEMethods rem=new ReservationEMethods();
        ObservableList<reservation_expo> Reservationlist = rem.getReservationEList();
        colcode.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("code_reservationE"));
        colnomClient.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("nom_client"));
        colprenomClient.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("prenom_client"));
        coltelephone.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("telephone"));
        colemail.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("email"));
        colnbPlace.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("nb_place"));
        tveR.setItems(Reservationlist);
    } 
       
       @FXML
    private void AddReservationE(ActionEvent event) {
        int code_expo = Integer.parseInt(codeeeExpo.getText().trim());
         String nom= nom_client.getText();
            String prenom = prenom_client.getText();
            int nbplace= nb_place.getValue();
            int tel = Integer.valueOf(telephone.getText());
            String mail = email.getText();
            ReservationEMethods rm = new ReservationEMethods();
            reservation_expo r= new reservation_expo(nom,prenom,tel,mail,nbplace,code_expo);
            rm.AddReservationE(r);
            showReservationE();
    }
    
     @FXML
    private void UpdateReservationE(ActionEvent event) {
        
            int codeee_r = Integer.parseInt(codeeeReservation.getText().trim());
            String nom= nom_client.getText();
            String prenom = prenom_client.getText();
            int tel =  Integer.parseInt(telephone.getText().trim());
            String mail = email.getText();
            int nbplace = nb_place.getValue();
            ReservationEMethods rm = new ReservationEMethods();
            reservation_expo r= new reservation_expo(nom, prenom, tel, mail, nbplace);
            rm.UpdateReservation(r,codeee_r);
            showReservationE();
    }

    @FXML
    
    private void DeleteReservationE(ActionEvent event) {
                int codeee = Integer.parseInt(codeeeReservation.getText().trim());
//        Integer.parseInt(line.toString())
        ReservationEMethods em = new ReservationEMethods();
            em.DeleteExpo(codeee);
        showReservationE();
    }


    @FXML
    private void BACK(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("AddExposition.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
