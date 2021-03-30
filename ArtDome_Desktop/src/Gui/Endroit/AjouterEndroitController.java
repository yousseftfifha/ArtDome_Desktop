/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Endroit;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.util.Duration;
import Entities.Endroit;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterEndroitController implements Initializable {

    @FXML
    private JFXTextField prixjour;
    @FXML
    private JFXTextField Type;
    @FXML
    private JFXTextField Endroit;
    @FXML
    private JFXTextField position;
    @FXML
    private JFXTextField nbrch;
    @FXML
    private JFXTextField Taille;

    /**
     * Initializes the controller class.
     */
    
    String chemin = "";
        Stage primaryStage = new Stage();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjoutEndroit(ActionEvent event) {
        try
        {
        Endroit e=new Endroit(Type.getText(),Integer.valueOf(Taille.getText()),Integer.valueOf(prixjour.getText()),Integer.valueOf(nbrch.getText()),position.getText());
            try {
                e.ajouterEndroit();
            } catch (SQLException ex) {
                Logger.getLogger(AjouterEndroitController.class.getName()).log(Level.SEVERE, null, ex);
            }
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION," Endroit ajoutée avec succes  ",ButtonType.FINISH);
        alert.showAndWait();
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
        
        String title = "Succes! ";
        String message = "L'endroit est ajouté avec succés";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(5));

    }

    @FXML
    private void Annuler(ActionEvent event) {
     prixjour.setText("");
     Type.setText("");
     Taille.setText("");
     position.setText("");
     nbrch.setText("");

    }
     @FXML
    private void Position(ActionEvent event) {
        chemin = "FXMLDocument.fxml";
	new OpenWindow2(primaryStage,chemin, "ajouter");

    }
    
    
}
