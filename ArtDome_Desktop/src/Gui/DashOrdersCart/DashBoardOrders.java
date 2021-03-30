package Gui.DashOrdersCart;

import Entities.Orders;
import Entities.PendingOrders;
import Gui.DashBoardSceneController;
import Gui.Event.ReservationBackController;
import Gui.Oeuvre.OeuvreItem;
import Services.OrdersCRUD;
import Tools.*;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import jxl.write.WriteException;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javafx.scene.image.Image;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class DashBoardOrders  implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private AnchorPane content;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXComboBox status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            OrdersCRUD ordersCRUD = new OrdersCRUD ();
            List<Orders> ordersList = ordersCRUD.readAllOrders ();
            ShowOrders (ordersList);
        } catch (Exception ex) {
            Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
        }
        status.getItems ().add("confirmed");
        status.getItems ().add("cancelled");
        status.getItems ().add("pending");

    }

    public void ShowOrders( List<Orders> lista) throws Exception {

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
        Label OrderID = new Label ("OrderID");
        OrderID.setStyle ("-fx-alignment : center;   -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label UserName = new Label ("UserName");
        UserName.setStyle ("-fx-alignment : center;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label DueAmount = new Label ("DueAmount");
        DueAmount.setStyle ("-fx-alignment : center;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label InnoNumber = new Label ("InnoNumber");
        InnoNumber.setStyle ("-fx-alignment : center;   -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label TotalQty = new Label ("TotalQty");
        TotalQty.setStyle ("-fx-alignment : center;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label OrderDate = new Label ("OrderDate");
        OrderDate.setStyle ("-fx-alignment : center;   -fx-font-size: 17; -fx-text-fill: #ffffff ");
        Label Status = new Label ("Status");
        Status.setStyle ("-fx-alignment : center;  -fx-font-size: 17; -fx-text-fill: #ffffff ");


        Label update = new Label ("Action");
        update.setStyle ("-fx-alignment : center;   -fx-font-size: 17; -fx-text-fill: #ffffff ");

        OrderID.setMinWidth (200);
        UserName.setMinWidth (200);
        DueAmount.setMinWidth (200);
        TotalQty.setMinWidth (100);
        InnoNumber.setMinWidth (200);
        OrderDate.setMinWidth (400);
        Status.setMinWidth (200);
        update.setMinWidth (200);

        titre.getChildren ().add (OrderID);
        titre.getChildren ().add (UserName);
        titre.getChildren ().add (DueAmount);
        titre.getChildren ().add (InnoNumber);
        titre.getChildren ().add (TotalQty);
        titre.getChildren ().add (OrderDate);
        titre.getChildren ().add (Status);
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
        for (Orders orders : lista) {

            //HBOX
            HBox Hb = new HBox ();

            Label OrderIDl = new Label (String.valueOf (orders.getOrderID ()));
            OrderIDl.setMinWidth (200);
            OrderIDl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            Label UserNamel = new Label (orders.getUserName ());
            UserNamel.setMinWidth (200);
            UserNamel.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            Label DueAmountl = new Label (String.valueOf (orders.getDueAmount ()));
            DueAmountl.setMinWidth (200);
            DueAmountl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;   -fx-font-size: 17;");

            Label InnoNumberl = new Label (String.valueOf (orders.getInnoNumber ()));
            InnoNumberl.setMinWidth (200);
            InnoNumberl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            Label TotalQtyl = new Label (String.valueOf (orders.getTotalQty ()));
            TotalQtyl.setMinWidth (200);
            TotalQtyl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            Label OrderDatel = new Label (String.valueOf (orders.getOrderDate ()));
            OrderDatel.setMinWidth (200);
            OrderDatel.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;   -fx-font-size: 17;");

            Label Statusl = new Label (orders.getStatus ());
            Statusl.setMinWidth (200);
            Statusl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000;  -fx-font-size: 17;");

            VBox btn = new VBox ();

            JFXButton showDetails = new JFXButton ("Show Details");
            showDetails.setMinWidth (200);
            showDetails.setStyle ("-fx-background-color: none; -fx-text-fill: #03568b; -fx-border-color: #03568b;-fx-border-width: 2; -fx-font-weight:bold;  -fx-font-size: 20");
            
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
            btn.getChildren ().add (showDetails);
            btn.getChildren().add(space);
            btn.getChildren ().add (Valider);
            btn.getChildren ().add (space1);
            btn.getChildren ().add (Cancel);



            /* Action listeners  */
            Valider.setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    OrdersCRUD ordersCRUD=new OrdersCRUD ();
                    ordersCRUD.updateOrderStatus(orders.getOrderID (),"confirmed");
                    try {
                        List<Orders> ordersList = ordersCRUD.readAllOrders ();
                        ShowOrders (ordersList);
                    } catch (Exception ex) {
                        Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
                    }
                }
            });
            Cancel.setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    OrdersCRUD ordersCRUD=new OrdersCRUD ();
                    ordersCRUD.updateOrderStatus(orders.getOrderID (),"cancelled");
                    try {
                        List<Orders> ordersList = ordersCRUD.readAllOrders ();
                        ShowOrders (ordersList);
                    } catch (Exception ex) {
                        Logger.getLogger (OeuvreItem.class.getName ()).log (Level.SEVERE, null, ex);
                    }
                }
            });

            showDetails.setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    OrdersCRUD ordersCRUD = new OrdersCRUD ();
                    List<PendingOrders> ordersList = ordersCRUD.selectPendById (orders.getOrderID ());


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
                    Label OrderID = new Label ("OrderID");
                    OrderID.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
                    Label UserName = new Label ("UserName");
                    UserName.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
                    Label InnoNumber = new Label ("InnoNumber");
                    InnoNumber.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
                    Label Quantity = new Label ("Quantity");
                    Quantity.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
                    Label OeuvreID = new Label ("OeuvreID");
                    OeuvreID.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");
                    Label Status = new Label ("Status");
                    Status.setStyle ("-fx-alignment : center; -fx-font-weight:bold;  -fx-font-size: 17; -fx-text-fill: #ffffff ");



                    OrderID.setMinWidth (100);
                    UserName.setMinWidth (200);
                    Quantity.setMinWidth (100);
                    InnoNumber.setMinWidth (200);
                    OeuvreID.setMinWidth (100);
                    Status.setMinWidth (100);


                    titre.getChildren ().add (OrderID);
                    titre.getChildren ().add (UserName);
                    titre.getChildren ().add (InnoNumber);
                    titre.getChildren ().add (Quantity);
                    titre.getChildren ().add (OeuvreID);
                    titre.getChildren ().add (Status);
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
                    for (PendingOrders orders : ordersList) {

                        //HBOX
                        HBox Hb = new HBox ();

                        Label OrderIDl = new Label (String.valueOf (orders.getOrderId ()));
                        OrderIDl.setMinWidth (100);
                        OrderIDl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000; -fx-font-weight:bold;  -fx-font-size: 17;");

                        Label UserNamel = new Label (orders.getUserName ());
                        UserNamel.setMinWidth (200);
                        UserNamel.setStyle ("-fx-alignment : center;-fx-text-fill: #000000; -fx-font-weight:bold;  -fx-font-size: 17;");

                        Label InnoNumberl = new Label (String.valueOf (orders.getInnoNumber ()));
                        InnoNumberl.setMinWidth (150);
                        InnoNumberl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000; -fx-font-weight:bold;  -fx-font-size: 17;");

                        Label Quantiyl = new Label (String.valueOf (orders.getQuantity ()));
                        Quantiyl.setMinWidth (100);
                        Quantiyl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000; -fx-font-weight:bold;  -fx-font-size: 17;");

                        Label OeuvreIDl = new Label (String.valueOf (orders.getOeuvreID ()));
                        OeuvreIDl.setMinWidth (100);
                        OeuvreIDl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000; -fx-font-weight:bold;  -fx-font-size: 17;");

                        Label Statusl = new Label (orders.getStatus ());
                        Statusl.setMinWidth (150);
                        Statusl.setStyle ("-fx-alignment : center;-fx-text-fill: #000000; -fx-font-weight:bold;  -fx-font-size: 17;");

                        Hb.getChildren ().add (OrderIDl);

                        Hb.getChildren ().add (UserNamel);
                        Hb.getChildren ().add (InnoNumberl);

                        Hb.getChildren ().add (Quantiyl);

                        Hb.getChildren ().add (OeuvreIDl);

                        Hb.getChildren ().add (Statusl);



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
            });


            Hb.getChildren ().add (OrderIDl);

            Hb.getChildren ().add (UserNamel);

            Hb.getChildren ().add (DueAmountl);
            Hb.getChildren ().add (InnoNumberl);

            Hb.getChildren ().add (TotalQtyl);

            Hb.getChildren ().add (OrderDatel);
            Hb.getChildren ().add (Statusl);
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
    private void gotohome(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../DashBoardScene.fxml")));
        dialogStage.setTitle ("ArtDome - Home");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }


    @FXML
    private void gotoorders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("DashBoardOrders.fxml")));
        dialogStage.setTitle ("ArtDome - Orders");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }

    @FXML
    private void print(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Print print=new Print ();

        print.printNode (content);
        String title = "Print table";
        String message = "You Table  has been Printed";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss (Duration.millis (3200));
    }

    @FXML
    private void searchOrder(ActionEvent actionEvent) throws Exception {
        String recherche=search.getText ();
        OrdersCRUD ordersCRUD=new OrdersCRUD ();
        List<Orders> ordersList=ordersCRUD.Rechercher (Integer.parseInt (recherche));
        ShowOrders (ordersList);


    }

    @FXML
    private void Click(ActionEvent actionEvent) throws Exception {
        OrdersCRUD ordersCRUD=new OrdersCRUD ();
        List<Orders> ordersList1=ordersCRUD.Rechercherstatus (String.valueOf (status.getValue ()));
        ShowOrders (ordersList1);
    }

    @FXML
    private void GenererPdf(ActionEvent actionEvent) throws IOException, DocumentException, URISyntaxException {
        PDF pdf=new PDF ();
        pdf.pdfGeneration ();
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("orders.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
        String title = "PDF ";
        String message = "You PDF  has been Generated";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));

    }

    @FXML
    private void stats(ActionEvent actionEvent) {

        Charts CC;
        try {
            CC = new Charts ("statistique commandes","statut commandes ");
        } catch (Exception ex) {
            Logger.getLogger(DashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GenererExcel(ActionEvent actionEvent) {
        try {
            ExcelOrders ex=new ExcelOrders();
            ex.ExcelOrders ();
        } catch (SQLException ex1) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (WriteException ex1) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (IOException ex1) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    @FXML
    private void gotouser(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../User/User.fxml")));
        dialogStage.setTitle("ArtDome - User");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotooeuvre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Oeuvre/Oeuvre.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotoexpo(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/Reservation_expoBack.fxml")));
        dialogStage.setTitle("ArtDome - Exposition");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotoevent(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Event/AddEvent.fxml")));
        dialogStage.setTitle("ArtDome - Event");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
}
