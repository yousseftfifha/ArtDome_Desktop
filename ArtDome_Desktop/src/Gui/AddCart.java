package Gui;

import Entities.Cart;
import Entities.Oeuvre;
import Services.CartCRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class AddCart  implements Initializable {


    @FXML
    private Button addToCart;
    @FXML
    private Button addToCart1;
    @FXML
    private Button addToCart2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void AddToCart(ActionEvent actionEvent) throws IOException {

        try {

            CartCRUD cartCRUD = new CartCRUD ();
            Oeuvre oeuvre=new Oeuvre (0,"faza",5.f);
            Oeuvre oeuvre1=new Oeuvre (1,"faza1",5.f);
            Oeuvre oeuvre2=new Oeuvre (2,"faza2",5.f);


//            Oeuvre oeuvre = new Oeuvre (oeuvres.get (0).getID_Oeuvre (),oeuvres.get (0).getNomOeuvre (),oeuvres.get (0).getPrixOeuvre ());
//            Cart cart1 = new Cart (oeuvre2.getID_Oeuvre (), 2);
//            cartCRUD.AddCart (cart1);
            System.out.println (oeuvre1.getID_Oeuvre ());
            FXMLLoader loader = new FXMLLoader (getClass ().getResource ("ShowCart.fxml"));
            Parent root = loader.load ();
            ShowCart showCart = loader.getController ();

            addToCart.getScene ().setRoot (root);
        } catch (IOException ex) {
            Logger.getLogger (AddCart.class.getName ()).log (Level.SEVERE, null, ex);

        }

    }
}
