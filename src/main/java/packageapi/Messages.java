/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.sql.Date;

/**
 *
 * @author Cyril
 */
public class Messages {
    
    //attributs
    
    private String contenu; // contenu du message
    private Utilisateur dest; // en destinataire on doit retrouver un nom d'utilisateur ou un nom de salon
    private Utilisateur sender; //nom de l'utilisateur connecté
    private Date date; // date courante
    private int id; // id unique du message
    
    //constructeur
    
    public Messages(int id, String contenu, Date date, Utilisateur send , Utilisateur dest) {
        this.id = id;
        this.contenu = contenu;
        this.date = date;
        this.sender = send;
        this.dest = dest;
    }
    
    
    
    //getters et tostring

    public String getContenu() {
        return contenu;
    }

    public Utilisateur getDest() {
        return dest;
    }

    public Utilisateur getSender() {
        return sender;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
    
     @Override
    public String toString() {
        return "Message{" + "contenu=" + contenu + ", destinataire=" + dest + ", envoyé par=" + sender + ", date=" + date + ", id=" + id + '}';
    }

        
    
}
