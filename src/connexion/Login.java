package connexion;

public class Login {
    public static String nom;
    public static String prenom;
    public static String email;
    public static int idPersonnelType;
    public static String personnelType;

    public Login(String nom, String prenom, String email, int idPersonnelType) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.idPersonnelType = idPersonnelType;

        switch(idPersonnelType) {
            case 1:
                this.personnelType = "Secretariat";
                break;
            case 2:
                this.personnelType = "Scolarite";
                break;
            case 3:
                this.personnelType = "Administrateur";
                break;
            default:
                this.personnelType = "Secretariat";
        }
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        Login.nom = nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static void setPrenom(String prenom) {
        Login.prenom = prenom;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Login.email = email;
    }

    public static int getIdPersonnelType() {
        return idPersonnelType;
    }

    public static void setIdPersonnelType(int idPersonnelType) {
        Login.idPersonnelType = idPersonnelType;
    }

    public static String getPersonnelType() {
        return personnelType;
    }
}
