/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagemain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Francois
 */
public class selectBDD {

    public static boolean isuservalid(String mail, String pass) throws SQLException {
    boolean tmp =false;
    Connection connect = testCoBDD.connect();
    Statement smt = connect.createStatement();
    return tmp;
    }


public static void main(String[] args) throws SQLException {
         selectBDD select = new selectBDD();
         System.out.println("titi");
         
        
        
    }

}
