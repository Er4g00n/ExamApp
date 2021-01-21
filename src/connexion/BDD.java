package connexion;
/**
 * Classe qui initialise la connexion à une base de données
 * Cette Classe contient toutes les méthodes qui interagissent avec la base de données
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import notification.GestionNotification;
import optaplanner.Epreuve;
import optaplanner.Examen;
import optaplanner.Initialisation;
import promotion.GestionPromotion;
import utilisateur.Etudiant;
import salle.Salle;
import promotion.Promotion;
import utilisateur.GestionUtilisateur;

import java.sql.*;
import java.util.*;

import static promotion.Promotion.*;

public class BDD {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public ObservableList<Epreuve> list2 = FXCollections.observableArrayList();
    private static Map<Epreuve, Set<Epreuve>> coincidenceMap;
    private static Map<Epreuve, Set<Epreuve>> exclusionMap;
    private static Map<Epreuve, Set<Epreuve>> afterMap;

    /**
     * Initialisation la connexion a une base de données
     */
    public BDD(){
        try{
            con = DriverManager.getConnection("jdbc:mariadb://er4goon.com/er4g_ExamApp","er4g_DevExamApp2","5Fo#ivMoexM9^kix");
            st = con.createStatement();
            refreshDB();

        }catch(Exception ex){
            System.out.println("Error is found to initialize DB :"+ex);
        }

        // Instancie une notification pour pouvoir afficher des notifications (Succès, Échec) lors des tentatives de connexion
        ConnexionController notification = new ConnexionController();
    }

    // ************************************************************************
    // Méthodes de la base de données
    // ************************************************************************

    public void refreshDB(){
        loadPromotions();
        loadEtudiants();
        loadExamens();
        loadSalles();
    }

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
                GestionNotification.notification("Cette adresse Email n'est pas enregistrée !", "INFORMATION", 1.0);
                return false;
            }

            while(rs.next()){
                String db_idPersonnel = rs.getString("idPersonnel");
                String db_email = rs.getString("email");
                String db_mdp = rs.getString("mdp");

                if (email.toLowerCase().equals(db_email.toLowerCase()) && mdp.equals(db_mdp)){
                    login = true;
                    ConnexionController notification = new ConnexionController();
                    GestionNotification.notification("Connexion réussi !", "SUCCES", 1.0);
                }
                else {
                    ConnexionController notification = new ConnexionController();
                    GestionNotification.notification("Erreur identifiants !", "ERROR", 1.0);
                }
            }
            System.out.println(login);


        }catch(Exception ex){
            System.out.println("Error is found to loadPromotions :"+ex);
        }
        return login;
    }

    // Récupère dans la base de données les Promotions et les initialisent
    public void loadPromotions(){
        clearPromotion();
        try{
            String sql = "SELECT * FROM EtuListes";
            rs = st.executeQuery(sql);
            while(rs.next()){
                String db_idEtuListe = rs.getString("idEtuListe");
                String db_libelle = rs.getString("libelle");
                GestionPromotion.ajouterPromotion(db_idEtuListe, db_libelle);
            }
        }catch(Exception ex){
            System.out.println("Error is found to loadPromotions :"+ex);
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
                String db_libelle = rs.getString("libelle");

                Promotion filliere = Promotion.getPromotionFromName(db_libelle);
                Etudiant a = GestionUtilisateur.creerEtudiant(db_nom, db_prenom, db_email, db_numEtu, filliere, Long.valueOf(db_numEtu));
                filliere.ajouterEtudiant(a);
            }

        }catch(Exception ex){
            System.out.println("Error is found to loadEtudiants :"+ex);
        }
    }

    // Récupère dans la base de données les Salles et les initialisent
    public void loadSalles(){
        try{
            String sql = "SELECT idSalle, Salles.libelle, capacite, SalleTypes.libelle  AS 'type' FROM Salles INNER JOIN SalleTypes ON Salles.idType = SalleTypes.idType";
            rs = st.executeQuery(sql);
            List<Salle> roomList = new ArrayList<>();

            while(rs.next()){
                String db_idSalle = rs.getString("idSalle");
                String db_libelle = rs.getString("libelle");
                int db_capacite = rs.getInt("capacite");
                String db_type = rs.getString("type");
                Salle salle = new Salle();
                salle.setId(Long.valueOf(db_idSalle));
                salle.setCapacite(db_capacite);
                salle.setPenalite(0);
                salle.setNom(db_libelle);
                salle.setType(db_type);
                roomList.add(salle);
            }
            ObservableList<Salle> list = FXCollections.observableArrayList(roomList);
            Salle.setSalles(list);
        }catch(Exception ex){
            System.out.println("Error is found to loadSalles :"+ex);
        }
    }

    // Récupère dans la base de données les Examens et les initialisent
    public void loadExamens(){
        try{
            String sql = "SELECT * FROM Examens";
            rs = st.executeQuery(sql);

            while(rs.next()){
                int db_idExamen = rs.getInt("idExamen");
                String db_libelle = rs.getString("libelle");
                String db_duree = rs.getString("duree");
                String db_idEtuListe = rs.getString("idPromotion");
                List<Epreuve> epreuveList = new ArrayList<>();
                coincidenceMap = new LinkedHashMap<>();
                exclusionMap = new LinkedHashMap<>();
                afterMap = new LinkedHashMap<>();

                for (Promotion promotion : getPromotions()) {
                    if(promotion.getIdFiliere().equals(db_idEtuListe)){
                      Epreuve epreuve = new Epreuve();
                      epreuve.setId((long)db_idExamen);
                      epreuve.setDuree(Integer.parseInt(db_duree));
                      epreuve.setNom(db_libelle);
                      List<Etudiant> topicStudentList = new ArrayList<>();
                      topicStudentList.addAll(promotion.getEtudiants());
                      epreuve.setEtudiantList(topicStudentList);
                      epreuve.setFrontLoadLarge(false);
                      epreuveList.add(epreuve);
                      coincidenceMap.put(epreuve, new HashSet<>());
                      exclusionMap.put(epreuve, new HashSet<>());
                      afterMap.put(epreuve, new HashSet<>());
                    }
                }
                list2.addAll(epreuveList);
                Epreuve.setExamens(list2);
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

        }catch(Exception ex){
            System.out.println("Error is found to modify Etudiant :"+ex);
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

        }catch(Exception ex){
            System.out.println("Error is found to add Etudiant :"+ex);
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
            }
        }catch(Exception ex){
            System.out.println("Error is found to getIDEtuListe :"+ex);
        }
        return Integer.parseInt(x);
    }

    // Suprime Promotion dans bdd
    public void supprimerPromotion(String libellePromotion) {
        try{
            int idEtuListe = getIDEtuListe(libellePromotion);
            String query = "DELETE FROM EtuListes WHERE idEtuListe = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, String.valueOf(idEtuListe));
            preparedStmt.executeUpdate();

        }catch(Exception ex){
            System.out.println("Error is found to add delete Promotion :"+ex);
        }
    }

    public void ajouterPromotion(String libellePromotion) {
        try{
            String query = "INSERT INTO EtuListes (libelle) VALUES (?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, libellePromotion);
            preparedStmt.executeUpdate();

        }catch(Exception ex){
            System.out.println("Error is found to add Promotion :"+ex);
        }
    }

    public void modifierPromotion(String idPromotion, String libellePromotion) {
        try{
            String query = "UPDATE EtuListes SET libelle = ? WHERE idEtuListe = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, libellePromotion);
            preparedStmt.setString(2, idPromotion);
            preparedStmt.executeUpdate();

        }catch(Exception ex){
            System.out.println("Error is found to add Promotion :"+ex);
        }
    }

    // Donne le dernière id de Promotion utilisé
    public int getLastIdPromotion(){
        int lastID = 0;

        try{
            String sql = "SELECT idEtuListe FROM EtuListes";
            rs = st.executeQuery(sql);

            while(rs.next()){
                lastID = rs.getInt("idEtuListe");
            }

        }catch(Exception ex){
            System.out.println("Error is found to getLastIdPromotion :"+ex);
        }
        return lastID;
    }

    public ObservableList<Object> getTypeSalle() {
        ObservableList<Object> type = FXCollections.observableArrayList();
        try{
            String sql = "SELECT libelle FROM SalleTypes";
            rs = st.executeQuery(sql);

            while(rs.next()){
                type.add(rs.getString("libelle"));
            }

        }catch(Exception ex){
            System.out.println("Error is found to getTypeSalle :"+ex);
        }
        return type;
    }

    // Suprime Salle dans bdd
    public void supprimerSalle(String nom) {
        try{
            String query = "DELETE FROM Salles WHERE libelle = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.executeUpdate();

        }catch(Exception ex){
            System.out.println("Error is found to add delete Salle :"+ex);
        }
    }

    public void modifierSalle(String nom, int capacite, int idType, int idSalle) {
        try{
            String query = "UPDATE Salles SET libelle = ?, capacite = ?, idType = ? WHERE idSalle = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setInt(2, capacite);
            preparedStmt.setInt(3, idType);
            preparedStmt.setInt(4, idSalle);
            preparedStmt.executeUpdate();

        }catch(Exception ex){
            System.out.println("Error is found to modify Salle :"+ex);
        }
    }

    public int getIdFromSalle(String libelle) {
        int idFromSalle = 0;

        try{
            String query = "SELECT idSalle FROM Salles WHERE libelle = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, libelle);
            preparedStmt.executeUpdate();
            while(rs.next()){
                idFromSalle = rs.getInt("idSalle");
            }

        }catch(Exception ex){
            System.out.println("Error is found to getIdFromSalle :"+ex);
        }
        return idFromSalle;
    }

    public int getIdTypeFromlibelle(String libelle) {
        int IdType = 0;
        try{
            String sql = "SELECT idType, libelle FROM SalleTypes";
            rs = st.executeQuery(sql);

            while(rs.next()){
                if (rs.getString("libelle").equals(libelle)){
                    IdType = rs.getInt("idType");
                }
            }
        }catch(Exception ex){
            System.out.println("Error is found to getIdTypeFromlibelle :"+ex);
        }
        return IdType;
    }


    public void ajouterSalle(String nom, int capacite, int idType) {
        try{
            String query = "INSERT INTO Salles (libelle, capacite, idType) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setInt(2, capacite);
            preparedStmt.setInt(3, idType);

            preparedStmt.executeUpdate();

        }catch(Exception ex){
            System.out.println("Error is found to add Salle :"+ex);
        }
    }

    public static Map<Epreuve, Set<Epreuve>> getCoincidenceMap() {
        return coincidenceMap;
    }

    public void setCoincidenceMap(Map<Epreuve, Set<Epreuve>> coincidenceMap) {
        this.coincidenceMap = coincidenceMap;
    }

    public static Map<Epreuve, Set<Epreuve>> getExclusionMap() {
        return exclusionMap;
    }

    public void setExclusionMap(Map<Epreuve, Set<Epreuve>> exclusionMap) {
        this.exclusionMap = exclusionMap;
    }

    public static Map<Epreuve, Set<Epreuve>> getAfterMap() {
        return afterMap;
    }

    public void setAfterMap(Map<Epreuve, Set<Epreuve>> afterMap) {
        this.afterMap = afterMap;
    }
}