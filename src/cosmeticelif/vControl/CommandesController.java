/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmeticelif.vControl;
import cosmeticelif.Controller.CommandesControl;
import cosmeticelif.model.Commandes;


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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author salma
 */
public class CommandesController implements Initializable {

    @FXML
    private TextField txtFourn;
    @FXML
    private TextField txtArticle;
    @FXML
    private TextField txtTotal;
    @FXML
    private TextField txtUnitaire;
    @FXML
    private TextField txtQuantite;
    @FXML
    private TextField txtDate;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TableView table;
    @FXML
    private TableColumn  id;
    @FXML
    private TableColumn fournisseur;
    @FXML
    private TableColumn article;
    @FXML
    private TableColumn quantite;
    @FXML
    private TableColumn total;
    @FXML
    private TableColumn unitaire;
    @FXML
    private TableColumn date;
    int ID;
   CommandesControl cc = new CommandesControl();
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
           
        id.setCellValueFactory(new PropertyValueFactory<>("id_commande"));
        fournisseur.setCellValueFactory(new PropertyValueFactory<>("fournisseur"));
        article.setCellValueFactory(new PropertyValueFactory<>("article"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        total.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
        unitaire.setCellValueFactory(new PropertyValueFactory<>("prix_unitaire"));
        

        table.setItems(cc.getAllCommandes());
    
    }
     public void Retour(Event e)
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
    
      public void Ajout(Event e)
        {
          Commandes cd = new Commandes();
          if(!txtFourn.getText().equals("")&&!txtArticle.getText().equals("")&&!txtQuantite.getText().equals("")&&!txtTotal.getText().equals("")&&!txtUnitaire.getText().equals("")){
          cd.setFournisseur(txtFourn.getText());
          cd.setArticle(txtArticle.getText());
          cd.setQuantite(Integer.parseInt(txtQuantite.getText()));
          cd.setPrix_total(Float.parseFloat(txtTotal.getText()));
          cd.setPrix_unitaire(Float.parseFloat(txtUnitaire.getText()));
          
          
   
          
          cc.insert(cd);
          
         txtFourn.setText("");
         txtArticle.setText("");
         txtQuantite.setText("");
         txtTotal.setText("");
         txtUnitaire.setText("");
        
          
          table.setItems(cc.getAllCommandes());
          }
          
        }
      
      
      
        public void Update(Event e)
        {
          Commandes cd = new Commandes();
          if(!txtFourn.getText().equals("")&&!txtArticle.getText().equals("")&&!txtQuantite.getText().equals("")&&
          !txtTotal.getText().equals("")&&!txtUnitaire.getText().equals("")){
          cd.setFournisseur((txtFourn.getText()));
          cd.setArticle(txtArticle.getText());
          cd.setQuantite(Integer.parseInt(txtQuantite.getText()));
          cd.setPrix_total(Float.parseFloat(txtTotal.getText()));
          cd.setPrix_unitaire(Float.parseFloat(txtUnitaire.getText()));
         
         
          cd.setId_commande(ID);
          
         cc.update(cd);
          
         txtFourn.setText("");
         txtArticle.setText("");
         txtQuantite.setText("");
         txtTotal.setText("");
         txtUnitaire.setText("");
        
         table.setItems(cc.getAllCommandes());
          }          
        }
        
      
      
     public void Supprime(Event e)
        {
         cc.delete(ID);
         txtFourn.setText("");
         txtArticle.setText("");
         txtQuantite.setText("");
         txtTotal.setText("");
         txtUnitaire.setText("");
        
         table.setItems(cc.getAllCommandes());
                
        }
        
     
        public void clickTable(Event e) 
        {
          Commandes cd = (Commandes) table.getSelectionModel().getSelectedItem();
          txtFourn.setText(cd.getFournisseur()+"");
          txtArticle.setText(cd.getArticle()+"");
          txtQuantite.setText(cd.getQuantite()+"");
          txtTotal.setText(cd.getPrix_total()+"");
          txtUnitaire.setText(cd.getPrix_unitaire()+"");
         

           ID=cd.getId_commande();
        }
}
