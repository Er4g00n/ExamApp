package connexion;
/**
 * Classe qui initialise la connexion à une base de données
 * Cette Classe contient toutes les méthodes qui interagissent avec la base de données
 */
import utilisateur.Etudiant;
import salle.Salle;
import promotion.Promotion;

import java.sql.*;

import static promotion.Promotion.getPromotions;
import static promotion.Promotion.nomToPromotion;

public class BDD {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    /**
     * Initialisation la connexion a une base de données
     */
    public BDD(){
        try{
            con = DriverManager.getConnection("jdbc:mariadb://er4goon.com/er4g_ExamApp","er4g_DevExamApp2","5Fo#ivMoexM9^kix");
            st = con.createStatement();

        }catch(Exception ex){
            System.out.println("Error is found to initialize DB :"+ex);
        }

        // Instancie une notification pour pouvoir afficher des notifications (Succès, Échec) lors des tentatives de connexion
        ConnexionController notification = new ConnexionController();
    }

    // ************************************************************************
    // Méthodes de la base de données
    // ************************************************************************


    // Récupère toutes les informations des étudiants
    public void getData(){
        try{
            rs = st.executeQuery("SELECT * FROM Etudiants INNER JOIN EtuListes ON Etudiants.idEtuListe = EtuListes.idEtuListe");
            System.out.println("Data from online Database :");
            while(rs.next()){
                String numEtudiant = rs.getString("numEtu");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String idEtuListe = rs.getString("idEtuListe");
                String libelle = rs.getString("libelle");

                System.out.println("[N°Etudiant : "+numEtudiant+" | Nom :"+nom+" | Prenom :"+prenom+" | idEtuListe :"+idEtuListe+" | Libelle :"+libelle+"]");
            }

        }catch(Exception ex){
            System.out.println("Error is found to getData :"+ex);
        }
    }

    // Vérifie les identifiants
    public boolean checkLogin(String email, String mdp){
        boolean login = false;
        try{
            String sql = "SELECT * FROM Personnels P WHERE email='"+email+"'";
            rs = st.executeQuery(sql);

            if (!rs.isBeforeFirst()) {
                ConnexionController notification = new ConnexionController();
                notification.notification("Cette adresse Email n'est pas enregistrée !", "INFORMATION", 1.0);
                return false;
            }

            while(rs.next()){
                String db_idPersonnel = rs.getString("idPersonnel");
                String db_email = rs.getString("email");
                String db_mdp = rs.getString("mdp");

                if (email.toLowerCase().equals(db_email.toLowerCase()) && mdp.equals(db_mdp)){
                    login = true;
                    ConnexionController notification = new ConnexionController();
                    notification.notification("Connexion réussi !", "SUCCES", 1.0);
                }
                else {
                    ConnexionController notification = new ConnexionController();
                    notification.notification("Erreur identifiants !", "ERROR", 1.0);
                }
            }
            st.close();
            System.out.println(login);


        }catch(Exception ex){
            System.out.println("Error is found to loadPromotions :"+ex);
        }
        return login;
    }

    // Récupère dans la base de données les Promotions et les initialisent
    public void loadPromotions(){
        try{
            String sql = "SELECT * FROM EtuListes";
            rs = st.executeQuery(sql);

            while(rs.next()){
                String db_idEtuListe = rs.getString("idEtuListe");
                String db_libelle = rs.getString("libelle");
                new Promotion(db_idEtuListe, db_libelle);
            }

        }catch(Exception ex){
            System.out.println("Here Error is found to loadPromotions :"+ex);
        }
    }

    // Récupère dans la base de données les Étudiants et les initialisent
    public void loadEtudiants(){
        try{
            String sql = "SELECT * FROM Etudiants INNER JOIN EtuListes ON Etudiants.idEtuListe = EtuListes.idEtuListe";
            rs = st.executeQuery(sql);

            while(rs.next()){
                String db_idEtuListe = rs.getString("idEtuListe");
                String db_numEtu = rs.getString("numEtu");
                String db_nom = rs.getString("nom");
                String db_prenom = rs.getString("prenom");
                String db_email = rs.getString("email");
                String db_filliere = rs.getString("libelle");

                Promotion filliere = nomToPromotion(db_filliere);

                Etudiant a = new Etudiant(db_nom, db_prenom, db_email, db_numEtu, filliere, null);

                for (Promotion promotion : getPromotions()) {
                    if(promotion.getNom().equals(db_idEtuListe)){
                        promotion.ajouterEtudiant(a);
                    }
                }
            }

        }catch(Exception ex){
            System.out.println("Error is found to loadEtudiants :"+ex);
        }
    }

    // Récupère dans la base de données les Salles et les initialisent
    public void loadSalles(){
        try{
            String sql = "SELECT * FROM Salles";
            rs = st.executeQuery(sql);

            while(rs.next()){
                String db_idSalle = rs.getString("idSalle");
                String db_libelle = rs.getString("libelle");
                String db_capacite = rs.getString("capacite");
                new Salle(db_libelle, Integer.parseInt(db_capacite));
            }

        }catch(Exception ex){
            System.out.println("Error is found to loadSalles :"+ex);
        }
    }

    // Récupère dans la base de données les Examens et les initialisent
    public void loadExamens(){
        try{
            String sql = "SELECT * FROM Examens INNER JOIN Concerne ON Examens.idExamen = Concerne.idExamen";
            rs = st.executeQuery(sql);

            while(rs.next()){
                int db_idExamen = Integer.parseInt(rs.getString("idExamen"));
                String db_libelle = rs.getString("libelle");
                String db_duree = rs.getString("duree");
                String db_idSalle = rs.getString("idSalle");
                String db_idExamenType = rs.getString("idExamenType");
                String db_date = rs.getString("date");
                String db_idEtuListe = rs.getString("idEtuListe");

                for (Promotion promotion : getPromotions()) {
                    if(promotion.getNom().equals(db_idEtuListe)){
                       // new Examen(db_idExamen, db_libelle, promotion.getNbetu(),1);
                    }
                }
            }

        }catch(Exception ex){
            System.out.println("Error is found to loadExamens :"+ex);
        }

    }


    public void modifierEtudiant(String numEtu, String nom, String prenom){
        try{
            String query = "UPDATE Etudiants SET nom = ?, prenom = ? where numEtu = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString   (3, numEtu);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, prenom);
            preparedStmt.executeUpdate();
            con.close();

        }catch(Exception ex){
            System.out.println("Error is found to modify Student :"+ex);
        }
    }


    public void ajouterEtudiant(String numEtu, String nom, String prenom, Integer idEtuListe) {
        try{
            String query = "INSERT INTO Etudiants (numEtu, nom, prenom, idEtuListe) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, numEtu);
            preparedStmt.setString(2, nom);
            preparedStmt.setString(3, prenom);
            preparedStmt.setInt(4, idEtuListe);
            preparedStmt.executeUpdate();
            con.close();

        }catch(Exception ex){
            System.out.println("Error is found to add Student :"+ex);
        }
    }

    // Cherche dans la bdd l'id de la promotion correspondant à son nom
    public int getIDEtuListe(String libellePromotion){
        String x = null;
        try{
            String query = "SELECT idEtuListe FROM EtuListes WHERE libelle = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, libellePromotion);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                x = rs.getString(1);
                System.out.println(x);
            }
        }catch(Exception ex){
            System.out.println("Error is found to getIDEtuListe :"+ex);
        }
        return Integer.parseInt(x);

    }


    public void supprimerPromotion(String libellePromotion) {
        try{
            int idEtuListe = getIDEtuListe(libellePromotion);
            String query = "DELETE FROM EtuListes WHERE idEtuListe = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, String.valueOf(idEtuListe));
            preparedStmt.executeUpdate();
            con.close();

        }catch(Exception ex){
            System.out.println("Error is found to add Student :"+ex);
        }
    }
}