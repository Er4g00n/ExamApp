package Salle;


import Abstracts.AbstractPersistable;
import Abstracts.Labeled;

/**
 * Le type salle
 */
public class Salle extends AbstractPersistable implements Labeled {
    private String nom;
    private Integer capacite;

    private Type type;
    private Specificite specificite;

    /**
     * Instancie une nouvelle salle.
     *
     * @param nom         the nom
     * @param capacite    the capacite
     * @param type        the type
     * @param specificite the specificite
     */
    public Salle(String nom, Integer capacite, Type type, Specificite specificite) {

        this.nom = nom;
        this.capacite = capacite;
        this.type = type;
        this.specificite = specificite;
    }

    /**
     * Obtient nom.
     *
     * @param e the e
     * @return the nom
     */
    public String getNom(Salle e) {

        return e.getNom();
    }

    /**
     * Obtient nom.
     *
     * @return the nom
     */
    public String getNom() {

        return this.nom;
    }

    /**
     * Definit nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {

        this.nom = nom;
    }

    /**
     * Obtient capacite.
     *
     * @return the capacite
     */
    public Integer getCapacite() {

        return this.capacite;
    }

    /**
     * Definit capacite.
     *
     * @param capacite the capacite
     */
    public void setCapacite(Integer capacite) {

        this.capacite = capacite;
    }


    /**
     * Obtient type.
     *
     * @return the type
     */
    public Type getType() {

        return this.type;
    }

    /**
     * Definit type.
     *
     * @param type the type
     */
    public void setType(Type type) {

        this.type = type;
    }

    /**
     * Obtient specificite.
     *
     * @return the specificite
     */
    public Specificite getSpecificite() {

        return this.specificite;
    }

    /**
     * Definit specificite.
     *
     * @param specificite the specificite
     */
    public void setSpecificite(Specificite specificite) {

        this.specificite = specificite;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public String toString() {
        return nom;
    }

}

