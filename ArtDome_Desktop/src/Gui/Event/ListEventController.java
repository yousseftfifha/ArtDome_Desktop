/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;

import Gui.HomeSceneController;
import Services.EventService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
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
import javafx.util.Duration;

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
    @FXML
    private AnchorPane holderPane;
    @FXML
    AnchorPane home,oeuvre,event,profiles,expo,blog,orders,location,login,cart;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            home = FXMLLoader.load(getClass().getResource("../HomeScene.fxml"));
            profiles = FXMLLoader.load(getClass().getResource("../User/Profile.fxml"));
            oeuvre = FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml"));
            expo = FXMLLoader.load(getClass().getResource("../Exposition/AddReservation_expo.fxml"));
            blog = FXMLLoader.load(getClass().getResource("../Blog/BlogShow.fxml"));
            orders = FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml"));
            location = FXMLLoader.load(getClass().getResource("../Endroit/AfficherReservation.fxml"));
            login = FXMLLoader.load(getClass().getResource("../User/Login.fxml"));
            cart = FXMLLoader.load(getClass().getResource("../OrdersCart/CartView.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(HomeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    @FXML
    private void profile(ActionEvent actionEvent) throws IOException {
        setNode(profiles);
    }

    @FXML
    private void order(ActionEvent actionEvent) throws IOException {
        setNode(orders);
    }

    @FXML
    private void oeuvre(ActionEvent actionEvent) throws IOException {
        setNode(oeuvre);
    }

    @FXML
    private void expo(ActionEvent actionEvent) throws IOException {
        setNode(expo);
    }

    @FXML
    private void event(ActionEvent actionEvent) throws IOException {
        setNode(event);
    }

    @FXML
    private void blog(ActionEvent actionEvent) throws IOException {
        setNode(blog);

    }
    @FXML
    private void location(ActionEvent actionEvent)throws IOException {
        setNode(location);
    }
    @FXML
    private void logout(ActionEvent actionEvent) throws IOException {
        setNode(login);

    }


    @FXML
    private void cart(ActionEvent actionEvent) {
        setNode(cart);
    }

    @FXML
    private void home(ActionEvent actionEvent) {
        setNode(home);

    }
}
