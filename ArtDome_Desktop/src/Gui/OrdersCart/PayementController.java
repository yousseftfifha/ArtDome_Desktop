/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.OrdersCart;

import Entities.Orders;
import Services.CartServices;
import Services.OrdersService;
import Tools.MyConnection;
import Tools.UserHolder;
import javafx.scene.image.Image;

import Tools.Payment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * FXML Controller class
 *
 * @author MSF_Nabeul
 */
public class PayementController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TextField usermail;
    @FXML
    private Button boutonpayer;
    @FXML
    private TextField montant;
    @FXML
    private TextField First;
    @FXML
    private TextField Last;
    @FXML
    private TextField Number;
    @FXML
    private TextField Card;
    @FXML
    private TextField CVC;



    /**
     * Initializes the controller class.
     */
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyConnection myConnection = MyConnection.getInstance ();
        CartServices cartServices =new CartServices ();
        OrdersService ordersService =new OrdersService ();
        UserHolder holder = UserHolder.getInstance();
        List<Orders> LastOrder= ordersService.readprice();
        usermail.setText (holder.getUser().getEmail ());
        montant.setText (String.valueOf (((int) LastOrder.get (0).getDueAmount ())));
        First.setText (holder.getUser().getPrenom ());
        Last.setText (holder.getUser().getNom ());
        Number.setText (String.valueOf (holder.getUser().getNumero ()));
        Card.setText ("**** **** **** 5556");
        CVC.setText ("101");


    }

    @FXML
    private void payerService(ActionEvent event) throws IOException {


        ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
        emailExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Payment P=new Payment();

                P.RetrieveCustomer ();
                Integer Dueamount = Integer.parseInt(montant.getText());
                P.payement (Dueamount);

                try {
                    Desktop.getDesktop().browse(new URL("https://dashboard.stripe.com/test/customers/cus_J4vLHqM4VkGLnH?fbclid=IwAR0Qq32Mve6E-ETXw1HRGN8U35vckgJQz4-Sq11Ht5Xw2-Egv-ebZwNLq6Y").toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        emailExecutor.shutdown();
        Node source = (Node) event.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Orders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        String title = "Payement succesful";
        String message = "You payment  has been Approved";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));

        dialogStage.show();
               
    }

    @FXML
    private void gotoorders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Orders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
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
    private void goTohome(ActionEvent actionEvent) throws IOException {
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
    private void expo(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Exposition/AddReservation_expo.fxml")));
        dialogStage.setTitle ("ArtDome - Exposition");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }
}


