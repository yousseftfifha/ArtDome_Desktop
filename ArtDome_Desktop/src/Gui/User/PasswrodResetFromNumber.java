package Gui.User;

import Services.UserService;
import Tools.UserHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * @author tfifha youssef
 */
public class PasswrodResetFromNumber {
    @FXML
    private JFXButton BValider;
    @FXML
    private JFXPasswordField Tmdp2;
    @FXML
    private JFXTextField Tmdp;
    @FXML
    private Label LBerror;
    @FXML
    private ImageView erreur;

    @FXML
    private void Mdp2(ActionEvent event) {


        if (Tmdp.getText().equals(Tmdp2.getText())){
            UserHolder holder = UserHolder.getInstance();
            UserService crd = new UserService();
            System.out.println(holder.getNumero());
            crd.updateMdp2(holder.getNumero(),Tmdp.getText());

        }else{
            erreur.setOpacity(1);
            LBerror.setTextFill(Color.BLACK);
            LBerror.setText("Mot de passe incorrect !");
        }

    }
}
