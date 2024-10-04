package tn.tuniprob.gestionmagasin;

import java.util.Date;

public class Produit {
    int id;
    String libelle;
    String marque;
    double prix;
    Date dateExpiration;

    public Produit() {
    }

    public Produit(int id, String libelle, String marque, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
    }

    public void afficher() {
        System.out.println("ID: " + id);
        System.out.println("Libellé: " + libelle);
        System.out.println("Marque: " + marque);
        System.out.println("Prix: " + prix);
        System.out.println("Date d'expiration: " + (dateExpiration != null ? dateExpiration : "undefined"));
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", dateExpiration=" + dateExpiration +
                '}';
    }

    // Méthode comparer avec un seul produit en paramètre
    public boolean comparer(Produit produit2) {
        if (produit2 == null) {
            return false;
        }
        return this.id == produit2.id &&
                this.libelle != null && this.libelle.equals(produit2.libelle) &&
                this.prix == produit2.prix;
    }

    // Méthode comparer avec deux produits en paramètre
    public static boolean comparer(Produit produit1, Produit produit2) {
        if (produit1 == null || produit2 == null) {
            return false;
        }
        return produit1.id == produit2.id &&
                produit1.libelle != null && produit1.libelle.equals(produit2.libelle) &&
                produit1.prix == produit2.prix;
    }

}


