package Gui;

import Entities.Event;
import Entities.Notification;
import Entities.Orders;
import Entities.PendingOrders;
import Gui.Oeuvre.OeuvreItem;
import Services.NotificationCRUD;
import Services.OrdersService;
import Services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;

import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
public class DashBoardSceneController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private PieChart chart;
    @FXML
    private JFXTextField term;
    @FXML
    private AnchorPane content;
    @FXML
    private AnchorPane root;

    @FXML
    private void searchForTerm(ActionEvent actionEvent) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            NotificationCRUD notificationCRUD = new NotificationCRUD ();
            ObservableList<Notification> notifications = notificationCRUD.readNotif ();

            ShowNotification (notifications);
        } catch (Exception ex) {
            Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gotoevent(ActionEvent actionEvent) throws IOException {
            Node source = (Node) actionEvent.getSource();
            dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
            scene = new Scene (FXMLLoader.load(getClass().getResource("Event/AddEvent.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("DashOrdersCart/DashBoardOrders.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("Oeuvre/Oeuvre.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("Exposition/Reservation_expoBack.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("User/User.fxml")));
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
        scene = new Scene (FXMLLoader.load(getClass().getResource("Endroit/AfficherEndroit.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Endroit");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
    @FXML
    private void logout(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("User/Login.fxml")));
        dialogStage.setTitle("ArtDome - Login");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
    public void ShowNotification( ObservableList<Notification> lista) throws Exception {

        // clear existing content if it exists
        if (content.getChildren () != null) {
            content.getChildren ().clear ();
        }

        // get Elements to display

        VBox Container = new VBox ();  // main container for all data specific to a materiel

        ScrollPane scrollPane = new ScrollPane (Container);
        scrollPane.setMinSize (1000, 400);
        scrollPane.setHbarPolicy (ScrollPane.ScrollBarPolicy.NEVER);

        AnchorPane.setTopAnchor (scrollPane, 0.);
        Container.setMinWidth (1000);
        Container.setMinWidth (400);

        content.setRightAnchor (scrollPane, 0.);
        content.setBottomAnchor (scrollPane, 0.);
        content.setLeftAnchor (scrollPane, 0.);

        //Container.setPadding(new Insets (30,30,30,30));
        HBox titre = new HBox ();
        Label NotifcationId = new Label ("Notifcation ID");
        NotifcationId.setStyle ("-fx-alignment : center;   -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label Name = new Label ("Name");
        Name.setStyle ("-fx-alignment : center;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label LastName = new Label ("LastName");
        LastName.setStyle ("-fx-alignment : center;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label Type = new Label ("Type");
        Type.setStyle ("-fx-alignment : center;   -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label Email = new Label ("Email");
        Email.setStyle ("-fx-alignment : center;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label Number = new Label ("Number");
        Number.setStyle ("-fx-alignment : center;   -fx-font-size: 17; -fx-text-fill: #ffffff ");

        Label update = new Label ("Action");
        update.setStyle ("-fx-alignment : center;   -fx-font-size: 17; -fx-text-fill: #ffffff ");

        NotifcationId.setMinWidth (200);
        Name.setMinWidth (200);
        LastName.setMinWidth (200);
        Type.setMinWidth (100);
        Email.setMinWidth (200);
        Number.setMinWidth (400);
        update.setMinWidth (200);

        titre.getChildren ().add (NotifcationId);
        titre.getChildren ().add (Name);
        titre.getChildren ().add (LastName);
        titre.getChildren ().add (Type);
        titre.getChildren ().add (Email);
        titre.getChildren ().add (Number);
        titre.getChildren ().add (update);

        titre.setStyle ("-fx-background-color : linear-gradient(to top right, #ff7f50, #6a5acd)");

        Container.getChildren ().add (titre);
        Label sep = new Label("   ");
        sep.setMinWidth(100);
        Label sep1 = new Label("   ");
        sep1.setMinWidth(100);
        Label sep2 = new Label("   ");
        sep2.setMinWidth(100);
        Label sep3 = new Label("   ");
        sep3.setMinWidth(100);
        Label sep4 = new Label("   ");
        sep4.setMinWidth(100);
        Label sep5 = new Label("   ");
        sep5.setMinWidth(100);
        Label sep6 = new Label("   ");
        sep6.setMinWidth(100);
        Label sep7 = new Label("   ");
        sep7.setMinWidth(100);
        // iterate through all events and create an event element
        String color = "#ffffff;";
        for (Notification orders : lista) {

            //HBOX
            HBox Hb = new HBox ();

            Label NotfiId = new Label (String.valueOf (orders.getId ()));
            NotfiId.setMinWidth (200);
            NotfiId.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            Label TypeL = new Label (orders.getU ().getRole ());
            TypeL.setMinWidth (200);
            TypeL.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            Label Namel = new Label (String.valueOf (orders.getU ().getNom ()));
            Namel.setMinWidth (200);
            Namel.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;   -fx-font-size: 17;");

            Label Lastl = new Label (String.valueOf (orders.getU ().getPrenom ()));
            Lastl.setMinWidth (200);
            Lastl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            Label EmailL = new Label (String.valueOf (orders.getU ().getEmail ()));
            EmailL.setMinWidth (200);
            EmailL.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            Label NumberL = new Label (String.valueOf (orders.getU ().getNumero ()));
            NumberL.setMinWidth (200);
            NumberL.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;   -fx-font-size: 17;");


            VBox btn = new VBox ();

            JFXButton Valider = new JFXButton ("Confirm");
            Valider.setMinWidth (200);
            Valider.setStyle ("-fx-background-color: none; -fx-text-fill: #03568b; -fx-border-color: #03568b;-fx-border-width: 2; -fx-font-weight:bold;  -fx-font-size: 20");

            JFXButton Cancel = new JFXButton ("Cancel");
            Cancel.setMinWidth (200);
            Cancel.setStyle ("-fx-background-color: none; -fx-text-fill: #03568b; -fx-border-color: #03568b;-fx-border-width: 2; -fx-font-weight:bold;  -fx-font-size: 20");

            Label space = new Label("");
            space.setMinHeight(20);
            Label space1 = new Label("");
            space.setMinHeight(20);
            btn.getChildren().add(space);
            btn.getChildren ().add (Valider);
            btn.getChildren ().add (space1);
            btn.getChildren ().add (Cancel);



            /* Action listeners  */
            Valider.setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    UserService ordersService =new UserService ();
                    NotificationCRUD notificationCRUD=new NotificationCRUD ();


                    ordersService.updateRole (orders.getU (), notificationCRUD.FindRole (orders.getId ()));
                    try {

                        ObservableList<Notification> notifications = notificationCRUD.readNotif ();
                        notificationCRUD.DeleteNotif (orders.getId ());

                        ShowNotification (notifications);
                    } catch (Exception ex) {
                        Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
                    }
                }
            });
            Cancel.setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    NotificationCRUD notificationCRUD=new NotificationCRUD ();
                    notificationCRUD.DeleteNotif (orders.getId ());
                    try {
                        ObservableList<Notification> notifications = notificationCRUD.readNotif ();

                        ShowNotification (notifications);
                    } catch (Exception ex) {
                        Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
                    }
                }
            });




            Hb.getChildren ().add (NotfiId);

            Hb.getChildren ().add (Namel);

            Hb.getChildren ().add (Lastl);
            Hb.getChildren ().add (TypeL);

            Hb.getChildren ().add (EmailL);

            Hb.getChildren ().add (NumberL);
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

    @FXML
    private void LOGOUT(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("User/Login.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
}
