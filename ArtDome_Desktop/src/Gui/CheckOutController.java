package Gui;

import Entities.Cart;
import Entities.Orders;
import Services.CartCRUD;
import Services.OrdersCRUD;
import Tools.PDF;
import Tools.Print;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author tfifha youssef
 */
public class CheckOutController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;

    @FXML
    private TableColumn OrderID;
    @FXML
    private TableColumn UserName;
    @FXML
    private TableColumn DueAmount;
    @FXML
    private TableColumn InnoNumber;
    @FXML
    private TableColumn TotalQty;
    @FXML
    private TableColumn OrderDate;
    @FXML
    private TableColumn Status;
    @FXML
    private TableColumn AdressId;
    @FXML
    private TableView CheckOutTable;
    @FXML
    private JFXButton changeButoon;
    @FXML
    private JFXTextField statusOrder;
    @FXML
    private JFXTextField rech;
    @FXML
    private JFXComboBox comboboxOrderID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CheckOutTable.setEditable (true);
        OrderID.setCellValueFactory (
                new PropertyValueFactory<Orders,Integer> ("OrderID")
        );
        UserName.setCellValueFactory (
                new PropertyValueFactory<Orders,Integer> ("UserName")
        );
        DueAmount.setCellValueFactory (
                new PropertyValueFactory<Orders,Integer> ("DueAmount")
        );
        InnoNumber.setCellValueFactory (
                new PropertyValueFactory<Orders,Integer> ("InnoNumber")
        );
        TotalQty.setCellValueFactory (
                new PropertyValueFactory<Orders,Integer> ("TotalQty")
        );
        OrderDate.setCellValueFactory (
                new PropertyValueFactory<Orders,Integer> ("OrderDate")
        );
        Status.setCellValueFactory (
                new PropertyValueFactory<Orders,Integer> ("Status")
        );
        AdressId.setCellValueFactory (
                new PropertyValueFactory<Orders,Integer> ("AddressID")
        );

        buildData ();
    }
    private ObservableList<Orders> data;
    public void buildData(){
        data = FXCollections.observableArrayList();

        try{
            OrdersCRUD ordersCRUD = new OrdersCRUD ();
            List<Orders> ordersList = ordersCRUD.readAllOrders ();

            data.addAll(ordersList);

            CheckOutTable.setItems(data);
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
        dialogStage.setTitle("ArtDome - Checkout");
        dialogStage.setScene(scene);
        dialogStage.show();
    }


    @FXML
    private void handleClick(MouseEvent mouseEvent) throws IOException {
        Node source = (Node) mouseEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("PendingOrderScene.fxml")));
        dialogStage.setTitle("ArtDome - PendingOrders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }


    @FXML
    private void Changevalue(ActionEvent actionEvent) throws IOException {
        String newstatus=statusOrder.getText ();
        int id= (int) comboboxOrderID.getValue ();
        OrdersCRUD ordersCRUD = new OrdersCRUD ();
        ordersCRUD.updateOrderStatus(id,newstatus);
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CheckOutScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        String title = "Order ";
        String message = "the status of order has been updated";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss (Duration.millis (3200));
        dialogStage.show();

    }


    @FXML
    private void print(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Print print=new Print ();

        print.printNode (CheckOutTable);
        String title = "Print table";
        String message = "You Table  has been Printed";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss (Duration.millis (3200));
    }


    @FXML
    private void rechereche(ActionEvent actionEvent) {
        data = FXCollections.observableArrayList();

        try{
            OrdersCRUD ordersCRUD = new OrdersCRUD ();
            List<Orders> ordersList = ordersCRUD.Rechercher (rech.getText ());
            System.out.println (ordersList);

            data.addAll(ordersList);

            CheckOutTable.setItems(data);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @FXML
    private void gotoouevre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("OeuvreItem.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
