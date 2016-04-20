/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagemain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Francois
 */
public class MainBDDmin {
    
    
    //attention, tu doit créer en 
    String URL = "jdbc:mysql://localhost:3306/"; 
    String login = "log"; 
    String password = "pass"; 
    Connection connexion = null;


try{ 
   Class.forName("com.mysql.jdbc.Driver");
   connexion = DriverManager.getConnection(URL,login,password); 
   //travail avec les données 
   
    /* Ici, nous placerons nos requêtes vers la BDD */
    /* ... */

} catch ( SQLException e ) {
    /* Gérer les éventuelles erreurs ici */
} finally {
    if ( connexion != null )
        try {
            /* Fermeture de la connexion */
            connexion.close();
        } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
        }
}
