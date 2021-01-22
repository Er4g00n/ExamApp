package optaplanner;

import abstracts.AbstractTxtSolutionExporter;
import org.optaplanner.examples.common.persistence.SolutionConverter;


import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class Exporteur extends AbstractTxtSolutionExporter<Calendrier> {
    private static final String OUTPUT_FILE_SUFFIX = "examapp";

    public static void main(String[] args) {
        SolutionConverter<Calendrier> converter = SolutionConverter.createExportConverter(
                "ressource", Calendrier.class, new Exporteur());
        converter.convertAll();
    }

    @Override
    public String getOutputFileSuffix() {
        return OUTPUT_FILE_SUFFIX;
    }
    
    public static class CalendrierOutputBuilder extends TxtOutputBuilder<Calendrier> {

        @Override
        public void writeSolution() throws IOException {
            Collections.sort(solution.getExamenList(), Comparator.comparingLong(Examen::getId));
            for (Examen exam : solution.getExamenList()) {
                bufferedWriter.write(exam.getPeriode().getLabel() + ", " + exam.getSalle().getNom() + "\r\n");
            }
        }

    }
    @Override
    public TxtOutputBuilder<Calendrier> createTxtOutputBuilder() {
        return new Exporteur.CalendrierOutputBuilder();
    }
}
