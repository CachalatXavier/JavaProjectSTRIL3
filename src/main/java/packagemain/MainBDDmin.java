/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//ce main permet de remplir la bdd au niveau le plus BAS

//doc : http://blog.paumard.org/cours/jdbc/chap02-apercu-exemple.html

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

// votre base de données doit avoir le le nom suivant: javaBDD
public class MainBDDmin {

    
    private String URL = "jdbc:mysql://localhost:8888/javaBDD";
    String login = "java";  //changé votre login si besoin
    String password = "java123123";   //changé votre mdp si besoin
    Connection connexion = null;

    
    public MainBDDmin() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(URL, login, password);
            //travail avec les données 
            System.err.println("test");
            /* Ici, nous placerons nos requêtes vers la BDD */
            
            //int i = smt.executeUpdate("insert into … values …") ;
            
        } catch (SQLException e) {
            /* Gérer les éventuelles erreurs ici */
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainBDDmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
         MainBDDmin maBDDmin = new MainBDDmin();
    }
}
