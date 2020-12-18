package Salle;


import java.util.Hashtable;


public abstract class GestionSalle {

    private static Hashtable listSalle = new Hashtable();



    public static void creer(String nom, Integer capacite, Type type, Specificite specificite) {
        Salle e = new Salle(nom, capacite, type, specificite);
        addSalle(e);
    }

    public static void modifier(String nom, Integer capacite, Type type, Specificite specificite)  {
        if (listSalle.containsKey(nom))
             creer(nom, capacite, type, specificite);
        else
            System.out.println(nom +" n'existe pas");

    }
    public static void modifier(String nom,String newname) {
        if (listSalle.containsKey(nom)) {
            creer(newname, getCapacite(nom), getType(nom), getSpecificite(nom));
            supprimer(nom);
        } else
            System.out.println(nom + " n'existe pas");
    }

    public static void modifier(String nom, Integer capacite) {
        if (listSalle.containsKey(nom))
            creer(nom, capacite, getType(nom), getSpecificite(nom));
        else
            System.out.println(nom + " n'existe pas");

    }
    public static void modifier(String nom,  Type type)  {
        if (listSalle.containsKey(nom))
            creer(nom,getCapacite(nom), type, getSpecificite(nom));
        else
            System.out.println(nom +" n'existe pas");

    }
    public static void modifier(String nom, Specificite specificite)  {
        if (listSalle.containsKey(nom))
            creer(nom, getCapacite(nom), getType(nom), specificite);
        else
            System.out.println(nom +" n'existe pas");

    }



        public static void supprimer(String e) {
    try {
        listSalle.remove(getNom(e));
    }
    catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }

    public static void addSalle(Salle e) {

        listSalle.put(e.getNom(), e);
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

    public static String getNom(String nom) {
        try {
            return ((Salle) listSalle.get(nom)).getNom();

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
