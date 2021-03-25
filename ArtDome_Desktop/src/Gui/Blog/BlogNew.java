package Gui.Blog;

import Entities.Blog;
import Entities.Event;
import Entities.User;
import Services.CartCRUD;
import Services.EventMethods;
import Services.blogService;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

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
    }
    @FXML
    private void gotohome(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../HomeScene.fxml")));
        dialogStage.setTitle("ArtDome - Home");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void gotooeuvre(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml")));
        dialogStage.setTitle("ArtDome - Oeuvre");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void gotoorders(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml")));
        dialogStage.setTitle("ArtDome - Orders");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void gotoexpo(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../Exposition/AddExposition.fxml")));
        dialogStage.setTitle("ArtDome - Exposition");
        dialogStage.setScene(scene);
        dialogStage.show();
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
}
