package Examen;

import Salle.Salle;
import Utilisateur.Etudiant;

import java.util.ArrayList;

/**
 * The type Examen.
 */
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

    /**
     * Gets id examen.
     *
     * @return the id examen
     */
    public Integer getIdExamen() {
        return this.idExamen;
    }

    /**
     * Sets id examen.
     *
     * @param idExamen the id examen
     */
    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets duree.
     *
     * @return the duree
     */
    public double getDuree() {
        return this.duree;
    }

    /**
     * Sets duree.
     *
     * @param duree the duree
     */
    public void setDuree(double duree) {
        this.duree = duree;
    }

    /**
     * Gets horraire.
     *
     * @return the horraire
     */
    public double getHorraire() {
        return this.horraire;
    }

    /**
     * Sets horraire.
     *
     * @param horraire the horraire
     */
    public void setHorraire(double horraire) {
        this.horraire = horraire;
    }

    /**
     * Gets est fini.
     *
     * @return the est fini
     */
    public Boolean getEstFini() {
        return this.estFini;
    }

    /**
     * Sets est fini.
     *
     * @param estFini the est fini
     */
    public void setEstFini(Boolean estFini) {
        this.estFini = estFini;
    }

    /**
     * Gets list etudiant.
     *
     * @return the list etudiant
     */
    public ArrayList<Etudiant> getListEtudiant() {
        return listEtudiant;
    }

    /**
     * Sets list etudiant.
     *
     * @param listEtudiant the list etudiant
     */
    public void setListEtudiant(ArrayList<Etudiant> listEtudiant) {
        this.listEtudiant = listEtudiant;
    }

    /**
     * Gets list contrainte.
     *
     * @return the list contrainte
     */
    public ArrayList<Contrainte> getListContrainte() {
        return listContrainte;
    }

    /**
     * Sets list contrainte.
     *
     * @param listContrainte the list contrainte
     */
    public void setListContrainte(ArrayList<Contrainte> listContrainte) {
        this.listContrainte = listContrainte;
    }

    /**
     * Gets salle.
     *
     * @return the salle
     */
    public Salle getSalle() {
        return this.salle;
    }

    /**
     * Sets salle.
     *
     * @param salle the salle
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    /**
     * Gets calendrier.
     *
     * @return the calendrier
     */
    public Calendrier getCalendrier() {
        return this.calendrier;
    }

    /**
     * Sets calendrier.
     *
     * @param calendrier the calendrier
     */
    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }

    /**
     * Gets gestion examen.
     *
     * @return the gestion examen
     */
    public GestionExamen getGestionExamen() {
        return this.gestionExamen;
    }

    /**
     * Sets gestion examen.
     *
     * @param gestionExamen the gestion examen
     */
    public void setGestionExamen(GestionExamen gestionExamen) {
        this.gestionExamen = gestionExamen;
    }

}
