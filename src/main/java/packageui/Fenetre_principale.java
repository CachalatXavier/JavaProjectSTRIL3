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
import static java.util.Collections.list;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import packageapi.MaListeUserPerso;
//import packageapi.Admin;
import packageapi.Messages;
import packageapi.Salon;
import packageapi.Utilisateur;
import packagebdd.coBDD;
import static packagebdd.decoBDD.deconnect;
import packagebdd.insertBDD;
import static packagebdd.insertBDD.addUserSalon;
import static packagebdd.insertBDD.addmsg;
import packagebdd.selectBDD;
import static packagebdd.selectBDD.*;
import static packageui.Accueil.Current;
import static packageui.Accueil.user;
import static packageui.Accueil.SalonGlobal;
import static packageui.Accueil.Mess;
import static packageui.Accueil.tempS;
import static packageui.Accueil.tempList;
import static packageapi.MaListeUserPerso.defaultRenderer;
//import static packageui.Accueil.listeAllUsers;
//import static packagebdd.selectBDD.getListUtilisateur;
import static packageapi.Salon.listeUsers;
import static packageapi.Messagerie.allUsers;
import static packageui.Accueil.tempList2;
//import static packageui.Accueil.Mess2;


/**
 *
 * @author Francois
 */
public class Fenetre_principale extends javax.swing.JFrame {

    /**
     * Creates new form Salon
     */
    
    // variable globale
/* destinataire de message pour la messagerie privée*/    
    static String destMessagerie = "" ;
/*  utilisateur destinataire des messages */
    static Utilisateur destUser;
   
      /*methode crée*/
    // refresh les messages des salons   
    private void refreshActionSalon()
    {
            //listeUtilisateurSalon.addListSelectionListener((ListSelectionEvent e) -> {
            //throw new UnsupportedOperationException("Not supported yet.");
            //To change body of generated methods, choose Tools | Templates.
           // if ( e.getValueIsAdjusting() )
           // {
                 
                try {
                    selectBDD.getListSalonUtilisateur(Current);
                    String tampon = selectBDD.getMessageSalon("Salon Global");
                    //faut afficher les messages dans le textarea
                    jMessageSalon.setText(tampon);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
  
        // }
    }  
                    
     // refresh lors de la selection de l'utilisateur en privé   

    /**
     *
     */
    public void refreshActionMessagerie()
    {
        
        // mise à jour de la messagerie
        repertoireMessagerie.addListSelectionListener((ListSelectionEvent e) -> {
            //throw new UnsupportedOperationException("Not supported yet.");
            //To change body of generated methods, choose Tools | Templates.
            if ( e.getValueIsAdjusting() )
            {
                // d'abord on clean les messages
                
                // on recuper juste l'utilisateur et le nom de l'utilisateur
                try {
                    affichageMessageMessagerie.setText("");
                    destUser = repertoireMessagerie.getSelectedValue();
                    destMessagerie = destUser.getNom();
                    
                    //afficher les messages appropriés
                    String messMessagerie = selectBDD.getMessageMessagerie( destMessagerie, Current.getNom() );
                    
                    //faut afficher les messages dans le textarea
                    affichageMessageMessagerie.setText(messMessagerie);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
    }
    
    public void refreshActionListSalon()
	{
    	listSalon.addListSelectionListener( (ListSelectionEvent ev ) ->
    	{
        	if( ev.getValueIsAdjusting() )
        	{
            	try{
                	jMessageSalon.setText("");
                	SalonGlobal = listSalon.getSelectedValue();
               	 
                	//recupere les messages deu salon selection
                	String messSalon = selectBDD.getMessageSalon( SalonGlobal.getDescription() );
               	 
                	// affiche les messages
                	jMessageSalon.setText(messSalon);
               	 
            	} catch (SQLException ex) {
                	Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            	}
        	}
    	});
	}

    
    /**
     *
     */
    public Fenetre_principale(){
        initComponents();
        
        Timer timerSalon = new Timer();
        timerSalon.schedule (new TimerTask() {
            @Override
            public void run(){
                refreshActionSalon();
                // on rafraichir;
                /*try
                {
                    affichageMessageMessagerie.setText("");
                    destUser = repertoireMessagerie.getSelectedValue();
                    destMessagerie = destUser.getNom();
                    
                    //afficher les messages appropriés
                    String messMessagerie = selectBDD.getMessageMessagerie( destMessagerie, Current.getNom() );
                    
                    //faut afficher les messages dans le textarea
                    affichageMessageMessagerie.setText(messMessagerie);
                }
                catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        },0, 1000);
        
        
        
        repertoireMessagerie.setCellRenderer(new MaListeUserPerso());
        listeUtilisateurSalon.setCellRenderer(new MaListeUserPerso());
       
       /* listeUtilisateurSalon.setCellRenderer(new ListCellRenderer<Utilisateur>() {
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
        });*/
        
        // liste des salons en fonction de l'utilisateur connecter
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
        refreshActionListSalon();
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
        jLabel1 = new javax.swing.JLabel();
        sendSalonSend = new javax.swing.JButton();
        decoButtonSalon = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ajoutUtilisateur = new javax.swing.JButton();
        nomUtilisateur = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jMessageSalon = new javax.swing.JTextArea();
        NameNewSalon = new javax.swing.JTextField();
        crationSalon = new javax.swing.JButton();
        afk = new javax.swing.JButton();
        RefreshUserPresent = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("SALON");

        sendSalonSend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sendSalonSend.setText("Envoyer");
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

        jMessageSalon.setEditable(false);
        jMessageSalon.setColumns(20);
        jMessageSalon.setRows(5);
        jScrollPane7.setViewportView(jMessageSalon);

        NameNewSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameNewSalonActionPerformed(evt);
            }
        });

        crationSalon.setText("Création d'un salon");
        crationSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crationSalonActionPerformed(evt);
            }
        });

        afk.setText("Absent");
        afk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afkActionPerformed(evt);
            }
        });

        RefreshUserPresent.setText("Rafraichir");
        RefreshUserPresent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshUserPresentActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(sendSalonSend, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(decoButtonSalon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ajoutUtilisateur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(nomUtilisateur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(NameNewSalon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(crationSalon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(afk, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(RefreshUserPresent, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(345, 345, 345)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ajoutUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(crationSalon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NameNewSalon)
                                    .addComponent(nomUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendSalonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(148, 148, 148)))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decoButtonSalon)
                            .addComponent(jLabel4)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(afk)
                                .addGap(52, 52, 52)
                                .addComponent(RefreshUserPresent)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decoButtonSalon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(sendSalonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(afk)
                    .addComponent(RefreshUserPresent))
                .addGap(24, 24, 24)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ajoutUtilisateur)
                    .addComponent(nomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameNewSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crationSalon))
                .addGap(16, 16, 16))
        );

        profil.addTab("SALON", jLayeredPane1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Messagerie");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(affichageMessageMessagerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validerSendMessageMessagie)
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(affichageMessageMessagerie, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(validerSendMessageMessagie, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Repertoire");

        repertoireMessagerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        repertoireMessagerie.setModel(Mess);
        repertoireMessagerie.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        repertoireMessagerie.setToolTipText("");
        jScrollPane6.setViewportView(repertoireMessagerie);

        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(512, 512, 512))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(25, 25, 25)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane3Layout.createSequentialGroup()
                            .addGap(283, 283, 283)
                            .addComponent(titreProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nameprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14)
                    .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane3Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(191, 191, 191)
                            .addComponent(serviceprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jLayeredPane3Layout.createSequentialGroup()
                            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(103, 103, 103)))
                            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(firstnameprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mailprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(775, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titreProfil)
                .addGap(44, 44, 44)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstnameprofil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(validerProfil)
                .addGap(33, 33, 33))
        );

        confirmpwd.getAccessibleContext().setAccessibleName("");

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
       
       mail = Current.getMail();
       
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
               Current.Deconnexion(Current.getNom(), Current.getPrenom(), Current.getMail(), user);
           } catch (SQLException ex) {
               Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }
        else{
            if(droit.equals("CHEF_PROJET")){
                try {
                    Current.Deconnexion(Current.getNom(), Current.getPrenom(), Current.getMail(), user);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                if(droit.equals("ADMIN")){
                    try {
                       Current.Deconnexion(Current.getNom(), Current.getPrenom(), Current.getMail(), user);
                    } catch (SQLException ex) {
                        Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        tempList.clear();
        tempList2.clear();
        listeUsers.clear();
        allUsers.clear();
        //tempS.clear();
        System.out.println("Contenu "+tempList);
        dispose();
        Accueil Accueil = new Accueil();
        Accueil.setVisible(true);
    }//GEN-LAST:event_decoButtonSalonActionPerformed

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
        testD = "Envoyé à "+heure.format(date)+":"+minute.format(date)+" le "+jour.format(date)+"-"+mois.format(date)+"-"+annee.format(date);
           
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
            
            //on récupert dans bdd le nom du salon auquel le current user est chef de projet
            String bdd = getNomSalon(Current.getMail());
            //on récupert le nom du salon courrant
            String CurrentSalon = SalonGlobal.getDescription();
        
            //on test les droit de l'utilisateur, s'il n'est pas admin on verifie qu'il soit bien chef de projet du salon courrant
        if( ( droitU.equals("ADMIN") || ( droitU.equals("CHEF_PROJET") && (bdd.equals(CurrentSalon))) ) )
        {
            
            //on test si l'utilisateur à ajouter n'est pas déjà dans le salon
           List malistSalon = selectBDD.getListSalonViaMail(userNameMail);
           int tmp = 0;
           for(Iterator it = malistSalon.iterator();it.hasNext();){
              Salon sal;
               sal = (Salon) it.next();
              String salnom = sal.getDescription();
               if(salnom.equals(CurrentSalon)){    
                  JOptionPane.showMessageDialog(this,"L'utilisateur est déjà dans le salon !", "Erreur de confirmation", JOptionPane.ERROR_MESSAGE);
                  tmp = 1;
               }
            }

                if (tmp==0){   
                    //select pour vérifier un utilisateur avec l'adresse mail existe
                    try
                    {
                        userMail = selectBDD.getUtilisateur(userNameMail);
                        //on teste 
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
            }
        else
        {
            JOptionPane.showMessageDialog(this,"Vous n'êtes pas autoriser à ajouter un utilisateur à se salon", "Erreur de confirmation", JOptionPane.ERROR_MESSAGE);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_ajoutUtilisateurActionPerformed

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
        testD = "Envoyé à "+heure.format(date)+":"+minute.format(date)+" le "+jour.format(date)+"-"+mois.format(date)+"-"+annee.format(date);
           
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
                sendMessageMessagerie.setText("");
                // on rafraichi
                try
                {
                    affichageMessageMessagerie.setText("");
                    destUser = repertoireMessagerie.getSelectedValue();
                    destMessagerie = destUser.getNom();
                    
                    //afficher les messages appropriés
                    String messMessagerie = selectBDD.getMessageMessagerie( destMessagerie, Current.getNom() );
                    
                    //faut afficher les messages dans le textarea
                    affichageMessageMessagerie.setText(messMessagerie);
                }
                catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    }//GEN-LAST:event_validerSendMessageMessagieActionPerformed
    
    /**
     *
     * @param e
     */
    public void windowClosing(WindowEvent e){
        String droit = "";
        String mail = "";
        mail = Current.getMail();
        
        try {
            droit = selectBDD.checkright(mail);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(droit.equals("USER")){
           try {
               Current.Deconnexion(Current.getNom(), Current.getPrenom(), Current.getMail(), user);
           } catch (SQLException ex) {
               Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }
        else{
            if(droit.equals("CHEF_PROJET")){
                try {
                    Current.Deconnexion(Current.getNom(), Current.getPrenom(), Current.getMail(), user);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                if(droit.equals("ADMIN")){
                    try {
                       Current.Deconnexion(Current.getNom(), Current.getPrenom(), Current.getMail(), user);
                    } catch (SQLException ex) {
                        Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
         //tempList2.clear();
        tempList.clear();
        tempList2.clear();
        listeUsers.clear();
        allUsers.clear();
        
    }
    
                                       

    private void crationSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crationSalonActionPerformed
        // TODO add your handling code here:
         // on prend juste le nom de l'utilisateur
                String nomSalon = NameNewSalon.getText();
               
                   
                
        try {
            //vérifie si l'utilisateur est admin
            String droitU = selectBDD.checkright(Current.getMail());
            
            
        
            //on test les droit de l'utilisateur, il doit être admin
        if(droitU.equals("ADMIN"))
        {
            
            //on test si le salon à créer n'est pas déjà existant
           List malistSalon = selectBDD.getListSalon();
           int tmp = 0;
           for(Iterator it = malistSalon.iterator();it.hasNext();){
              Salon sal;
               sal = (Salon) it.next();
              String salnom = sal.getDescription();
               if(salnom.equals(nomSalon)){    
                  JOptionPane.showMessageDialog(this,"Le salon existe déjà !", "Erreur de confirmation", JOptionPane.ERROR_MESSAGE);
                  tmp = 1;
               }
            }

                if (tmp==0){   
                    
                    insertBDD.createNewSalon(nomSalon);
                    JOptionPane.showMessageDialog(this,"Le salon "+nomSalon+" a été créé.", "Erreur de confirmation", JOptionPane.ERROR_MESSAGE);

                }
            }
        else
        {
            JOptionPane.showMessageDialog(this,"Vous n'êtes pas autoriser à créer un salon", "Erreur de confirmation", JOptionPane.ERROR_MESSAGE);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
    }//GEN-LAST:event_crationSalonActionPerformed

    private void NameNewSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameNewSalonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameNewSalonActionPerformed

    private void afkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afkActionPerformed
        try {
            // TODO add your handling code here:
            int pres = Current.getPresence();
            //on récup l'etat et on l'inverse
            
            
            if(pres==1){
                Current.setPresence(2);
            }
            else if (pres==2){
                Current.setPresence(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_afkActionPerformed

    private void RefreshUserPresentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshUserPresentActionPerformed
        // TODO add your handling code here:
        tempList2.clear();
        defaultRenderer.removeAll();
        SalonGlobal.deleteuser();
        try {
            tempList2 = selectBDD.getUserPresent();
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
        }
       for(int i=0; i<tempList2.size();i++){
           
            try {
                //System.out.println(tempList2.get(i).getNom());
                SalonGlobal.adduser(tempList2.get(i));
            } catch (SQLException ex) {
                Logger.getLogger(Fenetre_principale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_RefreshUserPresentActionPerformed

  
     
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
        java.awt.EventQueue.invokeLater(() -> {
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameNewSalon;
    private javax.swing.JButton RefreshUserPresent;
    private java.awt.TextArea affichageMessageMessagerie;
    private javax.swing.JButton afk;
    private javax.swing.JButton ajoutUtilisateur;
    private javax.swing.JTextField changerpwd;
    private javax.swing.JTextField confirmpwd;
    private javax.swing.JButton crationSalon;
    private javax.swing.JButton decoButtonSalon;
    private javax.swing.JLabel firstnameprofil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JList<Utilisateur> repertoireMessagerie;
    private javax.swing.JTextArea sendMessageMessagerie;
    private javax.swing.JButton sendSalonSend;
    private javax.swing.JTextArea sendSalontexte;
    private javax.swing.JLabel serviceprofil;
    private javax.swing.JLabel titreProfil;
    private javax.swing.JButton validerProfil;
    private javax.swing.JButton validerSendMessageMessagie;
    // End of variables declaration//GEN-END:variables
}
