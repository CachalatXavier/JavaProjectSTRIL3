/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagemain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Francois
 */
public class testCoBDD {
    
    private Connection DBConnection;
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Connectio Fail" + cnfe);
        }
        String url = "jdbc:mysql://localhost:8889/javaBDD";
        try {
            DBConnection = (Connection) DriverManager.getConnection(url, "root", "root");
            System.out.println("Database Connected");
        }
        catch (SQLException se){
            System.out.println("No database" + se);
        }
        
        return DBConnection;
    }
    
        public static void main(String[] args) {
        Connection testCO = new testCoBDD().connect();
    }
}

