/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import Entities.User;
import Entities.UserHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ProfileController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private JFXButton home;
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
    private JFXPasswordField Tmdp;
    @FXML
    private JFXTextField Tprenom;
    @FXML
    private JFXTextField TNom;
    @FXML
    private DatePicker date;
    @FXML
    private JFXTextField Tnum;
    @FXML
    private JFXTextField Temail;
    @FXML
    private JFXTextField Tville;
    @FXML
    private JFXButton Bupdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        UserHolder holder = UserHolder.getInstance();
        holder.getUser();
        TNom.setText(holder.getUser().getNom());
        Tprenom.setText(holder.getUser().getPrenom());
        date.setValue(holder.getUser().getDatenaissance().toLocalDate());
        Tville.setText(holder.getUser().getVille());
        Temail.setText(holder.getUser().getEmail());
        Tnum.setText(String.valueOf(holder.getUser().getNumero()));
        Tmdp.setText(holder.getUser().getMdp());

   
    }    

    @FXML
    private void HandleHomeBtn(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../User/Profile.fxml")));
        dialogStage.setTitle ("ArtDome - Profile");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void handleOrdBTn(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../OrdersCart/Orders.fxml")));
        dialogStage.setTitle ("ArtDome - Orders");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }
    @FXML
    private void update(ActionEvent event)throws IOException {

        
    }
    @FXML
    private void profile(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../User/Profile.fxml")));
        dialogStage.setTitle ("ArtDome - Profile");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void event(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Event/ListEvent.fxml")));
        dialogStage.setTitle ("ArtDome - Event");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void blog(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Blog/BlogShow.fxml")));
        dialogStage.setTitle ("ArtDome - Blog");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void oeuvre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Oeuvre/Oeuvre.fxml")));
        dialogStage.setTitle ("ArtDome - Oeuvre");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void expo(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Exposition/AddReservation_expo.fxml")));
        dialogStage.setTitle ("ArtDome - Exposition");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }
}
