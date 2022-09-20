/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.vControl;


import cosmeticelif.Controller.FournisseurControl;
import cosmeticelif.model.Fournisseur;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class fournisseurControler implements Initializable 
{
    @FXML   
    private TextField txtnom ;
    @FXML   
    private TextField txtprenom ;
    @FXML   
    private TextField txtnumero ;
    @FXML   
    private TextField txtmail ;
    @FXML
    private Button btnajouter ;
    @FXML
    private Button btnmodifier ;
    @FXML
    private Button btnsupprimer ;
    @FXML
    private Button btnretour ;
     @FXML
    private Button envoyer;
   
    
    @FXML
    private TableView idtable;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn nom;
    @FXML
    private TableColumn prenom;
    @FXML
    private TableColumn numero;
    @FXML
    private TableColumn mail;  
    
      int ID;
     FournisseurControl f = new FournisseurControl();
      
     
    @Override
     public void initialize(URL location, ResourceBundle resources) {
         id.setCellValueFactory(new PropertyValueFactory<>("id_fournisseur"));
         nom.setCellValueFactory(new PropertyValueFactory<>("nom_fournisseur"));
         prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_fournisseur"));
         numero.setCellValueFactory(new PropertyValueFactory<>("num_telephone"));
         mail.setCellValueFactory(new PropertyValueFactory<>("email"));
              idtable.setItems(f.getAllFournisseur());
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
              
        public void Add(Event e)
            {
          Fournisseur fourni = new Fournisseur();
          if(!txtnom.getText().equals("")&&!txtprenom.getText().equals("")&&!txtnumero.getText().equals("")&&!txtmail.getText().equals("")){
          
          fourni.setNom_fournisseur(txtnom.getText());
          fourni.setPrenom_fournisseur(txtprenom.getText());
          fourni.setNum_telephone(Integer.parseInt(txtnumero.getText()));
          fourni.setEmail(txtmail.getText());
         
          
          f.insert(fourni);
          
          txtnom.setText("");
          txtprenom.setText("");
          txtnumero.setText("");
          txtmail.setText("");
          
          
          idtable.setItems(f.getAllFournisseur());
          }
          else {
              JOptionPane.showMessageDialog(null, "Remplir tous les champs");
         }
            }
       public void update (Event e){
        Fournisseur fourni = new Fournisseur();
          if(!txtnom.getText().equals("")&&!txtprenom.getText().equals("")&&!txtnumero.getText().equals("")&&!txtmail.getText().equals(""))
          {
          fourni.setNom_fournisseur(txtnom.getText());
          fourni.setPrenom_fournisseur(txtprenom.getText());
          fourni.setNum_telephone(Integer.parseInt(txtnumero.getText()));
          fourni.setEmail(txtmail.getText());
         fourni.setId_fournisseur(ID);
          
          f.update(fourni);
          
          txtnom.setText("");
          txtprenom.setText("");
          txtnumero.setText("");
          txtmail.setText("");
          
          
          idtable.setItems(f.getAllFournisseur());
       
       } 
       }
     
     
             public void Delete(Event e)
        {
          f.delete(ID);
            txtnom.setText("");
          txtprenom.setText("");
          txtnumero.setText("");
          txtmail.setText("");
           idtable.setItems(f.getAllFournisseur());
                
        } 
     
   
          
 public void clickTable(Event e) 
        {
           Fournisseur fourni =  (Fournisseur) idtable.getSelectionModel().getSelectedItem();
           txtnom.setText(fourni.getNom_fournisseur()+"");
           txtprenom.setText(fourni.getPrenom_fournisseur()+"");
           txtnumero.setText(fourni.getNum_telephone()+"");
           txtmail.setText(fourni.getEmail()+"");
           

           ID=fourni.getId_fournisseur();
        }
   @FXML
    public void Mail (Event e) {
       
                   try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   stage.close();
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/cosmeticelif/viewFXML/Mail.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();

                } catch (Exception ex) {
                    System.out.println("y"+ex.getMessage());
                }
                 

                }
}
    
    
         
    
    
        
    

      