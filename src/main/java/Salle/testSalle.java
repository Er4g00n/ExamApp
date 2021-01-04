package Salle;

import static Salle.GestionSalle.*;


public class testSalle {
    public static void main(String[] args) {
        System.out.println("creation d'une salle:");
        creerSalle("A13",40,Type.Amphitheatre,Specificite.Reunion);
        System.out.println((listSalle.get("A13")).toString());

        System.out.println("modification du nom: ");
        modifierSalle("A13","A14");
        System.out.println((listSalle.get("A14")).toString());
        try {
            System.out.println((listSalle.get("A13")).toString());
        }catch (Exception e){
            System.out.println("A13 n'existe plus:");
        }

        System.out.println("modification de la capacite:");
        modifierSalle("A14",20);
        System.out.println((listSalle.get("A14")).toString());

        System.out.println("modification du type:");
        modifierSalle("A14",Type.CRL);
        System.out.println((listSalle.get("A14")).toString());

        System.out.println("modification de la specificite:");
        modifierSalle("A14",Specificite.Anglais);
        System.out.println((listSalle.get("A14")).toString());

        System.out.println("modification de tout les attributs:");
        modifierSalle("A14",40,Type.Amphitheatre,Specificite.Reunion);
        System.out.println((listSalle.get("A14")).toString());

        System.out.println("suppression de la salle:");
        supprimer("A14");
        try {
            System.out.println((listSalle.get("A14")).toString());
        }catch (Exception e){
            System.out.println("A14 n'existe plus");
        }

        System.out.println("verification de l'impossibilité de supprimer une salle qui n'existe pas:");
        supprimer("A14");

        System.out.println("verification de l'impossibilité de modifier une salle qui n'existe pas:");
        modifierSalle("A14",Specificite.Anglais);
        try {
            System.out.println((listSalle.get("A14")).toString());
        }catch (Exception e){
            System.out.println("A14 n'existe plus");
        }


    }
}

