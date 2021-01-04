
package Examen;

import Abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import static java.util.Objects.requireNonNull;

/**
 * Le type de p�nalit� de p�riode indisponible.
 */
@XStreamAlias("UnavailablePeriodPenalty")
public class UnavailablePeriodPenalty extends AbstractPersistable {

    private Examen examen;
    private Periode periode;

    /**
     * Instancie une nouvelle p�nalit� de p�riode d'indisponibilit�.
     */
    public UnavailablePeriodPenalty() {
    }

    /**
     * Instancie une nouvelle p�nalit� de p�riode d'indisponibilit�.
     *
     * @param id      the id
     * @param examen  the examen
     * @param periode the periode
     */
    public UnavailablePeriodPenalty(int id, Examen examen, Periode periode) {
        super(id);
        this.examen = requireNonNull(examen);
        this.periode = requireNonNull(periode);
    }

    /**
     * Obtient un examen.
     *
     * @return the examen
     */
    public Examen getExamen() {
        return examen;
    }

    /**
     * D�finit l'examen.
     *
     * @param examen the examen
     */
    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    /**
     * Obtient periode.
     *
     * @return the periode
     */
    public Periode getPeriode() {
        return periode;
    }

    /**
     * Definit periode.
     *
     * @param periode the periode
     */
    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return examen + "@" + periode;
    }

}
