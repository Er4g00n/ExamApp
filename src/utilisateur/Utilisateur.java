package utilisateur;

import optaplanner.Examen;

import java.util.ArrayList;

/**
 * The type Utilisateur.
 */
public abstract class Utilisateur {

    private String nom;
    private String prenom;
    private String email;


    private ArrayList<Examen> listExamenInscrit;


    /**
     * Instantiates a new Utilisateur.
     *
     * @param nom    the nom
     * @param prenom the prenom
     * @param email  the email
     */
    public Utilisateur(String nom,String prenom,String email){
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;

    }


    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Gets prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
        return this.prenom;
    }


    /**
     * Sets prenom.
     *
     * @param prenom the prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }


    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    public String toString() {
        return  "{nom: " + getNom() + " prenom: " + getPrenom()  + " email: " + getEmail() ;
    }





}
