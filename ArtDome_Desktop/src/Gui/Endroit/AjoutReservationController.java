/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Endroit;

import Tools.config;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import javax.mail.MessagingException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import Entities.ReservationE;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author gamer
 */
public class AjoutReservationController implements Initializable {

    @FXML
    private JFXTextField idclient,mat1,mat2,caution;
    @FXML
    private JFXDatePicker dated,datef;
        ObservableList<String> oblist = FXCollections.observableArrayList();

    @FXML
    private void AjoutReservation(ActionEvent event) throws SQLException, MessagingException{
        try
        {
        LocalDate dateDebut=dated.getValue();
        LocalDate dateFin=datef.getValue();
            ReservationE r=new ReservationE(Integer.parseInt(idclient.getText()),Integer.parseInt(mat1.getText()),dateDebut,dateFin,Integer.parseInt(caution.getText()));
        r.ajouterReservation();
        r.MAJdispo();
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION," Reservation ajoutée avec succes  ",ButtonType.FINISH);
        alert.showAndWait();
        }
        catch(SQLException ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }
       /* catch(RuntimeException ex)
        {
             Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }*/
       String title = "Succes! ";
        String message = "La reservation est ajouté avec succés";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(5));

         sendEmail();

    }
    public void sendEmail() throws SQLException, AddressException, MessagingException{
                    Connection con =config.getInstance().getConnection();
            
            
            ResultSet rs;
            
            rs = con.createStatement().executeQuery("SELECT email FROM client where idclient ='" + this.idclient + "' ");
            String email = null;
            if(rs.next())
            {
                email = rs.getString("email");
                        
            }
        String to="habib.charfeddine@esprit.tn";
        String from = "artdomeproject@gmail.com";
        String host = "smtp.gmail.com";
        final String username = "artdomeproject@gmail.com";
        final String password = "PiDev2021";

        //setup mail server

        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new Authenticator(){
         @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try{

            //create mail
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            m.setSubject("RESERVATION");
            m.setText("Reservation etablie");

            //send mail

            Transport.send(m);
            //sentBoolValue.setVisible(true);
            System.out.println("Message sent!");

        }   catch (MessagingException e){
            e.printStackTrace();
        }
        
            

    }

    @FXML
    private void Annuler(ActionEvent event)  {
    
     idclient.setText("");
     mat1.setText("");
     mat2.setText("");
     caution.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
