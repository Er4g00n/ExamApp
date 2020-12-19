package Utilisateur;

public class Etudiant extends Utilisateur {

    private Integer numeroEtudiant;
    private Filiere filiere;


    public Etudiant(String nom,String prenom,String email,int numeroEtudiant,Filiere filiere){
        super(nom,prenom,email);
        this.filiere = filiere;
        this.numeroEtudiant = numeroEtudiant;

    }



    public int getNumeroEtudiant() {

        return this.numeroEtudiant;
    }
    public void setNumeroEtudiant(int numeroEtudiant) {

        this.numeroEtudiant = numeroEtudiant;
    }
    public Filiere getFiliere() {

        return this.filiere;
    }
    public void setFiliere(Filiere filiere) {

        this.filiere = filiere;
    }
    
    
}
