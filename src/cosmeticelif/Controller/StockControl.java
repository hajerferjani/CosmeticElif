/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.Controller;

import cosmeticelif.model.Fournisseur;
import cosmeticelif.model.Produit;
import cosmeticelif.model.Stocks;
import java.sql.PreparedStatement;
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
            ResultSet rs =  state.executeQuery("SELECT * FROM stock");
             Stocks st = new Stocks();
            while (rs.next()) {
                int id=rs.getInt("id_stock");
               String reference=rs.getString("reference");
               String fournisseur=rs.getString("fournisseur");
               int quantite=rs.getInt("quantite");
               float prix_unit=rs.getFloat("prix_unit");
               float prix_vente=rs.getFloat("prix_vente");
               
                
                stock.add(new Stocks(id, reference, fournisseur, quantite, prix_unit, prix_vente));
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return stock;
   }
    public void insert(Stocks s)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();               
            state.executeUpdate("INSERT INTO `stock` ( `id_stock`, `reference`, `fournisseur`, `quantite`, `prix_unit`, `prix_vente`) VALUES ( '" + s.getId() + "','" + s.getReference() +"','"+ s.getFournisseur() + "','"+s.getQuantite()+"','"+s.getPrix_unit()+"','"+s.getPrix_vente()+"')");
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(Stocks s)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();

            state.executeUpdate("UPDATE stock set   `reference` = " +"'"+s.getReference()+"'" +", `fournisseur` = " +"'"+ s.getFournisseur()+"'" +", `quantite` = "+"'"+s.getQuantite()+"'"+", `prix_unit` = "+"'"+s.getPrix_unit()+"'"+", `prix_vente` = "+"'"+s.getPrix_vente()+"'"+" WHERE id_stock = "+s.getId() );
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
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
