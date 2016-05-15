/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagemain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Francois
 */
public class selectBDD {

    public static boolean isuservalid(String mail, String pass) throws SQLException {
    boolean tmp =false;
    /*createTableBDD creation = new createTableBDD();
    MainBDDmin maBDDmin = new MainBDDmin();*/
    
    Connection connect = testCoBDD.connect();
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
    
    public static boolean adduser(String firstName, String name, String mail, String pass) throws SQLException
    {
        boolean tmp = false;
        /*createTableBDD creation = new createTableBDD();
         MainBDDmin maBDDmin = new MainBDDmin();*/
    
        Connection connect = testCoBDD.connect();
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


public static void main(String[] args) throws SQLException {
         selectBDD select = new selectBDD();
         System.out.println("titi");
         
        
        
    }

}
