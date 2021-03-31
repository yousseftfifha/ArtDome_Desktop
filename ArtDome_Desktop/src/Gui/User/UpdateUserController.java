/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class UpdateUserController implements Initializable {

    @FXML
    private JFXPasswordField Tmdp;
    @FXML
    private JFXTextField Tid;
    @FXML
    private JFXTextField Tprenom;
    @FXML
    private JFXTextField TNom;
    @FXML
    private DatePicker date;
    @FXML
    private JFXTextField Tnum;
    @FXML
    private JFXTextField Temail;
    @FXML
    private JFXTextField Tville;
    @FXML
    private JFXButton Bupdate;
private boolean update;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleBupdate(ActionEvent event)throws SQLException{
        try{
        String x1=String.valueOf(date.getValue());
        Date x = java.sql.Date.valueOf(x1);
        int i = Integer.parseInt(Tnum.getText().trim());
        int idd = Integer.parseInt(Tid.getText().trim());
        User u = new User(idd,TNom.getText(),Tprenom.getText(),x,Tville.getText(),Temail.getText(),i,Tmdp.getText());
        UserService crd = new UserService ();
        crd.UpdateUser(u);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("UPDATE AVEC SUCCES");
        alert.setHeaderText(null);
        alert.setContentText("L'utilisateur "+u.getPrenom()+" "+u.getNom()+" a été mis a jour avec succès");
        alert.showAndWait();
        }
        
        catch(RuntimeException ex)
        {
             Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }
    }
    void setTextField(int idd, String name, String prenom, LocalDate toLocalDate, String ville, String email , int numero,String mdp) {

        Tid.setText(String.valueOf(idd));
        TNom.setText(name);
        Tprenom.setText(name);
        date.setValue(toLocalDate);
        Tville.setText(ville);
        Temail.setText(email);
        Tnum.setText(String.valueOf(numero));
        Tmdp.setText(mdp);

    }
    void setUpdate(boolean b) {
        this.update = b;

    }
    
}
