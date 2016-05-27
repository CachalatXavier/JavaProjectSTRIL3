/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Francois
 */
public class coBDD {
    
    private static Connection DBConnection;
    
    
    public static  Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connexion Success !");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Connexion Fail..." + cnfe);
        }
        
        String url = "jdbc:mysql://localhost:8889/javaBDD?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        //François: 8889 javaBDD root root
        //Xavier: 3306 javabdd root
        //Cyril: 3307 javabdd root
        //Najim: 3306 javaBDD root root
        
        try {
            DBConnection = (Connection) DriverManager.getConnection(url, "root", "root");
            System.out.println("Database Connected !");
        }
        catch (SQLException se){
            System.out.println("No database : " + se);
        }
        
        return DBConnection;
    }
    
   /*     public static void main(String[] args) {
        Connection testCO = new coBDD().connect();
    }*/
}

