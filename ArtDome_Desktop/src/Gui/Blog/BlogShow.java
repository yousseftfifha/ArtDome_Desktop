package Gui.Blog;

import Entities.Blog;
import Gui.HomeSceneController;
import Services.blogService;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class BlogShow implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private AnchorPane content;
    @FXML
    private VBox HD;
    @FXML
    private JFXTextArea area;
    @FXML
    private JFXTextField head;
    @FXML
    private ImageView imgarea;
    @FXML
    private AnchorPane holderPane;
    @FXML
    AnchorPane home,oeuvre,event,profiles,expo,blog,orders,location,login,cart,addbl;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ShowBlog ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        try {
            addbl=FXMLLoader.load(getClass().getResource("BlogNew.fxml"));
            home = FXMLLoader.load(getClass().getResource("../HomeScene.fxml"));
            profiles = FXMLLoader.load(getClass().getResource("../User/Profile.fxml"));
            oeuvre = FXMLLoader.load(getClass().getResource("../Oeuvre/OeuvreItem.fxml"));
            event = FXMLLoader.load(getClass().getResource("../Event/ListEvent.fxml"));
            expo = FXMLLoader.load(getClass().getResource("../Exposition/AddReservation_expo.fxml"));
            orders = FXMLLoader.load(getClass().getResource("../OrdersCart/Orders.fxml"));
            location = FXMLLoader.load(getClass().getResource("../Endroit/AfficherReservation.fxml"));
            login = FXMLLoader.load(getClass().getResource("../User/Login.fxml"));
            cart = FXMLLoader.load(getClass().getResource("../OrdersCart/CartView.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(HomeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void ShowBlog() throws Exception
    {
        if(content.getChildren()!=null)
        {
            content.getChildren().clear();
        }

        // get Elements to display
        blogService blogService = new blogService();
        List<Blog> blogList = blogService.selectionnerBlog();


        VBox Container = new VBox();  // main container for all data specific to a service

        // Scroll pane to display all the found services
        ScrollPane scrollPane = new ScrollPane(Container);
        scrollPane.setPrefSize(1060, 530);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        AnchorPane.setTopAnchor(scrollPane, 0.);
        Container.setPrefWidth(1060);
        Container.setPrefHeight(530);

        content.setRightAnchor(scrollPane, 0.);
        content.setBottomAnchor(scrollPane, 0.);
        content.setLeftAnchor(scrollPane, 0.);

        //Container.setPadding(new Insets(30,30,30,30));

        // iterate through all events and create an event element
        for(Blog blog : blogList)
        {

            //HBOX
            HBox Hb = new HBox();

            // Service image : first element
            ImageView imgView = new ImageView("/GFX/"+blog.getImage());
            imgView.setFitHeight(150);
            imgView.setFitWidth(150);


            VBox vb = new VBox();

            Label Title = new Label(blog.getTitle ());
            Title.setStyle("-fx-text-fill : #920000; -fx-font-size : 25; -fx-font-weight : bold; -fx-padding : 10 10 10 10;");

            Label publ = new Label(blog.getPublisher ());
            publ.setStyle("-fx-text-fill : #333333; -fx-font-size : 15; -fx-font-weight : bold; -fx-padding : 0 0 0 10;");

            Label category = new Label("Category : " + blog.getCategorie ());
            category.setStyle("-fx-text-fill : #333333; -fx-font-size : 15; -fx-font-weight : bold; -fx-padding : 0 0 0 10;");
            Label date = new Label("Added " + blog.getDateOfPub ());
            date.setStyle("-fx-text-fill : #333333; -fx-font-size : 15; -fx-font-weight : bold; -fx-padding : 0 0 4 10;");
            Button open = new Button("View more");
            open.setStyle("-fx-background-color : none; -fx-text-fill : #810000; -fx-font-size : 15; -fx-font-weight : bold; -fx-padding : 0 0 0 10;");

            open.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    VBox Container = new VBox();  // main container for all data specific to a Section

                    // Scroll pane to display all the found services
                    ScrollPane scrollPane = new ScrollPane(Container);
                    scrollPane.setPrefSize(1060, 530);
                    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

                    AnchorPane.setTopAnchor(scrollPane, 0.);
                    Container.setPrefWidth(1060);
                    Container.setPrefHeight(530);

                    content.setRightAnchor(scrollPane, 0.);
                    content.setBottomAnchor(scrollPane, 0.);
                    content.setLeftAnchor(scrollPane, 0.);

                    List<String> heads = Arrays.asList(blog.getTitle ().split(","));

                    HBox Hb = new HBox();


                    VBox vb = new VBox();
                    Label head = new Label();
//                    head.setMinWidth(450);
                    head.setText(heads.toString());
                    head.setStyle("-fx-text-fill : #920000; -fx-font-size : 25; -fx-font-weight : bold; -fx-padding : 10 10 10 10;");
                    TextArea section = new TextArea();
                    Label desc = new Label();
                    area.setText (blog.getDescription ());
//                    desc.setText(blog.getDescription ());
                    imgarea.setImage (new Image ("/GFX/"+blog.getImage () ));
//                    ImageView img = new ImageView(new Image ("/GFX/"+blog.getImage () ));
//                    section.setMinHeight (500);
                    vb.getChildren().add(head);
                    vb.getChildren().add(area);

                    Hb.getChildren().add(vb);
                    Hb.getChildren().add(imgarea);

                    Container.getChildren().add(Hb);

                    vb.setStyle(" -fx-background-color : linear-gradient(to top right, #eecda3, #ef629f) ");

//                    Hb.setStyle(" -fx-background-color : linear-gradient(to top right, #eecda3, #ef629f) ");


                    // Finally add all the events inside the Scrollpane to the main content Anchorpane
                    //    scrollPane.setStyle(transp);
                    //   Container.setStyle(transp);
                    content.getChildren().add(scrollPane);

                }
            });

            vb.getChildren().add(Title);vb.getChildren().add(publ);
            vb.getChildren().add(category);
            vb.getChildren().add(date);
            vb.getChildren().add(open);
            Hb.getChildren().add(imgView);
            Hb.getChildren().add(vb);

            Hb.setStyle("-fx-border-color :#ff7f50; -fx-background-color : #6a5acd");


         Hb.setStyle(" -fx-background-color : linear-gradient(to top right, #eecda3, #ef629f) ");
            Container.getChildren().add(Hb);

        }

        content.getChildren().add(scrollPane);
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

    @FXML
    private void addblog(ActionEvent actionEvent) {
        setNode(addbl);

    }
}
