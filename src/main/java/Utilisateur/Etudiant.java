package Utilisateur;

/**
 * The type Etudiant.
 */
public class Etudiant extends Utilisateur {

    private Integer numeroEtudiant;
    private Filiere filiere;


    /**
     * Instantiates a new Etudiant.
     *
     * @param nom            the nom
     * @param prenom         the prenom
     * @param email          the email
     * @param numeroEtudiant the numero etudiant
     * @param filiere        the filiere
     */
    public Etudiant(String nom,String prenom,String email,int numeroEtudiant,Filiere filiere){
        super(nom,prenom,email);
        this.filiere = filiere;
        this.numeroEtudiant = numeroEtudiant;

    }


    /**
     * Gets numero etudiant.
     *
     * @return the numero etudiant
     */
    public int getNumeroEtudiant() {

        return this.numeroEtudiant;
    }

    /**
     * Sets numero etudiant.
     *
     * @param numeroEtudiant the numero etudiant
     */
    public void setNumeroEtudiant(int numeroEtudiant) {

        this.numeroEtudiant = numeroEtudiant;
    }

    /**
     * Gets filiere.
     *
     * @return the filiere
     */
    public Filiere getFiliere() {

        return this.filiere;
    }

    /**
     * Sets filiere.
     *
     * @param filiere the filiere
     */
    public void setFiliere(Filiere filiere) {

        this.filiere = filiere;
    }

    public String toString() {
        return super.toString() +" numero etudiant: "+ getNumeroEtudiant()+" filiere: "+getFiliere()+" }";
    }
    
    
}
