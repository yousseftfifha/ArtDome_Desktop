///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Gui.Endroit;
//
//import Tools.config;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.jfoenix.controls.JFXTextField;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//import Entities.Client;
//import Entities.ReservationE;
//import tray.notification.NotificationType;
//import tray.notification.TrayNotification;
//
///**
// * FXML Controller class
// *
// * @author hp
// */
//public class AfficherReservationController implements Initializable {
//
//     @FXML
//    private TableView<ReservationE> table;
//    @FXML
//    private TableColumn<ReservationE, Integer> col_id_res;
//    @FXML
//    private TableColumn<ReservationE, Integer> col_id_client;
//    @FXML
//    private TableColumn<ReservationE, Integer> col_matricule;
//    @FXML
//    private TableColumn<ReservationE, LocalDate> col_date_debut;
//    @FXML
//    private TableColumn<ReservationE, LocalDate> col_date_fin;
//    @FXML
//    private TableColumn<ReservationE, LocalDate> col_date_retour;
//    @FXML
//    private TableColumn<ReservationE, Integer> col_cautionnement;
//    @FXML
//    private TableColumn<ReservationE, Integer> col_prix_final;
//    @FXML
//    private TableColumn<ReservationE, String> col_nom;
//    @FXML
//    private TableColumn<ReservationE, String> col_prenom;
//
//    ObservableList<ReservationE> oblist = FXCollections.observableArrayList();
//
//String chemin = "";
//    String title = "";
//    //Stage primaryStage = new Stage();
//
//    //@FXML
// //   private Pane contenu;
//
//    Stage primaryStage = new Stage();
//
//    @FXML
//    private Pane contenu;
//
//    @FXML
//    void handleAddAction(ActionEvent event) {
//        chemin = "AjoutReservation.fxml";
//	new OpenWindow2(primaryStage,chemin, "ajouter");
//
//    }
//
//
//    @FXML
//    private JFXTextField idres,idres1;
//
//     @FXML
//    void pdfs (ActionEvent event) throws SQLException {
//        try {
//                    Connection con = config.getInstance().getConnection();
//
//        ResultSet rs;
//        rs = con.createStatement().executeQuery("SELECT r.id_reservation,r.idclient,r.prix_total,r.Cautionnement,r.matricule,r.date_debut,r.date_fin, c.nom  ,c.prenom  FROM reservation r INNER JOIN client as c ON r.idclient = c.idclient ");
//                    /* Step-2: Initialize PDF documents - logical objects */
//                    Document my_pdf_report = new Document();
//                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Liste Reservation.pdf"));
//                    my_pdf_report.open();
//                    //we have four columns in our table
//                    PdfPTable my_report_table = new PdfPTable(6);
//                    //create a cell object
//                    PdfPCell table_cell;
//
//                    while (rs.next()) {
//                                    String dept_id = rs.getString("id_reservation");
//                                    table_cell=new PdfPCell(new Phrase(dept_id));
//                                    my_report_table.addCell(table_cell);
//
//                                    String dept_name=rs.getString("nom");
//                                    table_cell=new PdfPCell(new Phrase(dept_name));
//                                    my_report_table.addCell(table_cell);
//
//                                    String manager_id=rs.getString("prenom");
//                                    table_cell=new PdfPCell(new Phrase(manager_id));
//                                    my_report_table.addCell(table_cell);
//
//                                    String dated=rs.getString("date_debut");
//                                    table_cell=new PdfPCell(new Phrase(dated));
//                                    my_report_table.addCell(table_cell);
//
//                                    String datef=rs.getString("date_fin");
//                                    table_cell=new PdfPCell(new Phrase(datef));
//                                    my_report_table.addCell(table_cell);
//
//                                    String location_id=rs.getString("prix_total");
//                                    table_cell=new PdfPCell(new Phrase(location_id));
//                                    my_report_table.addCell(table_cell);
//                                    }
//                    /* Attach report table to PDF */
//                    my_pdf_report.add(my_report_table);
//                    my_pdf_report.close();
//
//                    /* Close all DB related objects */
//                    rs.close();
//
//
//
//
//
//    } catch (FileNotFoundException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//    } catch (DocumentException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//
//    }
//         String title = "Succes! ";
//        String message = "Le fichier PDF est generé";
//
//        TrayNotification tray = new TrayNotification();
//        tray.setTitle(title);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(Duration.seconds(5));
//
//    }
//    @FXML
//    void ModifierRes(ActionEvent event) {
//        chemin = "ModifierReservation.fxml";
//	new OpenWindow2(primaryStage,chemin, "modifier");
//
//    }
//
//    @FXML
//    private void handleBSupprimerRes(ActionEvent event) throws IOException, SQLException {
//        ReservationE r = new ReservationE(Integer.parseInt(idres.getText()));
//        if (r.exist()==true)
//        {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("CONFIRMATION");
//        alert.setHeaderText(null);
//        alert.setContentText("Voulez vous vraiment supprimer cette reservation?");
//
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK)
//        {
//            r.supprimerReservation();
//        }
//        }
//        else
//        {
//            Alert alert = new Alert(Alert.AlertType.ERROR,"Reservation inexistante",ButtonType.CLOSE);
//            alert.showAndWait();
//        }
//        String title = "Succes! ";
//        String message = "Reservation supprimée";
//
//        TrayNotification tray = new TrayNotification();
//        tray.setTitle(title);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(Duration.seconds(5));
//
//
//    }
//     @FXML
//    void recherche(ActionEvent event) {
//        String s=idres1.getText();
//        if (s.isEmpty())
//        {
//            try {
//            Connection con =config.getInstance().getConnection();
//
//
//            ResultSet rs;
//
//            rs = con.createStatement().executeQuery("SELECT r.id_reservation,r.idclient,r.prix_total,r.Cautionnement,r.matricule,r.date_debut,r.date_fin, c.nom  ,c.prenom  FROM reservation r INNER JOIN client as c ON r.idclient = c.idclient ");
//
//            System.out.println("f");
//            while (rs.next())
//            {   ReservationE r=new ReservationE(rs.getInt("id_reservation"),rs.getInt("idclient"),rs.getInt("matricule"),
//                        rs.getDate("date_debut").toLocalDate(),rs.getDate("date_fin").toLocalDate(),rs.getInt("Cautionnement"),rs.getInt("prix_total"),rs.getString("nom"),rs.getString("prenom"));
//                oblist.add(r);
//
//            }
//
//
//             System.out.println("f");
//
//            col_cautionnement.setCellValueFactory(new PropertyValueFactory<>("Cautionnement"));
//            col_prix_final.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
//            col_id_res.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
//            col_id_client.setCellValueFactory(new PropertyValueFactory<>("idclient"));
//            col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
//            col_date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
//            col_date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
//
//           col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//           col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//
//
//
//            table.setItems(oblist);
//            System.out.println("ffff");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//        }
//        else
//        {
//        table.getItems().clear();
//         try {
//            Connection con =config.getInstance().getConnection();
//
//            oblist.clear();
//            ResultSet rs;
//
//            rs = con.createStatement().executeQuery("SELECT r.id_reservation,r.idclient,r.prix_total,r.Cautionnement,r.matricule,r.date_debut,r.date_fin, c.nom  ,c.prenom  FROM reservation r INNER JOIN client as c ON r.idclient = c.idclient where id_reservation='" + idres1.getText() + "'");
//
//            System.out.println("f");
//            while (rs.next())
//            {   ReservationE r=new ReservationE(rs.getInt("id_reservation"),rs.getInt("idclient"),rs.getInt("matricule"),
//                        rs.getDate("date_debut").toLocalDate(),rs.getDate("date_fin").toLocalDate(),rs.getInt("Cautionnement"),rs.getInt("prix_total"),rs.getString("nom"),rs.getString("prenom"));
//                oblist.add(r);
//
//            }
//
//
//             System.out.println("f");
//
//            col_cautionnement.setCellValueFactory(new PropertyValueFactory<>("Cautionnement"));
//            col_prix_final.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
//            col_id_res.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
//            col_id_client.setCellValueFactory(new PropertyValueFactory<>("idclient"));
//            col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
//            col_date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
//            col_date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
//
//           col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//           col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//
//
//
//            table.setItems(oblist);
//            System.out.println("ffff");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//        }
//    }
//
//
//    public void initialize(URL url, ResourceBundle rb) {
//
//        try {
//            Connection con =config.getInstance().getConnection();
//
//
//            ResultSet rs;
//
//            rs = con.createStatement().executeQuery("SELECT r.id_reservation,r.idclient,r.prix_total,r.Cautionnement,r.matricule,r.date_debut,r.date_fin, c.nom  ,c.prenom  FROM reservation r INNER JOIN client as c ON r.idclient = c.idclient ");
//
//            System.out.println("f");
//            while (rs.next())
//            {   ReservationE r=new ReservationE(rs.getInt("id_reservation"),rs.getInt("idclient"),rs.getInt("matricule"),
//                        rs.getDate("date_debut").toLocalDate(),rs.getDate("date_fin").toLocalDate(),rs.getInt("Cautionnement"),rs.getInt("prix_total"),rs.getString("nom"),rs.getString("prenom"));
//                oblist.add(r);
//
//            }
//
//
//             System.out.println("f");
//
//            col_cautionnement.setCellValueFactory(new PropertyValueFactory<>("Cautionnement"));
//            col_prix_final.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
//            col_id_res.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
//            col_id_client.setCellValueFactory(new PropertyValueFactory<>("id_client"));
//            col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
//            col_date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
//            col_date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
//
//           col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//           col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//
//
//
//            table.setItems(oblist);
//            System.out.println("ffff");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//
//    }
//   /*    @FXML
//    private void handleBAjouterReservationAction(ActionEvent event) {
//
//        chemin = "AjoutReservation.fxml";
//		new OpenWindow(contenu, chemin);
//
//    }*/
//
//}
