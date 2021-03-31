/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Tools.MyConnection;
import Entities.User;
import Tools.UserHolder;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton BValider;
    @FXML
    private JFXPasswordField Tpassword;
    @FXML
    private JFXTextField TUser;
    @FXML
    private JFXButton Bnouveau;
    @FXML
    private Label LBerror;
    @FXML
    private ImageView erreur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ChangerScene(ActionEvent event) throws IOException {
        try {
            String user = TUser.getText().toString();
            String password = Tpassword.getText().toString();
            String sql = "SELECT * FROM user Where nom='" + user + "' and mdp='" + password + "'";
          

            Connection con = MyConnection.getInstance().getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                erreur.setOpacity(1);
                LBerror.setTextFill(Color.BLACK);
                LBerror.setText("ENTREZ UN NOM D'UTILISATEUR / MOT DE PASSE VALIDE !");
            } else {
                erreur.setOpacity(0);
                try {
                    File ff = new File("utilisateur.txt");
                    ff.createNewFile();
                    FileWriter ffw = new FileWriter(ff);
                    ffw.write(user);
                    ffw.close();
                } catch (Exception e) {
                    System.out.println("erreur");
                }
                if (resultSet.getString(9).equals("admin")){
                   
                Stage stage = new Stage();
                stage.setTitle("ArtDome");
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../Gui/DashBoardScene.fxml."))));
                    User u = new User (resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDate(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(10));
                    UserHolder holder = UserHolder.getInstance();
                    holder.setUser(u);
                stage.show();
                BValider.getScene().getWindow().hide();
                }
                else {
                    User u = new User (resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDate(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(10));
                    UserHolder holder = UserHolder.getInstance();
                    holder.setUser(u);
                    Stage stage = new Stage();
                stage.setTitle("ArtDome");
                 
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../Gui/HomeScene.fxml."))));
                stage.show();
                BValider.getScene().getWindow().hide();
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Nouveau(ActionEvent event) throws IOException, SQLException {
        Stage stage = new Stage();
        stage.setTitle("Nouvel Utilisateur");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SignUp.fxml"))));
        stage.show();
        BValider.getScene().getWindow().hide();
    }
   @FXML 
   private void forgotPassword (ActionEvent event)throws IOException{
        Stage stage = new Stage();
        stage.setTitle("Mot de passe Oublié");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("forgotPass.fxml"))));
        stage.show();
        
       
   }
    
}
