package utilisateur;


import javafx.collections.ObservableList;
import promotion.Promotion;

import java.util.Hashtable;

/**
 * The type Gestion utilisateur.
 */
public class GestionUtilisateur {
    private static Hashtable listEtudiant;
    private static Hashtable listScolarite;
    private static Hashtable listSecretariat;


    /**
     * Creer etudiant.
     *
     * @param nom            the nom
     * @param prenom         the prenom
     * @param email          the email
     * @param numeroEtudiant the numero etudiant
     * @param filiere        the filiere
     */
    public static Etudiant creerEtudiant(String nom, String prenom, String email, String numeroEtudiant, Promotion filiere, Long id) {
        Etudiant e = new Etudiant(nom, prenom, email, numeroEtudiant, filiere, id);
        return e;
    }

    /**
     * Creer scolarite.
     *
     * @param nom         the nom
     * @param prenom      the prenom
     * @param email       the email
     */
    public static void creerScolarite(String nom,String prenom,String email) {
        if (listScolarite.containsKey(email))
            System.out.println("cet email"+email+" est deja prise ou "+nom +" "+prenom +"est deja dans la liste de la scolarite");
        else
            {
                Scolarite e = new Scolarite(nom, prenom, email);
                listScolarite.put(e.getEmail(), e);
            }
    }

    /**
     * Creer secretairiat.
     *
     * @param nom           the nom
     * @param prenom        the prenom
     * @param email         the email
     */
    public static void creerSecretairiat(String nom,String prenom,String email) {
        if (listSecretariat.containsKey(email))
            System.out.println("cet email"+email+" est deja prise ou "+nom +" "+prenom +"est deja dans la liste du secretariat");
        else
            {
                Secretariat e = new Secretariat(nom, prenom, email);
                listSecretariat.put(e.getEmail(), e);
            }
    }


    /**
     * Supprimer etudiant.
     *
     * @param e the numero etudiant
     */
    public static void supprimerEtudiant(Integer e) {
        if (listEtudiant.containsKey(e))
            listEtudiant.remove(e);

         else
                 System.out.println(e+" ne correspond a aucun etudiant");

    }

    /**
     * Supprimer scolarite.
     *
     * @param e the email
     */
    public static void supprimerScolarite(String e) {
        if (listScolarite.containsKey(e))
            listScolarite.remove(e);

        else
            System.out.println(e+" ne correspond a aucun membre");


    }

    /**
     * Supprimer secretariat.
     *
     * @param e the email
     */
    public static void supprimerSecretariat(String e) {
        if (listSecretariat.containsKey(e))
            listSecretariat.remove(e);

        else

            System.out.println(e+" ne correspond a aucun membre");


    }


    /**
     * Modifier etudiant.
     *
     * @param nom            the nom
     * @param prenom         the prenom
     * @param email          the email
     * @param numeroEtudiant the numero etudiant
     */
    public void modifierEtudiant(String nom,String prenom,String email,Integer numeroEtudiant) {

        if (listEtudiant.containsKey(numeroEtudiant))
        {
//            Etudiant e = new Etudiant(  nom,
//                                        prenom,
//                                        email,
//                                        numeroEtudiant);
//            listEtudiant.put(e.getNumeroEtudiant(), e);
        }
        else
            System.out.println(nom +" n'existe pas");

    }

    /**
     * Modifier etudiant.
     *
     * @param numeroEtudiant    the numero etudiant
     * @param newNumeroEtudiant the new numero etudiant
     */
    public void modifierEtudiant(Integer numeroEtudiant, Integer newNumeroEtudiant) {
        if (listEtudiant.containsKey(numeroEtudiant))
        {
//            Etudiant e = new Etudiant(  ((Etudiant)listEtudiant.get(numeroEtudiant)).getNom(),
//                    ((Etudiant)listEtudiant.get(numeroEtudiant)).getPrenom(),
//                    ((Etudiant)listEtudiant.get(numeroEtudiant)).getEmail(),
//                    newNumeroEtudiant,
//                    ((Etudiant)listEtudiant.get(numeroEtudiant)).getFiliere());
//
//            listEtudiant.put(e.getNumeroEtudiant(), e);
//            supprimerEtudiant(numeroEtudiant);
        }
        else
            System.out.println(numeroEtudiant+" n'exite pas");
    }


    /**
     * Modifier scolarite.
     *
     * @param nom         the nom
     * @param prenom      the prenom
     * @param email       the email
     */
    public void modifierScolarite(String nom,String prenom,String email) {
        if (listScolarite.containsKey(email))
        {
            Scolarite e = new Scolarite(    nom,
                                            prenom,
                                            email,
                                            ((Scolarite)listScolarite.get(email)).getIdScolarite());


            listScolarite.put(e.getEmail(), e);

        }
        else
            System.out.println(email+" ne correspond a aucun membre");
    }

    /**
     * Modifier scolarite.
     *
     * @param email    the email
     * @param newEmail the new email
     */
    public void modifierScolarite(String email,String newEmail) {
        if (listScolarite.containsKey(email))
        {
            Scolarite e = new Scolarite(    ((Scolarite)listScolarite.get(email)).getNom(),
                                            ((Scolarite)listScolarite.get(email)).getPrenom(),
                                            newEmail,
                                            ((Scolarite)listScolarite.get(email)).getIdScolarite());


            listScolarite.put(e.getEmail(), e);
            supprimerScolarite(email);
        }
        else
            System.out.println(email +" ne correspond a aucun membre");
    }


    /**
     * Modifier secretariat.
     *
     * @param nom           the nom
     * @param prenom        the prenom
     * @param email         the email
     */
    public void modifierSecretariat(String nom,String prenom,String email) {
        if (listSecretariat.containsKey(email))
        {
            Secretariat e = new Secretariat(    nom,
                                                prenom,
                                                email,
                                                ((Secretariat)listSecretariat.get(email)).getIdSecretariat());


            listSecretariat.put(e.getEmail(), e);

        }
        else
            System.out.println(email +" ne correspond a aucun membre");
    }

    /**
     * Modifier secretariat.
     *
     * @param email   the email
     * @param newEmail the new email
     */
    public void modifierSecretariat(String email,String newEmail) {
        if (listSecretariat.containsKey(email))
        {
            Secretariat e = new Secretariat(    ((Secretariat)listSecretariat.get(email)).getNom(),
                    ((Secretariat)listSecretariat.get(email)).getPrenom(),
                    newEmail,
                    ((Secretariat)listSecretariat.get(email)).getIdSecretariat());


            listSecretariat.put(e.getEmail(), e);
            supprimerSecretariat(email);
        }
        else
            System.out.println(email +" ne correspond a aucun membre");
    }





}
