/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import Tools.UserHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static com.twilio.rest.api.v2010.account.usage.Record.Category.SMS;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.teknikindustries.bulksms.SMS;
import com.vonage.client.HttpConfig;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SmsRecoveryController implements Initializable {
    Stage dialogStage = new Stage ();
    Scene scene;
    @FXML
    private JFXButton BValider;
    @FXML
    private JFXPasswordField Tcode;
    @FXML
    private JFXTextField Tnum;
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
    private void valider(ActionEvent event) throws IOException {
         if((Integer.valueOf(Tcode.getText())==randomCode)){

         Node source = (Node) event.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("passwordReset.fxml")));
        dialogStage.setTitle("ArtDome - User");
        dialogStage.setScene(scene);
        dialogStage.show();
        int numero= Integer.parseInt (Tnum.getText());
             UserHolder holder = UserHolder.getInstance();
                    holder.setNumero (numero);

             System.out.println (holder.getNumero ());
    }
    else{
        erreur.setOpacity(1);
                LBerror.setTextFill(Color.BLACK);
                LBerror.setText("Code non valide !");
    }
    }

    @FXML
    private void sendSms(ActionEvent event) {
        
                       com.teknikindustries.bulksms.SMS sendtext=new SMS ();
                sendtext.SendSMS("yousseftfifha","181JMT2499y","votre code de verification est"+randomCode,"216"+"20245989","https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
                HttpConfig httpConfig = HttpConfig.defaultConfig();
                VonageClient client = new VonageClient .Builder()
                        .apiKey("8f52a2c6")
                       .apiSecret("967AQN7qPzUl5BB6")
                       .httpConfig(httpConfig)
                        .build();
               SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage (
                       "ArtDome",
                      "21620245989",
                       "votre code de verification est"+randomCode));

        
    }
    
}
