package BDD;

import java.sql.*;
public class BDD {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public BDD(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2384112","sql2384112","uR8*aJ5*");
            st = con.createStatement();

        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
        }
    }
    public void getData(){
        try{
            String sql = "select * from Etudiants";
            rs = st.executeQuery(sql);
            System.out.println("Data from online Database :");
            while(rs.next()){
                String name = rs.getString("nom");
                System.out.println("Name :"+name);
            }

        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
        }
    }

}