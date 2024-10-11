package tn.tuniprob.gestionmagasin;

public class Responsable extends  Employe {

    private double  prime;

    public Responsable(int id, String nom, String adresse, int nbr_heures, double  prime) {
        super(id, nom, adresse, nbr_heures);  // Appel au constructeur de la classe Employe
        this.prime = prime;}


    public double getPrime() {
        return prime; // Ajoute cette méthode
    }

    public double calculerSalaire() {
        double salaireBase = getNbrHeures() * 10; // 10 DT/H
        if (getNbrHeures() > 160) {
            double heuresSup = getNbrHeures() - 160;
            salaireBase += heuresSup * 10 * 1.2; // 20% de plus
        }
        return salaireBase + prime;
    }

    @Override
    public String toString() {
        return super.toString() + ", prime=" + prime + ", salaire=" + calculerSalaire();
    }
}