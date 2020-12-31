package Salle;

public class Salle {

    private String nom;
    private Integer capacite;
    private Object disponibilite;
    private Type type;
    private Specificite specificite;
    private GestionSalle gestionSalle;

    public Salle(String nom, Integer capacite, Object disponibilite, Type type, Specificite specificite) {
        this.nom = nom;
        this.capacite = capacite;
        this.disponibilite = disponibilite;
        this.type = type;
        this.specificite = specificite;
        this.gestionSalle = gestionSalle;
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

    public GestionSalle getGestionSalle() {
        return this.gestionSalle;
    }

    public void setGestionSalle(GestionSalle gestionSalle) {
        this.gestionSalle = gestionSalle;
    }
}
