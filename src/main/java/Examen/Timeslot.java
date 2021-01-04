package Examen;

import Abstracts.AbstractPersistable;

/**
 * Le type Timeslot.
 */
public class Timeslot extends AbstractPersistable {

    private static final String[] TIMES = {"08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00",
            "18:00"};

    private int timeslotIndex;

    /**
     * Instancie un nouveau créneau horaire
     *
     * @param timeslotIndex the timeslot index
     */
    public Timeslot(int timeslotIndex) {
        super(timeslotIndex);
        this.timeslotIndex = timeslotIndex;
    }

    /**
     * Obtient l'index des plages horaires.
     *
     * @return the timeslot index
     */
    public int getTimeslotIndex() {
        return timeslotIndex;
    }

    /**
     * Définit l'index des intervalles de temps.
     *
     * @param timeslotIndex the timeslot index
     */
    public void setTimeslotIndex(int timeslotIndex) {
        this.timeslotIndex = timeslotIndex;
    }

    /**
     * Obtient l'étiquette.
     *
     * @return the label
     */
    public String getLabel() {
        String time = TIMES[timeslotIndex % TIMES.length];
        if (timeslotIndex > TIMES.length) {
            return "Timeslot " + timeslotIndex;
        }
        return time;
    }

    @Override
    public String toString() {
        return Integer.toString(timeslotIndex);
    }

}
