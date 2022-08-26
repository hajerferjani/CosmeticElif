/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package cosmeticelif;
import cosmeticelif.model.Produit;
import javafx.scene.image.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class CosmeticElif extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        
         
            Parent root = FXMLLoader.load(getClass().getResource("/cosmeticelif/viewFXML/loginForm.fxml"));
            Scene scene = new Scene(root);
            //stage.getIcons().add(new Image("/images/h.png"));
            stage.setTitle("Elif Cosmetic");
            stage.setScene(scene);
            stage.show();
      } 
    public static void main(String[] args) {
        launch(args);
          // Produit ps=new Produit();
           
    }
    
}
