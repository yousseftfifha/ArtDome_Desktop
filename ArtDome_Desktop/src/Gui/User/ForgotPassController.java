/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import Tools.SendEmail;
import Tools.emailHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.image.Image;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class ForgotPassController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private JFXButton BValider;
    @FXML
    private JFXPasswordField Tcode;
    @FXML
    private JFXTextField Temail;
    @FXML
    private Label LBerror;
    @FXML
    private ImageView erreur;
    @FXML
    private JFXButton Benvoyer;
   Random rand = new Random();
        int randomCode=rand.nextInt(999999);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendmail(ActionEvent event)throws MessagingException {
     
        String message ="votre code de verification est : "+randomCode;
        ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
        emailExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    SendEmail.sendMail (Temail.getText(),"Code de verification",message);
                } catch (AddressException e) {
                    e.printStackTrace ();
                } catch (MessagingException e) {
                    e.printStackTrace ();
                }

            }
        });
        emailExecutor.shutdown();

}
    
@FXML
private void valider (ActionEvent event)throws IOException{
    if((Integer.valueOf(Tcode.getText())==randomCode)){

        scene = new Scene (FXMLLoader.load(getClass().getResource("passwordReset.fxml")));
        dialogStage.setTitle("ArtDome - User");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
        String mail= Temail.getText();
        emailHolder holder = emailHolder.getInstance();
        holder.setMail(mail);
//                            resetController.setUpdate(true);
        
    }
    else{
        erreur.setOpacity(1);
                LBerror.setTextFill(Color.BLACK);
                LBerror.setText("Code non valide !");
    }
}
}