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
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import packagebdd.coBDD;
import static packagebdd.decoBDD.deconnect;


/*
 *
 * @author Cyril
 */

/**
 *
 * @author Francois
 */

 public class Utilisateur extends AbstractListModel<Salon> {
    static List<Salon> listSalonUser = new ArrayList<Salon>();
    private String nom;
    private String prenom;
    String mail;
    private String Service;
    private String droit;
    private int presence;

    /**
     *
     * @param mail
     */
    public Utilisateur(String mail) {
        this.mail = mail;
    }

    /**
     *
     * @param nom
     * @param prenom
     * @param mail
     * @param Service
     * @param droit
     */
    public Utilisateur(String nom, String prenom, String mail, String Service, String droit) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.Service = Service;
        this.droit = droit;
    }

    
    
    /*
     * @return the nom
     * @throws java.sql.SQLException
     */

    /**
     *
     * @return
     * @throws SQLException
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
        deconnect(connect); 
        return nom;
    }

    /*
     * @param nom the nom to set
     */

    /**
     *
     * @param nom
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /*
     * @return the prenom
     * @throws java.sql.SQLException
     */

    /**
     *
     * @return
     * @throws SQLException
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
        deconnect(connect); 
        return prenom;
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public int getPresence() throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
            int pres;
        pres = 0;
        try {
            String sql = "SELECT presentU FROM utilisateurs WHERE mailU ='"+mail+"'";
            ResultSet resultat = smt.executeQuery(sql);
            
            if(resultat.next()){
                pres = resultat.getInt(1);
            }
            else
            {
                System.out.println("Présence non trouvée");
            }
            
        }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }
        deconnect(connect); 
        return pres;
    }

    /*
     * @param prenom the prenom to set
     */

    /**
     *
     * @param prenom
     */

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /*
     * @return the mail
     */

    /**
     *
     * @return
     */

    public String getMail() {
        return mail;
    }

    /*
     * @param mail the mail to set
     */

    /**
     *
     * @param mail
     */

    public void setMail(String mail) {
        this.mail = mail;
    }

    /*
     * @return the Service
     * @throws java.sql.SQLException
     */

    /**
     *
     * @return
     * @throws SQLException
     */

    public String getService() throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        try {
            String sql = "SELECT serviceU FROM utilisateurs WHERE mailU ='"+mail+"'";
            ResultSet resultat = smt.executeQuery(sql);
            
            if(resultat.next()){
                Service = resultat.getString(1);
            }
            else
            {
                System.out.println("Service non trouvé");
            }
            
        }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }
        
        deconnect(connect); 
        return Service;
    }

    /*
     * @param Service the Service to set
     */

    /**
     *
     * @param Service
     */

    public void setService(String Service) {
        this.Service = Service;
    }

    
    
   

    /*
     * @return the droit
     */

    /**
     *
     * @return
     */

    public String getDroit() {
        return droit;
    }

    /*
     * @param droit the droit to set
     */

    /**
     *
     * @param droit
     */

    public void setDroit(String droit) {
        this.droit = droit;
    }
    
    /**
     *
     * @param nom
     * @param prenom
     * @param type
     * @throws SQLException
     */
    public void setPresence(String nom, String prenom, int type) throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        /*faire ici les requêtes ( insert )*/
      
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 1 WHERE mailU ='"+mail+"'");
        switch (type) {
            case 3:
                System.out.println("L'utilisateur " + nom + " " + prenom + " est entré(e) dans le tchat");
                break;
            case 2:
                System.out.println("Le chef de projet " + nom + " " + prenom + " est entré(e) dans le tchat");
                break;
            default:
                System.out.println("L'admin " + nom + " " + prenom + " est entré(e) dans le tchat");
                break;
        }
      deconnect(connect); 
    }

    /**
     *
     * @param num
     * @throws SQLException
     */
    public void setPresence(int num) throws SQLException {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
      
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = '"+num+"' "+" WHERE mailU ='"+mail+"'");
        
      deconnect(connect); 
    }
    
    /**
     *
     * @param nom
     * @param prenom
     * @param mail
     * @param type
     * @throws SQLException
     */
    public void Deconnexion(String nom, String prenom, String mail, int type) throws SQLException{
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        /*faire ici les requêtes ( insert )*/
        int present = smt.executeUpdate("UPDATE `javabdd`.`utilisateurs` "
                + "SET presentU = 0 WHERE mailU ='"+mail+"'");
        
         switch (type) {
            case 3:
                System.out.println("L'utilisateur " + nom + " " + prenom + " a quitté le tchat");
                break;
            case 2:
                System.out.println("Le chef de projet " + nom + " " + prenom + " a quitté le tchat");
                break;
            default:
                System.out.println("L'admin " + nom + " " + prenom + " a quitté le tchat");
                break;
        }
        deconnect(connect); 
    }
    
    /**
     *
     * @param tempS
     * @throws SQLException
     */
    public void salonUser(Salon tempS) throws SQLException {
        
        listSalonUser.add(tempS);
        fireContentsChanged(listSalonUser, 0, listSalonUser.size());
    }
    
    public void InitSalonUser(){
        
        listSalonUser.clear();
        fireContentsChanged(listSalonUser, 0, listSalonUser.size());
    }

    @Override
    public int getSize() {
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return listSalonUser.size();
    }

    @Override
    public Salon getElementAt(int index) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return listSalonUser.get(index);
    }
    
    
    
    
         
}
