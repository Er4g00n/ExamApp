package optaplanner.solver;

import optaplanner.Calendrier;
import optaplanner.Examen;
import optaplanner.ExamenEnCours;
import optaplanner.PeriodePenalite;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

import java.util.Comparator;

public class ExamenPoidDetermination implements SelectionSorterWeightFactory<Calendrier, Examen> {

    @Override
    public ExamenDifficultyWeight createSorterWeight(Calendrier calendrier, Examen examen) {
        int etudiantSizeTotal = examen.getEpreuveEtudiantSize();
        int maximumDuree = examen.getEpreuveDuree();
        for (PeriodePenalite periodePenalite : calendrier.getPeriodePenaliteList()) {
            if (periodePenalite.getLeftEpreuve().equals(examen.getEpreuve())) {
                switch (periodePenalite.getPeriodePenaliteType()) {
                    case EXAM_COINCIDENCE:
                        etudiantSizeTotal += periodePenalite.getRightEpreuve().getEtudiantSize();
                        maximumDuree = Math.max(maximumDuree, periodePenalite.getRightEpreuve().getDuree());
                        break;
                    case EXCLUSION:
                        // Do nothing
                        break;
                    case AFTER:
                        // Do nothing
                        break;
                    default:
                        throw new IllegalStateException("The periodePenaliteType ("
                                + periodePenalite.getPeriodePenaliteType() + ") is not implemented.");
                }
            } else if (periodePenalite.getRightEpreuve().equals(examen.getEpreuve())) {
                switch (periodePenalite.getPeriodePenaliteType()) {
                    case EXAM_COINCIDENCE:
                        etudiantSizeTotal += periodePenalite.getLeftEpreuve().getEtudiantSize();
                        maximumDuree = Math.max(maximumDuree, periodePenalite.getLeftEpreuve().getDuree());
                        break;
                    case EXCLUSION:
                        // Do nothing
                        break;
                    case AFTER:
                        etudiantSizeTotal += periodePenalite.getLeftEpreuve().getEtudiantSize();
                        maximumDuree = Math.max(maximumDuree, periodePenalite.getLeftEpreuve().getDuree());
                        break;
                    default:
                        throw new IllegalStateException("The periodePenaliteType ("
                                + periodePenalite.getPeriodePenaliteType() + ") is not implemented.");
                }
            }
        }
        return new ExamenDifficultyWeight(examen, etudiantSizeTotal, maximumDuree);
    }

    public static class ExamenDifficultyWeight implements Comparable<ExamenDifficultyWeight> {

        private static final Comparator<ExamenDifficultyWeight> COMPARATOR = Comparator
                .comparingInt((ExamenDifficultyWeight weight) -> weight.etudiantSizeTotal)
                .thenComparingInt(weight -> weight.maximumDuree)
                .thenComparing(weight -> weight.examen instanceof ExamenEnCours)
                .thenComparingLong(weight -> weight.examen.getId());

        private final Examen examen;
        private final int etudiantSizeTotal;
        private final int maximumDuree;

        public ExamenDifficultyWeight(Examen examen, int etudiantSizeTotal, int maximumDuree) {
            this.examen = examen;
            this.etudiantSizeTotal = etudiantSizeTotal;
            this.maximumDuree = maximumDuree;
        }

        @Override
        public int compareTo(ExamenDifficultyWeight other) {
            return COMPARATOR.compare(this, other);
        }

    }

}
