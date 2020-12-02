package Examen;

import Salle.Salle;

public class Contrainte {

    private Salle salleSpeciale;
    private Integer nombrePlace;
    private Examen precedenceExam;


    private Salle getSalleSpeciale() {
        return this.salleSpeciale;
    }
    private void setSalleSpeciale(Salle salleSpeciale) {
        this.salleSpeciale = salleSpeciale;
    }
    private Integer getNombrePlace() {
        return this.nombrePlace;
    }
    private void setNombrePlace(Integer nombrePlace) {
        this.nombrePlace = nombrePlace;
    }
    private Examen getPrecedenceExam() {
        return this.precedenceExam;
    }
    private void setPrecedenceExam(Examen precedenceExam) {
        this.precedenceExam = precedenceExam;
    }

    
}
