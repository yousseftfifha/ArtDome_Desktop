/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Date;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.time.LocalDate;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Tools.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Entities.User;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import Services.UserCRUD;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import Tools.Download;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class UserController implements Initializable {
    @FXML
    private JFXButton SButton;
    @FXML
    private TextField recherche;
    @FXML
    private JFXButton home;
    @FXML
    private JFXButton UserB;
    @FXML
    private JFXButton OeuvresB;
    @FXML
    private JFXButton EventB;
    @FXML
    private JFXButton ExpositionB;
    @FXML
    private JFXButton BlogB;
    @FXML
    private JFXButton Forum;
    @FXML
    private JFXButton OrdersB;
    @FXML
    private TableView<User> UserT;
    @FXML
    private TableColumn<User, Integer> ID;
    @FXML
    private TableColumn<User, String> LastName;
    @FXML
    private TableColumn<User, String> Name;
    @FXML
    private TableColumn<User, String> Birth;
    @FXML
    private TableColumn<User, String> State;
    @FXML
    private TableColumn<User, String> Email;
    @FXML
    private TableColumn<User, Integer> Number;
    @FXML
    private TableColumn<User, String> Password;
    @FXML
    private TableColumn<User, String> Editcol;
        ObservableList<User> list = FXCollections.observableArrayList();
    User user;

Stage dialogStage = new Stage();
    Scene scene;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        UserCRUD crd = new UserCRUD ();
        List<User> UserList = crd.readUser();
        list.addAll(UserList);
        ID.setCellValueFactory(new PropertyValueFactory<>("id")); 
        LastName.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Birth.setCellValueFactory(new PropertyValueFactory<>("datenaissance"));
        State.setCellValueFactory(new PropertyValueFactory<>("ville"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Number.setCellValueFactory(new PropertyValueFactory<>("numero"));
        Password.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        //add cell of button edit
        Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctory = (TableColumn<User, String> param) -> {
            // make cell containing buttons
            final TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        URL l_url = null;
                        try {
                            l_url = new URL ("http://localhost:8080/artdome/add.png" );
                        } catch (MalformedURLException e) {
                            e.printStackTrace ();
                        }
                        BufferedImage imae = null;
                        try {
                            imae = ImageIO.read (l_url);
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                        URL l_url1 = null;
                        try {
                            l_url1 = new URL ("http://localhost:8080/artdome/refresh.png" );
                        } catch (MalformedURLException e) {
                            e.printStackTrace ();
                        }
                        BufferedImage imae1 = null;
                        try {
                            imae1 = ImageIO.read (l_url1);
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                        URL l_url2 = null;
                        try {
                            l_url2 = new URL ("http://localhost:8080/artdome/delete.png" );
                        } catch (MalformedURLException e) {
                            e.printStackTrace ();
                        }
                        BufferedImage imae2 = null;
                        try {
                            imae2 = ImageIO.read (l_url2);
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                        Image imge = SwingFXUtils.toFXImage (imae, null);
                        ImageView img = new ImageView (imge);
                        img.setFitHeight (10);
                        img.setFitWidth (10);
                        Image imge1 = SwingFXUtils.toFXImage (imae1, null);
                        ImageView img1 = new ImageView (imge1);
                        img1.setFitHeight (10);
                        img1.setFitWidth (10);
                        Image imge2 = SwingFXUtils.toFXImage (imae2, null);
                        ImageView img2 = new ImageView (imge2);
                        img2.setFitHeight (10);
                        img2.setFitWidth (10);
                        Button deleteIcon = new Button("");
                        deleteIcon.setGraphic(img2);
                        Button editIcon = new Button("");
                        editIcon.setGraphic(img);
                        Button imageIcon = new Button("");
                        imageIcon.setGraphic(img1);

                       // FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
//
//                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
//                        FontAwesomeIconView imageIcon = new FontAwesomeIconView(FontAwesomeIcon.FILE_IMAGE_ALT);

//                        deleteIcon.setStyle(
//                                " -fx-cursor: hand ; -fx-font-size:2px;"
//                                        + "-glyph-size:28px;"
//                                        + "-fx-fill:#ff1744;"
//                        );
//                        editIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                        + "-glyph-size:28px;"
//                                        + "-fx-fill:#00E676;"
//                        );
//                        imageIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                        + "-glyph-size:28px;"
//                                        + "-fx-fill:#00E676;"
//                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            user = UserT.getSelectionModel().getSelectedItem();
                            System.out.println(user.toString ());
                            UserCRUD crd = new UserCRUD();
                            crd.DeleteUser(user.getId());
                            Node source = (Node) event.getSource();
                            dialogStage = (Stage) source.getScene().getWindow();
                            dialogStage.close();
                            try {
                                scene = new Scene (FXMLLoader.load(getClass().getResource("User.fxml")));
                            } catch (IOException ex) {
                                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            dialogStage.setTitle("ArtDome - User");
                            dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
                            Alert alert=new Alert (Alert.AlertType.WARNING);
                            alert.setTitle ("Delete User");
                            alert.setHeaderText ("User");
                            alert.setContentText ("Vous avez supprimer un utilisateur! ");
                            alert.showAndWait ();
                            dialogStage.show();
                            
                            
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            user = UserT.getSelectionModel().getSelectedItem();
                            //System.out.println(user);
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("updateUser.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            UpdateUserController updateUserController = loader.getController();
                            updateUserController.setUpdate(true);
                            //user.setId();
                            updateUserController.setTextField(user.getId(),user.getNom(),user.getPrenom() ,user.getDatenaissance().toLocalDate(),
                                    user.getVille(),user.getEmail() ,user.getNumero() ,user.getMdp() );
                            
                            
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            
                            
                            
                            
                            
                        });
                        imageIcon.setOnMouseClicked((MouseEvent event) ->{
                            user = UserT.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("image.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            ImageController imageController = loader.getController();
                            imageController.setUpdate(true);
                            
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            
                        }      );
                        
                        HBox managebtn = new HBox(editIcon, deleteIcon,imageIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        Editcol.setCellFactory(cellFoctory);
        UserT.setItems(list);
    }    

    @FXML
    private void HandleHomeBtn(ActionEvent event) throws IOException {
         Node source = (Node) event.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("../DashBoardScene.fxml")));
        dialogStage.setTitle("ArtDome Dashboard - Home");
        dialogStage.setScene(scene);
dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show();
    }

    @FXML
    private void handleOrdBTn(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../DashOrdersCart/DashBoardOrders.fxml")));
        dialogStage.setTitle ("ArtDome Dashboard - Orders");
        dialogStage.setScene (scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show ();
    }
    
    @FXML 
    private void recherche_user (ActionEvent event){
        UserT.getItems().clear();
        try {
        Connection con =MyConnection.getInstance().getConnection();
            
            list.clear();
            ResultSet rs;
            
            rs = con.createStatement().executeQuery("SELECT ID,nom,prenom,datenaissance,ville,email,numero,mdp FROM user WHERE ID= "+recherche.getText());
            
           
            
            while (rs.next()){
                list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
                                             
            
             System.out.println("f");
        
            
          ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            LastName.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            Name.setCellValueFactory(new PropertyValueFactory<>("nom"));
            Birth.setCellValueFactory(new PropertyValueFactory<>("datenaissance"));
            State.setCellValueFactory(new PropertyValueFactory<>("ville"));
            Email.setCellValueFactory(new PropertyValueFactory<>("email"));
            Number.setCellValueFactory(new PropertyValueFactory<>("numero"));
            Password.setCellValueFactory(new PropertyValueFactory<>("mdp"));
            
            System.out.println("ffff");
            
            UserT.setItems(list); 
        }
            
        }catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @FXML
    private void user(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../User/User.fxml")));
        dialogStage.setTitle ("ArtDome Dashboard - User");
        dialogStage.setScene (scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show ();
    }

    @FXML
    private void oeuvre(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Oeuvre/Oeuvre.fxml")));
        dialogStage.setTitle ("ArtDome Dashboard - Oeuvre");
        dialogStage.setScene (scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show ();
    }

    @FXML
    private void event(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Event/AddEvent.fxml")));
        dialogStage.setTitle ("ArtDome Dashboard - Event");
        dialogStage.setScene (scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show ();
    }

    @FXML
    private void expo(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Exposition/Reservation_expoBack.fxml")));
        dialogStage.setTitle ("ArtDome Dashboard - Exposition");
        dialogStage.setScene (scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show ();
    }

    @FXML
    private void endroit(ActionEvent actionEvent)throws IOException {
        Node source = (Node) actionEvent.getSource ();
        dialogStage = (Stage) source.getScene ().getWindow ();
        dialogStage.close ();
        scene = new Scene (FXMLLoader.load (getClass ().getResource ("../Endroit/AfficherEndroit.fxml")));
        dialogStage.setTitle ("ArtDome Dashboard - Endroit");
        dialogStage.setScene (scene);
        dialogStage.getIcons ().add (new Image ("GFX/logo.png"));
        dialogStage.show ();
    }
}
