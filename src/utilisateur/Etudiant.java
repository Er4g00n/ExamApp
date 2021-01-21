package utilisateur;

import abstracts.AbstractPersistable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import promotion.Promotion;

public class Etudiant extends Utilisateur {

    private String numeroEtudiant;
    private Promotion filiere;
    protected Long id;
    private static ObservableList<Etudiant> listEtudiant = FXCollections.observableArrayList();

    private CheckBox statut;
    private Button modifier;


    public Etudiant(String nom,String prenom,String email,String numeroEtudiant,Promotion filiere, Long id){
        super(nom,prenom,email);
        this.filiere = filiere;
        this.numeroEtudiant = numeroEtudiant;
        listEtudiant.add(this);

        this.statut = new CheckBox();
        this.statut.setOnAction(event -> EtudiantListeStageController.updateNumberSelectedEtudiant((Button) (this.statut.getScene().lookup("#etuDel"))));
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
    @PlanningId
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }


    public static ObservableList<Etudiant> getListEtudiant() {
        return listEtudiant;
    }

    public static void setListEtudiant(ObservableList<Etudiant> listEtudiant) {
        Etudiant.listEtudiant = listEtudiant;
    }
}
