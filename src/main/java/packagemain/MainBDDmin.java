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
import java.sql.Statement;
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
        Statement smt = connect.createStatement();
        /*faire ici les requêtes ( insert )*/
        int insert_admin1 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('1', 'CACHALAT', 'Xavier', 'xavier.c@upssi.fr', 'xavier', 'ADMIN', '0');");
        
        int insert_admin2 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('2', 'LOUIS-STANISLAS', 'Cyril', 'cyril.ls@upssi.fr', 'cyril', 'ADMIN', '0');");
        
        int insert_admin3 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('3', 'LESAICHOT', 'Francois', 'francois.l@upssi.fr', 'francois', 'ADMIN', '0');");
        
        int insert_admin4 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('4', 'ELOUARIACHI', 'Najim', 'najim.e@upssi.fr', 'najim', 'ADMIN', '0');");
        
        System.out.println("Admins ajoutés");
        
        int insert_chef_projet = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `serviceU`, `droitU`, `salonMaster`, `presentU`) "
                + "VALUES ('5', 'BETA1', 'User1', 'user1.b1@upssi.fr', 'user1', 'Informatique', 'CHEF_PROJET', 'Informatique', '0');");
        
        System.out.println("Chef de projet ajoutés");
        
        int insert_user1 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `serviceU`, `droitU`, `presentU`) "
                + "VALUES ('6', 'BETA2', 'User2', 'user2.b2@upssi.fr', 'user2', 'Informatique', 'USER', '0');");
        
        int insert_user2 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `serviceU`, `droitU`, `presentU`) "
                + "VALUES ('7', 'BETA3', 'User3', 'user3.b3@upssi.fr', 'user3', 'Informatique', 'USER', '0');");
        
        int insert_user3 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `serviceU`, `droitU`, `presentU`) "
                + "VALUES ('8', 'BETA4', 'User4', 'user4.b4@upssi.fr', 'user4', 'RH', 'USER', '0');");

        System.out.println("Users ajoutés");
        
        int salon_global = smt.executeUpdate("INSERT INTO `javabdd`.`salon` "
                + "(`idS`, `description`) "
                + "VALUES ('1', 'Salon gobal');");
        
         System.out.println("Salon global créé");
        
        
        
    }
    
    public static void main(String[] args) throws SQLException {
         MainBDDmin maBDDmin = new MainBDDmin();
         System.out.println("toto");
    }
}
