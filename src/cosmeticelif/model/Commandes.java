/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmeticelif.model;

import java.util.Objects;



/**
 *
 * @author salma
 */
public class Commandes {
   private int id_commande;
   private String fournisseur;
   private String article;
   private int quantite;
   private float prix_total;
   private float prix_unitaire;
  

    public Commandes() {
    }

    public Commandes(int id_commande, String fournisseur, String article, int quantite, float prix_total, float prix_unitaire) {
        this.id_commande = id_commande;
        this.fournisseur = fournisseur;
        this.article = article;
        this.quantite = quantite;
        this.prix_total = prix_total;
        this.prix_unitaire = prix_unitaire;
       
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    @Override
    public String toString() {
        return "Commandes{" + "id_commande=" + id_commande + ", fournisseur=" + fournisseur + ", article=" + article + ", quantite=" + quantite + ", prix_total=" + prix_total + ", prix_unitaire=" + prix_unitaire + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id_commande;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commandes other = (Commandes) obj;
        if (this.id_commande != other.id_commande) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        if (Float.floatToIntBits(this.prix_total) != Float.floatToIntBits(other.prix_total)) {
            return false;
        }
        if (Float.floatToIntBits(this.prix_unitaire) != Float.floatToIntBits(other.prix_unitaire)) {
            return false;
        }
        if (!Objects.equals(this.fournisseur, other.fournisseur)) {
            return false;
        }
        if (!Objects.equals(this.article, other.article)) {
            return false;
        }
        return true;
    }
    
    
}
  

   

   