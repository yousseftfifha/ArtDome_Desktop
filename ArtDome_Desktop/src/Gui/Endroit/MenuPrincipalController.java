
package Gui.Endroit;

import Gui.Endroit.OpenWindow;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;





/**
 *
 * @author gamer
 */
public class MenuPrincipalController implements Initializable {
  
	String chemin = "";
    String title = "";
    Stage primaryStage = new Stage();
        
    @FXML
	private Pane imagePane;
    
    @FXML
    public Label NomMenu,nomemp;
    
    @FXML
    private JFXButton BAjoutClient,BSupprimerClient,BModifierClient,BSupprimerReservation,
            BModifierReservation,BSupprimerEmployee,BAfficherClient,BAfficherVehicule,BAfficherEmployee,
            BAfficherReservation,BModifierVehicule,BSupprimerVehicule,BModifierEmployee,BAjouterVehicule,BajouterReservation,logout;
    
     @FXML  
    private JFXButton BClient,BReservation,BEmployee,BVehicule;
    @FXML
    private Pane MenuClient,MenuReservation,MenuEmploye,PaneVehicul,contenu;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public Label getNomemp() {
        return nomemp;
    }
    //Client 
    
     @FXML
    private void handleBAjoutClientAction(ActionEvent event) {
        
        chemin = "ajoutClient.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    @FXML
    private void handleBAfficherClientAction(ActionEvent event) {
        
        chemin = "afficherClient.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    @FXML
    private void handleBSupprimerClientAction(ActionEvent event) {
        
        chemin = "SupprimerClient.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    
    
     @FXML
    private void handleBModifierClientAction(ActionEvent event) {
        
        chemin = "modifierClient.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    //reservation
    
       @FXML
    private void handleBSupprimerReservationAction(ActionEvent event) {
        
        chemin = "SupprimerReservation.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    
      @FXML
    private void handleBModifierReservationAction(ActionEvent event) {
        
        chemin = "ModifierReservation.fxml";
		new OpenWindow(contenu, chemin);

    }
    
        @FXML
    private void handleBAfficherReservationAction(ActionEvent event) {
        
        chemin = "AfficherReservation.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    @FXML
    private void handleBAjouterReservationAction(ActionEvent event) {
        
        chemin = "AjoutReservation.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    //employee
    
     @FXML
    private void handleBSupprimerEmployeeAction(ActionEvent event) {
        
        chemin = "SupprimerEmployee.fxml";
		new OpenWindow(contenu, chemin);

    }
    
     @FXML
    private void handleBAjouterEmployeeAction(ActionEvent event) {
        
        chemin = "AjouterEmployee.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    
  @FXML
    private void handleBAfficherEmployeeAction(ActionEvent event) {
        
        chemin = "AfficherEmployee.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    @FXML
    private void handleBModifierEmployeeAction(ActionEvent event) {
        
        chemin = "Modifier Employee.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    //vehicule
    
    @FXML
    private void handleBSupprimerVehiculeAction(ActionEvent event) {
        
        chemin = "SupprimerVehicul.fxml";
		new OpenWindow(contenu, chemin);

    }
    
     @FXML
    private void handleBAjouterVehiculeAction(ActionEvent event) {
        
        chemin = "AjouterEndroit.fxml";
		new OpenWindow(contenu, chemin);
                
    }
    
        @FXML
    private void handleBModifierVehiculAction(ActionEvent event) {
        
        chemin = "ModifierEndroit.fxml";
		new OpenWindow(contenu, chemin);

    }
    
   
 
    
     @FXML
    private void handleBAfficherVehiculeAction(ActionEvent event) {
        
        chemin = "AfficherEndroit.fxml";
		new OpenWindow(contenu, chemin);

    }
    
   
    
    
    @FXML
    private void hanleBClientAction(ActionEvent event) {
        chemin = "afficherClient.fxml";
		new OpenWindow(contenu, chemin);
        
    }
    @FXML
    private void handleBVehiculonAction(ActionEvent event) {
        
 chemin = "AfficherEndroit.fxml";
		new OpenWindow(contenu, chemin);

    }
    
    @FXML
    private void handleBemployeAction(ActionEvent event) {
        chemin = "AfficherEmployee.fxml";
		new OpenWindow(contenu, chemin); 
        
    }
    @FXML
    private void handleBReservationAction(ActionEvent event) {
        chemin = "AfficherReservation.fxml";
		new OpenWindow(contenu, chemin);
        
    }

    
@Override
	public void initialize(URL url, ResourceBundle rb) {
		
                try
{
    File f = new File ("utilisateur.txt");
    FileReader fr = new FileReader (f);
    BufferedReader br = new BufferedReader (fr);
 
    try
    {
          nomemp.setText(br.readLine());
          br.close();
          fr.close();
    }
    catch (IOException exception)
    {
        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
    }
}
catch (FileNotFoundException exception)
{
    System.out.println ("Le fichier n'a pas été trouvé");
}
            
            
                FadeTransition fadeout = new FadeTransition(Duration.seconds(4), imagePane);
		fadeout.setFromValue(1);
		fadeout.setToValue(0);
		fadeout.play();

		fadeout.setOnFinished(event -> {

			imagePane.setStyle(" -fx-background-image: url(\"/images/images4.jpg\");");

			FadeTransition fadein = new FadeTransition(Duration.seconds(4), imagePane);
			fadein.setFromValue(0);
			fadein.setToValue(0.6);
			fadein.play();

			fadein.setOnFinished(e -> {

				imagePane.setStyle(" -fx-background-image: url(\"/images/images1.jpg\");");
				FadeTransition fadein2 = new FadeTransition(Duration.seconds(4), imagePane);
				fadein2.setFromValue(0);
				fadein2.setToValue(1);
				fadein2.play();

				fadein2.setOnFinished(event2 -> {

					imagePane.setStyle(" -fx-background-image: url(\"/images/images2.jpg\");");

					FadeTransition fadein3 = new FadeTransition(Duration.seconds(4), imagePane);
					fadein3.setFromValue(1);
					fadein3.setToValue(0);
					fadein3.play();

					fadein3.setOnFinished(event3 -> {
						imagePane.setStyle(" -fx-background-image: url(\"/images/images3.jpg\");");

						FadeTransition fadein4 = new FadeTransition(Duration.seconds(4), imagePane);
						fadein4.setFromValue(0);
						fadein4.setToValue(1);
						fadein4.play();

						fadein4.setOnFinished(event4 -> {
							imagePane.setStyle(" -fx-background-image: url(\"/images/images4.jpg\");");

							FadeTransition fadein5 = new FadeTransition(Duration.seconds(4), imagePane);
							fadein5.setFromValue(0);
							fadein5.setToValue(1);
							fadein5.play();

						});

					});
				});

			});

		});
        }
        @FXML
    void LogOutOnAction(ActionEvent event) {
        logout.getScene().getWindow().hide();
        String chemin = "Login.fxml";
        title = "Login Page";
        /*Notifications notification = Notifications.create().title("Log Out complete ")
				.text(LoginController.usernameforHome + " has loged out").hideAfter(Duration.seconds(7))
				.position(Pos.BOTTOM_RIGHT);*/
        new OpenWindow(primaryStage, chemin, title);
        //notification.showInformation();
    }
}
	

