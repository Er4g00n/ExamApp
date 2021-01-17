package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import optaplanner.solver.ExamenPoidDetermination;
import optaplanner.solver.SallePoidDetermination;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity(difficultyWeightFactoryClass = ExamenPoidDetermination.class)
@XStreamInclude({
        ExamenEnCours.class,
        ExamenSuivant.class
})
public abstract class Examen extends AbstractPersistable {

    protected Epreuve epreuve;

    private CheckBox statut;
    private Button modifier;
    private static ObservableList<Examen> examens = FXCollections.observableArrayList();

    // Planning variables: changes during planning, between score calculations.
    protected Salle salle;

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    @PlanningVariable(valueRangeProviderRefs = {"salleRange"}, strengthWeightFactoryClass = SallePoidDetermination.class)
    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    public abstract Periode getPeriode();

    public int getEpreuveDuree() {
        return getEpreuve().getDuree();
    }

    public int getEpreuveEtudiantSize() {
        return getEpreuve().getEtudiantSize();
    }

    public int getJourIndex() {
        Periode periode = getPeriode();
        if (periode == null) {
            return Integer.MIN_VALUE;
        }
        return periode.getJourIndex();
    }

    public int getPeriodeIndex() {
        Periode periode = getPeriode();
        if (periode == null) {
            return Integer.MIN_VALUE;
        }
        return periode.getPeriodeIndex();
    }

    public int getPeriodeDuree() {
        Periode periode = getPeriode();
        if (periode == null) {
            return Integer.MIN_VALUE;
        }
        return periode.getDuree();
    }

    public boolean isEpreuveFrontLoadLarge() {
        return epreuve.isFrontLoadLarge();
    }

    public boolean isPeriodeFrontLoadLast() {
        Periode periode = getPeriode();
        if (periode == null) {
            return false;
        }
        return periode.isFrontLoadLast();
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


    public static ObservableList<Examen> getExamens() {
        return examens;
    }

    public String getLabel() {
        return Long.toString(epreuve.getId());
    }

    @Override
    public String toString() {
        return epreuve.toString();
    }

}
