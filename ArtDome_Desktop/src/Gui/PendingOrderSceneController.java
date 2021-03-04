package Gui;

import Entities.Oeuvre;
import Entities.Orders;
import Entities.PendingOrders;
import Services.CartCRUD;
import Services.OrdersCRUD;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author tfifha youssef
 */
public class PendingOrderSceneController implements Initializable {
    @FXML
    private TableView PendIngable;

    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TableColumn OrderID1;
    @FXML
    private TableColumn UserName1;
    @FXML
    private TableColumn InnoNumber1;
    @FXML
    private TableColumn OeuvreID1;
    @FXML
    private TableColumn Quantity1;
    @FXML
    private TableColumn Status1;
    @FXML
    private TableColumn AdressId1;
    @FXML
    private JFXTextField searchP;
    @FXML
    private JFXComboBox searchOrd;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PendIngable.setEditable (true);
        OrderID1.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("OrderId")
        );
        UserName1.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("UserName")
        );
        InnoNumber1.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("InnoNumber")
        );
        OeuvreID1.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("OeuvreID")
        );
        Quantity1.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("Quantity")
        );
        Status1.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("Status")
        );
        AdressId1.setCellValueFactory (
                new PropertyValueFactory<PendingOrders,Integer> ("AddressID")
        );
        OrdersCRUD ordersCRUD = new OrdersCRUD ();
        List<Orders> ordersList = ordersCRUD.combofill ();
        for (Orders orders:ordersList){
            searchOrd.getItems ().add(orders.getOrderID ());

        }
        buildData ();
    }
    private ObservableList<PendingOrders> data;
    public void buildData(){
//        data = FXCollections.observableArrayList();
//
//        try{
//            OrdersCRUD ordersCRUD = new OrdersCRUD ();
//            List<PendingOrders> pendingOrders = ordersCRUD.readAllpendingOrders ();
////            List<PendingOrders> pendingOrders = ordersCRUD.selectPendById ();
//            data.addAll(pendingOrders);
//
//            PendIngable.setItems(data);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            System.out.println("Error on Building Data");
//        }
    }

    @FXML
    private void HandleHomeBtn(ActionEvent actionEvent) throws IOException {
        CartCRUD cartCRUD=new CartCRUD ();
        List<Oeuvre> oeuvre1=cartCRUD.selectOeuvreById (1);
        cartCRUD.updateQuantity ("youssef",oeuvre1.get (0).getID_Oeuvre ());

        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("HomeScene.fxml")));
        dialogStage.setTitle("ArtDome - Home");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void handleOrdBTn(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CheckOutScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void serchMethod(ActionEvent inputMethodEvent) {
        int id= (int) searchOrd.getValue ();
        data = FXCollections.observableArrayList();

        try{
            OrdersCRUD ordersCRUD = new OrdersCRUD ();
//            List<PendingOrders> pendingOrders = ordersCRUD.readAllpendingOrders ();
              List<PendingOrders> pendingOrders = ordersCRUD.selectPendById (Integer.parseInt (String.valueOf (id)));
            data.addAll(pendingOrders);
            PendIngable.setItems(data);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }    }

    @FXML
    private void HomeHandle(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("DashBoardScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
