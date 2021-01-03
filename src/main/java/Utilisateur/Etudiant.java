package Utilisateur;

public class Etudiant extends Utilisateur {

    private int numeroEtudiant;
    private Filiere filiere;

    private int getNumeroEtudiant() {
        return this.numeroEtudiant;
    }

    private void setNumeroEtudiant(int numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    private Filiere getFiliere() {
        return this.filiere;
    }

    private void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }


}
