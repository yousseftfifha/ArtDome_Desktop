package Gui;

import Entities.Cart;
import Entities.Oeuvre;
import Entities.User;
import Services.CartCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
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


        CartCRUD cartCRUD=new CartCRUD ();
        int i=cartCRUD.count ();
        CartNumber.setText (""+i);

        List<User> u=cartCRUD.readLoggedInUser ();
        String title = "Welcome "+u.get (0).getEmail ()+" to ArtDome ";
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
//        dialogStage.sizeToScene();
        dialogStage.show();
    }

    @FXML
    private void AddToCart(ActionEvent actionEvent) {

            CartCRUD cartCRUD=new CartCRUD ();

//            List<Oeuvre> oeuvre1=cartCRUD.selectOeuvreById (1);
//            List<Oeuvre> oeuvre2=cartCRUD.selectOeuvreById (2);
            List<Oeuvre> oeuvres=cartCRUD.readOeuvre ();

            List<User> LoggedInUser=cartCRUD.readLoggedInUser ();
            Cart cart=new Cart(LoggedInUser.get (0));
             cart.setOeuvre1 (oeuvres);
            for (Oeuvre oeuvre :cart.getListOeuvre ()){
                cartCRUD.AddCart (cart,oeuvre);
            }

            int i=cartCRUD.count ();
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
        dialogStage.show();
    }

    @FXML
    private void goToExpos(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Exposition/AddExposition.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.show();

    }
}
