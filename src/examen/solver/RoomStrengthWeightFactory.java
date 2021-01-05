package examen.solver;

import examen.Calendrier;
import salle.Salle;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

/**
 * Le type Usine de poids de r�sistance de la pi�ce.
 */
public class RoomStrengthWeightFactory implements SelectionSorterWeightFactory<Calendrier, Salle> {

    @Override
    public RoomStrengthWeight createSorterWeight(Calendrier calendrier, Salle salle) {
        return new RoomStrengthWeight(salle);
    }

    /**
     * Le type Poids de r�sistance de la pi�ce.
     */
    public static class RoomStrengthWeight implements Comparable<RoomStrengthWeight> {

        private static final Comparator<Salle> COMPARATOR = comparingInt(Salle::getCapacite).thenComparingLong(Salle::getId);

        private final Salle salle;

        /**
         * Instancie un nouveau poids de r�sistance de la pi�ce.
         *
         * @param salle the room
         */
        public RoomStrengthWeight(Salle salle) {
            this.salle = salle;
        }

        @Override
        public int compareTo(RoomStrengthWeight other) {
            return COMPARATOR.compare(salle, other.salle);
        }
    }
}
