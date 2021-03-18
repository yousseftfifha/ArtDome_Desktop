package Gui.DashOrdersCart;

import Entities.Orders;
import Entities.PendingOrders;
import Services.OrdersCRUD;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author tfifha youssef
 */
public class DashPendOrderSceneController  implements Initializable {
    @FXML
    private TableView PendIngabledash;

    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TableColumn OrderID2;
    @FXML
    private TableColumn UserName2;
    @FXML
    private TableColumn InnoNumber2;
    @FXML
    private TableColumn OeuvreID2;
    @FXML
    private TableColumn Quantity2;
    @FXML
    private TableColumn Status2;
    @FXML
    private TableColumn AdressId2;
    @FXML
    private JFXComboBox comboref;
    @FXML
    private void HomeHandle(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../DashBoardScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void ordhandle(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("OrderDash.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
    private ObservableList<PendingOrders> data;
    @FXML
    private void searchdetails(ActionEvent actionEvent) {
        int id= (int) comboref.getValue ();
        data = FXCollections.observableArrayList();

        try{
            OrdersCRUD ordersCRUD = new OrdersCRUD ();
//            List<PendingOrders> pendingOrders = ordersCRUD.readAllpendingOrders ();
            List<PendingOrders> pendingOrders = ordersCRUD.selectPendById (Integer.parseInt (String.valueOf (id)));
            data.addAll(pendingOrders);
            PendIngabledash.setItems(data);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PendIngabledash.setEditable (true);
        OrderID2.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("OrderId")
        );
        UserName2.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("UserName")
        );
        InnoNumber2.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("InnoNumber")
        );
        OeuvreID2.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("OeuvreID")
        );
        Quantity2.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("Quantity")
        );
        Status2.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("Status")
        );
        AdressId2.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("AddressID")
        );
        OrdersCRUD ordersCRUD = new OrdersCRUD ();
        List<Orders> ordersList = ordersCRUD.combofill ();
        for (Orders orders:ordersList){
            comboref.getItems ().add(orders.getOrderID ());

        }
    }
}
