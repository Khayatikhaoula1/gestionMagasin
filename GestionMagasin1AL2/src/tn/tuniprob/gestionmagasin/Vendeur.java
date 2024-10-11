package tn.tuniprob.gestionmagasin;

public class Vendeur extends Employe{

    private double  tauxDeVente;


    public Vendeur(int id, String nom, String adresse, int nbr_heures, double  tauxDeVente) {
        super(id, nom, adresse, nbr_heures);  // Appel au constructeur de la classe Employe

        this.tauxDeVente = tauxDeVente;

    }

    public double calculerSalaire() {
        return 450 * tauxDeVente; // Salaire fixe multiplié par le taux de vente
    }

    @Override
    public String toString() {
        return super.toString() + ", tauxDeVente=" + tauxDeVente + ", salaire=" + calculerSalaire();
    }
}