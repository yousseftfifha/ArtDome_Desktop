/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Services.EventService;
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
import javafx.scene.image.Image;
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

        EventService em=new EventService ();
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
            EventService em=new EventService ();
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
        EventService em=new EventService ();
        ObservableList<Event> eventl = em.SearchEventF(s);
        colnom.setCellValueFactory(new PropertyValueFactory<Event, String>("nom_event"));
        coletat.setCellValueFactory(new PropertyValueFactory<Event, String>("etat"));

        listev.setItems(eventl);
        
    }

    @FXML
    private void refresh(ActionEvent event) {
        showEventlist();
    }

    @FXML
    private void home(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../HomeScene.fxml")));
        dialogStage.setTitle("ArtDome - Home");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void profile(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../User/Profile.fxml")));
        dialogStage.setTitle("ArtDome - Profile");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void oeuvre(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void event(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Event/ListEvent.fxml")));
        dialogStage.setTitle("ArtDome - Event");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void expo(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/AddReservation_expo.fxml")));
        dialogStage.setTitle("ArtDome - Exposition");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void blog(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Blog/BlogShow.fxml")));
        dialogStage.setTitle("ArtDome - Blog");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void orders(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
}
