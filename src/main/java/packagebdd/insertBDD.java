/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebdd;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Francois
 */
public class insertBDD {
    
    
    public static boolean adduser(String firstName, String name, String mail, String pass) throws SQLException
    {
        boolean tmp = false;
        /*createTableBDD creation = new createTableBDD();
         MainBDDmin maBDDmin = new MainBDDmin();*/
    
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();
        
        try {
            String sql = "SELECT mailU FROM utilisateurs WHERE mailU ='"+mail+"'";
            ResultSet resultat = smt.executeQuery(sql);
            
            if(resultat.next()){
                System.out.println(resultat.next());
                tmp = true;
            }
            else
            {
                int insert_user = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('"+firstName+"', '"+name+"', '"+mail+"', '"+pass+"', 'USER', '0');");
                
                JOptionPane.showMessageDialog(null,"User add ! ","Success",JOptionPane.PLAIN_MESSAGE);
                System.out.println("User add !");
            }                    
        }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }       
        return tmp;
    }
    
    public static boolean addUserSalon( String nomChefProjet,String nomUserAjouter,int salon) throws SQLException {
    boolean tmp = false;
    int i=0;
    Connection connect1 = coBDD.connect();
    Statement smt1 = connect1.createStatement();  
    Connection connect2 = coBDD.connect();
    Statement smt2 = connect2.createStatement();
    try{
         String req1 = "SELECT nomU FROM utilisateur WHERE salonMaster='"+nomChefProjet+"'";
         ResultSet requete1 = smt1.executeQuery(req1);
         String req2 = "SELECT nomU From utilisateurs WHERE nomU = '"+nomUserAjouter+"'"; 
         ResultSet requete2 = smt2.executeQuery(req2);
         String req3 = "SELECT listUser FROM salon WHERE salonMaster='"+nomChefProjet+"'AND idS = '"+salon+"'";
         ResultSet requete3 = smt2.executeQuery(req3);
         if (requete1.next()){      // teste si chef de projet 
             if (requete2.next()){  // teste si user a ajouter existe 
                 if (requete3.next()){ // teste si l'utilisateur n'est pas deja ajouter 
                     Array test = requete3.getArray("ZIPS"); // recuperation liste
                     String[] zips = (String[])test.getArray(); // converti en tableau
                     for (i=0; i <= zips.length;i++){   // 
                         if (zips[i]!=nomUserAjouter){  // teste si le nom est présent 
                             tmp = true ; // si le nom n'est pas présent on psse a vrai 
                         }
                         
                     }
                 }else JOptionPane.showMessageDialog(null,"l'utilisateur est deja present dans le salon","erreur",JOptionPane.PLAIN_MESSAGE);
                 
                 
             }else JOptionPane.showMessageDialog(null,"l'utilisateur n'existe pas","erreur",JOptionPane.PLAIN_MESSAGE);
             
         }else JOptionPane.showMessageDialog(null,"vous n'est pas chef de ce salon","erreur",JOptionPane.PLAIN_MESSAGE);
             
 
    }
    catch (SQLException e4){
        System.out.println(e4.getMessage());   
    }
    return tmp;
    }
    
    
    
}
