package Examen;

import Salle.Salle;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

public class Contrainte {

    private Salle salleSpeciale;
    private Integer nombrePlace;
    private Examen precedenceExam;

    @PlanningVariable(
            valueRangeProviderRefs = {"salleSpecial"})
    private Salle getSalleSpeciale() {
        return this.salleSpeciale;
    }

    private void setSalleSpeciale(Salle salleSpeciale) {
        this.salleSpeciale = salleSpeciale;
    }

    @PlanningVariable(
            valueRangeProviderRefs = {"nbPlace"})
    private Integer getNombrePlace() {
        return this.nombrePlace;
    }

    private void setNombrePlace(Integer nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    @PlanningVariable(
            valueRangeProviderRefs = {"examPrecedent"})
    private Examen getPrecedenceExam() {
        return this.precedenceExam;
    }

    private void setPrecedenceExam(Examen precedenceExam) {
        this.precedenceExam = precedenceExam;
    }


}
