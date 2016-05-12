/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagemain;

import java.sql.*;


/**
 *
 * @author Francois
 */
public class createTableBDD {
    
    public createTableBDD () throws SQLException {
    Connection connect = testCoBDD.connect();
    
    /* Création de l'objet gérant les requêtes */
        Statement smt = connect.createStatement();
        
    /*Création des différentes tables*/
        int tab_user = smt.executeUpdate("CREATE TABLE `javabdd`.`utilisateurs` "
                + "( `idU` INT NOT NULL AUTO_INCREMENT , "
                + "`nomU` VARCHAR(100) NOT NULL , "
                + "`prenomU` VARCHAR(100) NOT NULL , "
                + "`mailU` VARCHAR(100) NOT NULL , "
                + "`mdpU` VARCHAR(100) NOT NULL , "
                + "`droitU` VARCHAR(100) NOT NULL , "
                + "`presentU` BOOLEAN NOT NULL , "
                + "PRIMARY KEY (`idU`))"
                + " ENGINE = InnoDB;");
        
        int tab_salon = smt.executeUpdate("CREATE TABLE `javabdd`.`salon` "
                + "( `idS` INT NOT NULL AUTO_INCREMENT , "
                + "`description` TEXT NOT NULL , "
                + "`listUser` TEXT NOT NULL , "
                + "`listMessage` TEXT NOT NULL , "
                + "PRIMARY KEY (`idS`)) "
                + "ENGINE = InnoDB;");
        
        int tab_message = smt.executeUpdate("CREATE TABLE `javabdd`.`message` "
                + "( `idM` int( 11 ) NOT NULL , "
                + "`contenuM` text NOT NULL , "
                + "`dateM` date NOT NULL , "
                + "`emetteurM` varchar( 100 ) NOT NULL , "
                + "`destinataireM` varchar( 100 ) NOT NULL ) "
                + "ENGINE = InnoDB DEFAULT CHARSET = latin1");
        
        int tab_messageSalon = smt.executeUpdate("CREATE TABLE `javabdd`.`messageSalon` "
                + "( `idMsalon` INT NOT NULL AUTO_INCREMENT , "
                + "`contenuMS` TEXT NOT NULL , "
                + "`dateMS` DATE NOT NULL , "
                + "PRIMARY KEY (`idMsalon`)) "
                + "ENGINE = InnoDB;");
        
        int tab_fairePartie = smt.executeUpdate("CREATE TABLE `javabdd`.`fairePartie` "
                + "( `idU` INT NOT NULL , "
                + "`idS` INT NOT NULL , "
                + "PRIMARY KEY (`idS`)) "
                + "ENGINE = InnoDB;");
        
    }
}