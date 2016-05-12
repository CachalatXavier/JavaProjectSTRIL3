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
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francois
 */

// votre base de données doit avoir le le nom suivant: javaBDD
public class MainBDDmin {

    
    public MainBDDmin() {

        Connection connect = testCoBDD.connect();
        /*faire ici les requêtes ( insert )*/
    }
    
    public static void main(String[] args) {
         MainBDDmin maBDDmin = new MainBDDmin();
         System.out.println("toto");
    }
}
