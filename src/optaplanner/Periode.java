package optaplanner;

import abstracts.AbstractPersistable;
import abstracts.Labeled;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The type Periode.
 */
@XStreamAlias("Periode")
public class Periode extends AbstractPersistable implements Labeled {

    private String startDateTimeString;
    private int periodeIndex;
    private int jourIndex;
    private int duree; // in minutes
    private int penalite;
    private boolean frontLoadLast;

    /**
     * Gets start date time string.
     *
     * @return the start date time string
     */
    public String getStartDateTimeString() {
        return startDateTimeString;
    }

    /**
     * Sets start date time string.
     *
     * @param startDateTimeString the start date time string
     */
    public void setStartDateTimeString(String startDateTimeString) {
        this.startDateTimeString = startDateTimeString;
    }

    /**
     * Gets periode index.
     *
     * @return the periode index
     */
    public int getPeriodeIndex() {
        return periodeIndex;
    }

    /**
     * Sets periode index.
     *
     * @param periodeIndex the periode index
     */
    public void setPeriodeIndex(int periodeIndex) {
        this.periodeIndex = periodeIndex;
    }

    /**
     * Gets jour index.
     *
     * @return the jour index
     */
    public int getJourIndex() {
        return jourIndex;
    }

    /**
     * Sets jour index.
     *
     * @param jourIndex the jour index
     */
    public void setJourIndex(int jourIndex) {
        this.jourIndex = jourIndex;
    }

    /**
     * Gets duree.
     *
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Sets duree.
     *
     * @param duree the duree
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Gets penalite.
     *
     * @return the penalite
     */
    public int getPenalite() {
        return penalite;
    }

    /**
     * Sets penalite.
     *
     * @param penalite the penalite
     */
    public void setPenalite(int penalite) {
        this.penalite = penalite;
    }

    /**
     * Is front load last boolean.
     *
     * @return the boolean
     */
    public boolean isFrontLoadLast() {
        return frontLoadLast;
    }

    /**
     * Sets front load last.
     *
     * @param frontLoadLast the front load last
     */
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

    /**
     * With id periode.
     *
     * @param id the id
     * @return the periode
     */
    public Periode withId(long id) {
        this.setId(id);
        return this;
    }

    /**
     * With start date time string periode.
     *
     * @param startDateTimeString the start date time string
     * @return the periode
     */
    public Periode withStartDateTimeString(String startDateTimeString) {
        this.setStartDateTimeString(startDateTimeString);
        return this;
    }

    /**
     * With periode index periode.
     *
     * @param periodeIndex the periode index
     * @return the periode
     */
    public Periode withPeriodeIndex(int periodeIndex) {
        this.setPeriodeIndex(periodeIndex);
        return this;
    }

    /**
     * With jour index periode.
     *
     * @param jourIndex the jour index
     * @return the periode
     */
    public Periode withJourIndex(int jourIndex) {
        this.setJourIndex(jourIndex);
        return this;
    }

    /**
     * With duree periode.
     *
     * @param duree the duree
     * @return the periode
     */
    public Periode withDuree(int duree) {
        this.setDuree(duree);
        return this;
    }

    /**
     * With penalite periode.
     *
     * @param penalite the penalite
     * @return the periode
     */
    public Periode withPenalite(int penalite) {
        this.setPenalite(penalite);
        return this;
    }

    /**
     * With front load last periode.
     *
     * @param frontLoadLast the front load last
     * @return the periode
     */
    public Periode withFrontLoadLast(boolean frontLoadLast) {
        this.setFrontLoadLast(frontLoadLast);
        return this;
    }
}
