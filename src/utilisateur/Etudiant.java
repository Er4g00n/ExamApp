package utilisateur;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import promotion.Promotion;

public class Etudiant extends Utilisateur {

    private String numeroEtudiant;
    private Promotion filiere;

    private CheckBox statut;
    private Button modifier;


    public Etudiant(String nom,String prenom,String email,String numeroEtudiant,Promotion filiere){
        super(nom,prenom,email);
        this.filiere = filiere;
        this.numeroEtudiant = numeroEtudiant;

        this.statut = new CheckBox();
        //this.statut.setOnAction(event -> EtudiantListeStageController.updateNumberSelectedEtudiant((Button) (this.statut.getScene().lookup("#etuDel"))));
        this.modifier = new Button("Modifier");
        this.modifier.setOnAction(new EtudiantModifierEventHandler(this));

    }



    public String getNumeroEtudiant() {

        return this.numeroEtudiant;
    }
    public void setNumeroEtudiant(String numeroEtudiant) {

        this.numeroEtudiant = numeroEtudiant;
    }
    public Promotion getFiliere() {

        return this.filiere;
    }
    public void setFiliere(Promotion filiere) {

        this.filiere = filiere;
    }

    public CheckBox getStatut() {
        return statut;
    }

    public Button getModifier() {
        return modifier;
    }

    public String toString() {
        return super.toString() +" numero etudiant: "+ getNumeroEtudiant()+" filiere: "+getFiliere()+" }";
    }
    
    
}
