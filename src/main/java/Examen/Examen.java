package Examen;

import Salle.Salle;
import Utilisateur.Etudiant;

import java.util.ArrayList;

public class Examen {


    private Integer idExamen;
    private String title;
    private double duree;
    private double horraire;
    private Boolean estFini;
    private ArrayList<Etudiant> listEtudiant;
    private ArrayList<Contrainte> listContrainte;

    private Calendrier calendrier;
    private GestionExamen gestionExamen;
    private Salle salle;

    private Integer getIdExamen() {
        return this.idExamen;
    }

    private void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private double getDuree() {
        return this.duree;
    }

    private void setDuree(double duree) {
        this.duree = duree;
    }

    private double getHorraire() {
        return this.horraire;
    }

    private void setHorraire(double horraire) {
        this.horraire = horraire;
    }

    private Boolean getEstFini() {
        return this.estFini;
    }

    private void setEstFini(Boolean estFini) {
        this.estFini = estFini;
    }

    public ArrayList<Etudiant> getListEtudiant() {
        return listEtudiant;
    }

    public void setListEtudiant(ArrayList<Etudiant> listEtudiant) {
        this.listEtudiant = listEtudiant;
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

    public GestionExamen getGestionExamen() {
        return this.gestionExamen;
    }

    public void setGestionExamen(GestionExamen gestionExamen) {
        this.gestionExamen = gestionExamen;
    }

}
