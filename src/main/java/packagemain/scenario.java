package packagemain;

import java.sql.Date;
import java.sql.SQLException;
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
public class scenario {
    
    public static void main(String args[]) throws SQLException {
        createTableBDD creation = new createTableBDD();
        MainBDDmin maBDDmin = new MainBDDmin();
        String testD = "2012-09-01"; 

        Utilisateur u1 = new Utilisateur("CACHALAT", "Xavier", "xavier.c@upssi.fr",  "ADMIN", "0");
        Utilisateur u2 = new Utilisateur("Lesaichot", "Francois", "francois.c@upssi.fr",  "ADMIN", "0");
        
        System.out.println("blo");
        
        Messages monmsg = new Messages("contenfqzefzqu", testD,u1,u2);
        addmsg(monmsg);
        
        System.out.println("blA");
    }
    
}
