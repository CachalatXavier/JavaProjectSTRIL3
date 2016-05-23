/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import packagebdd.coBDD;

/**
 *
 * @author Cyril
 */
public class Utilisateur {
    private String nom;
    private String prenom;
    String mail;
    private String Service;
    private String droit;

    public Utilisateur(String mail) {
        this.mail = mail;
    }

    public Utilisateur(String nom, String prenom, String mail, String Service, String droit) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.Service = Service;
        this.droit = droit;
    }

    
    
    /**
     * @return the nom
     * @throws java.sql.SQLException
     */
    public String getNom() throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        try {
            String sql = "SELECT nomU FROM utilisateurs WHERE mailU ='"+mail+"'";
            ResultSet resultat = smt.executeQuery(sql);
            
            if(resultat.next()){
                nom = resultat.getString(1);
            }
            else
            {
                System.out.println("Nom non trouvé");
            }
            
        }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     * @throws java.sql.SQLException
     */
    public String getPrenom() throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        try {
            String sql = "SELECT prenomU FROM utilisateurs WHERE mailU ='"+mail+"'";
            ResultSet resultat = smt.executeQuery(sql);
            
            if(resultat.next()){
                prenom = resultat.getString(1);
            }
            else
            {
                System.out.println("Prénom non trouvé");
            }
            
        }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the Service
     */
    public String getService() {
        return Service;
    }

    /**
     * @param Service the Service to set
     */
    public void setService(String Service) {
        this.Service = Service;
    }

   

    /**
     * @return the droit
     */
    public String getDroit() {
        return droit;
    }

    /**
     * @param droit the droit to set
     */
    public void setDroit(String droit) {
        this.droit = droit;
    }
    
    public void setPresence(String nom, String prenom) throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        /*faire ici les requêtes ( insert )*/
      
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 1 WHERE mailU ='"+mail+"'");
        System.out.println("L'utilisateur " + nom + " " + prenom + " est entré(e) dans le chat");
      
    }
    
    public void Deconnexion(String nom, String prenom) throws SQLException{
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        /*faire ici les requêtes ( insert )*/
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 0 WHERE mailU ='"+mail+"'");
        
        System.out.println("L'utilisateur " + nom + " " + prenom + " a quitté le chat");
        
    }
    
    
    
    
         
}
