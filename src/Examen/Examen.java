package Examen;

import Salle.Salle;
import Utilisateur.Etudiant;

import java.time.Period;
import java.util.ArrayList;
import java.util.Hashtable;

public class Examen {


    private Integer idExamen;
    private String title;
    private double duree;
    private double horraire;
    private Periode periode;
    private Boolean estFini;
    private static Hashtable listEtudiantInscrit = new Hashtable();
    private ArrayList<Contrainte> listContrainte;
    private Calendrier calendrier;
    private Salle salle;

    public Examen(Integer idExamen, String title, double duree, Periode periode, Boolean estFini, Hashtable listEtudiantInscrit, ArrayList<Contrainte> listContrainte, Salle salle) {

        this.idExamen = idExamen;
        this.title = title;
        this.duree = duree;
        this.periode = periode;
        this.estFini = estFini;
        this.listEtudiantInscrit = listEtudiantInscrit;
        this.listContrainte = listContrainte;
        this.salle = salle;


    }


    public Integer getIdExamen() {
        return this.idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuree() {
        return this.duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public double getHorraire() {
        return this.horraire;
    }

    public void setHorraire(double horraire) {
        this.horraire = horraire;
    }

    public Boolean getEstFini() {
        return this.estFini;
    }

    public void setEstFini(Boolean estFini) {
        this.estFini = estFini;
    }

    public Hashtable getListEtudiantInscrit() {
        return listEtudiantInscrit;
    }

    public void setListEtudiantInscrit(Hashtable listEtudiantInscrit) {
        this.listEtudiantInscrit = listEtudiantInscrit;
    }

    public ArrayList<Contrainte> getListContrainte() {
        return listContrainte;
    }

    public void setListContrainte(ArrayList<Contrainte> listContrainte) {
        this.listContrainte = listContrainte;
    }

    public Salle getSalle() {
        return this.salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Calendrier getCalendrier() {
        return this.calendrier;
    }

    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }


    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public String toString() {

        return "{Id de l'examen: " + this.getIdExamen() + " Titre: " + this.getTitle() + " Duree: " + this.getDuree()
                + " Periode: " + this.getPeriode() +" L'examen est fini: " + this.getEstFini()+" Liste d'etudiant inscrit: " + this.getListEtudiantInscrit()
                +" liste des contrainte: " + this.getListContrainte()  +" Salle assigné: " + this.getSalle()+"}";

    }

}


