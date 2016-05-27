/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebdd;

import packagebdd.coBDD;
import java.sql.*;


/**
 *
 * @author Francois
 */
public class createTableBDD {
    
    public createTableBDD () throws SQLException {
    Connection connect = coBDD.connect();
    
    /* Création de l'objet gérant les requêtes */
        Statement smt = connect.createStatement();
        
    /*Création des différentes tables*/
        int initialisation = smt.executeUpdate("DROP TABLE IF EXISTS `javabdd`.`utilisateurs`");
        
        int tab_user = smt.executeUpdate("CREATE TABLE `javabdd`.`utilisateurs` "
                + "( `idU` INT NOT NULL AUTO_INCREMENT , "
                + "`nomU` VARCHAR(100) NOT NULL , "
                + "`prenomU` VARCHAR(100) NOT NULL , "
                + "`mailU` VARCHAR(100) NOT NULL , "
                + "`mdpU` VARCHAR(100) NOT NULL , "
                + "`serviceU` VARCHAR(100) NULL , "
                + "`droitU` VARCHAR(100) NOT NULL , "
                + "`salonMaster` VARCHAR(100) NULL, "
                + "`presentU` BOOLEAN NOT NULL , "
                + "PRIMARY KEY (`idU`))"
                + " ENGINE = InnoDB;");
        
        int initialisation2 = smt.executeUpdate("DROP TABLE IF EXISTS `javabdd`.`salon`");
        
        int tab_salon = smt.executeUpdate("CREATE TABLE `javabdd`.`salon` "
                + "( `idS` INT NOT NULL AUTO_INCREMENT , "
                + "`description` TEXT NOT NULL , "
                + "`listUser` TEXT NULL , "
                + "`listMessage` TEXT NULL , "
                + "PRIMARY KEY (`idS`)) "
                + "ENGINE = InnoDB;");
        
        int initialisation3 = smt.executeUpdate("DROP TABLE IF EXISTS `javabdd`.`message`");
        
        int tab_message = smt.executeUpdate("CREATE TABLE `javabdd`.`message` "
                + "( `idM` INT NOT NULL AUTO_INCREMENT , "
                + "`contenuM` text NOT NULL , "
                + "`dateM` date NOT NULL , "
                + "`emetteurM` varchar( 100 ) NOT NULL , "
                + "`destinataireM` varchar( 100 ) NOT NULL , "
                + "PRIMARY KEY (`idM`)) "
                + "ENGINE = InnoDB DEFAULT CHARSET = latin1;");
        
        int initialisation4 = smt.executeUpdate("DROP TABLE IF EXISTS `javabdd`.`appartenir`");
        
        int tab_appartenir = smt.executeUpdate("CREATE TABLE `javabdd`.`appartenir` "
                + "( `NumClient` INT NOT NULL, "
                + "`NumSalon` INT NOT NULL ) "
                /*+ "PRIMARY KEY (`NumClient`)) "
                + "CONSTRAINT `FK_numClient` FOREIGN KEY (`NumClient`) " 
                + "REFERENCES `javabdd`.`utilisateurs`(`idU`)"
                + "CONSTRAINT `FK_numSalon` FOREIGN KEY (`NumSalon`) "
                + "REFERENCES `javabdd`.`salon`(`idS`)"*/
                + "ENGINE = Inno DB;");
        // ON DELETE RESTRICT ON UPDATE RESTRICT; 
        System.out.println("Table créée");
        
    }
}
