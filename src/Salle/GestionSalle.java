package Salle;


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


    public static void modifierSalle(String nom, Integer capacite, Type type, Specificite specificite)  {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(nom, capacite, type, specificite);
            listSalle.put(e.getNom(), e);
        }
        else
            System.out.println(nom +" n'existe pas");

    }
    public static void modifierSalle(String nom,String newname) {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(newname, getCapacite(nom), getType(nom), getSpecificite(nom));
            listSalle.put(e.getNom(), e);
            supprimer(nom);
        } else
            System.out.println(nom + " n'existe pas");
    }
    public static void modifierSalle(String nom, Integer capacite) {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(nom, capacite, getType(nom), getSpecificite(nom));
            listSalle.put(e.getNom(), e);
        }
        else
            System.out.println(nom + " n'existe pas");

    }
    public static void modifierSalle(String nom,  Type type)  {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(nom,getCapacite(nom), type, getSpecificite(nom));
            listSalle.put(e.getNom(), e);
        }
        else
            System.out.println(nom +" n'existe pas");

    }
    public static void modifierSalle(String nom, Specificite specificite)  {
        if (listSalle.containsKey(nom))
        {
            Salle e = new Salle(nom, getCapacite(nom), getType(nom), specificite);
            listSalle.put(e.getNom(), e);
        }
        else
            System.out.println(nom +" n'existe pas");

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


    public static Salle getSalle(String nom) {
        try {
            return (Salle)listSalle.get(nom);
        }
        catch (Exception e)
            {
                System.out.println(nom + " n'existe pas");
                return null;
            }
    }
    public static Specificite getSpecificite(String nom) {
        try {
            return ((Salle)listSalle.get(nom)).getSpecificite();
        }
        catch(Exception e )
            {
                System.out.println(nom + " n'existe pas") ;
                return null;
            }
    }
    public static Type getType(String nom) {
        try {
            return ((Salle)listSalle.get(nom)).getType();
        }
        catch(Exception e )
            {
                System.out.println(nom + " n'existe pas") ;
                return null;
            }
    }
    public static Integer getCapacite(String nom) {
      try {
          return ((Salle) listSalle.get(nom)).getCapacite();
      }
      catch(Exception e )
          {
              System.out.println(nom + " n'existe pas") ;
              return null;
          }

    }



}
