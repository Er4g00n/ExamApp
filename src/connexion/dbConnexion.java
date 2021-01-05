package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnexion {
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2384991";
            String user = "sql2384991";
            String password = "rD7*wI2!";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(dbConnexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
