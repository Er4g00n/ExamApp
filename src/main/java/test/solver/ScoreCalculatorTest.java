package test.solver; 

import Examen.ExamensPlanningSolution;
import Examen.Examen;
import Examen.Periode;
import Salle.Salle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import static Salle.Type.Amphitheatre;
import static Salle.Specificite.Formation;


/** 
* ScoreCalculator Tester. 
* 
* @author <Authors name> 
* @since <pre>déc. 28, 2020</pre> 
* @version 1.0 
*/ 
public class ScoreCalculatorTest {
    static ExamensPlanningSolution unsolvedExamensPlanningSolution;

    @BeforeAll
    public static void setUp() {

        unsolvedExamensPlanningSolution = new ExamensPlanningSolution();

        for(int i = 0; i < 10; i++){
            unsolvedExamensPlanningSolution.getListExamen().add(new Examen());
        }


        unsolvedExamensPlanningSolution.getListPeriode().add(new Periode("24/01/2021", 600, 120));
        unsolvedExamensPlanningSolution.getListPeriode().add(new Periode("25/01/2021", 660, 15));
        unsolvedExamensPlanningSolution.getListPeriode().add(new Periode("26/01/2021", 660, 60));
        unsolvedExamensPlanningSolution.getListPeriode().add(new Periode("27/01/2021", 600, 30));
        unsolvedExamensPlanningSolution.getListSalles().add(new Salle("B404", 200, null, Amphitheatre, Formation));
        unsolvedExamensPlanningSolution.getListSalles().add(new Salle("A404", 200, null, Amphitheatre, Formation));
        unsolvedExamensPlanningSolution.getListSalles().add(new Salle("C404", 200, null, Amphitheatre, Formation));
        unsolvedExamensPlanningSolution.getListSalles().add(new Salle("D404", 200, null, Amphitheatre, Formation));
    }

    @Test
    public void test_whenCustomJavaSolver() {

        SolverFactory<ExamensPlanningSolution> solverFactory = SolverFactory.createFromXmlResource("examConfiguration.xml");
        Solver<ExamensPlanningSolution> solver = solverFactory.buildSolver();
        ExamensPlanningSolution solvedExamensPlanningSolution = solver.solve(unsolvedExamensPlanningSolution);

        Assert.assertNotNull(solvedExamensPlanningSolution.getScore());
        System.out.println(solvedExamensPlanningSolution.getScore());

        Assert.assertEquals(-4, solvedExamensPlanningSolution.getScore().getHardScore());
    }

    @Test
    public void test_whenDroolsSolver() {

        SolverFactory<ExamensPlanningSolution> solverFactory = SolverFactory.createFromXmlResource("examDrools.xml");
        Solver<ExamensPlanningSolution> solver = solverFactory.buildSolver();
        ExamensPlanningSolution solvedExamensPlanningSolution = solver.solve(unsolvedExamensPlanningSolution);

        System.out.println(solvedExamensPlanningSolution.getScore());
        Assert.assertNotNull(solvedExamensPlanningSolution.getScore());
        Assert.assertEquals(0, solvedExamensPlanningSolution.getScore().getHardScore());
    }
}
