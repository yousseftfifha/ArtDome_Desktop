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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author max
 */
public class SujetController implements Initializable {
    
    @FXML
    private Button retour;
    @FXML
    private TextArea usertopic;
    @FXML
    private TextArea viewtopic;
    @FXML
    private Label labtitre;
    @FXML
    private Label labuser;
    @FXML
    private Label labview;
    @FXML
    private ScrollBar bar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
