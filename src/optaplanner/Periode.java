package optaplanner;

import abstracts.AbstractPersistable;
import abstracts.Labeled;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Periode")
public class Periode extends AbstractPersistable implements Labeled {

    private String startDateTimeString;
    private int periodeIndex;
    private int jourIndex;
    private int duree; // in minutes
    private int penalite;
    private boolean frontLoadLast;

    public String getStartDateTimeString() {
        return startDateTimeString;
    }

    public void setStartDateTimeString(String startDateTimeString) {
        this.startDateTimeString = startDateTimeString;
    }

    public int getPeriodeIndex() {
        return periodeIndex;
    }

    public void setPeriodeIndex(int periodeIndex) {
        this.periodeIndex = periodeIndex;
    }

    public int getJourIndex() {
        return jourIndex;
    }

    public void setJourIndex(int jourIndex) {
        this.jourIndex = jourIndex;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getPenalite() {
        return penalite;
    }

    public void setPenalite(int penalite) {
        this.penalite = penalite;
    }

    public boolean isFrontLoadLast() {
        return frontLoadLast;
    }

    public void setFrontLoadLast(boolean frontLoadLast) {
        this.frontLoadLast = frontLoadLast;
    }

    @Override
    public String getLabel() {
        return startDateTimeString;
    }

    @Override
    public String toString() {
        return startDateTimeString;
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    public Periode withId(long id) {
        this.setId(id);
        return this;
    }

    public Periode withStartDateTimeString(String startDateTimeString) {
        this.setStartDateTimeString(startDateTimeString);
        return this;
    }

    public Periode withPeriodeIndex(int periodeIndex) {
        this.setPeriodeIndex(periodeIndex);
        return this;
    }

    public Periode withJourIndex(int jourIndex) {
        this.setJourIndex(jourIndex);
        return this;
    }

    public Periode withDuree(int duree) {
        this.setDuree(duree);
        return this;
    }

    public Periode withPenalite(int penalite) {
        this.setPenalite(penalite);
        return this;
    }

    public Periode withFrontLoadLast(boolean frontLoadLast) {
        this.setFrontLoadLast(frontLoadLast);
        return this;
    }
}
