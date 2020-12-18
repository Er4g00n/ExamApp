package Salle;

public class Salle {

    private String nom;
    private Integer capacite;
    private Type type;
    private Specificite specificite;
    private GestionSalle gestionSalle;

    private String getNom() {
        return this.nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    private Integer getCapacite() {
        return this.capacite;
    }

    private void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    private Type getType() {
        return this.type;
    }

    private void setType(Type type) {
        this.type = type;
    }

    private Specificite getSpecificite() {
        return this.specificite;
    }

    private void setSpecificite(Specificite specificite) {
        this.specificite = specificite;
    }

    public GestionSalle getGestionSalle() {
        return this.gestionSalle;
    }

    public void setGestionSalle(GestionSalle gestionSalle) {
        this.gestionSalle = gestionSalle;
    }
}
