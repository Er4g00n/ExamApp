package Utilisateur;


import Salle.Salle;

import java.util.Hashtable;

public class GestionUtilisateur {


    private static Hashtable listEtudiant ;
    private static Hashtable listScolarite ;
    private static Hashtable listSecretariat ;

    public static void creerEtudiant(String nom,String prenom,String email,Integer numeroEtudiant,Filiere filiere) {
        if (listEtudiant.containsKey(numeroEtudiant))
            System.out.println(nom +" "+prenom +"est deja dans la liste des etudiant");
        else
            {
                Etudiant e = new Etudiant(nom, prenom, email, numeroEtudiant, filiere);
                listEtudiant.put(e.getNumeroEtudiant(), e);
            }
    }
    public static void creerScolarite(String nom,String prenom,String email,Integer idScolarite) {
        if (listScolarite.containsKey(idScolarite))
            System.out.println(nom +" "+prenom +"est deja dans la liste de la scolarite");
        else
            {
                Scolarite e = new Scolarite(nom, prenom, email, idScolarite);
                listScolarite.put(e.getIdScolarite(), e);
            }
    }
    public static void creerSecretairiat(String nom,String prenom,String email,Integer idSecretariat) {
        if (listSecretariat.containsKey(idSecretariat))
            System.out.println(nom +" "+prenom +"est deja dans la liste du secretariat");
        else
            {
                Secretariat e = new Secretariat(nom, prenom, email, idSecretariat);
                listSecretariat.put(e.getIdSecretariat(), e);
            }
    }


    public static void supprimerEtudiant(Integer e) {
        try {
            listEtudiant.remove(e);
        }
        catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }
    public static void supprimerScolarite(Integer e) {
        try {
            listScolarite.remove(e);
        }
        catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }
    public static void supprimerSecretariat(Integer e) {
        try {
            listSecretariat.remove(e);
        }
        catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }


    public void modifierEtudiant(String nom,String prenom,String email,Integer numeroEtudiant,Filiere filiere) {

        if (listEtudiant.containsKey(numeroEtudiant))
        {
            Etudiant e = new Etudiant(  nom,
                                        prenom,
                                        email,
                                        numeroEtudiant,
                                        filiere);
            listEtudiant.put(e.getNumeroEtudiant(), e);
        }
        else
            System.out.println(nom +" n'existe pas");

    }
    public void modifierEtudiant(Integer numeroEtudiant,String nom,String prenom) {

        if (listEtudiant.containsKey(numeroEtudiant))
        {
            Etudiant e = new Etudiant(  nom,
                                        prenom,
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getEmail(),
                                        numeroEtudiant,
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getFiliere());

            listEtudiant.put(e.getNumeroEtudiant(), e);
        }
        else
            System.out.println(numeroEtudiant+" n'exite pas");

    }
    public void modifierEtudiant(Integer numeroEtudiant,String email) {
        if (listEtudiant.containsKey(numeroEtudiant))
        {
            Etudiant e = new Etudiant(  ((Etudiant)listEtudiant.get(numeroEtudiant)).getNom(),
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getPrenom(),
                                        email,
                                        numeroEtudiant,
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getFiliere());

            listEtudiant.put(e.getNumeroEtudiant(), e);
        }
        else
            System.out.println(numeroEtudiant+" n'exite pas");
    }
    public void modifierEtudiant(Integer numeroEtudiant,Filiere filiere) {
        if (listEtudiant.containsKey(numeroEtudiant))
        {
            Etudiant e = new Etudiant(  ((Etudiant)listEtudiant.get(numeroEtudiant)).getNom(),
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getPrenom(),
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getEmail(),
                                        numeroEtudiant,
                                        filiere);

            listEtudiant.put(e.getNumeroEtudiant(), e);
        }
        else
            System.out.println(numeroEtudiant+" n'exite pas");
    }
    public void modifierEtudiant(Integer numeroEtudiant, Integer newnumeroEtudiant) {
        if (listEtudiant.containsKey(numeroEtudiant))
        {
            Etudiant e = new Etudiant(  ((Etudiant)listEtudiant.get(numeroEtudiant)).getNom(),
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getPrenom(),
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getEmail(),
                                        newnumeroEtudiant,
                                        ((Etudiant)listEtudiant.get(numeroEtudiant)).getFiliere());

            listEtudiant.put(e.getNumeroEtudiant(), e);
            supprimerEtudiant(numeroEtudiant);
        }
        else
            System.out.println(numeroEtudiant+" n'exite pas");
    }


    public void modifierScolarite(String nom,String prenom,String email,Integer idScolarite) {
    }
    public void modifierScolarite(Integer idScolarite,String nom,String prenom) {
    }
    public void modifierScolarite(Integer idScolarite,String email) {
    }
    public void modifierScolarite(Integer idScolarite,Integer newIdScolarite) {
    }


    public void modifierSecretariat(String nom,String prenom,String email,Integer idSecretariat) {
    }
    public void modifierSecretariat(Integer idSecretariat,String nom,String prenom) {
    }
    public void modifierSecretariat(Integer idSecretariat,String email) {
    }
    public void modifierSecretariat(Integer idSecretariat,Integer newIdSecretariat) {
    }





}
