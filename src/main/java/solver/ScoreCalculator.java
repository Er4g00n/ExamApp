package solver;

import Examen.Examen;
import Examen.ExamensPlanningSolution;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

import java.util.HashSet;

public class ScoreCalculator implements EasyScoreCalculator<ExamensPlanningSolution, HardSoftScore> {

    public HardSoftScore calculateScore(ExamensPlanningSolution examensPlanningSolution) {
        int hardScore = 0;
        int softScore = 0;

        HashSet<String> occupiedRooms = new HashSet<>();
        for (Examen examen : examensPlanningSolution.getListExamen()) {
            if (examen.getHoraire() != 0 && examen.getSalle().getNom() != null) {
                String roomInUse = examen.getPeriode().toString() + ":" + examen.getSalle().toString();
                if (occupiedRooms.contains(roomInUse)) {
                    hardScore += -1;
                } else {
                    occupiedRooms.add(roomInUse);
                }
            } else {
                hardScore += -1;
            }
        }

        return HardSoftScore.of(hardScore, softScore);
    }
}