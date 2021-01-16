package optaplanner;

import abstracts.AbstractPersistable;
import abstracts.Labeled;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Salle")
public class Salle extends AbstractPersistable implements Labeled {

    private int capacite;
    private int penalite;

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getPenalite() {
        return penalite;
    }

    public void setPenalite(int penalite) {
        this.penalite = penalite;
    }

    @Override
    public String getLabel() {
        return Long.toString(id);
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

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

}
