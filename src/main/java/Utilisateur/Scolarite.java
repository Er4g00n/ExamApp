package Utilisateur;

public class Scolarite extends Utilisateur {

    private Integer idScolarite;


    public Scolarite(String nom,String prenom,String email,Integer idScolarite) {
        super(nom, prenom, email);
        this.idScolarite = idScolarite;
    }

    public Integer getIdScolarite() {
        return this.idScolarite;
    }
    public void setIdScolarite(Integer idScolarite) {
        this.idScolarite = idScolarite;
    }

    public String toString() {
        return super.toString()+" idScolarite: "+ getIdScolarite()+" }";
    }
}
