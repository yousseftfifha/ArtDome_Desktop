/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Forum;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Entities.topic;
import Entities.User;
import java.util.Date;

/**
 * FXML Controller class
 *
 * @author max
 */
public class NewsubjetController implements Initializable {
    
    @FXML
    private Button retour;
    @FXML
    private TextField title;
    @FXML
    private Button creer;
    @FXML
    private TextField desc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
