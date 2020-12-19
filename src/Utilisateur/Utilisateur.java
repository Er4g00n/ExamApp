package Utilisateur;

import Examen.Examen;

import java.util.ArrayList;

public abstract class Utilisateur {

    private String nom;
    private String prenom;
    private String email;


    private ArrayList<Examen> listExamenInscrit;


    public Utilisateur(String nom,String prenom,String email){
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;

    }





    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return this.prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }





}
