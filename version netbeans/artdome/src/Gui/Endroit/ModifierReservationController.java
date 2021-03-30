/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Endroit;

import Tools.config;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import Entities.Client;
import Entities.ReservationE;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gamer
 */
public class ModifierReservationController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private Button chercher;
    @FXML
    private Pane p;
    @FXML
    private JFXTextField Tid_res, Tid_client, Tcautionnement, Tmat1, Tmat2;
    @FXML
    private DatePicker Tdate_debut, Tdate_fin, Tdate_retour;

    @FXML
    private void AffichRes(ActionEvent event) throws SQLException {
try {
        Connection con = config.getInstance().getConnection();

        ResultSet rs;

        rs = con.createStatement().executeQuery("SELECT * FROM reservation WHERE id_reservation=" + Integer.parseInt(Tid_res.getText()));
            if (rs.next()) {
                p.setOpacity(1);
                String matricule;
                matricule = rs.getString(3);
                

                Tid_res.setText(rs.getString(1));
                Tid_client.setText(rs.getString(2));
                Tcautionnement.setText(rs.getString(7));
                Tmat1.setText(String.valueOf(rs.getInt(3))); 
              
                Tdate_debut.setValue(rs.getDate(4).toLocalDate());
                Tdate_fin.setValue(rs.getDate(5).toLocalDate());
                Tdate_retour.setValue(rs.getDate(6).toLocalDate());
            } else {
                System.out.println("non trouvé");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("RESERVATION INCONNU");
                alert.setHeaderText(null);
                alert.setContentText("Il n'existe pas de reservation avec un tel ID");
                alert.showAndWait();
            }
        } 
catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }
        

    }

    @FXML
    private void modifierReservation(ActionEvent event) {
        try {

            ReservationE r = new ReservationE(Integer.parseInt(Tid_res.getText()), Integer.parseInt(Tid_client.getText()), Integer.parseInt(Tmat1.getText()), Tdate_debut.getValue(), Tdate_fin.getValue(), Tdate_retour.getValue(), Integer.parseInt(Tcautionnement.getText()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("CONFIRMATION");
                    alert.setHeaderText(null);
                    alert.setContentText("Voulez vous vraiment Modifier la  reservation ?");
                    Optional <ButtonType> result= alert.showAndWait();
                    if (result.get()== ButtonType.OK)
                    {
                            r.modifierReservation();
                             Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Reservation Modifié ",ButtonType.OK);
                            a.showAndWait();
                    }
        } catch (SQLException ex) {
            //Logger.getLogger(ModifierClientController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception ex) {
             Alert a = new Alert(Alert.AlertType.ERROR,"Veuillez Verifier les donnees saisises ",ButtonType.OK);
         a.showAndWait();
        }

    }
    @FXML
    private void Annuler(ActionEvent event)  {
    
     Tid_client.setText("");
     Tmat1.setText("");
     Tcautionnement.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void gotohome(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../HomeScene.fxml")));
        dialogStage.setTitle("ArtDome - Home");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotooeuvre(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotoorders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotoexpo(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/AddExposition.fxml")));
        dialogStage.setTitle("ArtDome - Exposition");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }


    @FXML
    private void gotoADDBLOG(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("BlogNew.fxml")));
        dialogStage.setTitle("ArtDome - New Blog");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotoprofile(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../User/Profile.fxml")));
        dialogStage.setTitle("ArtDome - Profile");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotoevent(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Event/ListEvent.fxml")));
        dialogStage.setTitle("ArtDome - Event");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotoblog(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Blog/BlogNew.fxml")));
        dialogStage.setTitle("ArtDome - New Blog");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void logout(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../User/Login.fxml")));
        dialogStage.setTitle("ArtDome - Login");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
}
