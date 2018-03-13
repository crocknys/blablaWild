package fr.wcs.blablawild;

import java.util.Date;

/**
 * Created by wilder on 06/03/18.
 */


public class TripModel {
    String prenom;
    String nom;
    Date date;
    int prix;

    public TripModel (String prenom, String nom, Date date, int prix) {
        this.prenom = prenom;
        this.nom = nom;
        this.date = date;
        this.prix = prix;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public Date getDate() {
        return date;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
