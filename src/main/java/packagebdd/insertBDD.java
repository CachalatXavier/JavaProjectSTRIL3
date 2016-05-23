/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebdd;

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
    
    
}
