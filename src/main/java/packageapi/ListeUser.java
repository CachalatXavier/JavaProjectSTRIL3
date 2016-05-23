/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Cyril
 */
public class ListeUser extends AbstractListModel<Utilisateurs>{
    
    List<Utilisateurs> listeUsers = new ArrayList<Utilisateurs>();
    
   
         
    public void adduser(Utilisateurs U) {
        listeUsers.add(U);
        fireContentsChanged(listeUsers, 0, listeUsers.size());
       
    }
    @Override
    public int getSize() {
        return listeUsers.size();
   }

    @Override
    public Utilisateurs getElementAt(int index) {
        return listeUsers.get(index);
    }
    
    
}
