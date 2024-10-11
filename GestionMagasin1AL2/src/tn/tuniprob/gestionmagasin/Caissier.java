package tn.tuniprob.gestionmagasin;

public class Caissier extends Employe{
    private int numeroDeCaisse;

    public Caissier(int id, String nom, String adresse, int nbr_heures, int numeroDeCaisse) {
        super(id, nom, adresse, nbr_heures);  // Appel au constructeur de la classe Employe
        this.numeroDeCaisse = numeroDeCaisse;

    }

    public double calculerSalaire() {
        double salaireBase = getNbrHeures() * 5; // 5 DT/H
        if (getNbrHeures() > 180) {
            double heuresSup = getNbrHeures() - 180;
            salaireBase += heuresSup * 5 * 1.15; // 15% de plus pour les heures supplémentaires
        }
        return salaireBase;
    }

    @Override
    public String toString() {
        return super.toString() + ", numeroDeCaisse=" + numeroDeCaisse + ", salaire=" + calculerSalaire();
    }
}
