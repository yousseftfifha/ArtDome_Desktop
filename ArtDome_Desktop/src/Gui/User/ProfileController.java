/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import Entities.User;
import Services.UserService;
import Tools.UserHolder;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../HomeScene.fxml")));
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
    private void update(ActionEvent event){
        try{
            String x1=String.valueOf(date.getValue());
            Date x = java.sql.Date.valueOf(x1);
            int i = Integer.parseInt(Tnum.getText().trim());
            //int idd = Integer.parseInt(Tid.getText().trim());
            UserHolder holder = UserHolder.getInstance();

            User u = new User(holder.getUser().getId(),TNom.getText(),Tprenom.getText(),x,Tville.getText(),Temail.getText(),i,Tmdp.getText());
            UserService crd = new UserService ();
            crd.UpdateUser(u);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("UPDATE AVEC SUCCES");
            alert.setHeaderText(null);
            alert.setContentText("L'utilisateur "+u.getPrenom()+" "+u.getNom()+" a été mis a jour avec succès");
            alert.showAndWait();
            holder.setUser (u);
            holder.getUser();
            TNom.setText(holder.getUser().getNom());
            Tprenom.setText(holder.getUser().getPrenom());
            date.setValue(holder.getUser().getDatenaissance().toLocalDate());
            Tville.setText(holder.getUser().getVille());
            Temail.setText(holder.getUser().getEmail());
            Tnum.setText(String.valueOf(holder.getUser().getNumero()));
            Tmdp.setText(holder.getUser().getMdp());

        }

        catch(RuntimeException ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ", ButtonType.CLOSE);
            alert.showAndWait();
        }

    }
    @FXML
    private void request (ActionEvent event )throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Request");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("request.fxml"))));
        stage.show();

    }
    @FXML
    private void delete (ActionEvent event) throws IOException {
        UserHolder holder = UserHolder.getInstance();
        UserService crd = new UserService ();
        crd.DeleteUser(holder.getUser().getId());
        Node source = (Node) event.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Login.fxml")));
        dialogStage.setTitle("ArtDome - Cart");
        dialogStage.setScene(scene);
        dialogStage.show();

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
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Oeuvre/OeuvreItem.fxml")));
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

    @FXML
    private void location(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Endroit/AfficherReservation.fxml")));
        dialogStage.setTitle ("ArtDome - Endroit");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }
}
