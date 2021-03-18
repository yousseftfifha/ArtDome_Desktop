package Gui;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private void showOrders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("DashOrdersCart/DashBoardOrders.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void searchForTerm(ActionEvent actionEvent) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        String title = "Dashboard ArtDome";
        String message = "Welcome to ArtDome Dashboard where you can manage everything";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));
    }
}
