/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import Entities.Notification;
import Services.NotificationCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.sql.SQLException;
import Tools.UserHolder;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class RequestController implements Initializable {

    @FXML
    private JFXButton Bsend;
    @FXML
    private JFXComboBox<String> type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            type.getItems().addAll("artiste");
    }    
    
        @FXML
    private void send(ActionEvent event)throws SQLException{
        UserHolder holder = UserHolder.getInstance();
        Notification n = new Notification(type.getValue());
        NotificationCRUD crd = new NotificationCRUD();
        crd.AddNotif(n,holder.getUser().getId());
    }
    
}
