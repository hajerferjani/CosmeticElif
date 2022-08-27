/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.Controller;



import cosmeticelif.model.Stocks;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
             st.setPrix_unit(result.getFloat(5));
             st.setPrix_vente(result.getFloat(6));
             stock.add(st);            
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return stock;
   }
    public void insert(Stocks st){
        try{
        state = ConnectionDB.openConnection().createStatement();
        
      state.executeUpdate("INSERT INTO `stock` ( `id_stock`, `reference`, `fournisseur`, `quantite`, `prix_unit`, `prix_vente`) VALUES ( '" + st.getId()+ "','" + st.getReference() +"','"+ st.getFournisseur() + "','"+st.getQuantite()+"','"+"','"+st.getPrix_unit()+"','"+st.getPrix_vente()+"')");
        ConnectionDB.closeConnection();
        } catch (SQLException ex) {
        ConnectionDB.closeConnection();
        java.util.logging.Logger.getLogger(CommandesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    
     public void update(Stocks st)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();

            state.executeUpdate("UPDATE stock set   `reference` = " +"'"+st.getReference()+"'" +", `fournisseur` = " +"'"+ st.getFournisseur()+"'" +", `quantite` = "+"'"+st.getQuantite()+"'"+", `prix_unit` = "+"'"+st.getPrix_unit()+"'"+", `prix_vente` = "+"'"+st.getPrix_vente()+"'"+" WHERE id_stock = "+st.getId() );
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CommandesControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
    }
      public void delete(int id)
    {       
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("Delete FROM `stock` WHERE id_stock = " + id);
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
