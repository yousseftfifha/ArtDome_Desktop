/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Forum;

import Entities.cathegories;
import Entities.topic;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Services.CathegoryMethod;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author max
 */
public class CathegoriesController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TextField cat_name;
    @FXML
    private DatePicker lastPostDate;
    @FXML
    private TextArea cat_description;

    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private Button Recherche;
    
    ObservableList<cathegories>catlist;
    @FXML
    private TextField searchcat;
    @FXML
    private TableColumn<cathegories, String> type;
    @FXML
    private TableColumn<cathegories, String> desc;
    @FXML
    private TableView<cathegories> tableCat;
    @FXML
    private Button ajouter;
    @FXML
    private TextField idCat;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        showcat();
        
    }    
    
    @FXML
    private void AddCat(ActionEvent event) {
            String nom = cat_name.getText();
            Date date = java.sql.Date.valueOf(lastPostDate.getValue());
            String description = cat_description.getText();
            CathegoryMethod catm = new CathegoryMethod();
            cathegories cat = new cathegories(nom,description,date);
            
            catm.AddCat(cat);
            showcat();

    }
    
    public void showcat(){
        CathegoryMethod cat=new CathegoryMethod();
        ObservableList<cathegories> catlist = cat.getCatList();
        type.setCellValueFactory(new PropertyValueFactory<cathegories, String>("cat_name"));
        desc.setCellValueFactory(new PropertyValueFactory<cathegories, String>("cat_description"));
        tableCat.setItems(catlist);
    }
    
    private void getfromtv(MouseEvent event) {
        
            cathegories ev= tableCat.getSelectionModel().getSelectedItem();
            idCat.setText(" "+ ev.getCat_id());
            cat_name.setText(" "+ ev.getCat_name());
            cat_description.setText(" "+ev.getCat_description());
      
    }
    
    @FXML
    private void UpdateCat(ActionEvent event) {
        int code= Integer.parseInt(idCat.getText().trim());
            String nom = cat_name.getText();
            String description = cat_description.getText();

            CathegoryMethod cat = new CathegoryMethod();
            cathegories c= new cathegories(nom, description);
            cat.UpdateCat(c,code);
            showcat();
    }
    
    @FXML
    private void DeleteCat(ActionEvent event) {
        
        int nom = Integer.parseInt(idCat.getText().trim());
        CathegoryMethod cat = new CathegoryMethod();
            cat.DeleteCat(nom);
        showcat();
    }
    
    @FXML
    private void search(ActionEvent event) {
        
        String s=searchcat.getText();
        CathegoryMethod ct=new CathegoryMethod();
        ObservableList<cathegories> eventl = ct.Searchcat(s);
        type.setCellValueFactory(new PropertyValueFactory<cathegories, String>("cat_name"));
        desc.setCellValueFactory(new PropertyValueFactory<cathegories, String>("cat_description"));
        tableCat.setItems(eventl);
        
        
        
    }

    @FXML
    private void getfromtv(javafx.scene.input.MouseEvent event) {
          cathegories ev= tableCat.getSelectionModel().getSelectedItem();
          idCat.setText(" "+ ev.getCat_id());
            cat_name.setText(" "+ ev.getCat_name());
            cat_description.setText(" "+ev.getCat_description());
      
    }

    @FXML
    private void back(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../HomeScene.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }
}
