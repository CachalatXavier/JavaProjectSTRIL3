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
    
    private String contenu;
    private Utilisateur dest;
    private Utilisateur sender;
    private Date date;
    private int id;
    
    public Messages(int id, String contenu, Utilisateur send , Utilisateur dest, Date date) {
        this.id = id;
        this.contenu = contenu;
        this.sender = send;
        this.dest = dest;
        this.date = date;
    }

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
