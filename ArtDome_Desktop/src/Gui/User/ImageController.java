/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.User;

import Tools.Download;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Entities.User;
import Services.UserService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class ImageController implements Initializable {
private boolean update;

    @FXML
    private JFXTextField URL;
    @FXML
    private JFXButton Bupdate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    private void Bupdate (ActionEvent event) throws InterruptedException {
        
        String link =URL.getText();
        File out = new File("C:/Users/asus/Downloads/Quality-Overflow-main/QualityDome/src/GFX/photo.jpg");
        new Thread (new Download(link,out)).start();
        
        File uploadDirectory = new File("C:/Users/asus/Downloads/Quality-Overflow-main/QualityDome/src/GFX");
        
    File[] downloadedFiles = uploadDirectory.listFiles();
TimeUnit.SECONDS.sleep(15);

Arrays.sort(downloadedFiles, new Comparator<File>() {
        @Override
        public int compare(File fileOne, File fileTwo) {
            return Long.valueOf(fileTwo.lastModified()).compareTo(fileOne.lastModified());
        }
    });
    for (File file : downloadedFiles) {
        if (file.isFile()) {
            
           String path = file.getAbsolutePath();
            System.out.println(path);
           User u = new User();
           u.setImage(path);

        UserService crd = new UserService ();
        crd.updateImage(u);
        }
    }
        
                        
    }
    void setUpdate(boolean b) {
        this.update = b;

    }
}
