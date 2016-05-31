package packagemain;


import java.sql.SQLException;
import packageapi.Utilisateur;
import packagebdd.MainBDDmin;
import packagebdd.createTableBDD;
import packageui.Accueil;
import packageapi.Messages;
import packageapi.Utilisateur;
import packagebdd.insertBDD;
import static packagebdd.insertBDD.addmsg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xavier
 */
public class  scenario {
    
    public static void main(String args[]) throws SQLException {
       // createTableBDD creation = new createTableBDD();
     //   MainBDDmin maBDDmin = new MainBDDmin();
        Accueil Accueil = new Accueil();
        new Accueil().setVisible(true);
   
    }
    
}
