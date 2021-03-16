/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artdome;

import Entite.Oeuvre;
import services.CatégorieCRUD;
import Entite.catégorie;
import java.io.IOException;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
//import services.OeuvreCRUD;


/**ort pi.services.EventMethods;
import pidev.entities.Event;
/**
 * FXML Controller class
 *
 * @author user
 */
public class CatégorieController implements Initializable {
    private TextField ID_Cartegorie;
    private TextField Type;
    private TextField Description;
    private TextField NomCategorie;

 ObservableList<catégorie> ulist= FXCollections.observableArrayList();
    @FXML
    private TextField tftype;
    @FXML
    private TextField tfdescription;
    @FXML
    private TableView<catégorie> tvcatégorie;
    @FXML
    private Button btnaddc;
    @FXML
    private Button btnupdatec;
    @FXML
    private Button btndeletec;
    @FXML
    private TableColumn<catégorie, Integer > colidcategorie;
    @FXML
    private TableColumn<catégorie, String> colnomcategorie;
    @FXML
    private TableColumn<catégorie, String> coltype;
    @FXML
    private TableColumn<catégorie, String> coldescription;

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfidcategorie;
    @FXML
    private TextField tfnomcategorie;
    
    
    CatégorieCRUD cc = new CatégorieCRUD();
    @FXML
    private Button btnoeuv;
    @FXML
    private TextField tfsearchc;
    @FXML
    private Button btnsearchc;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            List list=cc.readAll();
            ulist= FXCollections.observableArrayList(list);
            colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
            tvcatégorie.setItems(ulist); 
    }

     
    @FXML
    private void AddCategorie(ActionEvent event) {
         //   int idcategorie = Integer.parseInt(tfidcategorie.getText().trim());
            String type = tftype.getText();
            String description = tfdescription.getText();
            String nomcategorie= tfnomcategorie.getText();
           
            CatégorieCRUD cc = new CatégorieCRUD();
            catégorie C = new catégorie(type , description, nomcategorie);
            cc.AddCategorie(C);
             List list=cc.readAll();
            ulist= FXCollections.observableArrayList(list);
            colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
            tvcatégorie.setItems(ulist); 
            
}
      @FXML
    private void getfromghada(MouseEvent event) {
        
         catégorie Cc = tvcatégorie.getSelectionModel().getSelectedItem();
           tfidcategorie.setText(""+ Cc.getID_Cat());
            tftype.setText(Cc.getType());
           tfdescription.setText(""+Cc.getDescription());
            tfnomcategorie.setText(" "+Cc.getNomCat());
    }

 
    @FXML
    private void UpdateCategorie(ActionEvent event) {
            int idcategorie = Integer.parseInt(tfidcategorie.getText().trim());
            String type = tftype.getText();
            String description = tfdescription.getText();
            String nomcategorie= tfnomcategorie.getText();
            
            CatégorieCRUD cc = new CatégorieCRUD();
            catégorie C = new catégorie(idcategorie, type , description, nomcategorie);
            cc.UpdateCategorie(C, idcategorie);
           
   List list=cc.readAll();
            ulist= FXCollections.observableArrayList(list);
            colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
            tvcatégorie.setItems(ulist); 
    }

    @FXML
    private void DeleteCategorie(ActionEvent event) {
        int C = Integer.parseInt(tfidcategorie.getText().trim());
            System.out.println(C);
           CatégorieCRUD cc = new CatégorieCRUD();
            cc.Deletecategorie(C);
            List list=cc.readAll();
            ulist= FXCollections.observableArrayList(list);
            colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
            tvcatégorie.setItems(ulist); 
    }

    @FXML
    private void oeuvre(ActionEvent event) {
           try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Oeuvre.fxml"));
            Parent root = loader.load();
            OeuvreController apc = loader.getController();
        
           tfidcategorie.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(CatégorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchc(ActionEvent event) throws SQLException {
              String search= tfsearchc.getText();
        System.out.println(search);
       CatégorieCRUD CC= new  CatégorieCRUD();
        ObservableList<catégorie> list = CC.Searchc(search);
            ulist= FXCollections.observableArrayList(list);
           colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
            tvcatégorie.setItems(ulist);
    }


}