/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//ce main permet de remplir la bdd au niveau le plus FORT

package packagebdd;

import packagebdd.coBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francois
 */

// votre base de données doit avoir le le nom suivant: javaBDD
public class MainBDDmax {
    
        public MainBDDmax() {

        Connection connect = coBDD.connect();
        /*faire ici les requêtes ( insert )*/
        
        
        
        
        
        
        
        
    }
    
    public static void main(String[] args) {
         MainBDDmax maBDDmax = new MainBDDmax();
         System.out.println("toto");
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
