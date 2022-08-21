/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.vControl;

import cosmeticelif.Controller.ProduitControl;
import cosmeticelif.model.Produit;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private TextField textNom ;
    @FXML   
    private TextField textReference ;
    @FXML   
    private TextField textMarque ;
    @FXML   
    private TextField textCategorie ;
    @FXML   
    private TextField textPrix ;
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
    private ComboBox  textSexe;
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
    
     int ID;
     ProduitControl pc = new ProduitControl();
    String  TypeProduct[]={"Femme","Homme"};;
    ObservableList<String> olType =FXCollections.observableArrayList(TypeProduct);
    
    //-----------------------------------------------------------------------------------------
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         
        
        
        id.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        reference.setCellValueFactory(new PropertyValueFactory<>("reference_produit"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
        marque.setCellValueFactory(new PropertyValueFactory<>("marque_produit"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("categorie_produit"));
        sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));

        table.setItems(pc.getAllProduct());
        textSexe.getItems().addAll(olType);

    }
    //-----------------------------------------------------------------------------------------
    public void Search(Event e)
        {
          
          table.setItems(pc.getSearchProduct(txtnom.getText()));          
          
        }
    //-----------------------------------------------------------------------------------------
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
          //-----------------------------------------------------------------------------------------
        public void Add(Event e)
        {
          Produit product = new Produit();
          if(!textReference.getText().equals("")&&!textNom.getText().equals("")&&!textMarque.getText().equals("")&&!textCategorie.getText().equals("")&&!textPrix.getText().equals("")){
          product.setReference_produit(Integer.parseInt(textReference.getText()));
          product.setNom_produit(textNom.getText());
          product.setMarque_produit(textMarque.getText());
          product.setCategorie_produit(textCategorie.getText());
          product.setSexe(textSexe.getValue().toString());
          product.setPrix_produit(Float.parseFloat(textPrix.getText()));
          
          pc.insert(product);
          
          textReference.setText("");
          textNom.setText("");
          textMarque.setText("");
          textCategorie.setText("");
          textPrix.setText("");
          
          table.setItems(pc.getAllProduct());
          }
          
        }
        
                
        public void Update(Event e)
        {
          Produit product = new Produit();
          if(!textReference.getText().equals("")&&!textNom.getText().equals("")&&!textMarque.getText().equals("")&&!textCategorie.getText().equals("")&&!textPrix.getText().equals("")){
          product.setReference_produit(Integer.parseInt(textReference.getText()));
          product.setNom_produit(textNom.getText());
          product.setMarque_produit(textMarque.getText());
          product.setCategorie_produit(textCategorie.getText());
          product.setSexe(textSexe.getValue().toString());
          product.setPrix_produit(Float.parseFloat(textPrix.getText()));
          product.setId_produit(ID);
          
          pc.update(product);
          
          textReference.setText("");
          textNom.setText("");
          textMarque.setText("");
          textCategorie.setText("");
          textPrix.setText("");
          table.setItems(pc.getAllProduct());
          }          
        }
        
               public void Delete(Event e)
        {
          pc.delete(ID);
          textReference.setText("");
          textNom.setText("");
          textMarque.setText("");
          textCategorie.setText("");
          textPrix.setText("");
          table.setItems(pc.getAllProduct());
                
        }
        
     public void clickTable(Event e) 
        {
           Produit product =  (Produit) table.getSelectionModel().getSelectedItem();
           textNom.setText(product.getNom_produit()+"");
           textReference.setText(product.getReference_produit()+"");
           textMarque.setText(product.getMarque_produit()+"");
           textCategorie.setText(product.getCategorie_produit()+"");
           textPrix.setText(product.getPrix_produit()+"");

           ID=product.getId_produit();
        }
}
