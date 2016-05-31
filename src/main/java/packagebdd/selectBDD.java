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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import packageapi.Salon;
import packageapi.Utilisateur;
import static packagebdd.decoBDD.deconnect;



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
    deconnect(connect); 
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
        deconnect(connect); 
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
    deconnect(connect); 
    return "NO";
}


    
public static List<Utilisateur> getListSalonUtilisateur(Utilisateur Current) throws SQLException{   
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
         deconnect(connect); 
         return listUser ; 
        
}

 //recuperer message d'un salon
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
                    +resultat.getString(2)+"\n";
                    
            
            while (resultat.next()) {
                msg = msg +"\n"+ resultat.getString(3)
                    +" a dit:\n"+resultat.getString(1)
                    +resultat.getString(2)+"\n";
            }
            
        deconnect(connect); 
        return msg;
    }
    
    public static String getMessageMessagerie(String dest, String emet )throws SQLException
    {
        String msg = "";
       
        //connexion base de donnée
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();

       // requete 
            String sql = "SELECT contenuM, dateM, emetteurM FROM message WHERE (destinataireM = '"
                    +dest+"' AND emetteurM = '"
                    +emet+"') OR (destinataireM = '"
                    +emet+"' AND emetteurM = '"
                    +dest+"')";
            ResultSet resultat = smt.executeQuery(sql);
            resultat.next();
            
            msg = resultat.getString(3)
                    +" a dit:\n"+resultat.getString(1)
                    +"\n\n"+resultat.getString(2)+"\n";
                    
            
            while (resultat.next()) {
                msg = msg +"\n"+ resultat.getString(3)
                    +" a dit:\n"+resultat.getString(1)
                    +"\n\n"+resultat.getString(2)+"\n";
            }
            
        deconnect(connect); 
        return msg;
    }
    
    //on recupert les salon d'un utilisateur rentré en parmetre, on retourn donc une list de salon
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
         deconnect(connect); 
         return listSalon ;
    }

    //on recupert les salon d'un utilisateur avec son mail rentré en parmetre, on retourne donc une list de salon
    public static List<Salon> getListSalonViaMail (String usermail) throws SQLException{
     Connection connect = coBDD.connect();
         Statement smt = connect.createStatement();
                         
         try {
            String sql = ("SELECT description FROM utilisateurs,fairepartie,salon "
                    + "WHERE (utilisateurs.idU=fairepartie.idU) AND (salon.idS=fairepartie.idS) AND ( NomU='"+usermail+"');"  );
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
         deconnect(connect); 
         return listSalon ;
    }
    
    
//ici on récupert une liste de tout nos salons.
public static List<Salon> getListSalon() throws SQLException
{
    String salonName = "";
       
        //connexion base de donnée
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();

            // requete 
            String sql = "SELECT description FROM salon";
            ResultSet resultat = smt.executeQuery(sql);
            ResultSetMetaData resultatUserMeta = resultat.getMetaData();
          String description = "";
            
           while ( resultat.next()){
               for (int i = 1; i <= resultatUserMeta.getColumnCount(); i++ ){
                   description = resultat.getString(i);
                   //System.out.println(description);
                   Salon S = new Salon(description);
                   listSalon.add(S);
               
               }
           }
           
           
           
           deconnect(connect); 
           return listSalon;
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
         deconnect(connect); 
         return listUser ;
    }
   
//ici on récupert le nom du salon auquel l'utilisateur est chef de salon si il l'est.
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
           deconnect(connect); 
           return "NULL";
}

public static int idUser (String userMail) throws SQLException
{ 
    int idUser;
    Connection connect = coBDD.connect();
    Statement smt = connect.createStatement();
    
    String sql = "SELECT idU FROM utilisateurs WHERE mailU='" +userMail+"'";
    ResultSet resultat = smt.executeQuery(sql);
    
    resultat.next();
    idUser = resultat.getInt(1);
    //System.out.println(idUser);
    return idUser;
}
public static void main(String[] args) throws SQLException {
         //selectBDD select = new selectBDD();
         //System.out.println("titi");
         
           
 
}



}





