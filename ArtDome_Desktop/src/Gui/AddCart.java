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
            CartCRUD cartCRUD=new CartCRUD ();

            List<Oeuvre> oeuvre1=cartCRUD.selectOeuvreById (1);
            List<Oeuvre> oeuvre2=cartCRUD.selectOeuvreById (2);

            Cart cart=new Cart(0);
            Cart cart1=new Cart(1);

            cartCRUD.AddCart (cart,oeuvre1.get (0));
            cartCRUD.AddCart (cart,oeuvre2.get (0));
            cartCRUD.AddCart (cart1,oeuvre2.get (0));

            cartCRUD.updateQuantity (cart,oeuvre1.get (0));

            cartCRUD.DeletCart (cart1);

            FXMLLoader loader = new FXMLLoader (getClass ().getResource ("ShowCart.fxml"));
            Parent root = loader.load ();
            ShowCart showCart = loader.getController ();

            addToCart.getScene ().setRoot (root);
        } catch (IOException ex) {
            Logger.getLogger (AddCart.class.getName ()).log (Level.SEVERE, null, ex);

        }

    }
}
