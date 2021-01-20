package test.optaplanner; 

import optaplanner.*;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.examination.domain.*;
import org.optaplanner.test.api.score.stream.ConstraintVerifier;
import promotion.Promotion;
import score.Contrainte;
import utilisateur.Etudiant;


import java.io.IOException;
import java.util.*;

/** 
* SolutionCalendrier Tester. 
* 
* @author <Authors name> 
* @since <pre>janv. 19, 2021</pre> 
* @version 1.0 
*/ 
public class SolutionCalendrierTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

    private Calendrier calendrier;

    private final Etudiant etudiant1 = new Etudiant("Tom","Lefrere","tom@hotmail.fr", "21903169", null, (long)1);
    private final Etudiant etudiant2 = new Etudiant("Robenson","Rapha","rob@hotmail.fr", "21903168", null,(long)2);
    private final Etudiant etudiant3 = new Etudiant("Jimmy","SaintOuen","jimmy@hotmail.fr", "21903167", null,(long)3);
    private final Etudiant etudiant4 = new Etudiant("Thomas","Timar","thomas@hotmail.fr", "21903166", null,(long)4);

/** 
* 
* Method: setSolver(SolverFactory<Solution_> solverFactory) 
* 
*/ 
@Test
public void testSetSolver() throws Exception {
    calendrier = new Calendrier();
    calendrier.setId(0L);

    Epreuve epreuve = new Epreuve();
    epreuve.setId((long)1);
    epreuve.setDuree(60);

    Epreuve epreuve2 = new Epreuve();
    epreuve2.setId((long)2);
    epreuve2.setDuree(30);

    Promotion l1Info = new Promotion("L1 Informatique", "Informatique");
    Promotion l2Info = new Promotion("L2 Informatique", "Informatique");

    l1Info.ajouterEtudiant(etudiant1);
    l1Info.ajouterEtudiant(etudiant2);
    l2Info.ajouterEtudiant(etudiant3);
    l2Info.ajouterEtudiant(etudiant4);

    epreuve.setEtudiantList(l1Info.getEtudiants());
    epreuve.setFrontLoadLarge(false);

    epreuve2.setEtudiantList(l2Info.getEtudiants());
    epreuve2.setFrontLoadLarge(false);

    List<Epreuve> epreuves = new ArrayList<>();
    epreuves.add(epreuve);
    epreuves.add(epreuve2);

    calendrier.setEpreuveList(epreuves);

    List<Etudiant> listAllEtudiants = new ArrayList<>();
    listAllEtudiants.addAll(l1Info.getEtudiants());
    listAllEtudiants.addAll(l2Info.getEtudiants());

    calendrier.setEtudiantList(listAllEtudiants);

    List<Periode> periodeList = new ArrayList<>();
    for (int i = 0; i < 7; i++) {

            for (int j = 0; j < 4; j++){
                Periode periode = new Periode();
                periode.setId((long) (i*4)+j);
                int jour = 18+i;
                if(j == 0) periode.setStartDateTimeString(String.valueOf(jour)+":01:2021 08:00:00");
                if(j == 1) periode.setStartDateTimeString(String.valueOf(jour)+":01:2021 10:00:00");
                if(j == 2) periode.setStartDateTimeString(String.valueOf(jour)+":01:2021 14:00:00");
                if(j == 3) periode.setStartDateTimeString(String.valueOf(jour)+":01:2021 16:00:00");

                periode.setPeriodeIndex((i*4)+j);
                periode.setJourIndex(i);
                periode.setDuree(90);
                periode.setPenalite(0);
                periodeList.add(periode);
            }}
    calendrier.setPeriodeList(periodeList);


    List<Salle> salleList = new ArrayList<>();
    Salle salle1 = new Salle();
    salle1.setId((long) 1);
    salle1.setCapacite(50);
    salle1.setPenalite(0);
    salleList.add(salle1);

    Salle salle2 = new Salle();
    salle2.setId((long) 2);
    salle2.setCapacite(150);
    salle2.setPenalite(0);
    salleList.add(salle2);

    calendrier.setSalleList(salleList);

    CalendrierContraintes constraintConfiguration = new CalendrierContraintes();
    constraintConfiguration.setId(0L);
    constraintConfiguration.setPeriodeSpreadPenalite(1);
    constraintConfiguration.setTwoInARowPenalite(1);
    constraintConfiguration.setTwoInAJourPenalite(1);
    constraintConfiguration.setPeriodeSpreadLength(1);
    constraintConfiguration.setMixedDureePenalite(1);
    constraintConfiguration.setFrontLoadLargeEpreuveSize(1);
    constraintConfiguration.setFrontLoadLastPeriodeSize(1);
    constraintConfiguration.setFrontLoadPenalite(1);
    calendrier.setConstraintConfiguration(constraintConfiguration);

    List<Epreuve> epreuvesList = calendrier.getEpreuveList();
    List<Examen> examList = new ArrayList<>(epreuvesList.size());
    Map<Epreuve, ExamenEnCours> examenEnCoursToExamenMap = new HashMap<>(epreuvesList.size());

    for (Epreuve epreuve1 : epreuves) {
        Examen examen;
        Epreuve epreuveEnCours = epreuve1;

        if (epreuveEnCours == epreuve1) {
        ExamenEnCours examenEnCours = new ExamenEnCours();
        examenEnCours.setExamenSuivantList(new ArrayList<>(10));
        examenEnCoursToExamenMap.put(epreuve1, examenEnCours);
        examen = examenEnCours;
        }
        else {
            ExamenSuivant followingExam = new ExamenSuivant();
            ExamenEnCours leadingExam = examenEnCoursToExamenMap.get(epreuveEnCours);
            if (leadingExam == null) {
                throw new IllegalStateException("The followingExam (" + epreuve1.getId()
                        + ")'s leadingExam (" + leadingExam + ") cannot be null.");
            }
            followingExam.setExamenEnCours(leadingExam);
            leadingExam.getExamenSuivantList().add(followingExam);
            examen = followingExam;
        }
        examen.setId(epreuve1.getId());
        examList.add(examen);
    }
    calendrier.setExamenList(examList);


    List<Epreuve> epreuveList = calendrier.getEpreuveList();
    List<PeriodePenalite> periodPenaltyList = new ArrayList<>();
    PeriodePenalite periodPenalty = new PeriodePenalite();
    periodPenalty.setId((long) 1);
    periodPenaltyList.add(periodPenalty);
    calendrier.setPeriodePenaliteList(periodPenaltyList);

    SallePenalite roomPenalty = new SallePenalite();
    List<SallePenalite> roomPenaltyList = new ArrayList<>();
    roomPenalty.setId((long) 1);
    roomPenaltyList.add(roomPenalty);
    calendrier.setSallePenaliteList(roomPenaltyList);


    SolverFactory<Calendrier> solverFactory = SolverFactory.createFromXmlResource("score/examinationSolverConfig.xml");
    Solver<Calendrier> solver = solverFactory.buildSolver();
    Calendrier solvedCourseSchedule = solver.solve(calendrier);

}


} 
