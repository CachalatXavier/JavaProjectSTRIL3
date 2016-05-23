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
public class Chef_Projet extends Utilisateur{
    
    public Chef_Projet(String mail) {
        super(mail);
    }
    
     public void setPresence(String nom, String prenom ,int presence ) throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        if (presence == 1 ){
            int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 1 WHERE mailU ='"+mail+"'");
            System.out.println("Le chef de projet " + nom + " " + prenom + " est entré(e) dans le chat");
        }
        if (presence == 0 ){
            int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 0 WHERE mailU ='"+mail+"'");
            System.out.println("Le chef de projet" + nom +" "+ prenom +"est deconnecter" );
        }
    }

     
    @Override
     public void Deconnexion(String nom, String prenom) throws SQLException{
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        /*faire ici les requêtes ( insert )*/
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 0 WHERE mailU ='"+mail+"'");
        
        System.out.println("Le chef de projet " + nom + " " + prenom + " a quitté le le chat");
        
    }
    

    public void addUser(String mail, String service, String nomSalon){
        
    }
}
