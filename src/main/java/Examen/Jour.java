package Examen;

import Abstracts.AbstractPersistable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Le type Jour.
 */
public class Jour extends AbstractPersistable {

    private static final String[] WEEKDAYS = {"Mo", "Tu", "We", "Th", "Fr", "Sat", "Sun"};

    private int dayIndex;

    private List<Periode> periodList;

    /**
     * Instancie un nouveau Jour.
     */
    public Jour() {
    }

    /**
     * Instancie un nouveau Jour.
     *
     * @param dayIndex the day index
     * @param periods  the periods
     */
    public Jour(int dayIndex, Periode... periods) {
        super(dayIndex);
        this.dayIndex = dayIndex;
        this.periodList = Arrays.stream(periods)
                .collect(Collectors.toList());
    }

    /**
     * Obtient l'index du jour.
     *
     * @return the day index
     */
    public int getDayIndex() {
        return dayIndex;
    }

    /**
     * Définit l'indice du jour.
     *
     * @param dayIndex the day index
     */
    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    /**
     * Obtient la liste des périodes.
     *
     * @return the period list
     */
    public List<Periode> getPeriodList() {
        return periodList;
    }

    /**
     * Définit la liste des périodes.
     *
     * @param periodList the period list
     */
    public void setPeriodList(List<Periode> periodList) {
        this.periodList = periodList;
    }

    /**
     * Obtient l'étiquette.
     *
     * @return the label
     */
    public String getLabel() {
        String weekday = WEEKDAYS[dayIndex % WEEKDAYS.length];
        if (dayIndex > WEEKDAYS.length) {
            return "Day " + dayIndex;
        }
        return weekday;
    }

    @Override
    public String toString() {
        return Integer.toString(dayIndex);
    }

}
