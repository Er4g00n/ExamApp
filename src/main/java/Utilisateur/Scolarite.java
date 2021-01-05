package Utilisateur;

/**
 * The type Scolarite.
 */
public class Scolarite extends Utilisateur {

    private Integer idScolarite;

    /**
     * Instantiates a new Scolarite.
     *
     * @param nom    the nom
     * @param prenom the prenom
     * @param email  the email
     */
    public Scolarite(String nom,String prenom,String email) {
        super(nom, prenom, email);
        this.idScolarite = null;
    }

    /**
     * Instantiates a new Scolarite.
     *
     * @param nom    the nom
     * @param prenom the prenom
     * @param email  the email
     * @param id     the id
     */
    public Scolarite(String nom,String prenom,String email, Integer id) {
        super(nom, prenom, email);
        this.idScolarite = id;
    }

    /**
     * Gets id scolarite.
     *
     * @return the id scolarite
     */
    public Integer getIdScolarite() {
        return this.idScolarite;
    }


    public String toString() {
        return super.toString()+" idScolarite: "+ getIdScolarite()+" }";
    }
}
