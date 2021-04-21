/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import Entities.User;
import Gui.HomeSceneController;
import Services.UserService;
import Tools.UserHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ProfileController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;

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
    @FXML
    private AnchorPane holderPane;
    @FXML
    AnchorPane home,oeuvre,event,profiles,expo,blog,orders,location,login,cart;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            oeuvre = FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml"));
            event = FXMLLoader.load(getClass().getResource("../Event/ListEvent.fxml"));
            expo = FXMLLoader.load(getClass().getResource("../Exposition/AddReservation_expo.fxml"));
            blog = FXMLLoader.load(getClass().getResource("../Blog/BlogShow.fxml"));
            orders = FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml"));
            location = FXMLLoader.load(getClass().getResource("../Endroit/AfficherReservation.fxml"));
            login = FXMLLoader.load(getClass().getResource("../User/Login.fxml"));
            cart = FXMLLoader.load(getClass().getResource("../OrdersCart/CartView.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(HomeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
