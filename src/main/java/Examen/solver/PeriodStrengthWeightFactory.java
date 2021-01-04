package Examen.solver;

import Examen.Calendrier;
import Examen.Periode;
import Examen.UnavailablePeriodPenalty;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

import java.util.Comparator;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.function.Function.identity;

/**
 * Usine de poids de résistance de type Période.
 */
public class PeriodStrengthWeightFactory implements SelectionSorterWeightFactory<Calendrier, Periode> {

    @Override
    public PeriodStrengthWeight createSorterWeight(Calendrier calendrier, Periode periode) {
        int unavailablePeriodPenaltyCount = 0;
        for (UnavailablePeriodPenalty penalty : calendrier.getUnavailablePeriodPenaltyList()) {
            if (penalty.getPeriode().equals(periode)) {
                unavailablePeriodPenaltyCount++;
            }
        }
        return new PeriodStrengthWeight(periode, unavailablePeriodPenaltyCount);
    }

    /**
     * Le poids de résistance de type Période.
     */
    public static class PeriodStrengthWeight implements Comparable<PeriodStrengthWeight> {

        // The higher unavailablePeriodPenaltyCount, the weaker
        private static final Comparator<PeriodStrengthWeight> BASE_COMPARATOR = reverseOrder(
                comparingInt((PeriodStrengthWeight w) -> w.unavailablePeriodPenaltyCount));
        private static final Comparator<Periode> PERIOD_COMPARATOR = comparingInt((Periode p) -> p.getJour().getDayIndex())
                .thenComparingInt(p -> p.getTimeslot().getTimeslotIndex())
                .thenComparingLong(Periode::getId);
        private static final Comparator<PeriodStrengthWeight> COMPARATOR = comparing(identity(), BASE_COMPARATOR)
                .thenComparing(w -> w.period, PERIOD_COMPARATOR);

        private final Periode period;
        private final int unavailablePeriodPenaltyCount;

        /**
         * Instancie un nouveau poids de force Période.
         *
         * @param period                        the period
         * @param unavailablePeriodPenaltyCount the unavailable period penalty count
         */
        public PeriodStrengthWeight(Periode period, int unavailablePeriodPenaltyCount) {
            this.period = period;
            this.unavailablePeriodPenaltyCount = unavailablePeriodPenaltyCount;
        }

        @Override
        public int compareTo(PeriodStrengthWeight other) {
            return COMPARATOR.compare(this, other);
        }
    }
}
