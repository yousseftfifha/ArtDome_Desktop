/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Cart;
import Entities.Oeuvre;
import Entities.Orders;
import Entities.User;
import Services.CartCRUD;
import Services.OrdersCRUD;
import Tools.MyConnection;
import Tools.Payment;
import Tools.SendEmail;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
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
    @FXML
    private JFXDatePicker Date;


    /**
     * Initializes the controller class.
     */
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyConnection myConnection = MyConnection.getInstance ();
        CartCRUD cartCRUD=new CartCRUD ();
        OrdersCRUD ordersCRUD=new OrdersCRUD ();

        List<User> LoggedInUser=cartCRUD.readLoggedInUser ();
        List<Orders> LastOrder=ordersCRUD.readprice();
        usermail.setText (LoggedInUser.get (0).getEmail ());
        montant.setText (String.valueOf (((int) LastOrder.get (0).getDueAmount ())));
        First.setText (LoggedInUser.get (0).getPrenom ());
        Last.setText (LoggedInUser.get (0).getNom ());
        Number.setText (String.valueOf (LoggedInUser.get (0).getNumero ()));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("CheckOutScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("CheckOutScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void gotooeuvre(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("OeuvreItem.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void goTohome(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("HomeScene.fxml")));
        dialogStage.setTitle("ArtDome - Home");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}


