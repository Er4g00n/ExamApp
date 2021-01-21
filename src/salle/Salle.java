package salle;


import abstracts.AbstractPersistable;
import abstracts.Labeled;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

/**
 * Le type salle
 */
@XStreamAlias("Salle")
public class Salle extends AbstractPersistable implements Labeled {
    private static ObservableList<Salle> salles = FXCollections.observableArrayList();
    private String nom;
    private Integer capacite;
    private String type;
    private int penalite;
    private final CheckBox statut;
    private final Button modifier;

    public Salle() {
        this.statut = new CheckBox();
        this.statut.setOnAction(event -> SalleViewController.updateNumberSelectedSalle((Button) (this.statut.getScene().lookup("#salleDel"))));
        this.modifier = new Button("Modifier");
        this.modifier.setOnAction(new SalleModifierEventHandler(this));
    }

    /**
     * Instancie une nouvelle salle.
     *
     * @param nom      the nom
     * @param capacite the capacite
     */
    public Salle(String nom, Integer capacite, String type) {

        this.nom = nom;
        this.capacite = capacite;
        this.type = type;

        this.statut = new CheckBox();
        this.statut.setOnAction(event -> SalleViewController.updateNumberSelectedSalle((Button) (this.statut.getScene().lookup("#salleDel"))));
        this.modifier = new Button("Modifier");
        this.modifier.setOnAction(new SalleModifierEventHandler(this));
        salles.add(this);
    }

    public static ObservableList<Salle> getSalles() {
        return salles;
    }

    public static void setSalles(ObservableList<Salle> salles) {
        Salle.salles = salles;
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
    public String getType() {
        return this.type;
    }

    /**
     * Definit type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    public CheckBox getStatut() {
        return statut;
    }

    public Button getModifier() {
        return modifier;
    }

    public int getPenalite() {
        return penalite;
    }

    public void setPenalite(int penalite) {
        this.penalite = penalite;
    }

    public Salle withId(long id) {
        this.setId(id);
        return this;
    }

    public Salle withCapacite(int capacite) {
        this.setCapacite(capacite);
        return this;
    }

    public Salle withPenalite(int penalite) {
        this.setPenalite(penalite);
        return this;
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

