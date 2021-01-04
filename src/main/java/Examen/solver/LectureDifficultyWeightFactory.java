package Examen.solver;

import Examen.Calendrier;
import Examen.Epreuve;
import Examen.Examen;
import Examen.UnavailablePeriodPenalty;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;

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

    public static class LectureDifficultyWeight implements Comparable<LectureDifficultyWeight> {

        private static final Comparator<LectureDifficultyWeight> COMPARATOR = comparingInt(
                (LectureDifficultyWeight c) -> c.unavailablePeriodPenaltyCount)
                .thenComparingInt(c -> c.epreuve.getExamen().getLectureSize())
                .thenComparingInt(c -> c.epreuve.getExamen().getStudentSize())
                .thenComparing(c -> c.epreuve.getExamen().getMinWorkingDaySize())
                .thenComparing(c -> c.epreuve, comparingLong(Epreuve::getId));

        private final Epreuve epreuve;
        private final int unavailablePeriodPenaltyCount;

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
