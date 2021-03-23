/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Exposition;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import Entities.Exposition;
import Services.ExpoMethods;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class AddExpositionController implements Initializable {

    @FXML
    private Button AddButton;
    @FXML
    private Button UpdateButton;
    @FXML
    private TextField code_expo;
    @FXML
    private TextField nom_expo;
    @FXML
    private TextField code_espace;
    @FXML
    private ComboBox<String> theme_expo;
    @FXML
    private DatePicker date_expo;
    @FXML
    private TextField code_artiste;
    @FXML
    private TextField code_oeuvre;
    @FXML
    private Spinner<Integer> nb_participant;
    @FXML
    private Spinner<Integer> nb_max_participant;
    @FXML
    private TableView<Exposition> tve;
    @FXML
    private TableColumn<Exposition, Integer> colcode;
    @FXML
    private TableColumn<Exposition, String> colnom;
    @FXML
    private TableColumn<Exposition, String> coltheme;
    @FXML
    private TableColumn<Exposition, Integer> colespace;
    @FXML
    private TableColumn<Exposition, Integer> colartiste;
    @FXML
    private TableColumn<Exposition, Date> coldate;
    @FXML
    private TableColumn<Exposition, Integer> colnb;
    @FXML
    private TableColumn<Exposition, Integer> colnbmax;
    @FXML
    private TableColumn<Exposition, Integer> coloeuvre;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button ReservationButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            ObservableList<String> list = theme_expo.getItems();
      //Adding items to the combo box
      list.add("photographie");
      list.add("peinture");
      list.add("sculture");
      list.add("autre..");
      
      nb_participant.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5000));
      nb_max_participant.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5000));
      
      showExpo();
              
      
    }  
    
       @FXML
    private void AddExpo(ActionEvent event) {
//          int code = Integer.valueOf(code_expo.getText());
            String nom = nom_expo.getText();
            String theme = theme_expo.getValue();
            int espace = Integer.valueOf(code_espace.getText());
            int artiste = Integer.valueOf(code_artiste.getText());
            
            Date date = java.sql.Date.valueOf(date_expo.getValue());
            int nbP = nb_participant.getValue();
            int nbMaxP = nb_max_participant.getValue();
            int oeuvre = Integer.valueOf(code_oeuvre.getText());
            
            ExpoMethods expoc = new ExpoMethods();
            Exposition expo = new Exposition(nom,theme,espace,artiste,date,nbP,nbMaxP,oeuvre);
            
            expoc.AddExpo(expo);
            showExpo();
    }
    
    
      public void showExpo(){
        ExpoMethods ex=new ExpoMethods();
        ObservableList<Exposition> expolist = ex.getExpoList();
        colcode.setCellValueFactory(new PropertyValueFactory<Exposition, Integer>("code_expo"));
        colnom.setCellValueFactory(new PropertyValueFactory<Exposition, String>("nom_expo"));
        coltheme.setCellValueFactory(new PropertyValueFactory<Exposition, String>("theme_expo"));
        colespace.setCellValueFactory(new PropertyValueFactory<Exposition, Integer>("code_espace"));
        colartiste.setCellValueFactory(new PropertyValueFactory<Exposition, Integer>("code_artiste"));
        coldate.setCellValueFactory(new PropertyValueFactory<Exposition, Date>("date_expo"));
        colnb.setCellValueFactory(new PropertyValueFactory<Exposition, Integer>("nb_participant"));
        colnbmax.setCellValueFactory(new PropertyValueFactory<Exposition, Integer>("nb_max_participant"));
        coloeuvre.setCellValueFactory(new PropertyValueFactory<Exposition, Integer>("code_oeuvre"));
        
        
        tve.setItems(expolist);
    } 
      
         @FXML
    private void getfromtv(MouseEvent event) {
        
            Exposition ev= tve.getSelectionModel().getSelectedItem();
            code_expo.setText(" "+ ev.getCode_expo());
            nom_expo.setText(" "+ ev.getNom_expo());
            theme_expo.setValue(ev.getTheme_expo());
            code_espace.setText(" "+ev.getCode_espace());
            code_artiste.setText(" "+ev.getCode_artiste());
            date_expo.setValue(Instant.ofEpochMilli((ev.getDate_expo()).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
            nb_participant.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(ev.getNb_participant(), 5000));
            nb_max_participant.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(ev.getNb_max_participant(), 5000));
            code_oeuvre.setText(" "+ev.getCode_oeuvre());
    }

    
      @FXML
    private void UpdateExpo(ActionEvent event) {
            int codeee = Integer.parseInt(code_expo.getText().trim());
            String nom = nom_expo.getText();
            String theme = theme_expo.getValue();
            int espace = Integer.parseInt(code_espace.getText().trim());
            int artiste = Integer.parseInt(code_artiste.getText().trim());
            Date date = java.sql.Date.valueOf(date_expo.getValue());
            int nb_part = nb_participant.getValue();
            int nb_max_part = nb_max_participant.getValue();
            int oeuvre = Integer.parseInt(code_oeuvre.getText().trim());
            ExpoMethods ex = new ExpoMethods();
            Exposition e= new Exposition(nom, theme, espace, artiste, date, nb_part, nb_max_part, oeuvre);
            ex.UpdateExpo(e,codeee);
            showExpo();
    }
    
      @FXML 
    private void DeleteExpo(ActionEvent event) {
        
        int codeee = Integer.parseInt(code_expo.getText().trim());
//        Integer.parseInt(line.toString())
        ExpoMethods ex = new ExpoMethods();
            ex.DeleteExpo(codeee);
        showExpo();
    }
    
    
    
    
      @FXML
    private void Reserver(ActionEvent event ) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddReservation_expo.fxml"));
            Parent root = loader.load();
            AddReservation_expoController apc = loader.getController();
            apc.setTfcodeeeEvent(code_expo.getText());
            code_expo.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddExpositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
