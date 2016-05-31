/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebdd;

import java.sql.Connection;

/**
 *
 * @author Francois
 */
public class decoBDD {
     
    public static void deconnect( Connection co) {
     
         if(co!=null){try{co.close();}catch(Exception e){}} 

    }
    
    
}
