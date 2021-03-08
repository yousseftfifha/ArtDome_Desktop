package Tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author tfifha youssef
 */
public class DashFxTest extends Application  {

        @Override
        public void start(Stage primaryStage) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("../Gui/DashBoardScene.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("ArtDome - DashBoard");

            primaryStage.show();
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            launch(args);
        }



}


