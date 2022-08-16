/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.vControl;

import cosmeticelif.Controller.ProduitControl;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class ProduitControler implements Initializable {

    @FXML   
    private TextField txtnom ;
    @FXML
    private Button bchercher ;
    @FXML
    private Button bajouter ;
    @FXML
    private Button bmodifier;
    @FXML
    private Button bsupprimer;
    @FXML
    private Button bretour;
    @FXML
    private TableView table;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn reference;
    @FXML
    private TableColumn nom;
    @FXML
    private TableColumn marque;
    @FXML
    private TableColumn categorie;
    @FXML
    private TableColumn sexe;
    @FXML
    private TableColumn prix;
    
     ProduitControl pc = new ProduitControl();
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         
        //refere to attribute 
        
        id.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        reference.setCellValueFactory(new PropertyValueFactory<>("reference_produit"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
        marque.setCellValueFactory(new PropertyValueFactory<>("marque_produit"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("categorie_produit"));
        sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));

        //show data
        table.setItems(pc.getAllProduct());
    }
    
    public void Search(Event e)
        {
          
          table.setItems(pc.getSearchProduct(txtnom.getText()));          
          
        }
    
    public void Back(Event e)
 {
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   stage.close();
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/cosmeticelif/viewFXML/Home.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();

                } catch (Exception ex) {
                    System.out.println("y"+ex.getMessage());
                }
 }
    
}
