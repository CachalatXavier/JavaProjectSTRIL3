/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import packageapi.Messagerie;
import packageapi.Messages;
import packageapi.Salon;
import packageapi.Utilisateur;
import packagebdd.selectBDD;



/**
 *
 * @author Xavier
 */
public class Accueil extends javax.swing.JFrame {
    //static Utilisateur CurrentU = new Utilisateur("");
   // static Chef_Projet CurrentCP = new Chef_Projet("");
    //static Admin CurrentA = new Admin("");
    static int user = 0;
    static List<Utilisateur> listeUsers = new ArrayList<Utilisateur>();
    static List<Messages> listeMessages = new ArrayList<Messages>();
    static Salon SalonGlobal = new Salon("Salon Global");
    static List<Utilisateur> listeAllUsers = new ArrayList<Utilisateur>();
    static Messagerie Mess = new Messagerie();
    //static Messagerie Mess2 = new Messagerie();
    static Utilisateur Current = new Utilisateur("");
    static ArrayList<Salon> tempS = new ArrayList<Salon>();
    static List<Utilisateur> tempList = new ArrayList<Utilisateur>();
    static List<Utilisateur> tempList2 = new ArrayList<Utilisateur>();

    /**
     * Creates new form Acceuil
     */
    public Accueil() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mailAccueil = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        connexion = new javax.swing.JButton();
        inscription = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        quitter = new javax.swing.JButton();
        motDePasse = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenue dans la messagerie STRI ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("S'enregistrer");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Se connecter");

        mailAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailAccueilActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mail");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mot de passe");

        connexion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        connexion.setText("Connexion");
        connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connexionActionPerformed(evt);
            }
        });

        inscription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inscription.setText("S'inscrire");
        inscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscriptionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Accueil ");

        quitter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quitter.setText("Quitter");
        quitter.setActionCommand("Quittez");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        motDePasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motDePasseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 206, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(349, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(quitter)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(motDePasse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mailAccueil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(155, 155, 155))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inscription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mailAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(motDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(connexion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(quitter)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscriptionActionPerformed
        // TODO add your handling code here:
        dispose();
        Formulaire formulaire = new Formulaire();
        formulaire.setVisible(true);
    }//GEN-LAST:event_inscriptionActionPerformed

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_quitterActionPerformed

    private void connexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connexionActionPerformed
        // TODO add your handling code here:
        String mail = mailAccueil.getText();
        String pass = motDePasse.getText();
        String nom =  "";
        String prenom = "";
        String service = "";
        String droit = "";
        boolean exist = false;
        
        System.out.println(mail);
        System.out.println(pass);
        
        try {
             exist = selectBDD.isuservalid(mail,pass);
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(exist == true)
        {
            dispose();
            Fenetre_principale MainWindow = new Fenetre_principale();
            MainWindow.setVisible(true);
            
            try {
                droit = selectBDD.checkright(mail);
            } catch (SQLException ex) {
                Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
      
            
            if(droit.equals("USER")){
                user = 3;
                Current = recupUser(mail, user);
       
            }
            else{
                if(droit.equals("CHEF_PROJET")){
                    user = 2;
                    Current = recupUser(mail, user);
                }
                else {
                    if(droit.equals("ADMIN")){
                        user = 1;
                        Current = recupUser(mail, user);
                    }
                }
            }
            
            /*try {
                SalonGlobal.adduser(Current);
            } catch (SQLException ex) {
                Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            try {
                userMess();
            } catch (SQLException ex) {
                Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           try {
                addSalonUser();
            } catch (SQLException ex) {
                Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
               
        }    
    }//GEN-LAST:event_connexionActionPerformed

    /*
     *
     * @param mail
     * @param type
     * @return
     */
   /*public Admin recupAdmin(String mail) throws SQLException{
        String nom = "";
        String prenom = "";

        CurrentA.setMail(mail);
        nom = CurrentA.getNom();
        prenom = CurrentA.getPrenom();
        CurrentA.setPresence(nom, prenom);
      
                //SalonGlobal.adduser(CurrentU);
        return CurrentA;
    }
    
   public Chef_Projet recupChefProjet(String mail){
       String nom = "";
       String prenom = "";
       String service = "";

       CurrentCP.setMail(mail);
       try {
           nom = CurrentCP.getNom();
        } catch (SQLException ex) {
           Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            prenom = CurrentCP.getPrenom();
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            service = CurrentCP.getService();
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            CurrentCP.setPresence(nom, prenom);
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
                //SalonGlobal.adduser(CurrentU);
        return CurrentCP;
    }*/

    /**
     *
     * @param mail
     * @param type
     * @return
     */

   
   public Utilisateur recupUser(String mail, int type){
       String nom = "";
       String prenom = "";
       String service = "";
       
      
       
       Current.setMail(mail);
       
        try {
            System.out.println(Current.getNom());
            nom = Current.getNom();
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            prenom = Current.getPrenom();
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            service = Current.getService();
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Current.setPresence(nom, prenom, type);
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
                //SalonGlobal.adduser(CurrentU);
        return Current;
    }
   
   /*public void addUserSalonGlobal() throws SQLException{
       
        /*switch(user){
            case 1 : SalonGlobal.addadmin(CurrentA);break;
            case 2 : SalonGlobal.addChefProjet(CurrentCP);break;
            default : SalonGlobal.adduser(CurrentU);break;
        }
        SalonGlobal.adduser(Current);
   }*/

    /**
     *
     * @throws SQLException
     */

   
   public void userMess() throws SQLException{
       tempList = selectBDD.getListUtilisateur();
       for(int i=0; i<tempList.size();i++){
           Mess.addAllUsers(tempList.get(i));
       }
       
       System.out.println("ICIIIIIIIIIIIIIIII");
       tempList2 = selectBDD.getUserPresent();
       for(int i=0; i<tempList2.size();i++){
           
           System.out.println(tempList2.get(i).getNom());
           SalonGlobal.adduser(tempList2.get(i));
       }
      
   }
 
    /**
     *
     * @throws SQLException
     */
    public void addSalonUser() throws SQLException{
        List<Salon> S = new ArrayList<Salon>();
        S = selectBDD.getListSalon(Current);
       
       for(int i=0; i<S.size();i++){
           tempS.add(S.get(i));
           /*System.out.println(tempS.get(i).getDescription());
           System.out.println("JE SUIS LA");*/
           Current.salonUser(tempS.get(i));
       }
    }
   
    private void motDePasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motDePasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motDePasseActionPerformed

    private void mailAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailAccueilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailAccueilActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String args[]) throws SQLException {
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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /*Initialisation*/
        /*createTableBDD creation = new createTableBDD();
        MainBDDmin maBDDmin = new MainBDDmin();*/
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton connexion;
    private javax.swing.JButton inscription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField mailAccueil;
    private javax.swing.JTextField motDePasse;
    private javax.swing.JButton quitter;
    // End of variables declaration//GEN-END:variables

    private void elseif(boolean equals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
