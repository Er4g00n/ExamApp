package optaplanner;


import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

/**
 * The type Solution calendrier.
 */
public class SolutionCalendrier {

    private Solver solver;

    /**
     * Sets solver.
     *
     * @param solverFactory the solver factory
     */
    public void setSolver(SolverFactory solverFactory) {
        this.solver = solverFactory.buildSolver();
    }
}
