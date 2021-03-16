///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package artdome;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.chart.PieChart;
//import javafx.scene.control.Button;
//import services.OeuvreCRUD;
//
///**
// * FXML Controller class
// *
// * @author user
// */
//public class ChartController implements Initializable {
//
//    @FXML
//    private PieChart pie;
//    @FXML
//    private Button oeuvrechart;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//               OeuvreCRUD o =new   OeuvreCRUD();
//       pie.setData(o.getData());
//
//    }
//
//    @FXML
//    private void oeuvrechart(ActionEvent event) {
//                            try {
//
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Oeuvre.fxml"));
//            Parent root = loader.load();
//           OeuvreController o = loader.getController();
//           oeuvrechart.getScene().setRoot(root);
//        } catch (IOException ex) {
//            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
