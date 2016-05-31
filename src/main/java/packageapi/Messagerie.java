/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import packagebdd.selectBDD;

/**
 *
 * @author Cyril
 */
public class Messagerie extends AbstractListModel<Utilisateur>{
    List<Utilisateur> allUsers = new ArrayList<Utilisateur>();
    List<Salon> allSalonUser = new ArrayList<Salon>();
    public Messagerie(){
        //this.allUsers = allU;
    }
    
    public void addAllUsers(Utilisateur tempU) throws SQLException {
        
        allUsers.add(tempU);
        fireContentsChanged(allUsers, 0, allUsers.size());
    }
  
    @Override
    public int getSize() {
        return allUsers.size();
   }

    @Override
    public Utilisateur getElementAt(int index) {
        return allUsers.get(index);
    }
 
    
}
