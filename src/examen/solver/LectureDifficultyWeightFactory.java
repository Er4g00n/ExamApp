package examen.solver;

import examen.Calendrier;
import examen.Epreuve;
import examen.Examen;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;

/**
 * Cette classe permet le calcule des poids des Epreuves
 */
public class LectureDifficultyWeightFactory implements SelectionSorterWeightFactory<Calendrier, Epreuve> {

    @Override
    public LectureDifficultyWeight createSorterWeight(Calendrier calendrier, Epreuve epreuve) {
        Examen examen = epreuve.getExamen();
        int unavailablePeriodPenaltyCount = 0;
        for (UnavailablePeriodPenalty penalty : calendrier.getUnavailablePeriodPenaltyList()) {
            if (penalty.getExamen().equals(examen)) {
                unavailablePeriodPenaltyCount++;
            }
        }
        return new LectureDifficultyWeight(epreuve, unavailablePeriodPenaltyCount);
    }

    /**
     * Le poids de difficulté de type Lecture.
     */
    public static class LectureDifficultyWeight implements Comparable<LectureDifficultyWeight> {

        private static final Comparator<LectureDifficultyWeight> COMPARATOR = comparingInt(
                (LectureDifficultyWeight c) -> c.unavailablePeriodPenaltyCount)
                .thenComparingInt(c -> c.epreuve.getExamen().getStudentSize())
                .thenComparing(c -> c.epreuve.getExamen().getMinWorkingDaySize())
                .thenComparing(c -> c.epreuve, comparingLong(Epreuve::getId));

        private final Epreuve epreuve;
        private final int unavailablePeriodPenaltyCount;

        /**
         * Instancie un nouveau poids de difficulté a l'épreuve.
         *
         * @param epreuve                       the epreuve
         * @param unavailablePeriodPenaltyCount the unavailable period penalty count
         */
        public LectureDifficultyWeight(Epreuve epreuve, int unavailablePeriodPenaltyCount) {
            this.epreuve = epreuve;
            this.unavailablePeriodPenaltyCount = unavailablePeriodPenaltyCount;
        }

        @Override
        public int compareTo(LectureDifficultyWeight other) {
            return COMPARATOR.compare(this, other);
        }
    }
}
