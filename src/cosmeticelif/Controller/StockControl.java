/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.Controller;

import cosmeticelif.model.Fournisseur;
import cosmeticelif.model.Produit;
import cosmeticelif.model.Stocks;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nassim
 */
public class StockControl {
     Statement state ;
    
    
    public ObservableList<Stocks> getAllStocks()
   {
        ObservableList<Stocks> stock =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM stock");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             Stocks st = new Stocks();   
             st.setId(result.getInt(1));
             st.setReference(result.getString(2));
             st.setFournisseur(result.getString(3));
             st.setQuantite(result.getInt(4));
             st.setDate_entree(result.getDate(5));
             st.setPrix_unit(result.getFloat(6));
             st.setPrix_vente(result.getFloat(7));
             stock.add(st);            
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return stock;
   }
}
