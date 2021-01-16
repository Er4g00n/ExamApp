package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;
import java.util.Set;


@XStreamAlias("Epreuve")
public class Epreuve extends AbstractPersistable {

    private int duree; // in minutes
    private List<Etudiant> etudiantList;

    // Calculated during initialization, not modified during score calculation.
    private boolean frontLoadLarge;
    private Set<Epreuve> coincidenceEpreuveSet = null;

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
}
