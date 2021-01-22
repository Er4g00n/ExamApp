package optaplanner;

import abstracts.AbstractTxtSolutionExporter;
import abstracts.SolutionConverter;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

/**
 * The type Exporteur.
 * Permet de convertir la solution du solver en fichier .examapp
 * avec les solutions
 */
public class Exporteur extends AbstractTxtSolutionExporter<Calendrier> {
    private static final String OUTPUT_FILE_SUFFIX = "examapp";

    @Override
    public String getOutputFileSuffix() {
        return OUTPUT_FILE_SUFFIX;
    }

    @Override
    public TxtOutputBuilder<Calendrier> createTxtOutputBuilder() {
        return new Exporteur.CalendrierOutputBuilder();
    }

    /**
     * The type Calendrier output builder.
     * Format de l'export - modifier si besoin
     * TUDO - Exporteur vers fichier excel
     */
    public static class CalendrierOutputBuilder extends TxtOutputBuilder<Calendrier> {

        @Override
        public void writeSolution() throws IOException {
            Collections.sort(solution.getExamenList(), Comparator.comparingLong(Examen::getId));
            for (Examen exam : solution.getExamenList()) {
                bufferedWriter.write(exam.getPeriode().getLabel() + ", " + exam.getSalle().getNom() + "\r\n");
            }
        }

    }
}
