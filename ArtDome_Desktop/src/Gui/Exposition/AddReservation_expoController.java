/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Exposition;

import Entities.UserHolder;
import Tools.QRcodeE;
import com.github.plushaze.traynotification.notification.TrayNotification;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import Entities.User;
import Entities.reservation_expo;
import Services.ReservationEService;
import static Tools.Print.printNode;

import Tools.SendMail;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class AddReservation_expoController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TextField nom_client;
    @FXML
    private TextField prenom_client;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private Spinner<Integer> nb_place;
    @FXML
    private Button AddButtonR;
    @FXML
    private Button UpdateButtonR;
    @FXML
    private Button DeleteButtonR;
    @FXML
    private TableView<reservation_expo> tveR;
    @FXML
    private TableColumn<reservation_expo, Integer> colcode;
    @FXML
    private TableColumn<User, String > colnomClient;
    @FXML
    private TableColumn<User, String> colprenomClient;
    @FXML
    private TableColumn<User, Integer> coltelephone;
    @FXML
    private TableColumn<User, String> colemail;
    @FXML
    private TableColumn<reservation_expo, Integer> colnbPlace;
    @FXML
    private TextField codeeeExpo;
    @FXML
    private TextField codeeeReservation;
    @FXML
    private Button back;
    @FXML
    private AnchorPane an;
    @FXML
    private Button imprimer;
    @FXML
    private TextField searchReservation;
    @FXML
    private Button recherche;
    @FXML
    private TextField code_client;
    @FXML
    private TableView<User> tvUser;
    @FXML
    private TableColumn<User, Integer> colcodeclient2;
    @FXML
    private TableColumn<User, Date> coledatenaissance;
    @FXML
    private TableColumn<User, String> colville;
    @FXML
    private Button mail;
    @FXML
    private TextField backToExpo;
    @FXML
    private Button refresh2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         nb_place.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5000));
         showReservationE();
        UserHolder holder = UserHolder.getInstance();
        int id =holder.getUser ().getId ();
        code_client.setText(""+id);

    }    
    
    public void setTfcodeeeEvent(String codeeeExpo) {
        this.codeeeExpo.setText(codeeeExpo);
    }


    @FXML
    private void getfromtv(MouseEvent event) {
          reservation_expo r= (reservation_expo) tveR.getSelectionModel().getSelectedItem();
            codeeeReservation.setText(""+r.getCode_reservationE());
            code_client.setText(""+r.getCode_client());
            //colcodeclient.setText(""+r.getCode_client());
//            nom_client.setText(r.getNom_client());
//            prenom_client.setText(r.getPrenom_client());
//            telephone.setText(""+r.getTelephone());
//            email.setText(r.getEmail());
            nb_place.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(r.getNb_place(), 5000));
            
           showUser(Integer.parseInt(code_client.getText().trim()));
    }
    
       @FXML
    private void getfromtvUser(MouseEvent event) {
        
         User r= (User) tvUser.getSelectionModel().getSelectedItem();
           
                    
            //code_client.setText(""+r.getId());
            nom_client.setText(r.getNom());
            prenom_client.setText(r.getPrenom());
            telephone.setText(""+r.getNumero());
            email.setText(r.getEmail());
        
        
        
    }
         public void showUser(int user){
        ReservationEService ex=new ReservationEService ();
             UserHolder holder = UserHolder.getInstance();
             int id =holder.getUser ().getId ();
        ObservableList<User> userlist = ex.getUserList(id);
        
        colcodeclient2.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colnomClient.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        colprenomClient.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        coledatenaissance.setCellValueFactory(new PropertyValueFactory<User, Date>("datenaissance"));
         colville.setCellValueFactory(new PropertyValueFactory<User, String>("ville"));
        colemail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
         coltelephone.setCellValueFactory(new PropertyValueFactory<User, Integer>("numero"));
        
        
        
        tvUser.setItems(userlist);
    }
    
    
    
       public void showReservationE(){
           ReservationEService rem=new ReservationEService ();
        ObservableList<reservation_expo> Reservationlist = rem.getReservationEListFront ();
        colcode.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("code_reservationE"));
       // colcodeclient.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("code_client"));
//        colnomClient.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("nom_client"));
//        colprenomClient.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("prenom_client"));
//        coltelephone.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("telephone"));
//        colemail.setCellValueFactory(new PropertyValueFactory<reservation_expo, String>("email"));
        colnbPlace.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("nb_place"));
        tveR.setItems(Reservationlist);
    } 
       
         @FXML
    private void mailing(ActionEvent event) {
        mail();
        
    }
       
       public void mail(){
           
           
            String nom= nom_client.getText();
            String prenom = prenom_client.getText();
            int codeClient=Integer.valueOf(code_client.getText());
            int nbplace= nb_place.getValue();
             String mail = email.getText();
                            String msg= "Bonjour Mme/Mr "+nom+" "+prenom+","
                    + "C'est un plaisir de vous accueillir lors de notre exposition."
                    + "Vous avez bien réservé "+nbplace+ " place(s)."
                    + "Nous avons hâte de vous accueillir."
                    +"Bonne journée."
                    ;
            SendMail sm= new SendMail();
             ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
        emailExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sm.sendMail (mail, "Réservation exposition confirmée", msg);
                } catch (AddressException e) {
                    e.printStackTrace ();
                } catch (MessagingException e) {
                    e.printStackTrace ();
                }
                }
//        try {
//            sm.sendMail(mail, "Réservation exposition confirmée", msg);
//       } catch (MessagingException ex) {
//            Logger.getLogger(AddReservation_expoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
           
       });
       }
       
       @FXML
    private void AddReservationE(ActionEvent event) {
       // int code_reser = Integer.parseInt(codeeeReservation.get().trim());
//            
//            String nom= colnomClient.getText();
//            String prenom = colprenomClient.getText();
            int codeClient=Integer.valueOf(code_client.getText());
            int nbplace= nb_place.getValue();
//            int tel = Integer.valueOf(telephone.getText());
            //String mail = email.getText();
            ReservationEService rm = new ReservationEService ();
            reservation_expo r= new reservation_expo(codeClient,nbplace);
            rm.AddReservationE(r);
            showReservationE();
//            
//                 String msg= "Bonjour Mme/Mr "+nom_client+" "+prenom_client+","
//                    + "C'est un plaisir de vous accueillir lors de notre événement."
//                    + "Vous avez bien réservé "+nb_place+ " place(s)."
//                    + "Nous avons hâte de vous accueillir."
//                    +"Bonne journée."
//                    ;
//            SendMail sm= new SendMail();
//        try {
//            sm.sendMail(mail, "Réservation confirmée", msg);
//       } catch (MessagingException ex) {
//            Logger.getLogger(AddReservation_expoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
     showUser(Integer.parseInt(code_client.getText().trim()));
      TrayNotification tray = new TrayNotification();
        tray.setTitle("Réservation ajoutée");
        tray.setMessage("Une réservation a été ajoutée, veuillez la confirmer");
        //tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (5200));
        
        QRcodeE qrc=new QRcodeE ();
        qrc.QRcodeE();
     //mail();
            
    }
    
     @FXML
    private void UpdateReservationE(ActionEvent event) {
        
            int codeee_r = Integer.parseInt(codeeeReservation.getText().trim());
             String nom= nom_client.getText();
             String prenom = prenom_client.getText();
//            int tel =  Integer.parseInt(telephone.getText().trim());
            String mail = email.getText();
            int codeClient=Integer.valueOf(code_client.getText());
            int nbplace = nb_place.getValue();
            ReservationEService rm = new ReservationEService ();
            reservation_expo r= new reservation_expo(codeClient,nbplace);
            rm.UpdateReservation(r,codeee_r);
            showReservationE();
            
//              String msg= "Bonjour Mme/Mr "+nom_client+" "+prenom+","
//                    + "C'est un plaisir de vous accueillir lors de notre événement."
//                    + "Vous avez bien réservé "+nb_place+ " place(s)."
//                    + "Nous avons hâte de vous accueillir."
//                    +"Bonne journée."
//                    ;
//            SendMail sm= new SendMail();
//        try {
//            sm.sendMail(mail, "Réservation confirmée", msg);
//        } catch (MessagingException ex) {
//            Logger.getLogger(AddReservation_expoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    
    private void DeleteReservationE(ActionEvent event) {
                int codeee = Integer.parseInt(codeeeReservation.getText().trim());
//        Integer.parseInt(line.toString())
//            String nom= nom_client.getText();
//            String prenom = prenom_client.getText();
//            int tel =  Integer.parseInt(telephone.getText().trim());
           // String mail = email.getText();
            int nbplace = nb_place.getValue();
        ReservationEService em = new ReservationEService ();
            em.DeleteExpo(codeee);
        showReservationE();
//          String msg= "Bonjour Mme/Mr "+nom_client+" "+prenom+","
//                    + "Vouz avez annulé votre réservation."
//                    + "Nous espérons que vous vous portez bien."
//                    +"Bonne journée."
//                    ;
//            SendMail sm= new SendMail();
//        try {
//            sm.sendMail(mail, "Réservation annulée", msg);
//        } catch (MessagingException ex) {
//            Logger.getLogger(AddReservation_expoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void ReturnToExpo(ActionEvent event) {
       
              try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddExposition.fxml"));
            Parent root = loader.load();
            AddExpositionController c = loader.getController();
            backToExpo.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddExpositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
  

    @FXML
    private void print(ActionEvent event) {
         try {
            printNode(an);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(AddReservation_expoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchReservation(ActionEvent event) {
        
        int s= Integer.parseInt(searchReservation.getText().trim());
        
        ReservationEService em=new ReservationEService ();
        ObservableList<reservation_expo> eventl = em.SearchReservation(s);
        colcode.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("code_reservationE"));
        colnbPlace.setCellValueFactory(new PropertyValueFactory<reservation_expo, Integer>("nb_place"));
       
        tveR.setItems(eventl);
        
        
    }

    @FXML
    private void refreshReserFront(ActionEvent event) {
        
        showReservationE();
        searchReservation.clear();
    }
    @FXML
    private void handleOrder(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
//        dialogStage.setFullScreen(true);
        dialogStage.show();
    }

    @FXML
    private void GoToOeuvre(ActionEvent actionEvent) throws IOException {
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
    private void goToExpos(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/AddReservation_expo.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();

    }

    @FXML
    private void gotoevent(ActionEvent actionEvent) throws IOException {
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
    private void gotoblog(ActionEvent actionEvent) throws IOException {
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
    private void profile(ActionEvent actionEvent) throws IOException {
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
    private void Location(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Endroit/AfficherReservation.fxml")));
        dialogStage.setTitle("ArtDome - Endroit");
        dialogStage.setScene(scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

}
