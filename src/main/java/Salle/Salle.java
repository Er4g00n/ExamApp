package Salle;


import Abstracts.AbstractPersistable;
import Abstracts.Labeled;

public class Salle extends AbstractPersistable implements Labeled {
    private String nom;
    private Integer capacite;

    private Type type;
    private Specificite specificite;

    public Salle(String nom, Integer capacite, Type type, Specificite specificite) {

        this.nom = nom;
        this.capacite = capacite;
        this.type = type;
        this.specificite = specificite;
    }

    public String getNom(Salle e) {

        return e.getNom();
    }

    public String getNom() {

        return this.nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public Integer getCapacite() {

        return this.capacite;
    }

    public void setCapacite(Integer capacite) {

        this.capacite = capacite;
    }


    public Type getType() {

        return this.type;
    }

    public void setType(Type type) {

        this.type = type;
    }

    public Specificite getSpecificite() {

        return this.specificite;
    }

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

