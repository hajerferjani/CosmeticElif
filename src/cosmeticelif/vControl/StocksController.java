/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cosmeticelif.vControl;

import cosmeticelif.Controller.StockControl;
import cosmeticelif.model.Stocks;
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
 * FXML Controller class
 *
 * @author nassim
 */
public class StocksController implements Initializable {

    @FXML
    private TableView<Stocks> table;
    @FXML
    private TableColumn<?, ?> id_s;
    @FXML
    private TableColumn<?, ?> ref_st;
    @FXML
    private TableColumn<?, ?> fourni;
    @FXML
    private TableColumn<?, ?> qte_st;
    @FXML
    private TableColumn<?, ?> date_st;
    @FXML
    private TableColumn<?, ?> prix_unit_st;
    @FXML
    private TableColumn<?, ?> prix_vente_st;
    @FXML
    private Button btn_ajuter;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_supp;
    @FXML
    private Button retour;
    @FXML
    private TextField txt_ref;
    @FXML
    private TextField txt_fourni;
    @FXML
    private TextField txt_quantite;
    @FXML
    private TextField txt_p_unit;
    @FXML
    private TextField txt_p_vente;

    /**
     * Initializes the controller class.
     */
    StockControl st = new StockControl();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //--------------------------------------------------------------------------
         id_s.setCellValueFactory(new PropertyValueFactory<>("id_stock"));
         ref_st.setCellValueFactory(new PropertyValueFactory<>("reference"));
         fourni.setCellValueFactory(new PropertyValueFactory<>("fournisseur"));
         qte_st.setCellValueFactory(new PropertyValueFactory<>("quantite"));
         date_st.setCellValueFactory(new PropertyValueFactory<>("date_entree"));
         prix_unit_st.setCellValueFactory(new PropertyValueFactory<>("prix_unit"));
         prix_vente_st.setCellValueFactory(new PropertyValueFactory<>("prix_vente"));
         table.setItems(st.getAllStocks());
        
          //-----------------------------------------------------------------------------------------
     
      
    
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

