package Utilisateur;

public class Secretariat extends Utilisateur {

    private Integer idSecretariat;


    public Secretariat( String nom, String prenom, String email, Integer idSecretariat) {
        super(nom, prenom, email);
        this.idSecretariat = idSecretariat;
    }

    public Integer getIdSecretariat() {
        return this.idSecretariat;
    }
    public void setIdSecretariat(Integer idSecretariat) {
        this.idSecretariat = idSecretariat;
    }

    public String toString() {
        return super.toString() +" idSecretariat: "+ getIdSecretariat()+" }";
    }
    
}
