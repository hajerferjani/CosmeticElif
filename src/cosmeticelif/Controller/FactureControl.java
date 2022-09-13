/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.Controller;

import cosmeticelif.Controller.ConnectionDB;
import cosmeticelif.Controller.ProduitControl;
import cosmeticelif.model.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author USER
 */
public class FactureControl {
        Statement state;

        
       public ObservableList<String> getNamesProduct()
   {
        ObservableList<String> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT nom_produit FROM produit");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             Produit pr = new Produit();            
            // pr.setName(result.getString(1));         
             product.add(result.getString(1));            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return product;
   }
     
       
       public ObservableList<String> getSearchNamesProduct(String name)
   {
        ObservableList<String> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT nom_produit FROM produit WHERE nom_produit LIKE '%"+name+"%'");
            
            
           
            while(result.next())
            {
        
             product.add(result.getString(1));      
             ConnectionDB.closeConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
             ConnectionDB.closeConnection();
        }
     
       return product;
   }
     
       
        public Produit getProduct(String name)
   {
        Produit pr = new Produit();  
       
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM produit where nom_produit = '"+name+"'");
            
            
           
            while(result.next())
            {
             pr.setId_produit(result.getInt(1));
             pr.setReference_produit(result.getInt(2));
             pr.setNom_produit(result.getString(3));
             pr.setMarque_produit(result.getString(4));
             pr.setCategorie_produit(result.getString(5));
             pr.setSexe(result.getString(6));
             pr.setPrix_produit(result.getFloat(7));          
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return pr;
   }
}
