/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PasswordResetController implements Initializable {

    @FXML
    private JFXButton BValider;
    @FXML
    private JFXPasswordField Tmdp2;
    @FXML
    private JFXTextField Tmdp;
    @FXML
    private Label LBerror;
    @FXML
    private ImageView erreur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Mdp(ActionEvent event) {
       /* if (Tmdp.getText().equals(Tmdp2.getText()))
            UserCRUD crd = new UserCRUD();
                            crd.updateMdp();
*/
    }

    /*void setUpdate(boolean b) {
        this.update = b;

    }*/
}
