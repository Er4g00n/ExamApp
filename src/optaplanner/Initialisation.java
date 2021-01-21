package optaplanner;

import javafx.collections.ObservableList;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import salle.Salle;
import utilisateur.Etudiant;

import java.util.*;

public class Initialisation {

    List<Salle> SalleList = new ArrayList<>();
    private Calendrier calendrier;

    public Initialisation(){
    }

    public void solverOn(){
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
    }

    private void readEpreuveListAndEtudiantList(){

        List<Epreuve> topicList = new ArrayList<>();
        topicList.addAll(Epreuve.getExamens());
        calendrier.setEpreuveList(topicList);
        List<Etudiant> studentList = new ArrayList<>();
        studentList.addAll(Etudiant.getListEtudiant());
        calendrier.setEtudiantList(studentList);
    }

    private void readPeriodeList(){
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

    private void readSalleList(){
        calendrier.setSalleList(getSalleList());
    }

    private void readPeriodePenaliteList(){
        List<Epreuve> epreuveList = calendrier.getEpreuveList();
        List<PeriodePenalite> periodPenaltyList = new ArrayList<>();
        PeriodePenalite periodPenalty = new PeriodePenalite();
        periodPenalty.setId((long) 1);
        periodPenaltyList.add(periodPenalty);
        calendrier.setPeriodePenaliteList(periodPenaltyList);
    }

    private void readSallePenaliteList(){
        SallePenalite roomPenalty = new SallePenalite();
        List<SallePenalite> roomPenaltyList = new ArrayList<>();
        roomPenalty.setId((long) 1);
        roomPenaltyList.add(roomPenalty);
        calendrier.setSallePenaliteList(roomPenaltyList);
    }

    private void readInstitutionalWeighting(){
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
            Epreuve leadingEpreuve = topic;
            if (leadingEpreuve == topic) {
                ExamenEnCours leadingExam = new ExamenEnCours();
                leadingExam.setExamenSuivantList(new ArrayList<>(10));
                leadingEpreuveToExamMap.put(topic, leadingExam);
                exam = leadingExam;
            } else {
                ExamenSuivant followingExam = new ExamenSuivant();
                ExamenEnCours leadingExam = leadingEpreuveToExamMap.get(leadingEpreuve);
                if (leadingExam == null) {
                    throw new IllegalStateException("The followingExam (" + topic.getId()
                            + ")'s leadingExam (" + leadingExam + ") cannot be null.");
                }
                followingExam.setExamenEnCours(leadingExam);
                leadingExam.getExamenSuivantList().add(followingExam);
                exam = followingExam;
            }
            exam.setId(topic.getId());
            exam.setEpreuve(topic);
            examList.add(exam);
        }
        calendrier.setExamenList(examList);
    }

    public List<Salle> getSalleList() {
        return SalleList;
    }

    public void setSalleList(List<Salle> salleList) {
        SalleList = salleList;
    }
}

