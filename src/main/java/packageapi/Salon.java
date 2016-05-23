
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Cyril
 */
public class Salon extends AbstractListModel<Utilisateur>{
    private String name;
    private String description;
    List<Utilisateur> listeUsers = new ArrayList<Utilisateur>();
    List<Messages> listeMessages = new ArrayList<Messages>();

   
    public void adduser(Utilisateur CurrentU) {
        listeUsers.add(CurrentU);
        fireContentsChanged(listeUsers, 0, listeUsers.size());
    }

    @Override
    public int getSize() {
        return listeUsers.size();
   }

    @Override
    public Utilisateur getElementAt(int index) {
        return listeUsers.get(index);
    }
    
}



