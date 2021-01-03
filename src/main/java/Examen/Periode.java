package Examen;

import Abstracts.AbstractPersistable;
import Abstracts.Labeled;

import static java.util.Objects.requireNonNull;

public class Periode extends AbstractPersistable implements Labeled {
    private Jour jour;
    private Timeslot timeslot;

    public Periode(int id, Jour jour, Timeslot timeslot) {
        super(id);
        this.jour = requireNonNull(jour);
        jour.getPeriodList().add(this);
        this.timeslot = requireNonNull(timeslot);
    }

    public Periode() {
    }


    public Jour getJour() {
        return jour;
    }

    public void setJour(Jour jour) {
        this.jour = jour;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return jour + "-" + timeslot;
    }

    @Override
    public String getLabel() {
        return null;
    }
}
