package Gui;

import Entities.Cart;
import Entities.Oeuvre;
import Services.CartServices;
import Tools.UserHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    @FXML
    private AnchorPane holderPane;
    @FXML
    AnchorPane home,oeuvre,event,profiles,expo,blog,orders,location,login,cart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            oeuvre = FXMLLoader.load(getClass().getResource("Oeuvre/OeuvreItem.fxml"));
            event = FXMLLoader.load(getClass().getResource("Event/ListEvent.fxml"));
            expo = FXMLLoader.load(getClass().getResource("Exposition/AddReservation_expo.fxml"));
            blog = FXMLLoader.load(getClass().getResource("Blog/BlogShow.fxml"));
            orders = FXMLLoader.load(getClass().getResource("OrdersCart/Orders.fxml"));
            location = FXMLLoader.load(getClass().getResource("Endroit/AfficherReservation.fxml"));
            login = FXMLLoader.load(getClass().getResource("User/Login.fxml"));
            cart = FXMLLoader.load(getClass().getResource("OrdersCart/CartView.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(HomeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }


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
