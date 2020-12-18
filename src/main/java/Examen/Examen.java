package Examen;

import Salle.Salle;
import Utilisateur.Etudiant;

import java.util.ArrayList;

/**
 * Classe Examen.
 * Permet l'utilisation de l'objet examen
 * Cet objet a pour role de définir les examens pour le solveur (OptaPlanner)
 */
public class Examen {


    private Integer idExamen;
    private String title;
    private double duree;
    private double horaire;
    private Boolean estFini;
    private ArrayList<Etudiant> listEtudiant;
    private ArrayList<Contrainte> listContrainte;

    private Calendrier calendrier;
    private Salle salle;


    @Override
    public String toString() {
        return "Examen{" +
                "idExamen=" + idExamen +
                ", title='" + title + '\'' +
                ", duree=" + duree +
                ", horraire=" + horaire +
                ", estFini=" + estFini +
                ", listEtudiant=" + listEtudiant +
                ", listContrainte=" + listContrainte +
                ", calendrier=" + calendrier +
                ", salle=" + salle +
                '}';
    }

    /**
     * Retourne id examen.
     *
     * @return l 'id examen (de type Integer)
     */
    public Integer getIdExamen() {
        return this.idExamen;
    }

    /**
     * Définie id examen.
     * En cas de besoin de modification de l'id
     *
     * @param idExamen deviendra l'idExamen
     */
    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    /**
     * Retourne title.
     *
     * @return le titre de l'examen (de type String)
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Définie le titre de l'examen.
     *
     * @param title deviendra le titre
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retourne duree.
     *
     * @return la durée de l'examen (de type double)
     */
    public double getDuree() {
        return this.duree;
    }

    /**
     * Définie la duree de l'examen.
     *
     * @param duree deviendra duree
     */
    public void setDuree(double duree) {
        this.duree = duree;
    }

    /**
     * Retourne les horaires.
     *
     * @return l 'horaire (de type double)
     */
    public double getHorraire() {
        return this.horaire;
    }

    /**
     * Définie l'horaire.
     *
     * @param horraire l'horaire
     */
    public void setHorraire(double horraire) {
        this.horaire = horraire;
    }

    /**
     * Retourne un boolean qui retourne true si il est fini.
     *
     * @return le boolean 'estfini'
     */
    public Boolean getEstFini() {
        return this.estFini;
    }

    /**
     * Définie le boolean 'est fini'.
     *
     * @param estFini le est fini
     */
    public void setEstFini(Boolean estFini) {
        this.estFini = estFini;
    }

    /**
     * Retourne la liste des etudiants.
     *
     * @return la liste des etudiants (de type ArrayList<Etudiant>)
     */
    public ArrayList<Etudiant> getListEtudiant() {
        return listEtudiant;
    }

    /**
     * Définie la liste d'etudiants.
     *
     * @param listEtudiant la list etudiant
     */
    public void setListEtudiant(ArrayList<Etudiant> listEtudiant) {
        this.listEtudiant = listEtudiant;
    }

    /**
     * Retourne la liste des contraintes.
     *
     * @return la liste des contraintes (de type ArrayList<Contrainte>)
     */
    public ArrayList<Contrainte> getListContrainte() {
        return listContrainte;
    }

    /**
     * Définie la liste de contraintes.
     *
     * @param listContrainte the list contrainte
     */
    public void setListContrainte(ArrayList<Contrainte> listContrainte) {
        this.listContrainte = listContrainte;
    }

    /**
     * Retourne la salle.
     *
     * @return la salle (de type Salle)
     */
    public Salle getSalle() {
        return this.salle;
    }

    /**
     * Définie la salle.
     *
     * @param salle the salle
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    /**
     * Retourne le calendrier.
     *
     * @return le calendrier (de type Calendrier)
     */
    public Calendrier getCalendrier() {
        return this.calendrier;
    }

    /**
     * Définie le calendrier.
     *
     * @param calendrier the calendrier
     */
    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }
}