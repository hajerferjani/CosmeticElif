/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package cosmeticelif;

import javafx.scene.image.Image;
import java.io.IOException;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
            stage.getIcons().add(new Image("/cosmeticelif/image/istockphoto.jpg"));
            stage.setTitle("Elif Cosmetic");
            stage.setScene(scene);
            stage.show();
      } 
    public static void main(String[] args) {
        launch(args);
          // Produit ps=new Produit();
           
    }
    
}
