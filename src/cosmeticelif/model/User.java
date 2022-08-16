/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.model;

/**
 *
 * @author USER
 */
public class User {
    private int id_user; 
    private int matricule;
    private String nom;
    private String prenom; 
    private String login;
    private String mot_de_passe;
    private String role;

    public User() {
    }

    public User(int id_user, int matricule, String nom, String prenom, String login, String mot_de_passe, String role) {
        this.id_user = id_user;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
    }
    
    

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
