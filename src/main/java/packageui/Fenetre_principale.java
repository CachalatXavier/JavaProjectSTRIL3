/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageui;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import packageapi.Admin;
import packageapi.Messages;
import packageapi.Salon;
import packageapi.Utilisateur;
import packagebdd.coBDD;
import static packagebdd.decoBDD.deconnect;
import static packagebdd.insertBDD.addUserSalon;
import static packagebdd.insertBDD.addmsg;
import packagebdd.selectBDD;
import static packagebdd.selectBDD.*;
//import static packageui.Accueil.CurrentU;
//import static packageui.Accueil.CurrentCP;
//import static packageui.Accueil.CurrentA;
import static packageui.Accueil.Current;
import static packageui.Accueil.user;
//import static packageui.Accueil.listeMessages;
import static packageui.Accueil.SalonGlobal;
import static packageui.Accueil.Mess;
import static packageui.Accueil.tempU;
import static packageui.Accueil.tempS;
//import static packageui.Accueil.listeAllUsers;
//import static packagebdd.selectBDD.getListUtilisateur;


/**
 *
 * @author Francois
 */
public class Fenetre_principale extends javax.swing.JFrame {

    /**
     * Creates new form Salon
     */
    
    //Salon SalonGlobal = new Salon("Salon Global");
        
    static String destMessagerie = "" ;
    static Utilisateur destUser;
   
    public Fenetre_principale(){
        initComponents();
        
        Timer timerSalon = new Timer();
        timerSalon.schedule (new TimerTask() {
            @Override
            public void run(){
                refreshActionSalon();
            }
        },0, 1000);
        
        repertoireMessagerie.setCellRenderer(new ListCellRenderer<Utilisateur>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Utilisateur> list, Utilisateur value, int index, boolean isSelected, boolean cellHasFocus) {

                JLabel l = new JLabel();
                if (isSelected) {
                    l.setForeground(Color.red);
                }
                
                //for(int i=0; i<=2; i++){
                    try {
                        l.setText(index + 1 + " - " + tempU.get(index).getNom() + " "+tempU.get(index).getPrenom()+"");
                    } catch (SQLException ex) {
                        Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //}
 
                
                return l;
            }
        });
        
        listeUtilisateurSalon.setCellRenderer(new ListCellRenderer<Utilisateur>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Utilisateur> list, Utilisateur value, int index, boolean isSelected, boolean cellHasFocus) {

                JLabel l = new JLabel();
                if (isSelected) {
                    l.setForeground(Color.red);
                }
                
                //for(int i=0; i<=2; i++){
                    try {
                        l.setText(index + 1 + " - " + Current.getNom() + " "+Current.getPrenom()+"");
                    } catch (SQLException ex) {
                        Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //}
                    
                
                
                return l;
            }
        });
        
       listSalon.setCellRenderer(new ListCellRenderer<Salon>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Salon> list, Salon value, int index, boolean isSelected, boolean cellHasFocus) {

                JLabel l = new JLabel();
                if (isSelected) {
                    l.setForeground(Color.red);
                }
                
                l.setText(index + 1 + " - " + tempS.get(index).getDescription());
                
                
                return l;
            }

         
        });
      // rafraichir la messagerie 
        refreshActionMessagerie();
        
    }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profil = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        sendSalontexte = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeUtilisateurSalon = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listSalon = new javax.swing.JList<>();
        rechercheSalon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sendSalonSend = new javax.swing.JButton();
        decoButtonSalon = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ajoutUtilisateur = new javax.swing.JButton();
        nomUtilisateur = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jMessageSalon = new javax.swing.JTextArea();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        rechercheMessagerie = new javax.swing.JTextField();
        validerRechercheMessagerie = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        sendMessageMessagerie = new javax.swing.JTextArea();
        validerSendMessageMessagie = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        affichageMessageMessagerie = new java.awt.TextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        repertoireMessagerie = new javax.swing.JList<>();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        validerProfil = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        titreProfil = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        firstnameprofil = new javax.swing.JLabel();
        mailprofil = new javax.swing.JLabel();
        nameprofil = new javax.swing.JLabel();
        serviceprofil = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        changerpwd = new javax.swing.JTextField();
        confirmpwd = new javax.swing.JTextField();
        pwdancien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sendSalontexte.setColumns(20);
        sendSalontexte.setRows(5);
        jScrollPane1.setViewportView(sendSalontexte);

        listeUtilisateurSalon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listeUtilisateurSalon.setModel(SalonGlobal);
        jScrollPane2.setViewportView(listeUtilisateurSalon);

        listSalon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listSalon.setModel(Current);
        listSalon.setToolTipText("");
        jScrollPane3.setViewportView(listSalon);

        rechercheSalon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("SALON");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Recherche :");

        sendSalonSend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sendSalonSend.setText("Send");
        sendSalonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendSalonSendActionPerformed(evt);
            }
        });

        decoButtonSalon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        decoButtonSalon.setText("Deconnexion");
        decoButtonSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decoButtonSalonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Liste des salons");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Liste d'utilisateurs");

        ajoutUtilisateur.setText("Ajouter un utilisateur à mon salon");
        ajoutUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutUtilisateurActionPerformed(evt);
            }
        });

        nomUtilisateur.setText("Nom de l'utilisateur");

        jMessageSalon.setEditable(false);
        jMessageSalon.setColumns(20);
        jMessageSalon.setRows(5);
        jScrollPane7.setViewportView(jMessageSalon);

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(rechercheSalon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(sendSalonSend, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(decoButtonSalon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ajoutUtilisateur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(nomUtilisateur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane1Layout.createSequentialGroup()
                            .addGap(230, 230, 230)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(rechercheSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(ajoutUtilisateur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sendSalonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(155, 155, 155)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decoButtonSalon)
                            .addComponent(jLabel4))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decoButtonSalon))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rechercheSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(sendSalonSend, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ajoutUtilisateur)
                    .addComponent(nomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        profil.addTab("SALON", jLayeredPane1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Messagerie");

        rechercheMessagerie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rechercheMessagerie.setText("Recherche");
        rechercheMessagerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheMessagerieActionPerformed(evt);
            }
        });

        validerRechercheMessagerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        validerRechercheMessagerie.setText("Valider");

        sendMessageMessagerie.setColumns(20);
        sendMessageMessagerie.setRows(5);
        jScrollPane5.setViewportView(sendMessageMessagerie);

        validerSendMessageMessagie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        validerSendMessageMessagie.setText("Valider");
        validerSendMessageMessagie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerSendMessageMessagieActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Votre message");

        affichageMessageMessagerie.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(192, 192, 192))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(affichageMessageMessagerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validerSendMessageMessagie)
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(affichageMessageMessagerie, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(validerSendMessageMessagie, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(16, 16, 16))))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Repertoire");

        repertoireMessagerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        repertoireMessagerie.setModel(Mess);
        repertoireMessagerie.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        repertoireMessagerie.setToolTipText("");
        jScrollPane6.setViewportView(repertoireMessagerie);

        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(rechercheMessagerie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(validerRechercheMessagerie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(rechercheMessagerie, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(validerRechercheMessagerie, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rechercheMessagerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validerRechercheMessagerie))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        profil.addTab("MESSAGERIE", jLayeredPane2);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Confirmer :");
        jLabel10.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Service :");

        validerProfil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        validerProfil.setText("Valider");
        validerProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerProfilActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("First name: ");

        titreProfil.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        titreProfil.setText("Profil");
        titreProfil.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Name: ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Mail: ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Changer de password: ");

        firstnameprofil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstnameprofil.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                firstnameprofilHierarchyChanged(evt);
            }
        });

        mailprofil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mailprofil.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                mailprofilHierarchyChanged(evt);
            }
        });

        nameprofil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameprofil.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                nameprofilHierarchyChanged(evt);
            }
        });

        serviceprofil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        serviceprofil.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                serviceprofilHierarchyChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Ancien mot de passe:");
        jLabel11.setToolTipText("");

        changerpwd.setText("Nouveau pwd");

        confirmpwd.setText("Confirmation");

        pwdancien.setText("Verif");
        pwdancien.setToolTipText("");

        jLayeredPane3.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(validerProfil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(titreProfil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(firstnameprofil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(mailprofil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(nameprofil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(serviceprofil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(changerpwd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(confirmpwd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(pwdancien, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(validerProfil))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(80, 80, 80)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmpwd)
                            .addComponent(changerpwd, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(pwdancien))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(firstnameprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane3Layout.createSequentialGroup()
                                    .addGap(283, 283, 283)
                                    .addComponent(titreProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(nameprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14)
                            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(164, 164, 164))
                                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(191, 191, 191)))
                                .addComponent(serviceprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(mailprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(666, 666, 666))))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titreProfil)
                .addGap(44, 44, 44)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(firstnameprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(nameprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(mailprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(serviceprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(changerpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(confirmpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pwdancien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(validerProfil)
                .addGap(33, 33, 33))
        );

        profil.addTab("PROFIL", jLayeredPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profil)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profil)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decoButtonSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decoButtonSalonActionPerformed
         // TODO add your handling code here:
       String droit = "";
       String mail = "";
       
       
       
      /* switch(user){
           case 1 : mail = CurrentA.getMail();break;
           case 2 : mail = CurrentCP.getMail();break;
           default : mail = CurrentU.getMail();break;
           
       }*/
          
        try {
            droit = selectBDD.checkright(mail);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(droit.equals("USER")){
           try {
               Current.Deconnexion(Current.getNom(), Current.getPrenom(), user);
           } catch (SQLException ex) {
               Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }
        else{
            if(droit.equals("CHEF_PROJET")){
                try {
                    Current.Deconnexion(Current.getNom(), Current.getPrenom(), user);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                if(droit.equals("ADMIN")){
                    try {
                       Current.Deconnexion(Current.getNom(), Current.getPrenom(), user);
                    } catch (SQLException ex) {
                        Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        dispose();
        Accueil Accueil = new Accueil();
        Accueil.setVisible(true);
    }//GEN-LAST:event_decoButtonSalonActionPerformed

    private void rechercheMessagerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheMessagerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechercheMessagerieActionPerformed

    
    private void sendSalonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendSalonSendActionPerformed
       // TODO add your handling code here:
        String salonText = sendSalontexte.getText();
        
        SimpleDateFormat annee = new SimpleDateFormat("YYYY");
        SimpleDateFormat mois = new SimpleDateFormat("MM");
        SimpleDateFormat jour = new SimpleDateFormat("dd");
        SimpleDateFormat heure = new SimpleDateFormat("HH");
        SimpleDateFormat minute = new SimpleDateFormat("mm");
	   //get current date time with Date()
	  java.util.Date date = new java.util.Date();
          String testD;
        testD = "\n\nEnvoyé à "+heure.format(date)+":"+minute.format(date)+" le "+jour.format(date)+"-"+mois.format(date)+"-"+annee.format(date);
           
        Messages msg = null;
        
                try {
                msg = new Messages(salonText, testD, Current, SalonGlobal);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    addmsg(msg);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
                //on vide la zone de texte 
                sendSalontexte.setText("");
                refreshActionSalon();

    }//GEN-LAST:event_sendSalonSendActionPerformed

    private void ajoutUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutUtilisateurActionPerformed
               // TODO add your handling code here:
                
                // on prend juste le nom de l'utilisateur
                String userNameMail = nomUtilisateur.getText();
                String userMail = "";
                
                
        try {
            //vérifie si l'utilisateur est admin
            String droitU = selectBDD.checkright(Current.getMail());
            
            String bdd= getNomSalon(Current.getMail());
            String CurrentSalon = SalonGlobal.getDescription();
        
        if( ( droitU.equals("ADMIN") || ( droitU.equals("CHEF_PROJET") && (bdd.equals(CurrentSalon))) ) )
        {
            
            System.out.println(droitU);
                
                //select pour vérifier un utilisateur avec l'adresse mail existe
                try
                {
                    userMail = selectBDD.getUtilisateur(userNameMail);
                    // on teste 
                    //System.out.println("User added to salon, "+userNameMail);
                    if ( userMail.equals(userNameMail) )
                    {
                        // l'utilisateur existe
                        addUserSalon(userNameMail, CurrentSalon);
                        System.out.println("User added to salon");
                        JOptionPane.showMessageDialog(this,"Vous avez ajouté "+userNameMail+" au salon", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"L'utilisateur n'existe pas !", "Erreur de confirmation", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        else
        {
            JOptionPane.showMessageDialog(this,"Vous n'êtes pas autoriser à ajouter un utilisateur à se salon", "Erreur de confirmation", JOptionPane.ERROR_MESSAGE);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_ajoutUtilisateurActionPerformed

    
    
  // refresh les messages des salons   
    private void refreshActionSalon()
    {
        try {// TODO add your handling code here:

            selectBDD.getListSalonUtilisateur(Current);
            String tampon = selectBDD.getMessageSalon("Salon Global");

            //faut afficher les messages dans le textarea
            jMessageSalon.setText(tampon);

        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:

    } 
    
     // refresh lors de la selection de l'utilisateur en privé   
    public void refreshActionMessagerie()
    {
        // mise à jour de la messagerie
        
        repertoireMessagerie.addListSelectionListener(new ListSelectionListener() {
             
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
                if ( e.getValueIsAdjusting() )
                {
                    //rString refreshM = repertoireMessagerie.getSelectedValue().toString();.toString();
                    //System.out.println(refreshM);
                    
                        destMessagerie = repertoireMessagerie.getSelectedValue().getMail();
                        destUser = repertoireMessagerie.getSelectedValue();
                        
                    try {
                        //afficher les messages appropriés
                        String messMessagerie = selectBDD.getMessageSalon( destMessagerie );
                        
                        //faut afficher les messages dans le textarea
                        affichageMessageMessagerie.setText(messMessagerie);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                    }

                        
                    
                }
            }
        }
        
        );
    }

    private void firstnameprofilHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_firstnameprofilHierarchyChanged
        // TODO add your handling code here:
             String name;
        try {
            name = Current.getNom();
            firstnameprofil.setText(name);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_firstnameprofilHierarchyChanged

    private void mailprofilHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_mailprofilHierarchyChanged
        // TODO add your handling code here:
        String mail;
        mail = Current.getMail();
        mailprofil.setText(mail); 
    }//GEN-LAST:event_mailprofilHierarchyChanged

    private void nameprofilHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_nameprofilHierarchyChanged
        // TODO add your handling code here:
        String prename;
        try {
            prename = Current.getPrenom();
            nameprofil.setText(prename);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_nameprofilHierarchyChanged

    private void serviceprofilHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_serviceprofilHierarchyChanged
        // TODO add your handling code here:
        String service;
        
        try {
            service = Current.getService();
            serviceprofil.setText(service);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_serviceprofilHierarchyChanged

    private void validerProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerProfilActionPerformed
        // TODO add your handling code here:
            Connection connect = coBDD.connect();
            Statement smt;
        try {
            smt = connect.createStatement();
            String sql = "SELECT mdpU FROM utilisateurs WHERE mailU ='"+Current.getMail()+"'";
            ResultSet resultat = smt.executeQuery(sql);
            if(resultat.next()){
                
                String motPasseUtilisateur = resultat.getString(1);
                String nouveaumdp = changerpwd.getText();
                String confirmnouveaumdp = confirmpwd.getText();              
                String ancienmdp = pwdancien.getText();
                
                
                System.out.println(Current.getMail());
            
                if (motPasseUtilisateur.equals(ancienmdp) ) { 
                    System.out.println(ancienmdp);
                    if(confirmnouveaumdp.equals(nouveaumdp)){
                    System.out.println("fesf");
                    
                        // create the java mysql update preparedstatement
                        String query = "UPDATE utilisateurs SET mdpU = ? WHERE mailU = ?";
                        PreparedStatement preparedStmt = connect.prepareStatement(query);
                        preparedStmt.setString(1, nouveaumdp);
                        preparedStmt.setString(2, Current.getMail());
 
                        // execute the java preparedstatement
                        preparedStmt.executeUpdate();
                        
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Les mots de passes ne sont pas identiques", "Erreur de confirmation", JOptionPane.ERROR_MESSAGE);
                    }
                }              
                else{
                    JOptionPane.showMessageDialog(this,"Le mot de passe pour autoriser le changement est invalide", "Mauvais mot de passe", JOptionPane.ERROR_MESSAGE);
                }
 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
              
                
    }//GEN-LAST:event_validerProfilActionPerformed

    
    private void validerSendMessageMessagieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerSendMessageMessagieActionPerformed
        // TODO add your handling code here:
        String msgText = sendMessageMessagerie.getText();
        
        SimpleDateFormat annee = new SimpleDateFormat("YYYY");
        SimpleDateFormat mois = new SimpleDateFormat("MM");
        SimpleDateFormat jour = new SimpleDateFormat("dd");
        SimpleDateFormat heure = new SimpleDateFormat("HH");
        SimpleDateFormat minute = new SimpleDateFormat("mm");
	   //get current date time with Date()
	  java.util.Date date = new java.util.Date();
          String testD;
        testD = "\n\nEnvoyé à "+heure.format(date)+":"+minute.format(date)+" le "+jour.format(date)+"-"+mois.format(date)+"-"+annee.format(date);
           
        Messages msg = null;
        
                try {
                msg = new Messages(msgText, testD, Current, destUser);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    addmsg(msg);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
                //on vide la zone de texte 
                sendSalontexte.setText("");
                refreshActionSalon();
    }//GEN-LAST:event_validerSendMessageMessagieActionPerformed

  
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new Salon().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea affichageMessageMessagerie;
    private javax.swing.JButton ajoutUtilisateur;
    private javax.swing.JTextField changerpwd;
    private javax.swing.JTextField confirmpwd;
    private javax.swing.JButton decoButtonSalon;
    private javax.swing.JLabel firstnameprofil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JTextArea jMessageSalon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<Salon> listSalon;
    private javax.swing.JList<Utilisateur> listeUtilisateurSalon;
    private javax.swing.JLabel mailprofil;
    private javax.swing.JLabel nameprofil;
    private javax.swing.JTextField nomUtilisateur;
    private javax.swing.JTabbedPane profil;
    private javax.swing.JTextField pwdancien;
    private javax.swing.JTextField rechercheMessagerie;
    private javax.swing.JTextField rechercheSalon;
    private javax.swing.JList<Utilisateur> repertoireMessagerie;
    private javax.swing.JTextArea sendMessageMessagerie;
    private javax.swing.JButton sendSalonSend;
    private javax.swing.JTextArea sendSalontexte;
    private javax.swing.JLabel serviceprofil;
    private javax.swing.JLabel titreProfil;
    private javax.swing.JButton validerProfil;
    private javax.swing.JButton validerRechercheMessagerie;
    private javax.swing.JButton validerSendMessageMessagie;
    // End of variables declaration//GEN-END:variables
}
