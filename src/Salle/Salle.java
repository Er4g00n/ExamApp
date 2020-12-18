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

    public Object getDisponibilite() {

        return this.disponibilite;
    }

    public void setDisponibilite(Object disponibilite) {

        this.disponibilite = disponibilite;
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



    public String toString() {

        return  "nom: "+getNom()+ "capacite: " + this.getCapacite() +"specificite: "+ this.getSpecificite() +"type: "+ this.getType() + "disponibilite: "+this.getDisponibilite();
    }

}

