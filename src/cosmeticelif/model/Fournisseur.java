/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.model;

/**
 *
 * @author ASUS
 */
public class Fournisseur {
    private int id_fournisseur ;
    private String nom_fournisseur;
    private  String prenom_fournisseur;
    private int num_telephone;
    private String email;

    public Fournisseur() {
    }

    public Fournisseur(int id_fournisseur, String nom_fournisseur, String prenom_fournisseur, int num_telephone, String email) {
        this.id_fournisseur = id_fournisseur;
        this.nom_fournisseur = nom_fournisseur;
        this.prenom_fournisseur = prenom_fournisseur;
        this.num_telephone = num_telephone;
        this.email = email;
    }

    public Fournisseur(String nom_fournisseur, String prenom_fournisseur, int num_telephone, String email) {
        this.nom_fournisseur = nom_fournisseur;
        this.prenom_fournisseur = prenom_fournisseur;
        this.num_telephone = num_telephone;
        this.email = email;
    }
    

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getNom_fournisseur() {
        return nom_fournisseur;
    }

    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }

    public String getPrenom_fournisseur() {
        return prenom_fournisseur;
    }

    public void setPrenom_fournisseur(String prenom_fournisseur) {
        this.prenom_fournisseur = prenom_fournisseur;
    }

    public int getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(int num_telephone) {
        this.num_telephone = num_telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
