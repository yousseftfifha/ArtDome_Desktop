package Gui;

import Entities.Cart;
import Entities.Oeuvre;
import Entities.User;
import Entities.UserHolder;
import Services.CartServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author tfifha youssef
 */

public class HomeSceneController implements Initializable {
    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton OrdersB;
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private JFXButton AddToCart;
    @FXML
    private JFXTextField CartNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        CartServices cartServices =new CartServices ();
        int i= cartServices.count ();
        CartNumber.setText (""+i);
        UserHolder holder = UserHolder.getInstance();
        String title = "Welcome "+holder.getUser().getEmail ()+" to ArtDome ";
        String message = "ArtDome is a Desktop application that provides to artists the opportunity to" +
                "share their works and gain money";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));

    }


    @FXML
    private void handleBtnOrder(ActionEvent actionEvent) throws IOException {

        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("OrdersCart/CartView.fxml")));
        dialogStage.setTitle("ArtDome - Cart");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
//        dialogStage.sizeToScene();
        dialogStage.show();
    }

    @FXML
    private void AddToCart(ActionEvent actionEvent) {

            CartServices cartServices =new CartServices ();

//            List<Oeuvre> oeuvre1=cartCRUD.selectOeuvreById (1);
//            List<Oeuvre> oeuvre2=cartCRUD.selectOeuvreById (2);
            List<Oeuvre> oeuvres= cartServices.readOeuvre ();
        UserHolder holder = UserHolder.getInstance();
            Cart cart=new Cart(holder.getUser());
             cart.setOeuvre1 (oeuvres);
            for (Oeuvre oeuvre :cart.getListOeuvre ()){
                cartServices.AddCart (cart,oeuvre);
            }

            int i= cartServices.count ();
            CartNumber.setText (""+i);
        String title = "Cart ";
        String message = "Vous avez ajouter tous les oeuvre: ";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));

    }

    @FXML
    private void handleOrder(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("OrdersCart/Orders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
//        dialogStage.setFullScreen(true);
        dialogStage.show();
    }

    @FXML
    private void GoToOeuvre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Oeuvre/OeuvreItem.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void goToExpos(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Exposition/AddReservation_expo.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();

    }

    @FXML
    private void gotoevent(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Event/ListEvent.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("Blog/BlogShow.fxml")));
        dialogStage.setTitle("ArtDome - Blog");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }


    @FXML
    private void gotoprofile(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("User/Profile.fxml")));
        dialogStage.setTitle("ArtDome - User");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
}
