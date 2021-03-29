/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Exposition;

import Tools.ExcelE;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import jxl.write.WriteException;
import Entities.User;
import Entities.reservation_expo;
import Services.ReservationEMethods;
import Tools.Excel;
import Tools.PDFreservation;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class Reservation_expoBackController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private TableView<reservation_expo> tveR1;
    @FXML
    private TableColumn<reservation_expo, Integer> colcode1;
    private TableColumn<reservation_expo, String > colnomClient1;
    private TableColumn<reservation_expo, String> colprenomClient1;
    private TableColumn<reservation_expo, Integer> coltelephone1;
    private TableColumn<reservation_expo, String> colemail1;
    private TableColumn<reservation_expo, Integer> colnbPlace1;
    @FXML
    private Button recherche;
    @FXML
    private Button pdf;
    @FXML
    private Button reservation;
    @FXML
    private TextField cod;
    @FXML
    private TextField searchReservationBack;
    private TableColumn<reservation_expo, Integer> colcodereservation;
    @FXML
    private TableColumn<reservation_expo, Integer> colnombreplace;
    @FXML
    private TableView<User> tvUser2;
    @FXML
    private TableColumn<User, Integer> colcodeclient2;
    @FXML
    private TableColumn<User, String> colnomClient2;
    @FXML
    private TableColumn<User, String> colprenomClient2;
    @FXML
    private TableColumn<User, Date> coledatenaissance2;
    @FXML
    private TableColumn<User, String> colville2;
    @FXML
    private TableColumn<User, String> colemail2;
    @FXML
    private TableColumn<User, Integer> coltelephone2;
    @FXML
    private TextField code_client2;
    @FXML
    private Button refresh3;
    @FXML
    private Button excel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReservationE();
    }  
    
      public void showReservationE(){
           ReservationEMethods rem=new ReservationEMethods();
        ObservableList<reservation_expo> Reservationlist = rem.getReservationEList();
        colcode1.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("code_reservationE"));
       // colcodeclient.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("code_client"));
//        colnomClient1.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("nom_client"));
//        colprenomClient1.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("prenom_client"));
//        coltelephone1.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("telephone"));
//        colemail1.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("email"));
        colnombreplace.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("nb_place"));
        tveR1.setItems(Reservationlist);
    } 

    @FXML
    private void pdf(ActionEvent event) {
        
         try {
             PDFreservation pdf=new PDFreservation();
            pdf.ReservationPDFback();
        } catch (DocumentException ex) {
            Logger.getLogger(Reservation_expoBackController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Reservation_expoBackController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reservation_expoBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void backtoreservation(ActionEvent event) {
        
            try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddExposition.fxml"));
            Parent root = loader.load();
            AddExpositionController c = loader.getController();
            cod.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddExpositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void searchReservationBack(ActionEvent event) {
        
          int s= Integer.parseInt(searchReservationBack.getText().trim());
        
        ReservationEMethods em=new ReservationEMethods();
        ObservableList<reservation_expo> eventl = em.SearchReservation(s);
        colcode1.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("code_reservationE"));
        colnombreplace.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("nb_place"));
       
        tveR1.setItems(eventl);
        
        
    }
    
     public void showUser(int user){
        ReservationEMethods ex=new ReservationEMethods();
        ObservableList<User> userlist = ex.getUserList(user);
        
        colcodeclient2.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID"));
        colnomClient2.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        colprenomClient2.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        coledatenaissance2.setCellValueFactory(new PropertyValueFactory<User, Date>("datenaissance"));
         colville2.setCellValueFactory(new PropertyValueFactory<User, String>("ville"));
        colemail2.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
         coltelephone2.setCellValueFactory(new PropertyValueFactory<User, Integer>("numero"));
        
        
        
        tvUser2.setItems(userlist);
    }

    @FXML
    private void GetFromReservationBack(MouseEvent event) {
         reservation_expo r= (reservation_expo) tveR1.getSelectionModel().getSelectedItem();
            
            code_client2.setText(""+r.getCode_client());
            ReservationEMethods em=new ReservationEMethods();
        ObservableList<User> eventl = em.getUserList(Integer.parseInt(code_client2.getText().trim()));
        
          colcodeclient2.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colnomClient2.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        colprenomClient2.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        coledatenaissance2.setCellValueFactory(new PropertyValueFactory<User, Date>("datenaissance"));
         colville2.setCellValueFactory(new PropertyValueFactory<User, String>("ville"));
        colemail2.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
         coltelephone2.setCellValueFactory(new PropertyValueFactory<User, Integer>("numero"));
        
          tvUser2.setItems(eventl);
        // showUser(Integer.parseInt(code_client2.getText().trim()));
         
    }

    @FXML
    private void refreshReserBack(ActionEvent event) {
        showReservationE();
        searchReservationBack.clear();
    }

    @FXML
    private void Excel(ActionEvent event) {
        
           
        try {
            ExcelE ex=new ExcelE ();
            ex.ExcelE();
        } catch (SQLException ex1) {
            Logger.getLogger(Reservation_expoBackController.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (WriteException ex1) {
            Logger.getLogger(Reservation_expoBackController.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (IOException ex1) {
            Logger.getLogger(Reservation_expoBackController.class.getName()).log(Level.SEVERE, null, ex1);
        }
      
    }

    @FXML
    private void gotohome(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../DashBoardScene.fxml")));
        dialogStage.setTitle ("ArtDome - Home");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }


    @FXML
    private void gotoorders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("DashBoardOrders.fxml")));
        dialogStage.setTitle ("ArtDome - Orders");
        dialogStage.setScene (scene);
        dialogStage.show ();
    }
   
    
}
