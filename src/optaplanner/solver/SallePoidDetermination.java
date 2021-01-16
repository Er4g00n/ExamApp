package optaplanner.solver;

import optaplanner.Calendrier;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;
import salle.Salle;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;


public class SallePoidDetermination implements SelectionSorterWeightFactory<Calendrier, Salle> {

    @Override
    public SalleStrengthWeight createSorterWeight(Calendrier calendrier, Salle salle) {
        return new SalleStrengthWeight(salle);
    }

    public static class SalleStrengthWeight implements Comparable<SalleStrengthWeight> {

        private static final Comparator<Salle> COMPARATOR = comparingInt(Salle::getCapacite)
                .thenComparingLong(Salle::getId);

        private final Salle salle;

        public SalleStrengthWeight(Salle salle) {
            this.salle = salle;
        }

        @Override
        public int compareTo(SalleStrengthWeight other) {
            return COMPARATOR.compare(this.salle, other.salle);
        }

    }

}
