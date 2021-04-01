/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ChooseMethodController implements Initializable {

    @FXML
    private JFXButton Bemail;
    @FXML
    private JFXButton Bsms;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void email(ActionEvent event) throws IOException{
       Stage stage = new Stage();

        stage.setTitle("Mail");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("forgotPass.fxml"))));
        stage.show();
        Bemail.getScene().getWindow().hide();
    }
    @FXML
    private void sms(ActionEvent event) throws IOException{
         Stage stage = new Stage();
        stage.setTitle("SMS");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("smsRecovery.fxml"))));
        stage.show();
        Bsms.getScene().getWindow().hide();
    }
    
    
}
