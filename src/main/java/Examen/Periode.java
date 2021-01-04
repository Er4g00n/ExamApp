package Examen;

import Abstracts.AbstractPersistable;
import Abstracts.Labeled;

import static java.util.Objects.requireNonNull;

/**
 * Le type Periode.
 */
public class Periode extends AbstractPersistable implements Labeled {
    private Jour jour;
    private Timeslot timeslot;

    /**
     * Instancie une nouvelle Période.
     *
     * @param id       the id
     * @param jour     the jour
     * @param timeslot the timeslot
     */
    public Periode(int id, Jour jour, Timeslot timeslot) {
        super(id);
        this.jour = requireNonNull(jour);
        jour.getPeriodList().add(this);
        this.timeslot = requireNonNull(timeslot);
    }

    /**
     * Instancie une nouvelle Période.
     */
    public Periode() {
    }


    /**
     * Obtient jour.
     *
     * @return the jour
     */
    public Jour getJour() {
        return jour;
    }

    /**
     * Definit jour.
     *
     * @param jour the jour
     */
    public void setJour(Jour jour) {
        this.jour = jour;
    }

    /**
     * Obtient timeslot.
     *
     * @return the timeslot
     */
    public Timeslot getTimeslot() {
        return timeslot;
    }

    /**
     * Definit timeslot.
     *
     * @param timeslot the timeslot
     */
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
