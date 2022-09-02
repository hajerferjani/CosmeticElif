/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author nassim
 */
public class Stocks {
    private int id;
    private String reference;
    private String fournisseur;
    private int quantite;
    private Date date_entree;
    private float prix_unit;
    private float prix_vente;

    public Stocks() {
    }

    public Stocks(int id, String reference, String fournisseur, int quantite, Date date_entree, float prix_unit, float prix_vente) {
        this.id = id;
        this.reference = reference;
        this.fournisseur = fournisseur;
        this.quantite = quantite;
        this.date_entree = date_entree;
        this.prix_unit = prix_unit;
        this.prix_vente = prix_vente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

  

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }

    public float getPrix_unit() {
        return prix_unit;
    }

    public void setPrix_unit(float prix_unit) {
        this.prix_unit = prix_unit;
    }

    public float getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(float prix_vente) {
        this.prix_vente = prix_vente;
    }

    

   
    
    
    
    
    
  
}
