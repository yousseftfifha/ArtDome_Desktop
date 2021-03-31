/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Entities.User;
import Services.UserService;
import java.sql.Date;
import javax.mail.MessagingException;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class SignUpController implements Initializable {

    @FXML
    private JFXPasswordField Tmdp;
    @FXML
    private JFXPasswordField tmdp2;
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
    private JFXButton BAjout;
    @FXML
    private Label LBerror;
    @FXML
    private ImageView erreur;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBAjout(ActionEvent event) throws MessagingException {
        try{

                String x1 = String.valueOf (date.getValue ());
                Date x = java.sql.Date.valueOf (x1);
                int i = Integer.parseInt (Tnum.getText ().trim ());
                User u = new User (TNom.getText (), Tprenom.getText (), x, Tville.getText (), Temail.getText (), i, Tmdp.getText ());
                UserService crd = new UserService ();
                crd.AddUser (u);
                Alert alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setTitle ("AJOUT AVEC SUCCES");
                alert.setHeaderText (null);
                alert.setContentText ("L'employé " + u.getPrenom () + " " + u.getNom () + " a été ajouté avec succès");
                alert.showAndWait ();

        }
        /*catch(SQLException ex)
        {
             Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }*/
        catch(RuntimeException ex)
        {
             Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }
        try {
        Stage stage = new Stage();
        stage.setTitle("ArtDome");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml"))));
                    stage.show();
        BAjout.getScene().getWindow().hide();
        } 
        catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
