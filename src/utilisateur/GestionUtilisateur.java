package utilisateur;


import salle.Salle;
import promotion.Promotion;

import java.util.Hashtable;

/**
 * The type Gestion utilisateur.
 */
public class GestionUtilisateur {

    private static Hashtable listEtudiant ;
    private static Hashtable listScolarite ;
    private static Hashtable listSecretariat ;


    /**
     * Creer etudiant.
     *
     * @param nom            the nom
     * @param prenom         the prenom
     * @param email          the email
     * @param numeroEtudiant the numero etudiant
     * @param filiere        the filiere
     */
    public static void creerEtudiant(String nom, String prenom, String email, String numeroEtudiant, Promotion filiere) {
        if (listEtudiant.containsKey(numeroEtudiant))
            System.out.println(nom +" "+prenom +"est deja dans la liste des etudiant");
        else
            {
                Etudiant e = new Etudiant(nom, prenom, email, numeroEtudiant, filiere);
                listEtudiant.put(e.getNumeroEtudiant(), e);
            }
    }

    /**
     * Creer scolarite.
     *
     * @param nom         the nom
     * @param prenom      the prenom
     * @param email       the email
     * @param idScolarite the id scolarite
     */
    public static void creerScolarite(String nom,String prenom,String email,Integer idScolarite) {
        if (listScolarite.containsKey(idScolarite))
            System.out.println(nom +" "+prenom +"est deja dans la liste de la scolarite");
        else
            {
                Scolarite e = new Scolarite(nom, prenom, email, idScolarite);
                listScolarite.put(e.getIdScolarite(), e);
            }
    }

    /**
     * Creer secretairiat.
     *
     * @param nom           the nom
     * @param prenom        the prenom
     * @param email         the email
     * @param idSecretariat the id secretariat
     */
    public static void creerSecretairiat(String nom,String prenom,String email,Integer idSecretariat) {
        if (listSecretariat.containsKey(idSecretariat))
            System.out.println(nom +" "+prenom +"est deja dans la liste du secretariat");
        else
            {
                Secretariat e = new Secretariat(nom, prenom, email, idSecretariat);
                listSecretariat.put(e.getIdSecretariat(), e);
            }
    }


    /**
     * Supprimer etudiant.
     *
     * @param e the e
     */
    public static void supprimerEtudiant(String e) {
        try {
            listEtudiant.remove(e);
        }
        catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }

    /**
     * Supprimer scolarite.
     *
     * @param e the e
     */
    public static void supprimerScolarite(Integer e) {
        try {
            listScolarite.remove(e);
        }
        catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }

    /**
     * Supprimer secretariat.
     *
     * @param e the e
     */
    public static void supprimerSecretariat(Integer e) {
        try {
            listSecretariat.remove(e);
        }
        catch(Exception a)
        {
            System.out.println("un probleme est survenue lors de la suppression");
        }

    }


    /**
     * Modifier etudiant.
     *
     * @param nom            the nom
     * @param prenom         the prenom
     * @param email          the email
     * @param numeroEtudiant the numero etudiant
     * @param filiere        the filiere
     */
    public void modifierEtudiant(String nom,String prenom,String email,String numeroEtudiant,Promotion filiere) {

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

    /**
     * Modifier etudiant.
     *
     * @param numeroEtudiant the numero etudiant
     * @param nom            the nom
     * @param prenom         the prenom
     */
    public void modifierEtudiant(String numeroEtudiant,String nom,String prenom) {

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

    /**
     * Modifier etudiant.
     *
     * @param numeroEtudiant the numero etudiant
     * @param email          the email
     */
    public void modifierEtudiant(String numeroEtudiant,String email) {
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

    /**
     * Modifier etudiant.
     *
     * @param numeroEtudiant the numero etudiant
     * @param filiere        the filiere
     */
    public void modifierEtudiant(String numeroEtudiant,Promotion filiere) {
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

    /**
     * Modifier etudiant.
     *
     * @param numeroEtudiant    the numero etudiant
     * @param newNumeroEtudiant the new numero etudiant
     */
    public void modifierEtudiant(String numeroEtudiant, String newNumeroEtudiant) {
        if (listEtudiant.containsKey(numeroEtudiant))
        {
            Etudiant e = new Etudiant(  ((Etudiant)listEtudiant.get(numeroEtudiant)).getNom(),
                    ((Etudiant)listEtudiant.get(numeroEtudiant)).getPrenom(),
                    ((Etudiant)listEtudiant.get(numeroEtudiant)).getEmail(),
                    newNumeroEtudiant,
                    ((Etudiant)listEtudiant.get(numeroEtudiant)).getFiliere());

            listEtudiant.put(e.getNumeroEtudiant(), e);
            supprimerEtudiant(numeroEtudiant);
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
     * @param idScolarite the id scolarite
     */
    public void modifierScolarite(String nom,String prenom,String email,Integer idScolarite) {
        if (listScolarite.containsKey(idScolarite))
        {
            Scolarite e = new Scolarite(    nom,
                                            prenom,
                                            email,
                                            idScolarite);


            listScolarite.put(e.getIdScolarite(), e);

        }
        else
            System.out.println(idScolarite+" n'exite pas");
    }

    /**
     * Modifier scolarite.
     *
     * @param idScolarite the id scolarite
     * @param nom         the nom
     * @param prenom      the prenom
     */
    public void modifierScolarite(Integer idScolarite,String nom,String prenom) {
        if (listScolarite.containsKey(idScolarite))
        {
            Scolarite e = new Scolarite(    nom,
                                            prenom,
                                            ((Scolarite)listScolarite.get(idScolarite)).getEmail(),
                                            idScolarite);


            listScolarite.put(e.getIdScolarite(), e);

        }
        else
            System.out.println(idScolarite+" n'exite pas");
    }

    /**
     * Modifier scolarite.
     *
     * @param idScolarite the id scolarite
     * @param email       the email
     */
    public void modifierScolarite(Integer idScolarite,String email) {
        if (listScolarite.containsKey(idScolarite))
    {
        Scolarite e = new Scolarite(    ((Scolarite)listScolarite.get(idScolarite)).getNom(),
                                        ((Scolarite)listScolarite.get(idScolarite)).getPrenom(),
                                        email,
                                        idScolarite);


        listScolarite.put(e.getIdScolarite(), e);

    }
    else
        System.out.println(idScolarite+" n'exite pas");
    }

    /**
     * Modifier scolarite.
     *
     * @param idScolarite    the id scolarite
     * @param newIdScolarite the new id scolarite
     */
    public void modifierScolarite(Integer idScolarite,Integer newIdScolarite) {
        if (listScolarite.containsKey(idScolarite))
        {
            Scolarite e = new Scolarite(    ((Scolarite)listScolarite.get(idScolarite)).getNom(),
                                            ((Scolarite)listScolarite.get(idScolarite)).getPrenom(),
                                            ((Scolarite)listScolarite.get(idScolarite)).getEmail(),
                                            newIdScolarite);


            listScolarite.put(e.getIdScolarite(), e);
            supprimerScolarite(idScolarite);
        }
        else
            System.out.println(idScolarite+" n'exite pas");
    }


    /**
     * Modifier secretariat.
     *
     * @param nom           the nom
     * @param prenom        the prenom
     * @param email         the email
     * @param idSecretariat the id secretariat
     */
    public void modifierSecretariat(String nom,String prenom,String email,Integer idSecretariat) {
        if (listSecretariat.containsKey(idSecretariat))
        {
            Secretariat e = new Secretariat(    nom,
                                                prenom,
                                                email,
                                                idSecretariat);


            listSecretariat.put(e.getIdSecretariat(), e);

        }
        else
            System.out.println(idSecretariat+" n'exite pas");
    }

    /**
     * Modifier secretariat.
     *
     * @param idSecretariat the id secretariat
     * @param nom           the nom
     * @param prenom        the prenom
     */
    public void modifierSecretariat(Integer idSecretariat,String nom,String prenom) {
        if (listSecretariat.containsKey(idSecretariat))
        {
            Secretariat e = new Secretariat(    nom,
                                                prenom,
                                                ((Secretariat)listSecretariat.get(idSecretariat)).getEmail(),
                                                idSecretariat);


            listSecretariat.put(e.getIdSecretariat(), e);

        }
        else
            System.out.println(idSecretariat+" n'exite pas");
    }

    /**
     * Modifier secretariat.
     *
     * @param idSecretariat the id secretariat
     * @param email         the email
     */
    public void modifierSecretariat(Integer idSecretariat,String email) {
        if (listSecretariat.containsKey(idSecretariat))
        {
            Secretariat e = new Secretariat(    ((Secretariat)listSecretariat.get(idSecretariat)).getNom(),
                                                ((Secretariat)listSecretariat.get(idSecretariat)).getPrenom(),
                                                email,
                                                idSecretariat);


            listSecretariat.put(e.getIdSecretariat(), e);

        }
        else
            System.out.println(idSecretariat+" n'exite pas");
    }

    /**
     * Modifier secretariat.
     *
     * @param idSecretariat    the id secretariat
     * @param newIdSecretariat the new id secretariat
     */
    public void modifierSecretariat(Integer idSecretariat,Integer newIdSecretariat) {
        if (listSecretariat.containsKey(idSecretariat))
        {
            Secretariat e = new Secretariat(    ((Secretariat)listSecretariat.get(idSecretariat)).getNom(),
                    ((Secretariat)listSecretariat.get(idSecretariat)).getPrenom(),
                    ((Secretariat)listSecretariat.get(idSecretariat)).getEmail(),
                    newIdSecretariat);


            listSecretariat.put(e.getIdSecretariat(), e);
            supprimerSecretariat(idSecretariat);
        }
        else
            System.out.println(idSecretariat+" n'exite pas");
    }





}
