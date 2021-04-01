/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Endroit;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Tools.config;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
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
public class AfficherEndroitController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TableView<Endroit> table;
    @FXML
    private TableColumn<Endroit, Integer> col_id_endroit;
    @FXML
    private TableColumn<Endroit, String> col_type;
    @FXML
    private TableColumn<Endroit, Integer> col_prix;
    @FXML
    private TableColumn<Endroit, Integer> col_nbrch;
    @FXML
    private TableColumn<Endroit, String> col_position;
    @FXML
    private TableColumn<Endroit, Integer> col_taille;
    @FXML
    private TableColumn<Endroit, String> col_dispo;
    @FXML
    private TableColumn<Endroit, String> col_date1;
    @FXML
    private TableColumn<Endroit, String> col_date2;

    ObservableList<Endroit> oblist = FXCollections.observableArrayList();


        String chemin = "";
    String title = "";
    Stage primaryStage = new Stage();

    @FXML
    private Pane contenu;

    @FXML
    void handleAddAction(ActionEvent event) {
        chemin = "AjouterEndroit.fxml";
	new OpenWindow2(primaryStage,chemin, "ajouter");

    }

    @FXML
    void recherche(ActionEvent event) {


    }
    @FXML
    private JFXTextField idendroit;

    @FXML
    void ModifierEndroit(ActionEvent event) {
        chemin = "ModifierEndroit.fxml";
	new OpenWindow2(primaryStage,chemin, "modifier");

    }

    @FXML
    private void handleBSupprimerEndroit(ActionEvent event) throws IOException, SQLException {
        Endroit r = new Endroit(Integer.parseInt(idendroit.getText()));
        if (r.exist()==true)
        {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("Voulez vous vraiment supprimer cet endroit?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            r.supprimerEndroit();
        }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Endroit inexistant",ButtonType.CLOSE);
            alert.showAndWait();
        }
        String title = "Succes! ";
        String message = "L'endroit est supprimé";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(5));


    }



    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Connection con =config.getInstance().getConnection();


            ResultSet rs;

            rs = con.createStatement().executeQuery("SELECT e.id_endroit, e.type, e.taille, e.prix_jour, e.nbrch, e.location, e.disponibilite , r.date_debut,r.date_fin FROM endroit e INNER JOIN reservation as r ON e.id_endroit = r.matricule");

            System.out.println("f");
            while (rs.next())
            {   Endroit e=new Endroit(rs.getInt(1),rs.getString(2),rs.getInt(3),
                        rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                oblist.add(e);

            }


             System.out.println("f");

            col_id_endroit.setCellValueFactory(new PropertyValueFactory<>("id_endroit"));
            col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
            col_taille.setCellValueFactory(new PropertyValueFactory<>("taille"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("prix_jour"));
            col_nbrch.setCellValueFactory(new PropertyValueFactory<>("nbrch"));
            col_position.setCellValueFactory(new PropertyValueFactory<>("location"));
            col_dispo.setCellValueFactory(new PropertyValueFactory<>("dispo"));
            col_date1.setCellValueFactory(new PropertyValueFactory<>("date1"));
            col_date2.setCellValueFactory(new PropertyValueFactory<>("date2"));



            System.out.println("ffff");

            table.setItems(oblist);
            System.out.println("ffff");

        } catch (SQLException ex) {
            Logger.getLogger(AfficherEndroitController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

    }
    @FXML
    private void gotoevent(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Event/AddEvent.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Event");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
    @FXML
    private void showOrders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../DashOrdersCart/DashBoardOrders.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Orders");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
    @FXML
    private void gotoOeuvre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Oeuvre/Oeuvre.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotooexpo(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/Reservation_expoBack.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotouser(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../User/User.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void endroit(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Endroit/AfficherEndroit.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Endroit");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void home(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../DashBoardScene.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Endroit");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
}
