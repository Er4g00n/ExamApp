package Salle;


import Utilisateur.Etudiant;

import java.util.Hashtable;


public  class GestionSalle {

    private static Hashtable listSalle = new Hashtable();


    public static void creerSalle(String nom, Integer capacite, Type type, Specificite specificite) {
        if (listSalle.containsKey(nom))
            System.out.println("la salle "+nom +" existe deja");

        else
            {
                Salle e = new Salle(nom, capacite, type, specificite);
                listSalle.put(e.getNom(), e);
            }
    }


    public static void supprimer(String e) {
        try {
            listSalle.remove(e);
        }
        catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }


    public static void modifierSalle(String nom, Integer capacite, Type type, Specificite specificite)  {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(nom,
                                capacite,
                                type,
                                specificite);

            listSalle.put(e.getNom(), e);
        }
        else
            System.out.println(nom +" n'existe pas");

    }
    public static void modifierSalle(String nom,String newname) {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(newname,
                                ((Salle)listSalle.get(nom)).getCapacite(),
                                ((Salle)listSalle.get(nom)).getType(),
                                ((Salle)listSalle.get(nom)).getSpecificite());

            listSalle.put(e.getNom(), e);
            supprimer(nom);
        } else
            System.out.println(nom + " n'existe pas");
    }
    public static void modifierSalle(String nom, Integer capacite) {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(nom,
                                capacite,
                                ((Salle)listSalle.get(nom)).getType(),
                                ((Salle)listSalle.get(nom)).getSpecificite());

            listSalle.put(e.getNom(), e);
        }
        else
            System.out.println(nom + " n'existe pas");

    }
    public static void modifierSalle(String nom,  Type type)  {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(nom,
                                ((Salle)listSalle.get(nom)).getCapacite(),
                                type,
                                ((Salle)listSalle.get(nom)).getSpecificite());

            listSalle.put(e.getNom(), e);
        }
        else
            System.out.println(nom +" n'existe pas");

    }
    public static void modifierSalle(String nom, Specificite specificite)  {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(nom,
                                ((Salle)listSalle.get(nom)).getCapacite(),
                                ((Salle)listSalle.get(nom)).getType(),
                                specificite);

            listSalle.put(e.getNom(), e);
        }
        else
            System.out.println(nom +" n'existe pas");

    }








}
