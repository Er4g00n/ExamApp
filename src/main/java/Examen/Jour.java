package Examen;

import Abstracts.AbstractPersistable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Jour extends AbstractPersistable {

    private static final String[] WEEKDAYS = { "Mo", "Tu", "We", "Th", "Fr", "Sat", "Sun" };

    private int dayIndex;

    private List<Periode> periodList;

    public Jour() {
    }

    public Jour(int dayIndex, Periode... periods) {
        super(dayIndex);
        this.dayIndex = dayIndex;
        this.periodList = Arrays.stream(periods)
                .collect(Collectors.toList());
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public List<Periode> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<Periode> periodList) {
        this.periodList = periodList;
    }

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
