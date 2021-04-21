package Gui.Blog;

import Entities.Blog;
import Gui.HomeSceneController;
import Services.blogService;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class BlogNew implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private ComboBox<String> Categorie;
    @FXML
    private TextField tfimage;
    @FXML
    private TextField Title;
    @FXML
    private TextField Publisher;
    @FXML
    private TextArea description;
    @FXML
    private AnchorPane holderPane;
    @FXML
    AnchorPane home,oeuvre,event,profiles,expo,blog,orders,location,login,cart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> listT = Categorie.getItems();
        //Adding items to the combo box
        listT.add("Genral");
        listT.add("Painting");
        listT.add("Music");
        listT.add("Dance");
        listT.add("Collection");
        listT.add("Rare antiquity");
        listT.add("Autre..");
        try {
            home = FXMLLoader.load(getClass().getResource("../HomeScene.fxml"));
            profiles = FXMLLoader.load(getClass().getResource("../User/Profile.fxml"));
            oeuvre = FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml"));
            event = FXMLLoader.load(getClass().getResource("../Event/ListEvent.fxml"));
            expo = FXMLLoader.load(getClass().getResource("../Exposition/AddReservation_expo.fxml"));
            blog = FXMLLoader.load(getClass().getResource("../Blog/BlogShow.fxml"));
            orders = FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml"));
            location = FXMLLoader.load(getClass().getResource("../Endroit/AfficherReservation.fxml"));
            login = FXMLLoader.load(getClass().getResource("../User/Login.fxml"));
            cart = FXMLLoader.load(getClass().getResource("../OrdersCart/CartView.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(HomeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    @FXML
    private void addimage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.png","*.jpg","*.gif"));
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null)
        {
            tfimage.setText(selectedFile.getName ());
        }else {
            System.out.println(" Picture file is not valid");
        }

    }

    @FXML
    private void AddBlog(ActionEvent actionEvent) {
        String Titre = Title.getText();
        String Cat = Categorie.getValue();
        String image = tfimage.getText();
        String Pub = Publisher.getText();
        String desc=description.getText ();
        blogService em = new blogService();
        Blog e= new Blog (Titre, Cat, image,desc,Pub);

        em.ajouterBlog (e);
        Title.clear();

        description.clear();
        tfimage.clear();
        Publisher.clear();
    }
    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    @FXML
    private void profile(ActionEvent actionEvent) throws IOException {
        setNode(profiles);
    }

    @FXML
    private void order(ActionEvent actionEvent) throws IOException {
        setNode(orders);
    }

    @FXML
    private void oeuvre(ActionEvent actionEvent) throws IOException {
        setNode(oeuvre);
    }

    @FXML
    private void expo(ActionEvent actionEvent) throws IOException {
        setNode(expo);
    }

    @FXML
    private void event(ActionEvent actionEvent) throws IOException {
        setNode(event);
    }

    @FXML
    private void blog(ActionEvent actionEvent) throws IOException {
        setNode(blog);

    }
    @FXML
    private void location(ActionEvent actionEvent)throws IOException {
        setNode(location);
    }
    @FXML
    private void logout(ActionEvent actionEvent) throws IOException {
        setNode(login);

    }


    @FXML
    private void cart(ActionEvent actionEvent) {
        setNode(cart);
    }

    @FXML
    private void home(ActionEvent actionEvent) {
        setNode(home);

    }

}
