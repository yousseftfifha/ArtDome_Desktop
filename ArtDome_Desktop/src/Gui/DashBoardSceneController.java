package Gui;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author tfifha youssef
 */
public class DashBoardSceneController {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private JFXTextField term;
    @FXML
    private void showOrders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("OrderDash.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void searchForTerm(ActionEvent actionEvent) throws IOException {

    }
}
