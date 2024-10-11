package tn.tuniprob.test;

import tn.tuniprob.gestionmagasin.*;

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

  Magasin Carrefour = new Magasin(1, "Centre-Ville", 50);
  Magasin Monoprix = new Magasin(2, "Menzah 6", 50);


  // Ajout de produits au magasin 1
  Carrefour.ajouterProduit(new Produit(1021, "Lait", "Delice", 0.7));
  Carrefour.ajouterProduit(new Produit(2510, "Yaourt", "Vitalait", 1.2));
  Carrefour.ajouterProduit(new Produit(3250, "Tomate", "Sicam", 1.3));

  // Tentative d'ajout d'un produit en double
  System.out.println("Tentative d'ajout d'un produit en double : " + Carrefour.ajouterProduit(new Produit(1021, "Lait", "Delice", 0.7))); // Devrait retourner false

  // Ajout de produits au magasin 2
  Monoprix.ajouterProduit(new Produit(1051, "Chocolat", "MARQUEPROD2", 3.0));
  Monoprix.ajouterProduit(new Produit(2061, "Jus", "MARQUEPROD1", 1.5));

  System.out.println("\nDétails de Carrefour :");
  Carrefour.afficherMagasin();
  System.out.println("\nDétails de Monoprix :");
  Monoprix.afficherMagasin();

  // Affichage du nombre total de produits
  int totalProduits = Carrefour.getNombreProduits() + Monoprix.getNombreProduits();
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
  System.out.println("Recherche du produit1 dans Carrefour : " + Carrefour.chercherProduit(produit1)); // Devrait afficher false (car produit1 n'est pas encore ajouté)

  Carrefour.ajouterProduit(produit1); // Ajout du produit1

  System.out.println("Recherche du produit1 dans Carrefour : " + Carrefour.chercherProduit(produit1)); // Devrait afficher true

  // Comparaison des deux magasins pour déterminer celui avec le plus de produits
  Magasin magasinAvecPlusDeProduits = Magasin.comparerMagasins(Carrefour, Monoprix);
  if (magasinAvecPlusDeProduits !=null) {
   System.out.println("Le magasin avec le plus de produits est le magasin " + magasinAvecPlusDeProduits.getAdresse() + " avec " + magasinAvecPlusDeProduits.getNombreProduits() + " produits.");
  } else {
   System.out.println("Les deux magasins ont le même nombre de produits.");
  }


  Carrefour.ajouterEmploye(new Caissier(1, "Mohamed", "Centre-Ville", 170, 5));
  Carrefour.ajouterEmploye(new Caissier(2, "Malek", "Centre-Ville", 170, 2));
  Carrefour.ajouterEmploye(new Vendeur(3, "Sara", "Centre-Ville", 160, 0.15));
  Carrefour.ajouterEmploye(new Responsable(4, "Mounir", "Centre-Ville", 180, 500.0));

  Monoprix.ajouterEmploye(new Caissier(5, "Noura", "Menzah 6", 190, 3));
  Monoprix.ajouterEmploye(new Vendeur(6, "Samir", "Menzah 6", 160, 0.10));
  Monoprix.ajouterEmploye(new Vendeur(7, "Mouna", "Menzah 6", 160, 0.10));
  Monoprix.ajouterEmploye(new Vendeur(8, "Rania", "Menzah 6", 160, 0.10));
  Monoprix.ajouterEmploye(new Responsable(9, "Hedi", "Menzah 6", 160, 400.0));

  // Afficher tous les employés
  System.out.println("\nEmployés de Carrefour :");
  Carrefour.afficherEmployes();

  System.out.println("\nEmployés de Monoprix :");
  Monoprix.afficherEmployes();

  Carrefour.afficherPrimesResponsables(); // Affiche les primes pour  Carrefour
  Monoprix.afficherPrimesResponsables(); // Affiche les primes pour  Monoprix

  double salaireTotalMonoprix = Monoprix.calculerSalaireTotal();
  System.out.println("Le salaire total des employés de Monoprix est: " + salaireTotalMonoprix);

  // Test de la méthode equals pour les employés
  Employe employe1 = new Caissier(1, "Mohamed", "Centre-Ville", 170, 5);
  Employe employe2 = new Caissier(1, "Mohamed", "Centre-Ville", 170, 5);
  Employe employe3 = new Caissier(2, "Malek", "Centre-Ville", 170, 2);

  System.out.println("employe1 et employe2 sont égaux : " + employe1.equals(employe2));
  System.out.println("employe1 et employe3 sont égaux : " + employe1.equals(employe3));
}}
