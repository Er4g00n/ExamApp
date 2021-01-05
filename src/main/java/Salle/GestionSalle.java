package Salle;

import java.util.Hashtable;


/**
 * The type Gestion salle.
 */
public class GestionSalle {

    private static final Hashtable listSalle = new Hashtable();


    /**
     * Creer salle.
     *
     * @param nom         the nom
     * @param capacite    the capacite
     * @param type        the type
     * @param specificite the specificite
     */
    public static void creerSalle(String nom, Integer capacite, Type type, Specificite specificite) {
        if (listSalle.containsKey(nom))
            System.out.println("la salle " + nom + " existe deja");

        else {
            Salle e = new Salle(nom, capacite, type, specificite);
            listSalle.put(e.getNom(), e);
        }
    }


    /**
     * Supprimer.
     *
     * @param nom the nom
     */
    public static void supprimer(String nom) {
        if (listSalle.containsKey(nom))
            listSalle.remove(nom);
        else
            System.out.println(nom + " n'existe pas");

    }


    /**
     * Modifier salle.
     *
     * @param nom         the nom
     * @param capacite    the capacite
     * @param type        the type
     * @param specificite the specificite
     */
    public static void modifierSalle(String nom, Integer capacite, Type type, Specificite specificite) {
        if (listSalle.containsKey(nom)) {
            Salle e = new Salle(nom,
                    capacite,
                    type,
                    specificite);

            listSalle.put(e.getNom(), e);
        } else
            System.out.println(nom + " n'existe pas");

    }

    /**
     * Modifier salle.
     *
     * @param nom     the nom
     * @param newname the newname
     */
    public static void modifierSalle(String nom, String newname) {
        if (listSalle.containsKey(nom)) {
            Salle e = new Salle(newname,
                    ((Salle) listSalle.get(nom)).getCapacite(),
                    ((Salle) listSalle.get(nom)).getType(),
                    ((Salle) listSalle.get(nom)).getSpecificite());

            listSalle.put(e.getNom(), e);
            supprimer(nom);
        } else
            System.out.println(nom + " n'existe pas");
    }


}
