package Gui;

import Entities.Cart;
import Entities.Oeuvre;
import Services.CartCRUD;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author tfifha youssef
 */
public class ShowCart  implements Initializable {

    @FXML
    public TableView<Cart> table;
    @FXML
    private TableColumn<Cart,Integer> CartID;
    @FXML
    private TableColumn<Cart,Integer>  ProductID;
    @FXML
    private TableColumn<Cart, Integer> Quantity;
    @FXML
    private JFXButton back;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.setEditable (true);

        CartID.setCellValueFactory (
                new PropertyValueFactory<Cart,Integer> ("CartId")
        );
        ProductID.setCellValueFactory (
                new PropertyValueFactory<Cart,Integer> ("OeuvreID")
        );
        Quantity.setCellValueFactory (
                new PropertyValueFactory<Cart, Integer> ("Quantiy")
        );

        buildData ();

    }
    private ObservableList<Cart> data;

    public void buildData(){
        data = FXCollections.observableArrayList();

        try{
            CartCRUD cartCRUD = new CartCRUD ();
            List<Cart> cartList = cartCRUD.readAll ();

            data.addAll(cartList);

            table.setItems(data);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @FXML
    private void backToMain(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader (getClass ().getResource ("AddCart.fxml"));
        Parent root=loader.load ();
        AddCart addCart=loader.getController ();

        back.getScene ().setRoot (root);


    }


}
