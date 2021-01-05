package connexion;

import utilisateur.Etudiant;
import salle.Salle;
import examen.Examen;
import promotion.Promotion;

import java.sql.*;
import java.util.List;

import static promotion.Promotion.getPromotions;
import static promotion.Promotion.nomToPromotion;

public class BDD {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public BDD(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2384991","sql2384991","rD7*wI2!");
            st = con.createStatement();

        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
        }

        Controller notification = new Controller();
    }
    public void getData(String sql){
        try{
            rs = st.executeQuery(sql);
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
            System.out.println("Error is found :"+ex);
        }
    }

    public boolean checkLogin(String email, String mdp){
        boolean login = false;
        try{
            String sql = "SELECT * FROM Personnels P WHERE email='"+email+"'";
            rs = st.executeQuery(sql);

            if (!rs.isBeforeFirst()) {
                Controller notification = new Controller();
                notification.notification("Cette adresse Email n'est pas enregistrée !", "INFORMATION", 1.0);
                return false;
            }

            while(rs.next()){
                String db_idPersonnel = rs.getString("idPersonnel");
                String db_email = rs.getString("email");
                String db_mdp = rs.getString("mdp");

                if (email.toLowerCase().equals(db_email.toLowerCase()) && mdp.equals(db_mdp)){
                    login = true;
                    Controller notification = new Controller();
                    notification.notification("Connexion réussi !", "SUCCES", 1.0);
                }
                else {
                    Controller notification = new Controller();
                    notification.notification("Erreur identifiants !", "ERROR", 1.0);
                }
            }
            st.close();
            System.out.println(login);


        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
        }
        return login;
    }

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
            System.out.println("Error is found :"+ex);
        }
    }

    public void loadEtudiants(){
        try{
            String sql = "SELECT * FROM Etudiants";
            rs = st.executeQuery(sql);

            while(rs.next()){
                String db_idEtuListe = rs.getString("idEtuListe");
                String db_numEtu = rs.getString("numEtu");
                String db_nom = rs.getString("nom");
                String db_prenom = rs.getString("prenom");
                String db_email = rs.getString("email");
                String db_filliere = rs.getString("filiere");

                Promotion filliere = nomToPromotion(db_filliere);

                Etudiant a = new Etudiant(db_nom, db_prenom, db_email, db_numEtu, filliere);

                for (Promotion promotion : getPromotions()) {
                    if(promotion.getNom().equals(db_idEtuListe)){
                        promotion.ajouterEtudiant(a);
                    }
                }
            }

        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
        }
    }

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
            System.out.println("Error is found :"+ex);
        }
    }

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
                        new Examen(db_idExamen, db_libelle, promotion.getNbetu(),1);
                    }
                }
            }

        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
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
            System.out.println("Error is found :"+ex);
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
            System.out.println("Error is found :"+ex);
        }
    }
}