/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.model;

/**
 *
 * @author USER
 */
public class Produit {
    private int id_produit;
   private int reference_produit;
   private String nom_produit;
   private String marque_produit;
   private String categorie_produit;  
   private String sexe;
   private float prix_produit;

    public Produit() {
    }

    public Produit(int reference_produit, String nom_produit, String marque_produit, String categorie_produit, String sexe, float prix_produit) {
        this.reference_produit = reference_produit;
        this.nom_produit = nom_produit;
        this.marque_produit = marque_produit;
        this.categorie_produit = categorie_produit;
        this.sexe = sexe;
        this.prix_produit = prix_produit;
    }
    

    public Produit(int id_produit, int reference_produit, String nom_produit, String marque_produit, String categorie_produit, String sexe, float prix_produit) {
        this.id_produit = id_produit;
        this.reference_produit = reference_produit;
        this.nom_produit = nom_produit;
        this.marque_produit = marque_produit;
        this.categorie_produit = categorie_produit;
        this.sexe = sexe;
        this.prix_produit = prix_produit;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getReference_produit() {
        return reference_produit;
    }

    public void setReference_produit(int reference_produit) {
        this.reference_produit = reference_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getMarque_produit() {
        return marque_produit;
    }

    public void setMarque_produit(String marque_produit) {
        this.marque_produit = marque_produit;
    }

    public String getCategorie_produit() {
        return categorie_produit;
    }

    public void setCategorie_produit(String categorie_produit) {
        this.categorie_produit = categorie_produit;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public float getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(float prix_produit) {
        this.prix_produit = prix_produit;
    }

    @Override
    public String toString() {
        return "produit{" + "id_produit=" + id_produit + ", reference_produit=" + reference_produit + ", nom_produit=" + nom_produit + ", marque_produit=" + marque_produit + ", categorie_produit=" + categorie_produit + ", sexe=" + sexe + ", prix_produit=" + prix_produit + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id_produit;
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
        final Produit other = (Produit) obj;
        return this.id_produit == other.id_produit;
    }
   
}
