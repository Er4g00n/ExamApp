package utilisateur;

/**
 * The type Secretariat.
 */
public class Secretariat extends Utilisateur {

    private Integer idSecretariat;


    /**
     * Instantiates a new Secretariat.
     *
     * @param nom    the nom
     * @param prenom the prenom
     * @param email  the email
     */
    public Secretariat( String nom, String prenom, String email) {
        super(nom, prenom, email);
        this.idSecretariat = null;
    }

    /**
     * Instantiates a new Secretariat.
     *
     * @param nom    the nom
     * @param prenom the prenom
     * @param email  the email
     * @param id     the id
     */
    public Secretariat( String nom, String prenom, String email,Integer id) {
        super(nom, prenom, email);
        this.idSecretariat = id;
    }

    /**
     * Gets id secretariat.
     *
     * @return the id secretariat
     */
    public Integer getIdSecretariat() {
        return this.idSecretariat;
    }


    public String toString() {
        return super.toString() +" idSecretariat: "+ getIdSecretariat()+" }";
    }
    
}
