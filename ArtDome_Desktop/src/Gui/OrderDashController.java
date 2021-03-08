package Gui;

import Entities.Orders;
import Services.OrdersCRUD;
import Tools.Charts;
import Tools.PDF;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class OrderDashController implements Initializable {
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
    private TableView OrderTable;
    @FXML
    private JFXButton changeButoon;
    @FXML
    private JFXTextField statusOrder;
    @FXML
    private JFXComboBox comboboxOrderID;
    @FXML
    private void HomeHandle(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("DashBoardScene.fxml")));
        dialogStage.setTitle("ArtDome - Dashboard");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        OrderTable.setEditable (true);
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

            OrderTable.setItems(data);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @FXML
    private void pend(MouseEvent mouseEvent) throws IOException {
        Node source = (Node) mouseEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("DashPendOrd.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Pending Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void Changevalue(ActionEvent actionEvent) throws IOException {
        String newstatus=statusOrder.getText ();
        int done=1;
        if (!newstatus.equals ("cancelled") && !newstatus.equals ("confirmed") ){
            Alert alert=new Alert (Alert.AlertType.ERROR);
            alert.setTitle ("Statue of Order");
            alert.setHeaderText ("Statue of Order");
            alert.setContentText ("Vous avez choisi un choix erroné repeter");
            alert.showAndWait ();
            done=0;
        }
        int id= (int) comboboxOrderID.getValue ();
        OrdersCRUD ordersCRUD = new OrdersCRUD ();
        if (done==1){
            ordersCRUD.updateOrderStatus(id,newstatus);

            String title = "Statue of Order ";
            String message = "Vous avez modifier le statut de la commande: "+id+" a "+newstatus;

            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndWait();
        }

        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("OrderDash.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);

        dialogStage.show();
    }

    @FXML
    private void GenererPdf(ActionEvent actionEvent) throws IOException, DocumentException {
            PDF pdf=new PDF ();
            pdf.pdfGeneration ();
        String title = "PDF ";
        String message = "You PDF  has been Generated";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
    }

    @FXML
    private void stats(ActionEvent actionEvent) {

        Charts CC;
        try {
            CC = new Charts ("statistique commandes","statut commandes ");
            CC.pack();
            CC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            CC.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(DashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
