/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.model;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Facture {
    private int id_facture;
    private Date date;
    private float prix_total;

    public Facture() {
    }

    public Facture(int id_facture, Date date, float prix_total) {
        this.id_facture = id_facture;
        this.date = date;
        this.prix_total = prix_total;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }
    
    
    
}
