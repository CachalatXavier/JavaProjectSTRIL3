
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractListModel;
/*import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;*/
import packagebdd.selectBDD;


/**
 *
 * @author Cyril
 */
public class Salon extends AbstractListModel<Utilisateur>{

    private String description;

    /**
     *
     */
    public static List<Utilisateur> listeUsers = new ArrayList<Utilisateur>();
    List<Messages> listeMessages = new ArrayList<Messages>();
    
    //constructeur 1

    /**
     *
     * @param description
     * @param listeU
     * @param listeM
     */
    public Salon(String description, List listeU, List listeM) {
        this.description = description;
        this.listeUsers = listeU;
        this.listeMessages = listeM;
    }

    //constructeur 2

    /**
     *
     * @param description
     */
    public Salon(String description) {
        this.description = description;
    }  
   
    /**
     *
     * @param CurrentU
     * @throws SQLException
     */
    public void adduser(Utilisateur CurrentU) throws SQLException {
        
        listeUsers.add(CurrentU);
        fireContentsChanged(listeUsers, 0, listeUsers.size());
    }
    
    public void deleteuser (){
        listeUsers.clear();
        fireContentsChanged(listeUsers, 0, listeUsers.size());
    }
    
    /*public void addChefProjet(Chef_Projet CurrentCP) throws SQLException {
        
        listeUsers.add(CurrentCP);
        fireContentsChanged(listeUsers, 0, listeUsers.size());
    }
    
    public void addadmin(Admin CurrentA) throws SQLException {
        
        listeUsers.add(CurrentA);
        fireContentsChanged(listeUsers, 0, listeUsers.size());
    }*/
    

    @Override
    public int getSize() {
        return listeUsers.size();
   }

    @Override
    public Utilisateur getElementAt(int index) {
        return listeUsers.get(index);
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    
    
}



