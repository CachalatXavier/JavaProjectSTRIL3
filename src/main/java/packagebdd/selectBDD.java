/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import packageapi.Admin;
import packageapi.Chef_Projet;
import packageapi.Salon;
import packageapi.Utilisateur;



/**
 *
 * @author Francois
 */
public class selectBDD {
    static List<Utilisateur> listUser = new ArrayList<>();
    static List<Salon> listSalon = new ArrayList<>();
    
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
    
    // recupere l'utilisateur à l'aide d'une adresse mail
public static String getUtilisateur(String email) throws SQLException{
    Connection connect = coBDD.connect();
    Statement smt = connect.createStatement();
    
    String user = "";
    
    try {
        String sql = "SELECT * FROM utilisateurs WHERE (mailU) IN (SELECT mailU FROM utilisateurs WHERE mailU='"
            +email+"')";
        ResultSet resultat = smt.executeQuery(sql);
        
        if(resultat.next()){
                    user = resultat.getString(4);
                    //System.out.println(user);
                    return user;
                }else {
                     
                    System.out.println("Problème lors de la récupération de l'utilisateur!");
                    
                }
    }
    catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
    }
     
    return "NO";
}
    


public static List<Utilisateur> getListSalonUtilisateur(Utilisateur Current) throws SQLException{    // a finir
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        try {
            String sql = ("SELECT NomU FROM utilisateurs" );
            ResultSet res = smt.executeQuery(sql);
            ResultSetMetaData resUserMeta = res.getMetaData();
            
           //) finir
          
        } catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
         }
         
         return listUser ; 
        
}

 //recuperer message
    public static String getMessageSalon(String salon )throws SQLException
    {
        String msg = "";
       
        //connexion base de donnée
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();

       // requete 
            String sql = "SELECT contenuM, dateM, emetteurM FROM message WHERE destinataireM ='" + salon + "'";
            ResultSet resultat = smt.executeQuery(sql);
            
            resultat.next();
            
            msg = resultat.getString(3)
                    +" a dit:\n"+resultat.getString(1)
                    +"\nenvoyé le "
                    +resultat.getDate(2)+"\n";
            
            while (resultat.next()) {
                msg = msg +"\n"+ resultat.getString(3)
                    +" a dit:\n"+resultat.getString(1)
                    +"\nenvoyé le "
                    +resultat.getDate(2)+"\n";
            }
       
        return msg;
    }
    
    public static List<Salon> getListSalon (Utilisateur Current) throws SQLException{
     Connection connect = coBDD.connect();
         Statement smt = connect.createStatement();
         
                
         try {
            String sql = ("SELECT description FROM utilisateurs,fairepartie,salon "
                    + "WHERE (utilisateurs.idU=fairepartie.idU) AND (salon.idS=fairepartie.idS) AND ( NomU='"+Current.getNom()+"');"  );
            ResultSet res = smt.executeQuery(sql);
            ResultSetMetaData resUserMeta = res.getMetaData();
            String description = "";
            
           while ( res.next()){
               for (int i = 1; i <= resUserMeta.getColumnCount(); i++ ){
                   description = res.getString(i);
                   //System.out.println(description);
                   Salon S = new Salon(description);
                   listSalon.add(S);
               
               }
           }
          
        } catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
         }
         
         return listSalon ;
    }



    /**
     *
     * @return
     * @throws SQLException
     */
    public static List<Utilisateur> getListUtilisateur () throws SQLException{


         Connection connect = coBDD.connect();
         Statement smt = connect.createStatement();
         
                
         try {
            String sql = ("SELECT mailU FROM utilisateurs" );
            ResultSet res = smt.executeQuery(sql);
            ResultSetMetaData resUserMeta = res.getMetaData();
            String mail = "";
            
           while ( res.next()){
               for (int i = 1; i <= resUserMeta.getColumnCount(); i++ ){
                   mail = res.getString(i);
                   //System.out.println(mail);
                   Utilisateur U = new Utilisateur(mail);
                   listUser.add(U);
               
               }
           }
          
        } catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
         }
         
         return listUser ;
    }
   
    
public static String getNomSalon( String userMail) throws SQLException
{
    String salonName = "";
       
        //connexion base de donnée
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();

       // requete 
       
            String sql = "SELECT salonMaster FROM utilisateurs WHERE mailU='" +userMail+"'";
            ResultSet resultat = smt.executeQuery(sql);
            
            if(resultat.next()){
                   salonName  = resultat.getString(1);
                    //System.out.println(user);
                    return salonName;
                }else {
                     
                    System.out.println("Problème lors de la récupération du nom Salon !");
                   
                }
            
           return "NULL";
}

public static void main(String[] args) throws SQLException {
         //selectBDD select = new selectBDD();
         //System.out.println("titi");
         
           
 
}



}





