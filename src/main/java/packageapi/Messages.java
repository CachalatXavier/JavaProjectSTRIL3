/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.sql.SQLException;

/**
 *
 * @author Cyril
 */
public class Messages {
    
    //attributs
    
    private String contenu; // contenu du message
    private String dest; // en destinataire on doit retrouver un nom d'utilisateur ou un nom de salon
    private String sender; //nom de l'utilisateur connecté
    private String date; // date courante
    
    //constructeur
    
    public Messages(String contenu, String date, Utilisateur send , Utilisateur dest) throws SQLException {
        this.contenu = contenu;
        this.date = date;
        this.sender = send.getNom();
        this.dest = dest.getNom();
    }
    
    
    
    //getters et tostring

    public String getContenu() {
        return contenu;
    }

    public String getDest() {
        return dest;
    }

    public String getSender() {
        return sender;
    }

   
    public String getDate() {
        return date;
    }

    
     @Override
    public String toString() {
        return "Message{" + "contenu=" + contenu + ", destinataire=" + dest + ", envoyé par=" + sender + ", date=" + date + '}';
    }

        
    
}
