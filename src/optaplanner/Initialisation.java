package optaplanner;

import connexion.BDD;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import salle.Salle;
import utilisateur.Etudiant;

import java.io.File;
import java.util.*;

/**
 * The type Initialisation.
 * Permet de mettre en place la solution prete pour etre resolut
 */
public class Initialisation {

    private Calendrier calendrier;
    private Map<Epreuve, Set<Epreuve>> coincidenceMap;
    private Map<Epreuve, Set<Epreuve>> exclusionMap;
    private Map<Epreuve, Set<Epreuve>> afterMap;


    /**
     * Instantiates a new Initialisation.
     */
    public Initialisation() {
    }

    /**
     * Solver on.
     * Recupere les informations
     * Lance le solver
     * Exporte la solution vers un fichier data/ressource/resultat.examapp
     */
    public void solverOn() {
        calendrier = new Calendrier();
        calendrier.setId(0L);
        readEpreuveListAndEtudiantList();
        readPeriodeList();
        readSalleList();
        readPeriodePenaliteList();
        readSallePenaliteList();
        readInstitutionalWeighting();
        createExamList();
        SolverFactory<Calendrier> solverFactory = SolverFactory.createFromXmlResource("score/examinationSolverConfig.xml");
        Solver<Calendrier> solver = solverFactory.buildSolver();
        Calendrier solvedCourseSchedule = solver.solve(calendrier);
        Exporteur export = new Exporteur();
        File file = new File("data/ressource/resultat.examapp");
        export.writeSolution(solvedCourseSchedule, file);
    }

    private void readEpreuveListAndEtudiantList() {
        coincidenceMap = new LinkedHashMap<>();
        exclusionMap = new LinkedHashMap<>();
        afterMap = new LinkedHashMap<>();
        List<Epreuve> topicList = new ArrayList<>(Epreuve.getExamens());
        calendrier.setEpreuveList(topicList);
        List<Etudiant> studentList = new ArrayList<>(Etudiant.getListEtudiant());
        calendrier.setEtudiantList(studentList);
        coincidenceMap = BDD.getCoincidenceMap();
        exclusionMap = BDD.getExclusionMap();
        afterMap = BDD.getAfterMap();
    }

    private void readPeriodeList() {
        List<Periode> periodeList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {

            for (int j = 0; j < 4; j++) {
                Periode periode = new Periode();
                periode.setId((long) (i * 4) + j);
                int jour = 18 + i;
                if (j == 0) periode.setStartDateTimeString(jour + ":01:2021 08:00:00");
                if (j == 1) periode.setStartDateTimeString(jour + ":01:2021 10:00:00");
                if (j == 2) periode.setStartDateTimeString(jour + ":01:2021 14:00:00");
                if (j == 3) periode.setStartDateTimeString(jour + ":01:2021 16:00:00");

                periode.setPeriodeIndex((i * 4) + j);
                periode.setJourIndex(i);
                periode.setDuree(90);
                periode.setPenalite(0);
                periodeList.add(periode);
            }
        }
        calendrier.setPeriodeList(periodeList);
    }

    private void readSalleList() {
        calendrier.setSalleList(Salle.getSalles());
    }

    private void readPeriodePenaliteList() {
        int id = 0;
        List<Epreuve> epreuveList = calendrier.getEpreuveList();
        List<PeriodePenalite> periodPenaltyList = new ArrayList<>();
        // createIndirectPeriodPenalties of type EXAM_COINCIDENCE
        for (Map.Entry<Epreuve, Set<Epreuve>> entry : coincidenceMap.entrySet()) {
            Epreuve leftEpreuve = entry.getKey();
            Set<Epreuve> middleEpreuveSet = entry.getValue();
            for (Epreuve middleEpreuve : new ArrayList<>(middleEpreuveSet)) {
                for (Epreuve rightEpreuve : new ArrayList<>(coincidenceMap.get(middleEpreuve))) {
                    if (rightEpreuve != leftEpreuve
                            && !middleEpreuveSet.contains(rightEpreuve)) {
                        PeriodePenalite indirectPeriodePenalite = new PeriodePenalite();
                        indirectPeriodePenalite.setId((long) id);
                        id++;
                        indirectPeriodePenalite.setPeriodePenaliteType(PeriodePenaliteType.EXAM_COINCIDENCE);
                        indirectPeriodePenalite.setLeftEpreuve(leftEpreuve);
                        indirectPeriodePenalite.setRightEpreuve(rightEpreuve);
                        periodPenaltyList.add(indirectPeriodePenalite);
                        boolean added = coincidenceMap.get(leftEpreuve).add(rightEpreuve)
                                && coincidenceMap.get(rightEpreuve).add(leftEpreuve);
                        if (!added) {
                            throw new IllegalStateException("The periodPenalty (" + indirectPeriodePenalite
                                    + ") for leftEpreuve (" + leftEpreuve + ") and rightEpreuve (" + rightEpreuve
                                    + ") was not successfully added twice.");
                        }
                    }
                }
            }
        }
        // createIndirectPeriodPenalties of type AFTER
        for (Map.Entry<Epreuve, Set<Epreuve>> entry : afterMap.entrySet()) {
            Epreuve leftEpreuve = entry.getKey();
            Set<Epreuve> afterLeftSet = entry.getValue();
            Queue<Epreuve> queue = new ArrayDeque<>();
            for (Epreuve topic : afterMap.get(leftEpreuve)) {
                queue.add(topic);
                queue.addAll(coincidenceMap.get(topic));
            }
            while (!queue.isEmpty()) {
                Epreuve rightEpreuve = queue.poll();
                if (!afterLeftSet.contains(rightEpreuve)) {
                    PeriodePenalite indirectPeriodePenalite = new PeriodePenalite();
                    indirectPeriodePenalite.setId((long) id);
                    id++;
                    indirectPeriodePenalite.setPeriodePenaliteType(PeriodePenaliteType.AFTER);
                    indirectPeriodePenalite.setLeftEpreuve(leftEpreuve);
                    indirectPeriodePenalite.setRightEpreuve(rightEpreuve);
                    periodPenaltyList.add(indirectPeriodePenalite);
                    boolean added = afterMap.get(leftEpreuve).add(rightEpreuve);
                    if (!added) {
                        throw new IllegalStateException("The periodPenalty (" + indirectPeriodePenalite
                                + ") for leftEpreuve (" + leftEpreuve + ") and rightEpreuve (" + rightEpreuve
                                + ") was not successfully added.");
                    }
                }
                for (Epreuve topic : afterMap.get(rightEpreuve)) {
                    queue.add(topic);
                    queue.addAll(coincidenceMap.get(topic));
                }
            }
        }
        calendrier.setPeriodePenaliteList(periodPenaltyList);
    }

    private void readSallePenaliteList() {
        SallePenalite roomPenalty = new SallePenalite();
        List<SallePenalite> roomPenaltyList = new ArrayList<>();
        roomPenalty.setId((long) 1);
        roomPenaltyList.add(roomPenalty);
        calendrier.setSallePenaliteList(roomPenaltyList);
    }

    private void readInstitutionalWeighting() {
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
    }

    private void createExamList() {
        List<Epreuve> topicList = calendrier.getEpreuveList();
        List<Examen> examList = new ArrayList<>(topicList.size());
        Map<Epreuve, ExamenEnCours> leadingEpreuveToExamMap = new HashMap<>(topicList.size());
        for (Epreuve topic : topicList) {
            Examen exam;
            ExamenEnCours leadingExam = new ExamenEnCours();
            leadingExam.setExamenSuivantList(new ArrayList<>(10));
            leadingEpreuveToExamMap.put(topic, leadingExam);
            exam = leadingExam;
            exam.setId(topic.getId());
            exam.setEpreuve(topic);
            examList.add(exam);
        }
        calendrier.setExamenList(examList);
    }
}

