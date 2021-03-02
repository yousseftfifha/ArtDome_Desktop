package Gui;

import Entities.Cart;
import Entities.Oeuvre;
import Services.CartCRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */

public class HomeSceneController implements Initializable {
    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton OrdersB;
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private JFXButton AddToCart;
    @FXML
    private JFXTextField CartNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CartCRUD cartCRUD=new CartCRUD ();
        int i=cartCRUD.count ();
        CartNumber.setText (""+i);

    }


    @FXML
    private void handleBtnOrder(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CartItem.fxml")));
        dialogStage.setTitle("ArtDome - Cart");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void AddToCart(ActionEvent actionEvent) {

            CartCRUD cartCRUD=new CartCRUD ();

            List<Oeuvre> oeuvre1=cartCRUD.selectOeuvreById (1);
            List<Oeuvre> oeuvre2=cartCRUD.selectOeuvreById (2);

            Cart cart=new Cart(0);

            cartCRUD.AddCart (cart,oeuvre1.get (0));
            cartCRUD.AddCart (cart,oeuvre2.get (0));

            cartCRUD.updateQuantity (0,oeuvre1.get (0));
            int i=cartCRUD.count ();
            CartNumber.setText (""+i);
    }

    @FXML
    private void handleOrder(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("CheckOutScene.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
