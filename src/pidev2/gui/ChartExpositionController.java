/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev2.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pidev2.services.ExpoMethods;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class ChartExpositionController implements Initializable {

    @FXML
    private PieChart piechart;
    @FXML
    private Button exposition;
    @FXML
    private TextField cod1;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ExpoMethods e=new ExpoMethods();
       piechart.setData(e.getData());
    }    

    @FXML
    private void backtoexpo(ActionEvent event) {
          try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddExposition.fxml"));
            Parent root = loader.load();
            AddExpositionController c = loader.getController();
            cod1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddExpositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
