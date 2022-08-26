/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmeticelif.Controller;

import cosmeticelif.model.Commandes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author salma
 */
public class CommandesControl {
    
    
    Statement state ;
    
    
    public ObservableList<Commandes> getAllCommandes()
   {
        ObservableList<Commandes> cd =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM commande");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
                Commandes commande = new Commandes();   
             
             commande.setId_commande(result.getInt(1));
             commande.setFournisseur(result.getString(2));
             commande.setArticle(result.getString(3));
             commande.setQuantite(result.getInt(4));
             commande.setPrix_total(result.getFloat(5));
             commande.setPrix_unitaire(result.getFloat(6));
            
            
             cd.add(commande);            
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CommandesControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return cd;
   }
    
     public void insert(Commandes cd){
        try{
        state = ConnectionDB.openConnection().createStatement();
        
      state.executeUpdate("INSERT INTO `commande` ( `id_commande`, `fournisseur`, `article`, `quantite`, `prix_total`, `prix_unitaire`) VALUES ( '" + cd.getId_commande()+ "','" + cd.getFournisseur() +"','"+ cd.getArticle() + "','"+cd.getQuantite()+"','"+cd.getPrix_total()+"','"+cd.getPrix_unitaire()+"')");
        ConnectionDB.closeConnection();
        } catch (SQLException ex) {
        ConnectionDB.closeConnection();
        java.util.logging.Logger.getLogger(CommandesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
     
     
     
     public void update(Commandes cd)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();

            state.executeUpdate("UPDATE commande set   `fournisseur` = " +"'"+cd.getFournisseur()+"'" +", `article` = " +"'"+ cd.getArticle()+"'" +", `quantite` = "+"'"+cd.getQuantite()+"'"+", `prix_total` = "+"'"+cd.getPrix_total()+"'"+", `prix_unitaire` = "+"'"+cd.getPrix_unitaire()+"'"+" WHERE id_commande = "+cd.getId_commande() );
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
            state.executeUpdate("Delete FROM `commande` WHERE id_commande = " + id);
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(CommandesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
}
