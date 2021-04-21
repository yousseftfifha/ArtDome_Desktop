package Gui.Oeuvre;

import Entities.Cart;
import Entities.Oeuvre;
import Gui.HomeSceneController;
import Services.CartServices;
import Tools.UserHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class OeuvreItem implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private AnchorPane root;
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private JFXTextField CartNumber1;
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
            home = FXMLLoader.load(getClass().getResource("../HomeScene.fxml"));
            profiles = FXMLLoader.load(getClass().getResource("../User/Profile.fxml"));
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
        CartServices cartServices = new CartServices ();
        int i = cartServices.count ();
        CartNumber1.setText ("" + i);
        try {

            AfficherProduits ();
        } catch (Exception ex) {
            Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
        }
    }

    public void AfficherProduits() throws Exception {

        // clear existing content if it exists
        if (content.getChildren () != null) {
            content.getChildren ().clear ();
        }

        // get Elements to display
        CartServices ser = new CartServices ();
        List<Oeuvre> myList = new ArrayList<Oeuvre> ();
        myList = ser.readOeuvre ();

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

        // Container.setPadding(new Insets(30,30,30,30));
        HBox titre = new HBox ();
        Label image = new Label ("Image");
        image.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label nom = new Label ("Nom du produit");
        nom.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label prix = new Label ("Prix unitaire");
        Label update = new Label ("Action");
        update.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");

        image.setPrefWidth (200);
        image.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff");
        nom.setPrefWidth (380);
        update.setPrefWidth (300);
        prix.setPrefWidth (200);
        prix.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff");

        titre.getChildren ().add (image);
        titre.getChildren ().add (nom);
        titre.getChildren ().add (prix);
        titre.getChildren ().add (update);

        titre.setStyle ("-fx-background-color : linear-gradient(to top right, #ff7f50, #6a5acd)");

        Container.getChildren ().add (titre);
        HBox separ = new HBox ();
        separ.setPrefHeight (20);
        Container.getChildren ().add (separ);
        // iterate through all events and create an event element
        String color = "#ffffff;";
        for (Oeuvre m : myList) {

            //HBOX
            HBox Hb = new HBox ();
            Label nomque = new Label (m.getNomOeuvre ());
            nomque.setPrefWidth (280);
            nomque.setStyle ("-fx-padding : 20 20 0 35;-fx-text-fill: #000000; -fx-font-weight:bold;  -fx-font-size: 17;");
            URL l_url = new URL ("http://localhost:8080/artdome/" + m.getImageOeuvre ());
            BufferedImage imae = ImageIO.read (l_url);
            Image imge = SwingFXUtils.toFXImage (imae, null);
            ImageView img = new ImageView (imge);
            img.setFitHeight (140);
            img.setFitWidth (140);
            VBox btn = new VBox ();
            JFXButton update_btn = new JFXButton (" Add to cart ");
            update_btn.setStyle ("-fx-background-color: none; -fx-text-fill: #03568b; -fx-border-color: #03568b;-fx-border-width: 2; -fx-font-weight:bold; -fx-font-family: 'Oswald Regular'; -fx-font-size: 20");
            update_btn.setUnderline (true);
            btn.getChildren ().add (update_btn);
            Label prixl = new Label (String.valueOf (m.getPrixOeuvre ()));
            prixl.setMinWidth (200);
            prixl.setStyle ("-fx-padding : 20 20 0 35;-fx-text-fill: #000000; -fx-font-weight:bold;  -fx-font-size: 17;");


            Label space = new Label ("");
            space.setMinHeight (20);


            /* Action listeners  */


            update_btn.setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    int i=0;
                    CartServices cartServices = new CartServices ();
                    UserHolder holder = UserHolder.getInstance();
                    Cart cart = new Cart (holder.getUser());
                    List<Cart> cartList= cartServices.readAll ();
                    cartServices.AddCart (cart, m);
                    String title = "Cart ";
                    String message = "Vous avez ajouter une oeuvre: " + m.getNomOeuvre ();

                    TrayNotification tray = new TrayNotification ();
                    tray.setTitle (title);
                    tray.setMessage (message);
                    tray.setNotificationType (NotificationType.SUCCESS);
                    tray.showAndDismiss (Duration.millis (3200));
//                    if(!cartList.isEmpty ()){//ken lista fergha
//                    for (Cart cart1 : cartList){
//
//                        if (cart1.getNomOeuvre ().equals (m.getNomOeuvre ())){//ken l'oeuvre mawjouda
//                            cartCRUD.updateQuantity (LoggedInUser.get (0).getEmail (), m.getID_Oeuvre ());
//                            String title = "Cart ";
//                            String message = "you have updated the quantity of the product";
//
//                            TrayNotification tray = new TrayNotification();
//                            tray.setTitle(title);
//                            tray.setMessage(message);
//                            tray.setNotificationType(NotificationType.SUCCESS);
//                            tray.showAndDismiss (Duration.millis (3200));
//                        }
//                        else if(!cart1.getNomOeuvre ().equals (m.getNomOeuvre ()))//ken l'oeuvre mch mawjouda
//                        {
//                            cartCRUD.AddCart (cart, m);
//                            String title = "Cart ";
//                            String message = "Vous avez ajouter une oeuvre: " + m.getNomOeuvre ();
//
//                            TrayNotification tray = new TrayNotification ();
//                            tray.setTitle (title);
//                            tray.setMessage (message);
//                            tray.setNotificationType (NotificationType.SUCCESS);
//                            tray.showAndDismiss (Duration.millis (3200));
//                        }
//                    }
//                    }else//ken lista fergha //happens only once
//                    {
//                        cartCRUD.AddCart (cart, m);
//                        String title = "Cart ";
//                        String message = "Vous avez ajouter une oeuvre: " + m.getNomOeuvre ();
//
//                        TrayNotification tray = new TrayNotification ();
//                        tray.setTitle (title);
//                        tray.setMessage (message);
//                        tray.setNotificationType (NotificationType.SUCCESS);
//                        tray.showAndDismiss (Duration.millis (3200));
//                    }

                    int z = cartServices.count ();
                    CartNumber1.setText ("" + z);

                    try {
                        AfficherProduits ();
                    } catch (Exception ex) {
                        Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
                    }
                }
            });


            Label sep = new Label ("");
            sep.setPrefWidth (20);
            Hb.getChildren ().add (sep);
            Hb.getChildren ().add (img);
            Label sep1 = new Label ("");
            sep1.setPrefWidth (10);
            Hb.getChildren ().add (sep1);
            Hb.getChildren ().add (nomque);
            Label sep2 = new Label ("");
            sep2.setPrefWidth (10);
            Label sep3 = new Label ("");
            sep3.setPrefWidth (10);

            Hb.getChildren ().add (prixl);
            Hb.getChildren ().add (sep2);
            Hb.getChildren ().add (sep3);
            Hb.getChildren ().add (btn);

            Hb.setStyle ("-fx-background-color : #ffffff");

            // Add all the materiel elements to the event container

            HBox separ1 = new HBox ();
            separ1.setMinHeight (10);
            separ1.setMaxHeight (10);
            HBox separ2 = new HBox ();
            separ2.setMinHeight (20);
            Container.getChildren ().add (separ1);
            Container.getChildren ().add (Hb);
            Container.getChildren ().add (separ2);
            Container.setStyle ("-fx-background-color: #ffffff");

        }

        // Finally add all the events inside the Scrollpane to the main content Anchorpane

        content.getChildren ().add (scrollPane);
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
