/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cosmeticelif.vControl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import cosmeticelif.Controller.FactureControl;
import cosmeticelif.model.Produit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FactureController implements Initializable {

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
    private Button btnAdd ;  
    @FXML
    private Button btnSearch;
    @FXML
    private Button back;
    @FXML
    private Button print;        
    @FXML
    private ComboBox table;
    @FXML
    private TextArea bill;
    @FXML
    private Label ltotal ;
   
    
    int numProduct;
    double total=0;
    static int num =0;
    FactureControl SC = new FactureControl();
    Produit pr = new Produit();  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    table.getItems().addAll( SC.getNamesProduct());
    num=0;
    bill.setText("*****************************  Facture ******************************\n");
    
    }  
    
     public void Print() {
       
          try {
        num++; 
	Document document = new Document();
        // cree fichier 
	OutputStream outputStream = new FileOutputStream(new File("Facture "+String.valueOf(num)+".pdf"));
 
        PdfWriter.getInstance(document, outputStream);
        //ouvrire fichier
        document.open();
        // ajouter contenue fichier
        document.add(new Paragraph(bill.getText()));
        // fermer fichier
        document.close();
        outputStream.close();
 
        System.out.println("Pdf created successfully."+num);
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
    
     
     public void clickTable(Event e)
        {
           String  product =  (String) table.getSelectionModel().getSelectedItem();         
           pr = SC.getProduct(product);
           textNom.setText(pr.getNom_produit()+"");
           textReference.setText(pr.getReference_produit()+"");
           textMarque.setText(pr.getMarque_produit()+"");
           textCategorie.setText(pr.getCategorie_produit()+"");
           textPrix.setText(pr.getPrix_produit()+"");
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
     
     public void Ajouter(){
      String s=bill.getText();
     
      bill.setText(s+"Non Produit : "+table.getValue()+"\n"+"Prix Produit : "+textPrix.getText()+"\n"
      +"Categorie produit : "+textCategorie.getText()+"\n--------------------------------------\n"
      );
   
      //txtNumber.setText("");
      double x = Double.parseDouble(textPrix.getText());
      total+=x;
      ltotal.setText(total+"");
    } 
}
