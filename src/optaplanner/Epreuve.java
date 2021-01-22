package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import utilisateur.Etudiant;

import java.util.List;
import java.util.Set;


/**
 * The type Epreuve.
 */
@XStreamAlias("Epreuve")
public class Epreuve extends AbstractPersistable {

    private static ObservableList<Epreuve> examens = FXCollections.observableArrayList();
    private String nom;
    private int duree; // in minutes
    private List<Etudiant> etudiantList;
    private CheckBox statut;
    private Button modifier;
    // Calculated during initialization, not modified during score calculation.
    private boolean frontLoadLarge;
    private Set<Epreuve> coincidenceEpreuveSet = null;

    /**
     * Instantiates a new Epreuve.
     */
    public Epreuve() {
        this.statut = new CheckBox();
        this.statut.setOnAction(event -> ExamenViewController.updateNumberSelectedExamen((Button) (this.statut.getScene().lookup("#examDel"))));
        this.modifier = new Button("Modifier");
        this.modifier.setOnAction(new ExamenModifierEventHandler(this));
    }

    /**
     * Gets examens.
     *
     * @return the examens
     */
    public static ObservableList<Epreuve> getExamens() {
        return examens;
    }

    /**
     * Sets examens.
     *
     * @param examens the examens
     */
    public static void setExamens(ObservableList<Epreuve> examens) {
        Epreuve.examens = examens;
    }

    /**
     * Gets duree.
     *
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Sets duree.
     *
     * @param duree the duree
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Gets etudiant list.
     *
     * @return the etudiant list
     */
    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    /**
     * Sets etudiant list.
     *
     * @param etudiantList the etudiant list
     */
    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    /**
     * Gets etudiant size.
     *
     * @return the etudiant size
     */
    public int getEtudiantSize() {
        return etudiantList.size();
    }

    /**
     * Is front load large boolean.
     *
     * @return the boolean
     */
    public boolean isFrontLoadLarge() {
        return frontLoadLarge;
    }

    /**
     * Sets front load large.
     *
     * @param frontLoadLarge the front load large
     */
    public void setFrontLoadLarge(boolean frontLoadLarge) {
        this.frontLoadLarge = frontLoadLarge;
    }

    /**
     * Gets coincidence epreuve set.
     *
     * @return the coincidence epreuve set
     */
    public Set<Epreuve> getCoincidenceEpreuveSet() {
        return coincidenceEpreuveSet;
    }

    /**
     * Sets coincidence epreuve set.
     *
     * @param coincidenceEpreuveSet the coincidence epreuve set
     */
    public void setCoincidenceEpreuveSet(Set<Epreuve> coincidenceEpreuveSet) {
        this.coincidenceEpreuveSet = coincidenceEpreuveSet;
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    /**
     * Has coincidence epreuve boolean.
     *
     * @return the boolean
     */
    public boolean hasCoincidenceEpreuve() {
        return coincidenceEpreuveSet != null;
    }

    @Override
    public String toString() {
        return id == null ? "no id" : Long.toString(id);
    }

    /**
     * With id epreuve.
     *
     * @param id the id
     * @return the epreuve
     */
    public Epreuve withId(long id) {
        this.setId(id);
        return this;
    }

    /**
     * With duree epreuve.
     *
     * @param duree the duree
     * @return the epreuve
     */
    public Epreuve withDuree(int duree) {
        this.setDuree(duree);
        return this;
    }

    /**
     * With etudiant list epreuve.
     *
     * @param etudiantList the etudiant list
     * @return the epreuve
     */
    public Epreuve withEtudiantList(List<Etudiant> etudiantList) {
        this.setEtudiantList(etudiantList);
        return this;
    }

    /**
     * With front load large epreuve.
     *
     * @param frontLoadLarge the front load large
     * @return the epreuve
     */
    public Epreuve withFrontLoadLarge(boolean frontLoadLarge) {
        this.setFrontLoadLarge(frontLoadLarge);
        return this;
    }

    /**
     * With coincidence epreuve set epreuve.
     *
     * @param coincidenceEpreuveSet the coincidence epreuve set
     * @return the epreuve
     */
    public Epreuve withCoincidenceEpreuveSet(Set<Epreuve> coincidenceEpreuveSet) {
        this.setCoincidenceEpreuveSet(coincidenceEpreuveSet);
        return this;
    }

    /**
     * Gets statut.
     *
     * @return the statut
     */
    public CheckBox getStatut() {
        return statut;
    }

    /**
     * Sets statut.
     *
     * @param statut the statut
     */
    public void setStatut(CheckBox statut) {
        this.statut = statut;
    }

    /**
     * Gets modifier.
     *
     * @return the modifier
     */
    public Button getModifier() {
        return modifier;
    }

    /**
     * Sets modifier.
     *
     * @param modifier the modifier
     */
    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public Long getId() {
        return super.getId();
    }
}
