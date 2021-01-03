package Utilisateur;

import Examen.Examen;

import java.util.ArrayList;

public class Utilisateur {

    private String nom;
    private String prenom;
    private String email;

    private GestionUtilisateur gestionUtilisateur;
    private ArrayList<Examen> listExamenInscrit;

    public ArrayList<Examen> getListExamenInscrit() {
        return listExamenInscrit;
    }

    public void setListExamenInscrit(ArrayList<Examen> listExamenInscrit) {
        this.listExamenInscrit = listExamenInscrit;
    }

    private String getNom() {
        return this.nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }


    private String getPrenom() {
        return this.prenom;
    }


    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    private String getEmail() {
        return this.email;
    }


    private void setEmail(String email) {
        this.email = email;
    }


    public GestionUtilisateur getGestionUtilisateur() {
        return this.gestionUtilisateur;
    }


    public void setGestionUtilisateur(GestionUtilisateur gestionUtilisateur) {
        this.gestionUtilisateur = gestionUtilisateur;
    }


}
