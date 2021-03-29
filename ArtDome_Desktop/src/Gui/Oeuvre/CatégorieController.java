/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Oeuvre;

import Services.CatégorieServices;
import Entities.catégorie;
import java.io.IOException;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
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
    private DatePicker Dateajout;
    Stage dialogStage = new Stage();
    Scene scene;
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
    
    
    CatégorieServices cc = new CatégorieServices ();
    @FXML
    private Button btnoeuv;
    @FXML
    private TextField tfsearchc;
    @FXML
    private Button btnsearchc;
//    @FXML
//    private TableColumn<catégorie, ?> coldescription1;
//    @FXML
//    private TableColumn<catégorie, ?> coldescription11;
    @FXML
    private DatePicker dtcat;
    @FXML
    private TableColumn<catégorie, Date> coltdateajout;
    @FXML
    private TableColumn<catégorie, Integer> colnbreoeuvre;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            List list=cc.readAll();
            ulist= FXCollections.observableArrayList(list);
            colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
           coltdateajout.setCellValueFactory(new PropertyValueFactory<>("DateCat"));
           colnbreoeuvre.setCellValueFactory(new PropertyValueFactory<>("NbreOeuvre"));
            tvcatégorie.setItems(ulist); 
    }

     
    @FXML
    private void AddCategorie(ActionEvent event) {
         //   int idcategorie = Integer.parseInt(tfidcategorie.getText().trim());
            String type = tftype.getText();
            String description = tfdescription.getText();
            String nomcategorie= tfnomcategorie.getText();
            Date dateajout= java.sql.Date.valueOf(dtcat.getValue());
           
            CatégorieServices cc = new CatégorieServices ();
            catégorie C = new catégorie(type , description, nomcategorie,dateajout);
            cc.AddCategorie(C);
             List list=cc.readAll();
           ulist= FXCollections.observableArrayList(list);
           colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
           coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
           coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
           coltdateajout.setCellValueFactory(new PropertyValueFactory<>("DateCat"));
           colnbreoeuvre.setCellValueFactory(new PropertyValueFactory<>("NbreOeuvre"));
           tvcatégorie.setItems(ulist); 
           
            tfidcategorie.clear();
            tftype.clear();
            tfdescription.clear();
            tfnomcategorie.clear();
}
      @FXML
    private void getfromghada(MouseEvent event) {
        
         catégorie Cc = tvcatégorie.getSelectionModel().getSelectedItem();
           tfidcategorie.setText(""+ Cc.getID_Cat());
            tftype.setText(Cc.getType());
           tfdescription.setText(""+Cc.getDescription());
            tfnomcategorie.setText(" "+Cc.getNomCat());
          dtcat.setValue(Instant.ofEpochMilli((Cc.getDateCat()).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
    }

 
    @FXML
    private void UpdateCategorie(ActionEvent event) {
            int idcategorie = Integer.parseInt(tfidcategorie.getText().trim());
            String type = tftype.getText();
            String description = tfdescription.getText();
            String nomcategorie= tfnomcategorie.getText();
            Date dateajout= java.sql.Date.valueOf(dtcat.getValue());
            
            CatégorieServices cc = new CatégorieServices ();
            catégorie C = new catégorie(idcategorie, type , description, nomcategorie,dateajout);
            cc.UpdateCategorie(C, idcategorie);
           
   List list=cc.readAll();
            ulist= FXCollections.observableArrayList(list);
            colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
           coltdateajout.setCellValueFactory(new PropertyValueFactory<>("DateCat"));
           colnbreoeuvre.setCellValueFactory(new PropertyValueFactory<>("NbreOeuvre"));
            tvcatégorie.setItems(ulist); 
            tfidcategorie.clear();
            tftype.clear();
            tfdescription.clear();
            tfnomcategorie.clear();
    }

    @FXML
    private void DeleteCategorie(ActionEvent event) {
        int C = Integer.parseInt(tfidcategorie.getText().trim());
            System.out.println(C);
           CatégorieServices cc = new CatégorieServices ();
            cc.Deletecategorie(C);
            List list=cc.readAll();
            ulist= FXCollections.observableArrayList(list);
            colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
           coltdateajout.setCellValueFactory(new PropertyValueFactory<>("DateCat"));
           colnbreoeuvre.setCellValueFactory(new PropertyValueFactory<>("NbreOeuvre"));
            tvcatégorie.setItems(ulist); 
            tfidcategorie.clear();
            tftype.clear();
            tfdescription.clear();
            tfnomcategorie.clear();
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
       CatégorieServices CC= new CatégorieServices ();
        ObservableList<catégorie> list = CC.Searchc(search);
            ulist= FXCollections.observableArrayList(list);
           colidcategorie.setCellValueFactory(new PropertyValueFactory<>("ID_Cat"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
            coldescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           colnomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCat")); 
          coltdateajout.setCellValueFactory(new PropertyValueFactory<>("DateCat"));
           colnbreoeuvre.setCellValueFactory(new PropertyValueFactory<>("NbreOeuvre"));
            tvcatégorie.setItems(ulist);
    }

    @FXML
    private void gotoevent(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Event/AddEvent.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void gotoOeuvre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("Oeuvre/Oeuvre.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
    @FXML
    private void showOrders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("DashOrdersCart/DashBoardOrders.fxml")));
        dialogStage.setTitle("ArtDome DashBoard - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}