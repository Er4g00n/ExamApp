package optaplanner.solver;

import optaplanner.Calendrier;
import optaplanner.ExamenEnCours;
import optaplanner.ExamenSuivant;
import optaplanner.Periode;
import org.optaplanner.core.api.domain.variable.VariableListener;
import org.optaplanner.core.api.score.director.ScoreDirector;

public class PeriodeUpdatingVariableListener implements VariableListener<Calendrier, ExamenEnCours> {

    @Override
    public void beforeEntityAdded(ScoreDirector<Calendrier> scoreDirector, ExamenEnCours examenEnCours) {
        // Do nothing
    }

    @Override
    public void afterEntityAdded(ScoreDirector<Calendrier> scoreDirector, ExamenEnCours examenEnCours) {
        updatePeriode(scoreDirector, examenEnCours);
    }

    @Override
    public void beforeVariableChanged(ScoreDirector<Calendrier> scoreDirector, ExamenEnCours examenEnCours) {
        // Do nothing
    }

    @Override
    public void afterVariableChanged(ScoreDirector<Calendrier> scoreDirector, ExamenEnCours examenEnCours) {
        updatePeriode(scoreDirector, examenEnCours);
    }

    @Override
    public void beforeEntityRemoved(ScoreDirector<Calendrier> scoreDirector, ExamenEnCours examenEnCours) {
        // Do nothing
    }

    @Override
    public void afterEntityRemoved(ScoreDirector<Calendrier> scoreDirector, ExamenEnCours examenEnCours) {
        // Do nothing
    }

    protected void updatePeriode(ScoreDirector<Calendrier> scoreDirector, ExamenEnCours examenEnCours) {
        Periode periode = examenEnCours.getPeriode();
        for (ExamenSuivant examenSuivant : examenEnCours.getExamenSuivantList()) {
            scoreDirector.beforeVariableChanged(examenSuivant, "periode");
            examenSuivant.setPeriode(periode);
            scoreDirector.afterVariableChanged(examenSuivant, "periode");
        }
    }

}
