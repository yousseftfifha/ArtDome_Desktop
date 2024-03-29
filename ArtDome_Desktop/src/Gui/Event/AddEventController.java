/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Event;


import Services.EventService;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import Entities.Event;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddEventController implements Initializable {

    /**
     * Initializes the controller class.
     */    
    private Connection cnx;
    Stage dialogStage = new Stage ();
    Scene scene;
    private PreparedStatement ste;
    private ResultSet rs;
    private Statement st;
    @FXML
    private TextField tfnom;
    @FXML
    private ComboBox<String> tftheme;
    @FXML
    private ComboBox<String> tfetat;
    @FXML
    private DatePicker tfdate;
    @FXML
    private Spinner<Integer> tfnbmax;
    @FXML
    private TextField tfimage;
    @FXML
    private TextField tfvideo;
    @FXML
    private Button AddButton;
    @FXML
    private Button UpdateButton;
    @FXML
    private TextField tfcodeespace;
    @FXML
    private TableView<Event> tve;
    @FXML
    private TableColumn<Event, String> colnom;
    @FXML
    private TableColumn<Event, String> coltheme;
    @FXML
    private TableColumn<Event, String> coletat;
    @FXML
    private TableColumn<Event, Date> coldate;
    @FXML
    private TableColumn<Event, Integer> colnbmax;
    @FXML
    private TableColumn<Event, Integer> colcodeespace;
    @FXML
    private TableColumn<Event, String> colimage;
    @FXML
    private TableColumn<Event, String> colvideo;
    @FXML
    private Button DeleteButton;
    @FXML
    private TextField tfcodeee;
    private TextField tfrech;
    @FXML
    private TableColumn<Event, Integer> colnbpart;
    @FXML
    private TextField search;
    @FXML
    private Button chart;
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
    private JFXButton ViewRes;
    @FXML
    private JFXButton RechercheButton;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      ObservableList<String> list = tfetat.getItems();
      //Adding items to the combo box
      list.add("Physique");
      list.add("Digital");
      
      ObservableList<String> listT = tftheme.getItems();
      //Adding items to the combo box
      listT.add("Launching");
      listT.add("WorkShop");
      listT.add("Concert");
      listT.add("Color Fest");
      listT.add("Runway Show");
      listT.add("Book Singing");
      listT.add("Autre..");
      
      
     tfnbmax.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5000));
     showEvent();
    }    

    @FXML
    private void AddEvent(ActionEvent event) {
            String nom = tfnom.getText();
            String theme = tftheme.getValue();
            String etat = tfetat.getValue();
            Date date = java.sql.Date.valueOf(tfdate.getValue());
            int nb_max_part = tfnbmax.getValue();
            int code_espace = Integer.parseInt(tfcodeespace.getText().trim());
            String image = tfimage.getText();
            String video = tfvideo.getText();
            EventService em = new EventService ();
            Event e= new Event(nom, theme, etat, date, nb_max_part, image, video, code_espace);
            //Event e = new Event(00,nom,theme,etat,date,0,nb_max_part,image,video,12,13);
            em.AddEvent(e);
            showEvent();
            tfnom.clear();
           
            tfcodeespace.clear();
            tfimage.clear();
            tfvideo.clear();
        
    } 
    
    public void showEvent(){

//        ImageView iv1 = new ImageView();
//        iv1.setImage(new Image("flower.png"));
        EventService em=new EventService ();
        ObservableList<Event> eventlist = em.getEventListBACK ();
        colnom.setCellValueFactory(new PropertyValueFactory<Event, String>("nom_event"));
        coltheme.setCellValueFactory(new PropertyValueFactory<Event, String>("theme_event"));
        coletat.setCellValueFactory(new PropertyValueFactory<Event, String>("etat"));
        coldate.setCellValueFactory(new PropertyValueFactory<Event, Date>("date"));
        colnbpart.setCellValueFactory(new PropertyValueFactory<Event, Integer>("nb_participant"));
        colnbmax.setCellValueFactory(new PropertyValueFactory<Event, Integer>("nb_max_part"));
        colcodeespace.setCellValueFactory(new PropertyValueFactory<Event, Integer>("code_espace"));
        colimage.setCellValueFactory(new PropertyValueFactory<Event, String>("image"));
        colvideo.setCellValueFactory(new PropertyValueFactory<Event, String>("video"));
        tve.setItems(eventlist);
    }   

    @FXML
    private void getfromtv(MouseEvent event) {
        
            Event ev= tve.getSelectionModel().getSelectedItem();
            tfcodeee.setText(" "+ ev.getCode_event());
            tfnom.setText(ev.getNom_event());
            tftheme.setValue(ev.getTheme_event());
            tfetat.setValue(ev.getEtat());
            tfdate.setValue(Instant.ofEpochMilli((ev.getDate()).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
            tfnbmax.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(ev.getNb_max_part(), 5000));
            tfcodeespace.setText(" "+ ev.getCode_espace());
            tfimage.setText(ev.getImage());
            tfvideo.setText(ev.getVideo());
    }
    
    @FXML
    private void UpdateEvent(ActionEvent event) {
            int codeee = Integer.parseInt(tfcodeee.getText().trim());
            String nom = tfnom.getText();
            String theme = tftheme.getValue();
            String etat = tfetat.getValue();
            Date date = java.sql.Date.valueOf(tfdate.getValue());
            int nb_max_part = tfnbmax.getValue();
            int code_espace = Integer.parseInt(tfcodeespace.getText().trim());
            String image = tfimage.getText();
            String video = tfvideo.getText();
            EventService em = new EventService ();
            Event e= new Event(nom, theme, etat, date, nb_max_part, image, video, code_espace);
            em.UpdateEvent(e,codeee);
            showEvent();
            tfnom.clear();
           
            tfcodeespace.clear();
            tfimage.clear();
            tfvideo.clear();
        
    }
    
    @FXML
    private void DeleteEvent(ActionEvent event) {
        
        int codeee = Integer.parseInt(tfcodeee.getText().trim());
//        Integer.parseInt(line.toString())
        EventService em = new EventService ();
            em.DeleteEvent(codeee);
        showEvent();
    }


    private void Reserver(ActionEvent event ) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddReservation.fxml"));
            Parent root = loader.load();
            AddReservationController apc = loader.getController();
            apc.setTfcodeeeEvent(tfcodeee.getText());
            tfcodeee.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void addimage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.png","*.jpg","*.gif"));
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null)
        {
            tfimage.setText(selectedFile.getAbsolutePath());
        }else {
            System.out.println(" Picture file is not valid");
        }
        
    }
 
    @FXML
    private void addvideo(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("select your media(*.mp4)", "*.mp4"));
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null)
        {
            tfvideo.setText(selectedFile.getAbsolutePath());
        }else {
            System.out.println("Video file is not valid");
        }
    }


    @FXML
    private void piechart(ActionEvent event) {

          try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Chart.fxml"));
            Parent root = loader.load();
            ChartController c = loader.getController();
            tfcodeee.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void ViewRes(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationBack.fxml"));
            Parent root = loader.load();
            ReservationBackController c = loader.getController();
            tfcodeee.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReservationBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SearchEvent(ActionEvent event) {
        String s=search.getText();
        EventService em=new EventService ();
        ObservableList<Event> eventl = em.SearchEvent(s);
        colnom.setCellValueFactory(new PropertyValueFactory<Event, String>("nom_event"));
        coltheme.setCellValueFactory(new PropertyValueFactory<Event, String>("theme_event"));
        coletat.setCellValueFactory(new PropertyValueFactory<Event, String>("etat"));
        coldate.setCellValueFactory(new PropertyValueFactory<Event, Date>("date"));
        colnbmax.setCellValueFactory(new PropertyValueFactory<Event, Integer>("nb_max_part"));
        colcodeespace.setCellValueFactory(new PropertyValueFactory<Event, Integer>("code_espace"));
        colimage.setCellValueFactory(new PropertyValueFactory<Event, String>("image"));
        colvideo.setCellValueFactory(new PropertyValueFactory<Event, String>("video"));
        tve.setItems(eventl);
    }


    @FXML
    private void gotoevent(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Event/AddEvent.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Event");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotoOeuvre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Oeuvre/Oeuvre.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotooexpo(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/Reservation_expoBack.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void gotouser(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../User/User.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void endroit(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Endroit/AfficherEndroit.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Endroit");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
    @FXML
    private void showOrders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../DashOrdersCart/DashBoardOrders.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Orders");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void home(ActionEvent actionEvent)  throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../DashBoardScene.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Home");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
}
