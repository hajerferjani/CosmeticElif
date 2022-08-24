/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.Controller;

import cosmeticelif.Controller.ConnectionDB;
import cosmeticelif.Controller.ProduitControl;
import cosmeticelif.model.Fournisseur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class FournisseurControl {
    Statement state ;
    public ObservableList<Fournisseur> getAllFournisseur()
   {
        ObservableList<Fournisseur> fournisseur =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM fournisseur");
           
            while(result.next())
            {
             // if define object out while will store last row n time
             Fournisseur fr = new Fournisseur();   
             fr.setId_fournisseur(result.getInt(1));
             fr.setNom_fournisseur(result.getString(2));
             fr.setPrenom_fournisseur(result.getString(3));
             fr.setNum_telephone(result.getInt(4));
             fr.setEmail(result.getString(5));
             fournisseur.add(fr); 
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return fournisseur;
   }
    
    
    
        public void insert(Fournisseur  fourni)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();               
            state.executeUpdate("INSERT INTO `fournisseur` (`id_fournisseur`, `nom_fournisseur`, `prenom_fournisseur`, `num_telephone`, `email`) VALUES ( '" + fourni.getId_fournisseur() + "','" + fourni.getNom_fournisseur() +"','"+ fourni.getPrenom_fournisseur() + "','"+fourni.getNum_telephone()+"','"+fourni.getEmail()+"')");
            //state.executeUpdate("INSERT INTO `produit` ( `id_produit`, `reference_produit`, `nom_produit`, `marque_produit`, `categorie_produit`, `sexe`, `prix_produit`) VALUES (  "+product.getId_produit()+","+product.getReference_produit()+","+product.getNom_produit()+",'"+product.getMarque_produit()+"' ,"+product.getCategorie_produit()+"' ,"+product.getSexe()+"' ,"+product.getPrix_produit());
           // state.executeUpdate("insert into Produit(id_produit,reference_produit,nom_produit,marque_produit,categorie_produit,sexe,prix_produit) values(?,?,?,?,?,?,?)");
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Fournisseur fourni)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();

            state.executeUpdate("UPDATE fournisseur set   `nom_fournisseur` = " +"'"+fourni.getNom_fournisseur()+"'" +", `prenom_fournisseur` = " +"'"+ fourni.getPrenom_fournisseur()+"'" +", `num_telephone` = "+"'"+fourni.getNum_telephone()+"'"+", `email` = "+"'"+fourni.getEmail()+"'"+" WHERE id_fournisseur  = "+fourni.getId_fournisseur() );
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
            state.executeUpdate("Delete FROM `fournisseur` WHERE id_fournisseur  = " + id);
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProduitControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
