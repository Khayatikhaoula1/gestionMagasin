package tn.tuniprob.gestionmagasin;

public class Magasin {
    int id;
    private String adresse;
    private int capacite;
    private Produit[] produits;
    private int nbrProduits;

    public Magasin(int id, String adresse, int capacite) {
        this.id = id;
        this.adresse = adresse;
        this.capacite = capacite;
        this.produits = new Produit[capacite];
        this.nbrProduits = 0; // Compteur pour le nombre total de produits
    }
    public String getAdresse() {
        return adresse;
    }

    public boolean ajouterProduit(Produit produit) {
        if (chercherProduit(produit)) {
            System.out.println("Le produit existe déjà dans le magasin.");
            return false; // Produit déjà présent, ne pas l'ajouter
        }

        if (nbrProduits < capacite) {
            produits[nbrProduits] = produit;
            nbrProduits++;
            return true;
        } else {
            System.out.println("Capacité maximale atteinte.");
            return false;
        }
    }

    public boolean supprimerProduit(Produit produit) {
        for (int i = 0; i < nbrProduits; i++) {
            if (produits[i].comparer(produit)) {
                // Décaler les produits vers la gauche
                for (int j = i; j < nbrProduits - 1; j++) {
                    produits[j] = produits[j + 1];
                }
                produits[nbrProduits - 1] = null; // Évite la référence à l'ancien produit
                nbrProduits--; // Décrémente le compteur de produits
                return true; // Produit supprimé
            }
        }
        return false; // Produit non trouvé
    }

    public void afficherMagasin() {
        System.out.println("ID du magasin: " + id);
        System.out.println("Adresse: " + adresse);
        System.out.println("Capacité: " + capacite);
        System.out.println("Produits dans le magasin: ");
        for (int i = 0; i < nbrProduits; i++) {
            System.out.println(produits[i].toString());
        }
    }

    // Nombre total de produits dans ce magasin
    public int getNombreProduits() {
        return nbrProduits;
    }

    public boolean chercherProduit(Produit produit) {
        for (int i = 0; i < nbrProduits; i++) {
            if (produits[i].comparer(produit)) {
                return true; // Produit trouvé
            }
        }
        return false; // Produit non trouvé
    }

    public static Magasin comparerMagasins(Magasin magasin1, Magasin magasin2) {
        if (magasin1.getNombreProduits() > magasin2.getNombreProduits()) {
            return magasin1; // Retourne magasin1 s'il a plus de produits
        } else if (magasin1.getNombreProduits() < magasin2.getNombreProduits()) {
            return magasin2; // Retourne magasin2 s'il a plus de produits
        } else {
            System.out.println("Les deux magasins ont le même nombre de produits.");
            return null; // Retourne null si les deux magasins ont le même nombre de produits
        }
    }
}
