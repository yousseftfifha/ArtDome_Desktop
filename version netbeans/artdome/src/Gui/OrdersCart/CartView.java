package Gui.OrdersCart;

import Entities.Cart;
import Entities.User;
import Gui.Oeuvre.OeuvreItem;
import Services.CartCRUD;
import Services.OrdersCRUD;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class CartView implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private AnchorPane content;
    @FXML
    private AnchorPane root;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            ShowCart ();
        } catch (Exception ex) {
            Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
        }
    }

    public void ShowCart() throws Exception {

        // clear existing content if it exists
        if (content.getChildren () != null) {
            content.getChildren ().clear ();
        }

        // get Elements to display
        CartCRUD cartCRUD = new CartCRUD ();
        List<Cart> myList = new ArrayList<Cart> ();
        myList = cartCRUD.readAll ();

        VBox Container = new VBox ();  // main container for all data specific to a materiel

        ScrollPane scrollPane = new ScrollPane (Container);
        scrollPane.setPrefSize (1000, 400);
        scrollPane.setHbarPolicy (ScrollPane.ScrollBarPolicy.NEVER);

        AnchorPane.setTopAnchor (scrollPane, 0.);
        Container.setPrefWidth (1000);
        Container.setPrefHeight (400);

        content.setRightAnchor (scrollPane, 0.);
        content.setBottomAnchor (scrollPane, 0.);
        content.setLeftAnchor (scrollPane, 0.);

         //Container.setPadding(new Insets (30,30,30,30));
        HBox titre = new HBox ();
        Label CartID = new Label ("CartID");
        CartID.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label OeuvreID = new Label ("OeuvreID");
        OeuvreID.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label Quantiy = new Label ("Quantiy");
        Quantiy.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label NomOeuvre = new Label ("NomOeuvre");
        NomOeuvre.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");

        Label update = new Label ("Action");
        update.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");

        CartID.setMinWidth (300);
        OeuvreID.setMinWidth (100);
        Quantiy.setMinWidth (100);
        NomOeuvre.setMinWidth (200);
        update.setMinWidth (100);

        titre.getChildren ().add (CartID);
        titre.getChildren ().add (OeuvreID);
        titre.getChildren ().add (Quantiy);
        titre.getChildren ().add (NomOeuvre);
        titre.getChildren ().add (update);

        titre.setStyle ("-fx-background-color : linear-gradient(to top right, #ff7f50, #6a5acd)");

        Container.getChildren ().add (titre);
        Label sep = new Label ("   ");
        sep.setMinWidth (100);
        Label sep1 = new Label ("   ");
        sep1.setMinWidth (100);
        Label sep2 = new Label ("   ");
        sep2.setMinWidth (100);
        Label sep3 = new Label ("   ");
        sep3.setMinWidth (100);
        Label sep4 = new Label ("   ");
        sep4.setMinWidth (100);
        Label sep5 = new Label ("   ");
        sep5.setMinWidth (100);
        Label sep6 = new Label ("   ");
        sep6.setMinWidth (100);
        Label sep7 = new Label ("   ");
        sep7.setMinWidth (100);
        // iterate through all events and create an event element
        String color = "#ffffff;";
        for (Cart cart : myList) {

            //HBOX
            HBox Hb = new HBox ();

            Label CartIDL = new Label (cart.getCartId ());
            CartIDL.setPrefWidth (300);
            CartIDL.setStyle (" -fx-alignment : center;-fx-text-fill: #000000;   -fx-font-size: 17;");

            Label OeuvreIDl = new Label (String.valueOf (cart.getOeuvreID ()));
            OeuvreIDl.setMinWidth (100);
            OeuvreIDl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;   -fx-font-size: 17;");

            Label QuantityL = new Label (String.valueOf (cart.getQuantity ()));
            QuantityL.setMinWidth (100);
            QuantityL.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;   -fx-font-size: 17;");

            Label NomOeuvreL = new Label (cart.getNomOeuvre ());
            NomOeuvreL.setMinWidth (200);
            NomOeuvreL.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;   -fx-font-size: 17;");

            VBox btn = new VBox ();

            JFXButton ADD1_btn = new JFXButton ("+ Increase");
            ADD1_btn.setStyle ("-fx-background-color: none; -fx-text-fill: #03568b; -fx-border-color: #03568b;-fx-border-width: 2; -fx-font-weight:bold;  -fx-font-size: 20");

            JFXButton Remove1_btn = new JFXButton ("- Decrease");
            Remove1_btn.setStyle ("-fx-background-color: none; -fx-background-color: none; -fx-text-fill: #03568b; -fx-border-color: #03568b;-fx-border-width: 2; -fx-font-weight:bold;  -fx-font-size: 20");


            Label space = new Label("");
            space.setMinHeight(20);
            Label space1 = new Label("");
            space.setMinHeight(20);
            btn.getChildren ().add (ADD1_btn);
            btn.getChildren().add(space);
            btn.getChildren ().add (Remove1_btn);
            btn.getChildren().add(space1);


            /* Action listeners  */


            ADD1_btn.setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    CartCRUD cartCRUD=new CartCRUD ();
                    List<User> LoggedInUser=cartCRUD.readLoggedInUser ();
                    cartCRUD.updateQuantity (LoggedInUser.get (0).getEmail (),cart.getOeuvreID ());

                    System.out.println("aasba");

                    try {
                        ShowCart ();
                    } catch (Exception ex) {
                        Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
                    }
                }
            });
            Remove1_btn.setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    CartCRUD cartCRUD=new CartCRUD ();
                    List<User> LoggedInUser=cartCRUD.readLoggedInUser ();
                    cartCRUD.updateQuantity1(LoggedInUser.get (0).getEmail (),cart.getOeuvreID ());
                    System.out.println("aasba1");
                    if (cart.getQuantity ()==0){
                        cartCRUD.DeletOeuvreCart (cart.getOeuvreID ());
                        Node source = (Node) event.getSource ();
                        dialogStage = (Stage) source.getScene ().getWindow ();
                        dialogStage.close ();
                        try {
                            scene = new Scene (FXMLLoader.load (getClass ().getResource ("CartView.fxml")));
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                        dialogStage.setTitle ("ArtDome - Home");
                        dialogStage.setScene (scene);
                        dialogStage.show ();
                    }
                    try {
                        ShowCart ();
                    } catch (Exception ex) {
                        Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
                    }
                }
            });
            if (cart.getQuantity ()==0){
                cartCRUD.DeletOeuvreCart (cart.getOeuvreID ());
                ShowCart ();
                String title = "Cart ";
                String message = "you have removed  the product from cart";

                TrayNotification tray = new TrayNotification();
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss (Duration.millis (3200));
            }

            Hb.getChildren ().add (CartIDL);
            Hb.getChildren ().add (OeuvreIDl);
            Hb.getChildren ().add (QuantityL);
            Hb.getChildren ().add (NomOeuvreL);
            Hb.getChildren ().add (btn);

            Hb.setStyle ("-fx-background-color : #ffffff");

            // Add all the materiel elements to the event container


            Container.getChildren ().add (Hb);
            Container.setStyle ("-fx-background-color: #ffffff");

        }

        // Finally add all the events inside the Scrollpane to the main content Anchorpane

        content.getChildren ().add (scrollPane);
    }


    @FXML
    private void gotohome(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../HomeScene.fxml")));
        dialogStage.setTitle ("ArtDome - Home");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void gotooeuvre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Oeuvre/OeuvreItem.fxml")));
        dialogStage.setTitle ("ArtDome - Oeuvre");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void gotoexpo(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Exposition/AddExposition.fxml")));
        dialogStage.setTitle ("ArtDome - Exposition");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void gotoorders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("Orders.fxml")));
        dialogStage.setTitle ("ArtDome - Orders");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void check(ActionEvent actionEvent) throws IOException, MessagingException, URISyntaxException, DocumentException {
        OrdersCRUD ordersCRUD=new OrdersCRUD ();
        CartCRUD cartCRUD=new CartCRUD ();
        List<User> LoggedInUser=cartCRUD.readLoggedInUser ();
        ordersCRUD.AddFromCart (LoggedInUser.get (0).getId ());
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("payement.fxml")));
        dialogStage.setTitle("ArtDome - Home");
        dialogStage.setScene(scene);
        dialogStage.show();
        String title = "Order ";
        String message = "You Order  has been Added";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));
    }
}
