/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import packagebdd.coBDD;

/**
 *
 * @author Cyril
 */
public class Admin extends Utilisateur{
    
    public Admin(String mail) {
        super(mail);
    }
    
     /*public void setPresence(String nom, String prenom) throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        
       
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 1 WHERE mailU ='"+mail+"'");
        System.out.println("L'admin " + nom + " " + prenom + " est entré(e) dans le chat");
      
    }
     
    @Override
     public void Deconnexion(String nom, String prenom) throws SQLException{
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
       
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 0 WHERE mailU ='"+mail+"'");
        
        System.out.println("L'admin " + nom + " " + prenom + " a quitté le chat");
        
    }*/
    
}
