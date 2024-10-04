package tn.tuniprob.test;

import tn.tuniprob.gestionmagasin.Magasin;
import tn.tuniprob.gestionmagasin.Produit;

import java.util.ArrayList;
import java.util.List;

public class Main {
 public static void main(String[] args) {
  List<Produit> produits = new ArrayList<>();

  produits.add(new Produit(1021, "Lait", "Delice", 0.7));
  produits.add(new Produit(2510, "Yaourt", "Vitalait", 1.2));
  produits.add(new Produit(3250, "Tomate", "Sicam", 1.3));

  // Affichage des produits dans la liste
  for (Produit produit : produits) {
   produit.afficher();
   System.out.println();
  }

  Magasin magasin1 = new Magasin(1, "MG1", 50);
  Magasin magasin2 = new Magasin(2, "MG2", 50);

  // Ajout de produits au magasin 1
  magasin1.ajouterProduit(new Produit(1021, "Lait", "Delice", 0.7));
  magasin1.ajouterProduit(new Produit(2510, "Yaourt", "Vitalait", 1.2));
  magasin1.ajouterProduit(new Produit(3250, "Tomate", "Sicam", 1.3));

  // Tentative d'ajout d'un produit en double
  System.out.println("Tentative d'ajout d'un produit en double : " + magasin1.ajouterProduit(new Produit(1021, "Lait", "Delice", 0.7))); // Devrait retourner false

  // Ajout de produits au magasin 2
  magasin2.ajouterProduit(new Produit(1051, "Chocolat", "MARQUEPROD2", 3.0));
  magasin2.ajouterProduit(new Produit(2061, "Jus", "MARQUEPROD1", 1.5));

  // Affichage des magasins
  magasin1.afficherMagasin();
  System.out.println();
  magasin2.afficherMagasin();

  // Affichage du nombre total de produits
  int totalProduits = magasin1.getNombreProduits() + magasin2.getNombreProduits();
  System.out.println("\nNombre total de produits dans tous les magasins : " + totalProduits);

  // Comparer des produits
  Produit produit1 = new Produit(101, "Lait", "Delice", 0.7);
  Produit produit2 = new Produit(101, "Lait", "Delice", 0.7);
  Produit produit3 = new Produit(102, "Jus", "Vitalait", 1.5);

  // Comparer avec 1 paramètre
  System.out.println("Le produit1 et produit2 sont identiques : " + produit1.comparer(produit2));  // true
  System.out.println("Le produit1 et produit3 sont identiques : " + produit1.comparer(produit3));  // false

  // Comparer avec 2 paramètres
  System.out.println("Le produit1 et produit2 sont identiques : " + Produit.comparer(produit1, produit2));  // true
  System.out.println("Le produit1 et produit3 sont identiques : " + Produit.comparer(produit1, produit3));  // false

  // Test de la méthode chercherProduit
  System.out.println("Recherche du produit1 dans magasin1 : " + magasin1.chercherProduit(produit1)); // Devrait afficher false (car produit1 n'est pas encore ajouté)

  magasin1.ajouterProduit(produit1); // Ajout du produit1

  System.out.println("Recherche du produit1 dans magasin1 : " + magasin1.chercherProduit(produit1)); // Devrait afficher true

  // Comparaison des deux magasins pour déterminer celui avec le plus de produits
  Magasin magasinAvecPlusDeProduits = Magasin.comparerMagasins(magasin1, magasin2);
  if (magasinAvecPlusDeProduits != null) {
   System.out.println("Le magasin avec le plus de produits est le magasin " + magasinAvecPlusDeProduits.getAdresse() + " avec " + magasinAvecPlusDeProduits.getNombreProduits() + " produits.");
  } else {
   System.out.println("Les deux magasins ont le même nombre de produits.");
  }

 }
}
