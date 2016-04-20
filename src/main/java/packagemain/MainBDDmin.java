/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagemain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francois
 */
public class MainBDDmin {

    //attention, tu doit créer en 
    private String URL = "jdbc:mysql://localhost:3306/";
    String login = "log";
    String password = "pass";
    Connection connexion = null;

    
    public MainBDDmin() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(URL, login, password);
            //travail avec les données 
System.err.println("test");
            /* Ici, nous placerons nos requêtes vers la BDD */
 /* ... */
        } catch (SQLException e) {
            /* Gérer les éventuelles erreurs ici */
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainBDDmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        new MainBDDmin();
    }
}
