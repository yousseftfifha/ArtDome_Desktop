/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artdome;

import Entite.Oeuvre;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import services.OeuvreCRUD;
import Entite.Oeuvre;
import Entite.catégorie;
import Tools.Email;
import Tools.PDFOeuvre;
import static Tools.PRINT.printNode;
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
import services.CatégorieCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class OeuvreController implements Initializable {

    private TextField idoeuvre;
    private TextField nom;
    private TextField prix;
    private TextField idartiste;
    private DatePicker DateOeuvre;
    private TextField ImageOeuvre;
    private ComboBox NomCat;
    private TextField EmailArtiste;

    /**
     * Initializes the controller class.
     */
   OeuvreCRUD oc = new OeuvreCRUD();
    ObservableList<Oeuvre> ulist= FXCollections.observableArrayList();
    @FXML
    private TableView<Oeuvre> table;
    @FXML
    private TableColumn<Oeuvre,Integer> col_idO;
    @FXML
    private TableColumn<Oeuvre,String> col_nom;
    @FXML
    private TableColumn<Oeuvre,Double> col_prix;
    @FXML
    private TableColumn<Oeuvre,Integer> col_idA;
    @FXML
    private Button btnadd;
    @FXML
    private VBox vbox1;
    @FXML
    private TextField tfidoeuvre;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfidartiste;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btncat;
    @FXML
    private Button btnsearcho;
    @FXML
    private TextField tfsearch;
    @FXML
    private Button pdf;
    @FXML
    private Button print;
    @FXML
    private AnchorPane AnO;
    @FXML
    private Button chart;
    @FXML
    private TableColumn<Oeuvre, String> colemail;
    @FXML
    private TableColumn<Oeuvre, String> colnomcat;
    @FXML
    private TableColumn<Oeuvre, String> colimage;
    @FXML
    private TableColumn<Oeuvre, Date> coldate;
    @FXML
    private TextField tfmail;
    @FXML
    private ComboBox<String> cbcat;
    @FXML
    private TextField tfimage;
    @FXML
    private DatePicker dpdateo;
    @FXML
    private Button btnimage;
    @FXML
    private Button refresh;
    @FXML
    private TextField type;
    @FXML
    private TextField descripton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            List list=oc.readAll();
            ulist= FXCollections.observableArrayList(list);
            col_idO.setCellValueFactory(new PropertyValueFactory<>("ID_Oeuvre"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("NomOeuvre"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("PrixOeuvre"));
            col_idA.setCellValueFactory(new PropertyValueFactory<>("ID_Artiste"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("EmailArtiste"));
            colnomcat.setCellValueFactory(new PropertyValueFactory<>("NomCat"));
            colimage.setCellValueFactory(new PropertyValueFactory<>("ImageOeuvre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("DateOeuvre"));
            
          
            table.setItems(ulist); 
            
      ObservableList<String> Combo = cbcat.getItems();
      //Adding items to the combo box
      CatégorieCRUD e=new CatégorieCRUD();
      Combo.addAll(e.readName());

    }  
    @FXML
     public void ajouter(ActionEvent event) throws SQLException
    {
           // int idO =Integer.parseInt(tfidoeuvre.getText());
            String nomO =tfnom.getText();
            double prixO =Double.valueOf(tfprix.getText());
            int idA=Integer.parseInt(tfidartiste.getText());
            String Email =tfmail.getText();
            String NomC = cbcat.getValue();
            String ImageO =tfimage.getText();
            Date date = java.sql.Date.valueOf(dpdateo.getValue());
            
            
            
           Oeuvre o = new Oeuvre(nomO,prixO,idA,date,ImageO,NomC,Email);
            
            OeuvreCRUD oc = new OeuvreCRUD();
            oc.AddOeuvrePst(o);
            List list=oc.readAll();
            ulist= FXCollections.observableArrayList(list);
            col_idO.setCellValueFactory(new PropertyValueFactory<>("ID_Oeuvre"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("NomOeuvre"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("PrixOeuvre"));
            col_idA.setCellValueFactory(new PropertyValueFactory<>("ID_Artiste"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("EmailArtiste"));
            colnomcat.setCellValueFactory(new PropertyValueFactory<>("NomCat"));
            colimage.setCellValueFactory(new PropertyValueFactory<>("ImageOeuvre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("DateOeuvre"));
            
          
            
            table.setItems(ulist); 
            
            tfnom.clear();
            tfprix.clear();
            tfidartiste.clear();
            tfmail.clear();
            tfimage.clear();
            String msg= "Bonjour Mme/Mr,"
                    +" Votre oeuvre "+nomO+" a été bien ajoutée "
                    + "Nous avons hâte de voir d'autres travaux"
                    +" Bonne journée."
                    ;
            Email sm= new Email();
             ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
        emailExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sm.sendMail (Email, "Ajout confirmé", msg);
                } catch (AddressException e) {
                    e.printStackTrace ();
                } catch (MessagingException e) {
                    e.printStackTrace ();
                }
//        try {
//            sm.sendMail(email, "Réservation confirmée", msg);
//        } catch (MessagingException ex) {
//            Logger.getLogger(AddReservationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
   
    }});
        emailExecutor.shutdown();
           
    }
     
        @FXML
    private void getfromunicorn(MouseEvent event) {
        
           Oeuvre ev = table.getSelectionModel().getSelectedItem();
            tfidoeuvre.setText(""+ ev.getID_Oeuvre());
            tfnom.setText(ev.getNomOeuvre());
           tfprix.setText(""+ev.getPrixOeuvre());
            tfidartiste.setText(" "+ev.getID_Artiste());
              tfmail.setText(""+ ev.getEmailArtiste());
            cbcat.setValue(ev.getNomCat());
           tfimage.setText(""+ev.getImageOeuvre());
            dpdateo.setValue(Instant.ofEpochMilli((ev.getDateOeuvre()).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
            OeuvreCRUD o=new OeuvreCRUD();
            catégorie c=o.readAllJ(ev.getID_Oeuvre());
             type.setText(c.getType());
            descripton.setText(c.getDescription());
           
          //  tfdate.setValue(Instant.ofEpochMilli((ev.getDate()).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
            //tfnbmax.setValueFactory((ev.getNb_max_part()));
            //tfnbmax.setValueFactory(ev.getNb_max_part());
            //tfnbmax.setValueFactory(ev.getNb_max_part());
            //tfnbmax.setAccessibleText(" "+ev.getNb_max_part());
//            tfcodeespace.setText(" "+ ev.getCode_espace());
//            tfimage.setText(ev.getImage());
//            tfvideo.setText(ev.getVideo());
  }


    @FXML
    private void deleteO(ActionEvent event) {
                
        int o = Integer.parseInt(tfidoeuvre.getText().trim());
//        Integer.parseInt(line.toString())
        OeuvreCRUD OC= new OeuvreCRUD();
            OC.DeleteOeuvre(o);
      List list=oc.readAll();
            ulist= FXCollections.observableArrayList(list);
            col_idO.setCellValueFactory(new PropertyValueFactory<>("ID_Oeuvre"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("NomOeuvre"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("PrixOeuvre"));
            col_idA.setCellValueFactory(new PropertyValueFactory<>("ID_Artiste"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("EmailArtiste"));
            colnomcat.setCellValueFactory(new PropertyValueFactory<>("NomCat"));
            colimage.setCellValueFactory(new PropertyValueFactory<>("ImageOeuvre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("DateOeuvre"));
            
            table.setItems(ulist);
            tfnom.clear();
            tfprix.clear();
            tfidartiste.clear();
            tfmail.clear();
            tfimage.clear();
            
    }

    @FXML
    private void UpdateO(ActionEvent event)
    {  
            int idO = Integer.parseInt(tfidoeuvre.getText().trim());
            String nomO = tfnom.getText();
            double PrixO = Double.parseDouble(tfprix.getText().trim());
            int idA=  Integer.parseInt(tfidartiste.getText().trim());
            String Email =tfmail.getText();
            String NomC = cbcat.getValue();
            String ImageO =tfimage.getText();
            Date date = java.sql.Date.valueOf(dpdateo.getValue());
           OeuvreCRUD OC= new OeuvreCRUD();
           Oeuvre ov = new Oeuvre(idO,nomO,PrixO,idA,date,Email,NomC,ImageO);
           OC.UpdateOeuvre(ov,idO);
           
            List list=oc.readAll();
            ulist= FXCollections.observableArrayList(list);
                        col_idO.setCellValueFactory(new PropertyValueFactory<>("ID_Oeuvre"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("NomOeuvre"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("PrixOeuvre"));
            col_idA.setCellValueFactory(new PropertyValueFactory<>("ID_Artiste"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("EmailArtiste"));
            colnomcat.setCellValueFactory(new PropertyValueFactory<>("NomCat"));
            colimage.setCellValueFactory(new PropertyValueFactory<>("ImageOeuvre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("DateOeuvre"));
            
            
            table.setItems(ulist); 
            
            tfnom.clear();
            tfprix.clear();
            tfidartiste.clear();
            tfmail.clear();
            tfimage.clear();
    }

    @FXML
    private void categorie(ActionEvent event) {
           try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("catégorie.fxml"));
            Parent root = loader.load();
            CatégorieController apc = loader.getController();
        
            tfidoeuvre.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searcho(ActionEvent event) throws SQLException {
        String search= tfsearch.getText();
        System.out.println(search);
        OeuvreCRUD OC= new OeuvreCRUD();
        ObservableList<Oeuvre> list = OC.Searcho(search);
              col_idO.setCellValueFactory(new PropertyValueFactory<>("ID_Oeuvre"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("NomOeuvre"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("PrixOeuvre"));
            col_idA.setCellValueFactory(new PropertyValueFactory<>("ID_Artiste"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("EmailArtiste"));
            colnomcat.setCellValueFactory(new PropertyValueFactory<>("NomCat"));
            colimage.setCellValueFactory(new PropertyValueFactory<>("ImageOeuvre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("DateOeuvre"));
             tfnom.clear();
            tfprix.clear();
            tfidartiste.clear();
            tfmail.clear();
            tfimage.clear();
            
    }

    @FXML
    private void pdf(ActionEvent event) { 
        
        try {
            PDFOeuvre pdf=new  PDFOeuvre();
            pdf.OeuvrePDF();
             JOptionPane.showMessageDialog(null, "done!", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @FXML
    private void print(ActionEvent event) {
          
        try {
            printNode(AnO);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

    @FXML
    private void chart(ActionEvent event) {
                try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chart.fxml"));
            Parent root = loader.load();
            ChartController apc = loader.getController();
        
            tfidoeuvre.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(OeuvreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void getimage(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.png","*.jpg","*.gif"));
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null)
        {
            tfimage.setText(selectedFile.getAbsolutePath());
        }else {
            System.out.println(" Picture file is not valid");
        }
    }

    @FXML
    private void refresh(ActionEvent event) {
           
             List list=oc.readAll();
            ulist= FXCollections.observableArrayList(list);
            col_idO.setCellValueFactory(new PropertyValueFactory<>("ID_Oeuvre"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("NomOeuvre"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("PrixOeuvre"));
            col_idA.setCellValueFactory(new PropertyValueFactory<>("ID_Artiste"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("EmailArtiste"));
            colnomcat.setCellValueFactory(new PropertyValueFactory<>("NomCat"));
            colimage.setCellValueFactory(new PropertyValueFactory<>("ImageOeuvre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("DateOeuvre"));
            
            table.setItems(ulist);  
            tfnom.clear();
            tfprix.clear();
            tfidartiste.clear();
            tfmail.clear();
            tfimage.clear();

    }
    }

        
        
    

