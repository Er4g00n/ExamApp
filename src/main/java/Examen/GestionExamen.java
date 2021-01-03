package Examen;



import Utilisateur.Etudiant;
import Salle.Salle;
import java.util.ArrayList;
import java.util.Hashtable;

public class GestionExamen {

    private static Hashtable listExamen = new Hashtable();


    public static void creerExamen(Integer idExamen, String title, double duree, Periode periode, Boolean estFini, Hashtable listEtudiantInscrit, ArrayList<Contrainte> listContrainte, Salle salle) {

        if(listExamen.containsKey(idExamen))
        {
            System.out.println("cet examen est déjà planifié :"+idExamen +" existe deja");
        }
        else{
            Examen e = new Examen(idExamen,title,duree,periode,estFini,listEtudiantInscrit,listContrainte,salle);
            listExamen.put(e.getIdExamen(), e);
        }
    }

    public void supprimer(Integer e) {
        try {
            listExamen.remove(e);
        }
        catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }

    public void modifierExamen(Integer idExamen, String title, double duree, Periode periode, Boolean estFini, Hashtable listEtudiantInscrit, ArrayList<Contrainte> listContrainte, Salle salle ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(
                    idExamen,
                    title,
                    duree,
                    periode,
                    estFini,
                    listEtudiantInscrit,
                    listContrainte,
                    salle);


            listExamen.put(e.getIdExamen(), e);

        } else
            System.out.println(idExamen + " n'existe pas");
    }
    public void modifierExamen(Integer idExamen, Integer newIdExamen ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(newIdExamen,
                    ((Examen)listExamen.get(idExamen)).getTitle(),
                    ((Examen)listExamen.get(idExamen)).getDuree(),
                    ((Examen)listExamen.get(idExamen)).getPeriode(),
                    ((Examen)listExamen.get(idExamen)).getEstFini(),
                    ((Examen)listExamen.get(idExamen)).getListEtudiantInscrit(),
                    ((Examen)listExamen.get(idExamen)).getListContrainte(),
                    ((Examen)listExamen.get(idExamen)).getSalle());


            listExamen.put(e.getIdExamen(), e);
            supprimer(idExamen);
        } else
            System.out.println(idExamen + " n'existe pas");
    }
    public void modifierExamen(Integer idExamen, String title ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(
                    ((Examen)listExamen.get(idExamen)).getIdExamen(),
                    title,
                    ((Examen)listExamen.get(idExamen)).getDuree(),
                    ((Examen)listExamen.get(idExamen)).getPeriode(),
                    ((Examen)listExamen.get(idExamen)).getEstFini(),
                    ((Examen)listExamen.get(idExamen)).getListEtudiantInscrit(),
                    ((Examen)listExamen.get(idExamen)).getListContrainte(),
                    ((Examen)listExamen.get(idExamen)).getSalle());


            listExamen.put(e.getIdExamen(), e);

        } else
            System.out.println(idExamen + " n'existe pas");
    }
    public void modifierExamen(Integer idExamen, double duree ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(
                    ((Examen)listExamen.get(idExamen)).getIdExamen(),
                    ((Examen)listExamen.get(idExamen)).getTitle(),
                    duree,
                    ((Examen)listExamen.get(idExamen)).getPeriode(),
                    ((Examen)listExamen.get(idExamen)).getEstFini(),
                    ((Examen)listExamen.get(idExamen)).getListEtudiantInscrit(),
                    ((Examen)listExamen.get(idExamen)).getListContrainte(),
                    ((Examen)listExamen.get(idExamen)).getSalle());


            listExamen.put(e.getIdExamen(), e);

        } else
            System.out.println(idExamen + " n'existe pas");
    }
    public void modifierExamen(Integer idExamen, Periode periode ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(
                    ((Examen)listExamen.get(idExamen)).getIdExamen(),
                    ((Examen)listExamen.get(idExamen)).getTitle(),
                    ((Examen)listExamen.get(idExamen)).getDuree(),
                    periode,
                    ((Examen)listExamen.get(idExamen)).getEstFini(),
                    ((Examen)listExamen.get(idExamen)).getListEtudiantInscrit(),
                    ((Examen)listExamen.get(idExamen)).getListContrainte(),
                    ((Examen)listExamen.get(idExamen)).getSalle());


            listExamen.put(e.getIdExamen(), e);

        } else
            System.out.println(idExamen + " n'existe pas");
    }
    public void modifierExamen(Integer idExamen, Boolean estFini ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(
                    ((Examen)listExamen.get(idExamen)).getIdExamen(),
                    ((Examen)listExamen.get(idExamen)).getTitle(),
                    ((Examen)listExamen.get(idExamen)).getDuree(),
                    ((Examen)listExamen.get(idExamen)).getPeriode(),
                    estFini,
                    ((Examen)listExamen.get(idExamen)).getListEtudiantInscrit(),
                    ((Examen)listExamen.get(idExamen)).getListContrainte(),
                    ((Examen)listExamen.get(idExamen)).getSalle());


            listExamen.put(e.getIdExamen(), e);

        } else
            System.out.println(idExamen + " n'existe pas");
    }
    public void modifierExamen(Integer idExamen, Hashtable listEtudiantInscrit ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(
                    ((Examen)listExamen.get(idExamen)).getIdExamen(),
                    ((Examen)listExamen.get(idExamen)).getTitle(),
                    ((Examen)listExamen.get(idExamen)).getDuree(),
                    ((Examen)listExamen.get(idExamen)).getPeriode(),
                    ((Examen)listExamen.get(idExamen)).getEstFini(),
                    listEtudiantInscrit,
                    ((Examen)listExamen.get(idExamen)).getListContrainte(),
                    ((Examen)listExamen.get(idExamen)).getSalle());


            listExamen.put(e.getIdExamen(), e);

        } else
            System.out.println(idExamen + " n'existe pas");
    }
    public void modifierExamen(Integer idExamen, ArrayList<Contrainte> listContrainte ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(
                    ((Examen)listExamen.get(idExamen)).getIdExamen(),
                    ((Examen)listExamen.get(idExamen)).getTitle(),
                    ((Examen)listExamen.get(idExamen)).getDuree(),
                    ((Examen)listExamen.get(idExamen)).getPeriode(),
                    ((Examen)listExamen.get(idExamen)).getEstFini(),
                    ((Examen)listExamen.get(idExamen)).getListEtudiantInscrit(),
                    listContrainte,
                    ((Examen)listExamen.get(idExamen)).getSalle());


            listExamen.put(e.getIdExamen(), e);

        } else
            System.out.println(idExamen + " n'existe pas");
    }
    public void modifierExamen(Integer idExamen, Salle salle ) {

        if (listExamen.containsKey(idExamen))
        {
            Examen e = new Examen(
                    ((Examen)listExamen.get(idExamen)).getIdExamen(),
                    ((Examen)listExamen.get(idExamen)).getTitle(),
                    ((Examen)listExamen.get(idExamen)).getDuree(),
                    ((Examen)listExamen.get(idExamen)).getPeriode(),
                    ((Examen)listExamen.get(idExamen)).getEstFini(),
                    ((Examen)listExamen.get(idExamen)).getListEtudiantInscrit(),
                    ((Examen)listExamen.get(idExamen)).getListContrainte(),
                    salle);


            listExamen.put(e.getIdExamen(), e);

        } else
            System.out.println(idExamen + " n'existe pas");
    }



}
