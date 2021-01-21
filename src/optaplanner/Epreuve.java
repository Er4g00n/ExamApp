package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import utilisateur.Etudiant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


@XStreamAlias("Epreuve")
public class Epreuve extends AbstractPersistable {

    private String nom;
    private int duree; // in minutes
    private List<Etudiant> etudiantList;

    private CheckBox statut;
    private Button modifier;

    private static ObservableList<Epreuve> examens = FXCollections.observableArrayList();

    // Calculated during initialization, not modified during score calculation.
    private boolean frontLoadLarge;
    private Set<Epreuve> coincidenceEpreuveSet = null;

    public Epreuve() {
        this.statut = new CheckBox();
        this.statut.setOnAction(event -> ExamenViewController.updateNumberSelectedExamen((Button) (this.statut.getScene().lookup("#examDel"))));
        this.modifier = new Button("Modifier");
        this.modifier.setOnAction(new ExamenModifierEventHandler(this));
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public int getEtudiantSize() {
        return etudiantList.size();
    }

    public boolean isFrontLoadLarge() {
        return frontLoadLarge;
    }

    public void setFrontLoadLarge(boolean frontLoadLarge) {
        this.frontLoadLarge = frontLoadLarge;
    }

    public Set<Epreuve> getCoincidenceEpreuveSet() {
        return coincidenceEpreuveSet;
    }

    public void setCoincidenceEpreuveSet(Set<Epreuve> coincidenceEpreuveSet) {
        this.coincidenceEpreuveSet = coincidenceEpreuveSet;
    }

    public boolean hasCoincidenceEpreuve() {
        return coincidenceEpreuveSet != null;
    }

    @Override
    public String toString() {
        return id == null ? "no id" : Long.toString(id);
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    public Epreuve withId(long id) {
        this.setId(id);
        return this;
    }

    public Epreuve withDuree(int duree) {
        this.setDuree(duree);
        return this;
    }

    public Epreuve withEtudiantList(List<Etudiant> etudiantList) {
        this.setEtudiantList(etudiantList);
        return this;
    }

    public Epreuve withFrontLoadLarge(boolean frontLoadLarge) {
        this.setFrontLoadLarge(frontLoadLarge);
        return this;
    }

    public Epreuve withCoincidenceEpreuveSet(Set<Epreuve> coincidenceEpreuveSet) {
        this.setCoincidenceEpreuveSet(coincidenceEpreuveSet);
        return this;
    }


    public CheckBox getStatut() {
        return statut;
    }


    public void setStatut(CheckBox statut) {
        this.statut = statut;
    }


    public Button getModifier() {
        return modifier;
    }


    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }


    public static ObservableList<Epreuve> getExamens() {
        return examens;
    }

    public static void setExamens(ObservableList<Epreuve> examens) {
        Epreuve.examens = examens;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public Long getId() {
        return super.getId();
    }
}
