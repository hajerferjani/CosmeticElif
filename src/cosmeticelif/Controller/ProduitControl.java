/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.Controller;

/**
 *
 * @author USER
 */


import cosmeticelif.model.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class ProduitControl {
    
    Statement state ;
    
    
    public ObservableList<Produit> getAllProduct()
   {
        ObservableList<Produit> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM produit");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             Produit pr = new Produit();   
             pr.setId_produit(result.getInt(1));
             pr.setReference_produit(result.getInt(2));
             pr.setNom_produit(result.getString(3));
             pr.setMarque_produit(result.getString(4));
             pr.setCategorie_produit(result.getString(5));
             pr.setSexe(result.getString(6));
             pr.setPrix_produit(result.getFloat(7));
             product.add(pr);            
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return product;
   }
    
    public void insert(Produit  product)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();               
            state.executeUpdate("INSERT INTO `produit` ( `id_produit`, `reference_produit`, `nom_produit`, `marque_produit`, `categorie_produit`, `sexe`, `prix_produit`) VALUES ( '" + product.getId_produit() + "','" + product.getReference_produit() +"','"+ product.getNom_produit() + "','"+product.getMarque_produit()+"','"+product.getCategorie_produit()+"','"+product.getSexe()+"','"+product.getPrix_produit()+"')");
            //state.executeUpdate("INSERT INTO `produit` ( `id_produit`, `reference_produit`, `nom_produit`, `marque_produit`, `categorie_produit`, `sexe`, `prix_produit`) VALUES (  "+product.getId_produit()+","+product.getReference_produit()+","+product.getNom_produit()+",'"+product.getMarque_produit()+"' ,"+product.getCategorie_produit()+"' ,"+product.getSexe()+"' ,"+product.getPrix_produit());
           // state.executeUpdate("insert into Produit(id_produit,reference_produit,nom_produit,marque_produit,categorie_produit,sexe,prix_produit) values(?,?,?,?,?,?,?)");
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Produit product)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("UPDATE produit set   `reference_produit` = "+product.getReference_produit() +", `nom_produit` = " + product.getNom_produit() +", `marque_produit` = "+"'"+product.getMarque_produit()+"'"+", `categorie_produit` = "+product.getCategorie_produit()+", `sexe` = "+product.getSexe()+", `prix_produit` = "+product.getPrix_produit()+" WHERE id_produit = "+product.getId_produit() );
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
            state.executeUpdate("Delete FROM `produit` WHERE id_produit = " + id);
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<Produit> getSearchProduct(String name)
   {
        ObservableList<Produit> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM produit WHERE nom_produit LIKE '%"+name+"%'");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             Produit pr = new Produit();   
             pr.setId_produit(result.getInt(1));
             pr.setReference_produit(result.getInt(2));
             pr.setNom_produit(result.getString(3));
             pr.setMarque_produit(result.getString(4));
             pr.setCategorie_produit(result.getString(5));
             pr.setSexe(result.getString(6));
             pr.setPrix_produit(result.getFloat(7));
             product.add(pr);            
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return product;
   }
    
    
}
