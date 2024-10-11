package tn.tuniprob.gestionmagasin;

public class Employe {
    int id;
    private String nom;
    private String adresse;
    private int nbr_heures;

    public Employe() {
    }
public Employe(int id, String nom, String adresse, int nbr_heures) {
    this.id = id;
    this.nom = nom;
    this.adresse = adresse;
    this.nbr_heures = nbr_heures;
}
    public String getNom() {
        return nom; // Méthode pour obtenir le nom de l'employé
    }
public int getNbrHeures(){
        return nbr_heures;
    }

    public double calculerSalaire() {
        return 0;
    }
    public static double calculerSalaireTotal(Employe[] employes) {
        double total = 0.0;
        for (Employe employe : employes) {
            if (employe != null) {
                total += employe.calculerSalaire();
            }
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employe employe = (Employe) o;
        return id == employe.id &&
                nbr_heures == employe.nbr_heures &&
                nom.equals(employe.nom) &&
                adresse.equals(employe.adresse);
    }


    @Override
        public String toString() {
            return "Employe {id=" + id + ",nom : '" + nom + "', adresse='" + adresse + "', nbr_heures=" + nbr_heures + "}";
        }



















}