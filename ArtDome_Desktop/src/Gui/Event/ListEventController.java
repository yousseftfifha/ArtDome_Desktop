/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Services.EventMethods;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import static Tools.Print.printNode;
import Entities.Event;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ListEventController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TableView<Event> listev;
    @FXML
    private TableColumn<Event, String> colnom;
    @FXML
    private TableColumn<Event, String> coletat;
    @FXML
    private TextField tfcode;
    @FXML
    private JFXButton UserB;
    @FXML
    private JFXButton OeuvresB;
    @FXML
    private JFXButton EventB;
    @FXML
    private JFXButton ExpositionB;
    @FXML
    private JFXButton BlogB;
    @FXML
    private JFXButton Forum;
    @FXML
    private JFXButton OrdersB;
    @FXML
    private JFXButton btnimp;
    @FXML
    private AnchorPane AnEv;
    @FXML
    private TextField tfRech;
    @FXML
    private JFXButton btnRech;
    @FXML
    private JFXButton refresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      showEventlist();  
    } 
    
    public void showEventlist(){

        EventMethods em=new EventMethods();
        ObservableList<Event> eventlist = em.getEventList();
        colnom.setCellValueFactory(new PropertyValueFactory<Event, String>("nom_event"));
        coletat.setCellValueFactory(new PropertyValueFactory<Event, String>("etat"));
        listev.setItems(eventlist);
    }

    @FXML
    private void evlist(MouseEvent event) throws IOException {

       try{

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailEvent.fxml"));
            Parent root = loader.load();
            Event ev= listev.getSelectionModel().getSelectedItem();
            EventMethods em=new EventMethods();
            //em.getEventDetail(ev.getU().getId());
            DetailEventController apc = loader.getController();
            apc.setCodeev(""+ev.getCode_event());
            int c=ev.getU().getId();
            Event e=em.getEventDetail(c);
            apc.setLbartiste(e.getU().getNom()+" "+e.getU().getPrenom());
            apc.setNom(ev.getNom_event());
            apc.setLbtheme(ev.getTheme_event());
            apc.setLbetat(ev.getEtat());
            apc.setLbdate(ev.getDate().toString());
            apc.setLbcodeespace(""+ev.getCode_espace());
            apc.setNbplace(""+(ev.getNb_max_part()-ev.getNb_participant()));
            apc.setImage(ev.getImage());
            apc.setVideo(ev.getVideo());
            tfcode.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(ListEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @FXML
    private void ImpEv(ActionEvent event) {
        
        try {
            printNode(AnEv);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(AddReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RechEvent(ActionEvent event) {
        String s=tfRech.getText();
        EventMethods em=new EventMethods();
        ObservableList<Event> eventl = em.SearchEventF(s);
        colnom.setCellValueFactory(new PropertyValueFactory<Event, String>("nom_event"));
        coletat.setCellValueFactory(new PropertyValueFactory<Event, String>("etat"));

        listev.setItems(eventl);
        
    }

    @FXML
    private void refresh(ActionEvent event) {
        showEventlist();
    }


}
