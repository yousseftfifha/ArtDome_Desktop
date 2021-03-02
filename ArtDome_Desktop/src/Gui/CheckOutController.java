package Gui;

import Entities.Cart;
import Entities.Orders;
import Services.CartCRUD;
import Services.OrdersCRUD;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
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
        OrdersCRUD ordersCRUD = new OrdersCRUD ();
        List<Orders> ordersList = ordersCRUD.combofill ();
        for (Orders orders:ordersList){
            comboboxOrderID.getItems ().add(orders.getOrderID ());

        }
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
    private void Changevalue(ActionEvent actionEvent) {
        String newstatus=statusOrder.getText ();
        int id= (int) comboboxOrderID.getValue ();
        OrdersCRUD ordersCRUD = new OrdersCRUD ();
        ordersCRUD.updateOrderStatus(id,newstatus);

    }
}
