package Salle;

public class Salle {
    private String nom;
    private Integer capacite;
    private Object disponibilite;
    private Type type;
    private Specificite specificite;




    public Salle(String nom, Integer capacite, Type type, Specificite specificite, Object disponibilite) {
        this.disponibilite = disponibilite;
        this.nom = nom;
        this.capacite = capacite;
        this.type = type;
        this.specificite = specificite;
    }

    protected String getNom(Salle e) {

        return e.getNom();
    }

    protected String getNom() {

        return this.nom;
    }

    protected void setNom(String nom) {

        this.nom = nom;
    }

    protected Integer getCapacite() {

        return this.capacite;
    }

    protected void setCapacite(Integer capacite) {

        this.capacite = capacite;
    }

    protected Object getDisponibilite() {

        return this.disponibilite;
    }

    protected void setDisponibilite(Object disponibilite) {

        this.disponibilite = disponibilite;
    }

    protected Type getType() {

        return this.type;
    }

    protected void setType(Type type) {

        this.type = type;
    }

    protected Specificite getSpecificite() {

        return this.specificite;
    }

    protected void setSpecificite(Specificite specificite) {

        this.specificite = specificite;
    }



    public String toString() {

        return  "nom: "+getNom()+ "capacite: " + this.getCapacite() +"specificite: "+ this.getSpecificite() +"type: "+ this.getType() + "disponibilite: "+this.getDisponibilite();
    }

}

