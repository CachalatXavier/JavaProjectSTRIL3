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
        //int initialisation = smt.executeUpdate("DROP TABLE IF EXISTS `javabdd`.`utilisateurs`"); 
        //int initialisation2 = smt.executeUpdate("DROP TABLE IF EXISTS `javabdd`.`salon`");
        //int initialisation3 = smt.executeUpdate("DROP TABLE IF EXISTS `javabdd`.`message`");
        //int initialisation4 = smt.executeUpdate("DROP TABLE IF EXISTS `javabdd`.`fairePartie`");
        
        int tab_salon = smt.executeUpdate("CREATE TABLE `javabdd`.`salon` "
                + "( `idS` INT NOT NULL AUTO_INCREMENT , "
                + "`description` TEXT NOT NULL , "
                + "`listUser` TEXT NULL , "
                + "`listMessage` TEXT NULL , "
                + "PRIMARY KEY (`idS`)) "
                + "ENGINE = InnoDB;");
        
        int tab_user1 = smt.executeUpdate("CREATE TABLE `javabdd`.`utilisateurs` "
                + "(`idU` INT NOT NULL AUTO_INCREMENT , "
                + "`nomU` VARCHAR(100) NOT NULL , "
                + "`prenomU` VARCHAR(100) NOT NULL , "
                + "`mailU` VARCHAR(100) NOT NULL , "
                + "`mdpU` VARCHAR(100) NOT NULL , "
                + "`serviceU` VARCHAR(100) NULL , "
                + "`droitU` VARCHAR(100) NOT NULL , "
                + "`salonMaster` VARCHAR(100) NULL, "
                + "`presentU` BOOLEAN NOT NULL , "
                + "PRIMARY KEY (`idU`)) "
                + " ENGINE = InnoDB;");
 
        int tab_fairePartieP1 = smt.executeUpdate("CREATE TABLE `javabdd`.`fairePartie` " 
                +  "( `idU` INT NOT NULL,"
                +  "`idS` INT NOT NULL,"
                +  "PRIMARY KEY (`idU`,`idS`));");

        int tab_fairePartieP2 = smt.executeUpdate ("ALTER TABLE `javabdd`.`fairePartie` " 
            + "ADD FOREIGN KEY (idU) REFERENCES utilisateurs(idU),"
            + "ADD FOREIGN KEY (idS) REFERENCES salon(idS);");
        
        
        int tab_messageP1 = smt.executeUpdate("CREATE TABLE `javabdd`.`message` "
                + "( `idM` INT NOT NULL AUTO_INCREMENT , "
                + "`contenuM` text NOT NULL , "
                + "`dateM` date NOT NULL , "
                + "`emetteurM` varchar( 100 ) NOT NULL , "
                + "`destinataireM` varchar( 100 ) NOT NULL , "
                + "`idU` int , "
                + "`idS` int , "
                + " PRIMARY KEY (`idM`)) "
                + "ENGINE = InnoDB DEFAULT CHARSET = latin1;");
        
        int tab_messageP2 = smt.executeUpdate ("ALTER TABLE `javabdd`.`message` " 
            + "ADD FOREIGN KEY (idU) REFERENCES utilisateurs(idU),"
            + "ADD FOREIGN KEY (idS) REFERENCES salon(idS);");
        
        
        
        
        
        
        
    }
}
