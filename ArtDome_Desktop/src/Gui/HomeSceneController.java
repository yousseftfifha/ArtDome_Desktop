package Gui;

import Entities.Cart;
import Entities.Oeuvre;
import Services.CartCRUD;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CartCRUD cartCRUD=new CartCRUD ();
        int i=cartCRUD.count ();
        CartNumber.setText (""+i);

        String title = "Welcome to ArtDome ";
        String message = "ArtDome is a Desktop application that provides to artists the opportunity to" +
                "share their works and gain money";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();

    }


    @FXML
    private void handleBtnOrder(ActionEvent actionEvent) throws IOException {

        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CartItem.fxml")));
        dialogStage.setTitle("ArtDome - Cart");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void AddToCart(ActionEvent actionEvent) {

            CartCRUD cartCRUD=new CartCRUD ();

            List<Oeuvre> oeuvre1=cartCRUD.selectOeuvreById (1);
            List<Oeuvre> oeuvre2=cartCRUD.selectOeuvreById (2);

            Cart cart=new Cart("youssef");

            cartCRUD.AddCart (cart,oeuvre1.get (0));
            cartCRUD.AddCart (cart,oeuvre2.get (0));

            cartCRUD.updateQuantity ("youssef",oeuvre1.get (0).getID_Oeuvre ());
            int i=cartCRUD.count ();
            CartNumber.setText (""+i);
        String title = "Cart ";
        String message = "Vous avez ajouter deux oeuvre: "+oeuvre1.get (0).getNomOeuvre ()+" et "+oeuvre2.get (0).getNomOeuvre ();

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();

    }

    @FXML
    private void handleOrder(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CheckOutScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
