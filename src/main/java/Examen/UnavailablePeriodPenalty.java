
package Examen;

import Abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import static java.util.Objects.requireNonNull;

@XStreamAlias("UnavailablePeriodPenalty")
public class UnavailablePeriodPenalty extends AbstractPersistable {

    private Examen examen;
    private Periode periode;

    public UnavailablePeriodPenalty() {
    }

    public UnavailablePeriodPenalty(int id, Examen examen, Periode periode) {
        super(id);
        this.examen = requireNonNull(examen);
        this.periode = requireNonNull(periode);
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return examen + "@" + periode;
    }

}
