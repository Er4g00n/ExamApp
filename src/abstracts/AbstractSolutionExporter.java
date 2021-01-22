package abstracts;

import org.optaplanner.core.api.domain.solution.PlanningSolution;

import java.io.File;

/**
 *
 * Cette classe provient des classes communes des exemples d'optaplanner
 *
 * @param <Solution_> the solution type, the class with the {@link PlanningSolution} annotation
 */
public abstract class AbstractSolutionExporter<Solution_> {

    public abstract String getOutputFileSuffix();

    public abstract void writeSolution(Solution_ solution, File outputFile);

    public static abstract class OutputBuilder {

    }

}
