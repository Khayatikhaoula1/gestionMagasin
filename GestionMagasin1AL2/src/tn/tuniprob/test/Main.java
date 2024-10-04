package tn.tuniprob.test;

import tn.tuniprob.gestionmagasin.Magasin;
import tn.tuniprob.gestionmagasin.Produit;

public class Main {
    public static void main(String[] args) {

       Produit p1=new Produit();

        System.out.println("identifiant :"+p1.getIdentifiant());
        System.out.println("marque :"+p1.getMarque());
        System.out.println("libelle :"+p1.getLibelle());
        System.out.println("prix :"+p1.getPrix());

        Produit p2=new Produit(1024,"Lait","Delice");

        System.out.println("identifiant :"+p2.getIdentifiant());
        System.out.println("marque :"+p2.getMarque());
        System.out.println("libelle :"+p2.getLibelle());
        System.out.println("prix :"+p2.getPrix());

        Produit p3=new Produit(3250,"Sicam","Tomate",(float)1.2);
        System.out.println("identifiant :"+p3.getIdentifiant());
        System.out.println("marque :"+p3.getMarque());
        System.out.println("libelle :"+p3.getLibelle());
        System.out.println("prix :"+p3.getPrix());


        System.out.println("Méthode affich");

        p3.afficher();

        System.out.println(p3.toString());
        System.out.println(p3);

     Magasin m1=new Magasin();

     m1.ajouter(p1);
     m1.ajouter(p2);

     m1.ajouter(p3);

     m1.afficherMarquePr();

     System.out.println("to string");
     System.out.println(m1);
    }
}