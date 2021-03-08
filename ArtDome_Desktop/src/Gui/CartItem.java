package Gui;

import Entities.Cart;
import Entities.Orders;
import Services.CartCRUD;
import Services.OrdersCRUD;
import Tools.PDF;
import Tools.Payment;
import Tools.SendEmail;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author tfifha youssef
 */
public class CartItem implements Initializable {
    @FXML
    private TableView CartTable;
    @FXML
    private TableColumn CartID;
    @FXML
    private TableColumn OeuvreID;
    @FXML
    private TableColumn Quantity;
    @FXML
    private TableColumn Nom;
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private JFXComboBox idCart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            CartTable.setEditable (true);


            CartID.setCellValueFactory (
                    new PropertyValueFactory<Cart,Integer> ("CartId")
            );
            OeuvreID.setCellValueFactory (
                    new PropertyValueFactory<Cart,Integer> ("OeuvreID")
            );
        Quantity.setCellValueFactory (
                new PropertyValueFactory<Cart,Integer> ("Quantiy")
        );
            Nom.setCellValueFactory (
                    new PropertyValueFactory<Cart,Integer> ("NomOeuvre")
            );


        CartCRUD cartCRUD = new CartCRUD ();
        List<Cart> carts = cartCRUD.FillCombo ();
        for (Cart cart:carts){
            idCart.getItems ().add(cart.getOeuvreID ());

        }
            buildData ();
    }
    private ObservableList<Cart> data;
    public void buildData(){
        data = FXCollections.observableArrayList();

        try{
            CartCRUD cartCRUD = new CartCRUD ();
            List<Cart> cartList = cartCRUD.readAll ();

            data.addAll(cartList);

            CartTable.setItems(data);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @FXML
    private void HandleHomeBtn(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("HomeScene.fxml")));
        dialogStage.setTitle("ArtDome - Home");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void CheckOutBtnHandle(ActionEvent actionEvent) throws IOException, MessagingException {
        OrdersCRUD ordersCRUD=new OrdersCRUD ();
        ordersCRUD.AddFromCart (0);
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
        tray.showAndWait();

    }

    @FXML
    private void hnadleordBtn(ActionEvent actionEvent) throws IOException, MessagingException {
        OrdersCRUD ordersCRUD=new OrdersCRUD ();
        ordersCRUD.AddFromCart (0);
//        Payment payment=new Payment ();
//        payment.payement (150);
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CheckOutScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();


    }

    @FXML
    private void deleteCartId(ActionEvent keyEvent) throws IOException {
        CartCRUD cartCRUD = new CartCRUD ();
//        cartCRUD.DeletOeuvreCart ((Integer) idCart.getValue ());
        cartCRUD.DeletOeuvreCart ((Integer) idCart.getValue ());

        Node source = (Node) keyEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CartItem.fxml")));
        dialogStage.setTitle("ArtDome - Cart");
        dialogStage.setScene(scene);
        String title = "Cart ";
        String message = "une oeuvre a ete supprimé";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
        dialogStage.show();
    }

    @FXML
    private void update(ActionEvent actionEvent) throws IOException {
        CartCRUD cartCRUD=new CartCRUD ();

        cartCRUD.updateQuantity ("youssef", (Integer) idCart.getValue ());
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CartItem.fxml")));
        dialogStage.setTitle("ArtDome - Cart");
        dialogStage.setScene(scene);
        String title = "Cart ";
        String message = "you have updated the quantity of the product";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
        dialogStage.show();
    }
}
