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
import java.sql.*;

/**
 *
 * @author Francois
 */

// votre base de données doit avoir le le nom suivant: javaBDD
public class MainBDDmin {

    
    public MainBDDmin() throws SQLException {

        Connection connect = testCoBDD.connect();
        /*faire ici les requêtes ( insert )*/
        
        Statement smt =  connect.createStatement();
        // utilisateurs :  idU (auto ) nomU prenomU mailU mdpU droitU presentU
        int insertu1 = smt.executeUpdate("insert into utilisateurs values('chan','jackie','jackie@chan.com','kunfu','user',0 )");
        
    }
    
    public static void main(String[] args) throws SQLException {
        createTableBDD BDD = new createTableBDD();
         MainBDDmin maBDDmin = new MainBDDmin();
         System.out.println("toto");
    }
}
