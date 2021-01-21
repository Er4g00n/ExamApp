package optaplanner;


import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class SolutionCalendrier {

    private Solver solver;

    public void setSolver(SolverFactory solverFactory) {
        this.solver = solverFactory.buildSolver();
    }
}
