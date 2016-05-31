/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//ce main permet de remplir la bdd au niveau le plus FORT

package packagebdd;

import packagebdd.coBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francois
 */

// votre base de données doit avoir le le nom suivant: javaBDD
public class MainBDDmax {
    
        public MainBDDmax() throws SQLException {

        Connection connect = coBDD.connect();
        /*faire ici les requêtes ( insert )*/
        
       
        Statement smt = connect.createStatement();
        /*faire ici les requêtes ( insert )*/
        int insert_admin1 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('1', 'CACHALAT', 'Xavier', 'xavier.c@upssi.fr', 'xavier', 'ADMIN', '0');");
        
        int insert_admin2 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('2', 'LOUIS-STANISLAS', 'Cyril', 'cyril.ls@upssi.fr', 'cyril', 'ADMIN', '0');");
        
        int insert_admin3 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('3', 'LESAICHOT', 'Francois', 'francois.l@upssi.fr', 'francois', 'ADMIN', '0');");
        
        int insert_admin4 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `droitU`, `presentU`) "
                + "VALUES ('4', 'ELOUARIACHI', 'Najim', 'najim.e@upssi.fr', 'najim', 'ADMIN', '0');");
        
        System.out.println("Admins ajoutés");
        
        int insert_chef_projet = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `serviceU`, `droitU`, `salonMaster`, `presentU`) "
                + "VALUES ('5', 'BETA1', 'User1', 'user1.b1@upssi.fr', 'user1', 'Informatique', 'CHEF_PROJET', 'Informatique', '0');");
                
        int insert_user1 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `serviceU`, `droitU`, `presentU`) "
                + "VALUES ('6', 'BETA2', 'User2', 'user2.b2@upssi.fr', 'user2', 'Informatique', 'USER', '0');");
        int insert_user2 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `serviceU`, `droitU`, `presentU`) "
                + "VALUES ('7', 'BETA3', 'User3', 'user3.b3@upssi.fr', 'user3', 'Informatique', 'USER', '0');");

        int insert_user3 = smt.executeUpdate("INSERT INTO `javabdd`.`utilisateurs` "
                + "(`idU`, `nomU`, `prenomU`, `mailU`, `mdpU`, `serviceU`, `droitU`, `presentU`) "
                + "VALUES ('8', 'BETA4', 'User4', 'user4.b4@upssi.fr', 'user4', 'RH', 'USER', '0'),"
                + "('9','JORNA','jack','jack.j@upssi.fr','jack','Informatique','USER','0'),"
                + "('10','COOPER','sly','sly.c@upssi.fr','sly','RH','USER','0'),"
                + "('11','TSONGA','joe','joe.t@upssi.fr','joe','Informatique','USER','0'),"
                + "('12','JORDAN','mickael','mickael.j@upssi.fr','mickael','Informatique','USER','0'),"
                + "('13','SOKO','roko','roko.s@upssi.fr','roko','RH','USER','0'),"
                + "('14','CENA','john','john.c@upssi.fr','john','Informatique','USER','0'),"
                + "('15','MURDOCK','rick','rick.m@upssi.fr','rick','Informatique','USER','0'),"
                + "('16','MANDALA','nelson','nelson.m@upssi.fr','nelson','RH','USER','0'),"
                + "('17','MATHIEU','jeremy','jeremy.m@upssi.fr','jeremy','RH','USER','0'),"
                + "('18','BARNARBY','inp','ins.b@upssi.fr','ins','RH','USER','0'),"
                + "('19','MORGANA','clara','clara.m@upssi.fr','clara','RH','USER','0'),"
                + "('20','DUPONT','jean','jean.d@upssi.fr','jean','RH','USER','0'),"
                + "('21','BON','jean','jean.b@upssi.fr','jean','RH','USER','0');");
                
        System.out.println("Users ajoutés");
        
        int salon_global = smt.executeUpdate("INSERT INTO `javabdd`.`salon` "
                + "(`description`) "
                + "VALUES ('Salon Global');");
        
         System.out.println("Salon global créé");
        
        
        int salon = smt.executeUpdate("INSERT INTO `javabdd`.`salon` "
                + "(`description`) "
                + "VALUES ( 'Salon Informatique'),"
                + "('Salon Securité'),"
                + "('Salon java'),"
                + "('Salon web'),"
                + "('Salon linux');");
        
       System.out.println("Salon Informatique créé");
          
        
          int salon_hacking = smt.executeUpdate("INSERT INTO `javabdd`.`salon` "
                + "( `description`) "
                + "VALUES ( 'Salon Hacking');");
          
          System.out.println("Salon créé");
          
          // rajout de quelques messages dans la bdd
          int msg1 = smt.executeUpdate("INSERT INTO `javabdd`.`message` "
                + "(`contenuM`, `dateM`, `emetteurM`, `destinataireM`) "
                + "VALUES ('Bonjour la compagnie', '25/05/16', 'ELOUARIACHI', 'CACHALAT');");
                    System.out.println("Salon créé");

          int msg2 = smt.executeUpdate("INSERT INTO `javabdd`.`message` "
                + "(`contenuM`, `dateM`, `emetteurM`, `destinataireM`) "
                + "VALUES ('Salut Najim', '25/05/16', 'CACHALAT', 'ELOUARIACHI'),"
                  + "('Salut comment vas tu ? ','25/05/16','ELOUARIACHI','CACHALAT');");
          
                  System.out.println("Messages envoyés");

          
          // Envoi message dans un salon
          int msg3 = smt.executeUpdate("INSERT INTO `javabdd`.`message` "
                + "(`contenuM`, `dateM`, `emetteurM`, `destinataireM`) "
                + "VALUES ('Hello World où en est le projet ?', '25/05/16', 'CACHALAT', 'Salon Informatique'),"
                  + "('Bientot fini normalement ','25/06/16','ELOUARIACHI','Salon Informatique'),"
                  + "('On est dans les temps','25/06/16','LOUIS-STANISLAS','Salon Informatique'),"
                  + "('Ouais, super','27/06/16','LESAICHOT','Salon Informatique'),"
                  + "('Plus qu'une semaine !,'26/06/16','LESAICHOT','Salon Informatique');");
          
          int msg4 = smt.executeUpdate("INSERT INTO `javabdd`.`message` "
                + "(`contenuM`, `dateM`, `emetteurM`, `destinataireM`) "
                + "VALUES ('Hello World', '25/05/16', 'CACHALAT', 'Salon Global'),"
                  + "('Bonjour tout le monde','25/06/16','ELOUARIACHI','Salon Global'),"
                  + "('Il fais beau demain','25/06/16','LOUIS-STANISLAS','Salon Global'),"
                  + "('Ouais, super','25/06/16','CENA','Salon Global'),"
                  + "('Super, il fais grand soleil','26/06/16','CENA','Salon Global');");
        
          
        // rejout des utilisateurs appartenant a un salon
        int salonUser = smt.executeUpdate("INSERT INTO `javabdd`.`fairepartie`"
                + "(idU,idS)"
                + " VALUES (1,1),"
                + " (2,1),"
                + " (3,1),"
                + " (4,1),"
                + " (5,1),"
                + " (6,1),"
                + " (7,1),"
                + " (8,1),"
                + " (1,2),"
                + " (1,3),"
                + " (2,3),"
                + " (2,2),"
                + " (3,2),"
                + " (3,3),"
                + " (4,2),"
                + " (4,3),"
                + " (5,2),"
                + " (6,3),"
                + " (7,2),"
                + " (8,3),"
                + " (9,1),"
                + " (10,1),"
                + "(11,1),"
                + "(12,1),"
                + "(13,1),"
                + "(14,1),"
                + "(15,1),"
                + "(16,1),"
                + "(17,1),"
                + "(18,1),"
                + "(19,1),"
                + "(20,1);");
          
          
        System.out.println("Messages envoyés");
        
        
        
        
        
        
        
    }
    
    public static void main(String[] args) throws SQLException {
         MainBDDmax maBDDmax = new MainBDDmax();
        // System.out.println("toto");
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
