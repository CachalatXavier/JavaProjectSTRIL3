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
    //un constructeur pour envoie d'un message à une personne

    /**
     *
     * @param contenu
     * @param date
     * @param send
     * @param dest
     * @throws SQLException
     */
    public Messages(String contenu, String date, Utilisateur send , Utilisateur dest) throws SQLException {
        this.contenu = contenu;
        this.date = date;
        this.sender = send.getNom();
        this.dest = dest.getNom();
    }
    
    //un constructeur pour envoie d'un message à un salon

    /**
     *
     * @param contenu
     * @param date
     * @param send
     * @param dest
     * @throws SQLException
     */
    public Messages(String contenu, String date, Utilisateur send , Salon dest) throws SQLException {
        this.contenu = contenu;
        this.date = date;
        this.sender = send.getNom();
        this.dest = dest.getDescription();
    }
    
    
    //getters et tostring

    /**
     *
     * @return
     */

    public String getContenu() {
        return contenu;
    }

    /**
     *
     * @return
     */
    public String getDest() {
        return dest;
    }

    /**
     *
     * @return
     */
    public String getSender() {
        return sender;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    
     @Override
    public String toString() {
        return "Message{" + "contenu=" + contenu + ", destinataire=" + dest + ", envoyé par=" + sender + ", date=" + date + '}';
    }

        
    
}
