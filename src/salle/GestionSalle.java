package salle;

import java.util.Hashtable;


public class GestionSalle {

    private static final Hashtable listSalle = new Hashtable();


    public static void creerSalle(String nom, Integer capacite, String type) {
        if (listSalle.containsKey(nom))
            System.out.println("la salle " + nom + " existe deja");

        else {
            Salle e = new Salle(nom, capacite, type);
            listSalle.put(e.getNom(), e);
        }
    }


    public static void supprimer(String e) {
        try {
            listSalle.remove(e);
        } catch (Exception a) {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }


    public static void modifierSalle(String nom, Integer capacite, String type) {
        if (listSalle.containsKey(nom)) {
            Salle e = new Salle(nom, capacite, type);

            listSalle.put(e.getNom(), e);
        } else
            System.out.println(nom + " n'existe pas");

    }

}
