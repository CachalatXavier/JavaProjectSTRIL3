/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import packageapi.Admin;
import packageapi.Chef_Projet;
import packageapi.Utilisateur;


/**
 *
 * @author Francois
 */
public class selectBDD {

    public static boolean isuservalid(String mail, String pass) throws SQLException {
    boolean tmp =false;
    /*createTableBDD creation = new createTableBDD();
    MainBDDmin maBDDmin = new MainBDDmin();*/
    
    Connection connect = coBDD.connect();
    Statement smt = connect.createStatement();
    try{
                String sql = "SELECT mdpU FROM utilisateurs WHERE mailU ='"+mail+"'";
                ResultSet resultat = smt.executeQuery(sql);
                 
                if(resultat.next()){
                     
                    String motDePasse = resultat.getString(1);
         
                if(motDePasse.equals(pass)){
             
                    JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
                    tmp = true;
                }else {
                     
                    JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
                }
                }else {
                     
                    JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
                }
 
                   
         
            }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }
    return tmp;
    }
    
    
    
    public static String checkright(String mail) throws SQLException{
        String droit = "";
        
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        try{
                String sql = "SELECT droitU FROM utilisateurs WHERE mailU ='"+mail+"'";
                ResultSet resultat = smt.executeQuery(sql);
                 
                if(resultat.next()){
                    droit = resultat.getString(1);
                    
                }else {
                     
                    System.out.println("Problème lors de la récupération des droits");
                }
 
            }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }
        
        return droit;
    }
    
    
    


public static void getListSalonUtilisateur(Utilisateur Current) throws SQLException{    // a finir
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        ArrayList<String> Resultat= new ArrayList<String>();
        
        String tmp;
        String Nom = Current.getNom();  
        
        try {
            String sql = ("SELECT description,listUser FROM salon" );
            ResultSet res = smt.executeQuery(sql);
           
            // a finir
          
        } catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
         }
        
}

 //recuperer message
    public static String getMessageSalon(String salon )throws SQLException
    {
        String msg = "";
       
        //connexion base de donnée
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
       
        try
        {
            String sql = "SELECT contenuM FROM Message WHERE destinataireM ='"+salon+"'";
            ResultSet resultat = smt.executeQuery(sql);
                
                while(resultat.next())
                {
                    msg = msg + resultat.getString(1);
                   
                
                    
                }
 
            }catch (SQLException e4) {
            
                System.out.println(e4.getMessage());
            }
       
        return msg;
    }


public static void main(String[] args) throws SQLException {
         //selectBDD select = new selectBDD();
         //System.out.println("titi");
         
           
 
}



}





