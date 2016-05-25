/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebdd;

import java.sql.Array;
import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import packageapi.Messages;
import packageapi.Utilisateur;

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
    
    
     public static void addmsg(Messages msg) throws SQLException
    {
        Connection connect = coBDD.connect();
        Statement smt = connect.createStatement();            
           
                int insert_msg = smt.executeUpdate("INSERT INTO `javabdd`.`message` "
                + "(`contenuM`, `dateM`, `emetteurM`, `destinataireM`) "
                + "VALUES ('"+msg.getContenu()+"', '"+msg.getDate()+"', '"+msg.getSender()+"', '"+msg.getDest()+"');");
    }
    
     
     public static boolean addUserSalon (String nomChefProjet , String user , int idsalon) throws SQLException{
          Connection connect = coBDD.connect(); //  a teste 
         Statement smt = connect.createStatement();
         boolean tmp = false; 
         int i=0;
         boolean acce = true; 
         try{
             //requete SQL
            String sql1 = "SELECT nomU FROM utilisateurs WHERE salonMaster ='"+nomChefProjet+"'";
            ResultSet resultat1 = smt.executeQuery(sql1);
            String sql2 = "SELECT nomU FROM utilisateurs WHERE nomU ='"+user+"'";
            ResultSet resultat2 = smt.executeQuery(sql2);
            String sql3 = "SELECT listUser FROM salon WHERE idS ='"+idsalon+"'";
            ResultSet resultat3 = smt.executeQuery(sql3);
            
            if (resultat1.next()){  // teste si l'utilisateur est chef de salon
                if (resultat2.next()){ // teste si l'utilisateur a ajouter existe
                    while (resultat3.next()) // test si l'utilisateur est deja enregistre dans le salon
                    {
                         Array list = resultat3.getArray("ZIPS"); // écupére la liste 
                         String[] zips = (String[])list.getArray(); // la transforme en un tableau
                         for (i=0 ; i<zips.length ; i++){   // pour chaque case 
                             if (zips[i]==user )        // on teste si l'user nest pas dans la liste
                             {
                                 JOptionPane.showMessageDialog(null,"l'utilisateur fais deja partie du salon","errreur",JOptionPane.PLAIN_MESSAGE);
                                 acce = false;
                             }
                         }
                    }
                    
                }if (acce== true){
                    int sql4 = smt.executeUpdate("INSERT INTO `javabdd`.`salon` "   // ajout de l'utilisateur
                            +"(`'idS' , 'listUser')"
                            + "VALUES ('"+idsalon+"','"+user+"');");
            
                   } else JOptionPane.showMessageDialog(null,"l'utilisateur n'existe pas","errreur",JOptionPane.PLAIN_MESSAGE);
                
                
            }else JOptionPane.showMessageDialog(null,"Vous n'etes pas chef de projet de ce salon","errreur",JOptionPane.PLAIN_MESSAGE);
                
            
         }
         catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }       
        return tmp;
     }
    
}
