/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import packagemain.testCoBDD;

/**
 *
 * @author Cyril
 */
public class Admin extends Utilisateurs{
    
    public Admin(String mail) {
        super(mail);
    }
    
    @Override
     public void setPresence(String nom, String prenom) throws SQLException {
        Connection connect = testCoBDD.connect();
        Statement smt = connect.createStatement();
        
        /*faire ici les requêtes ( insert )*/
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 1 WHERE mailU ='"+mail+"'");
        
        System.out.println("L'admin " + nom + " " + prenom + " est entré(e) dans le chat");
    }
    
}
