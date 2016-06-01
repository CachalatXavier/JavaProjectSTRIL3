/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageapi;

import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
//import static packagebdd.selectBDD.listUser;

/**
 *
 * @author Cyril
 */
public class MaListeUserPerso implements ListCellRenderer {
    
    public static DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
    
    public Component getListCellRendererComponent(JList list, Object value, int index,
      boolean isSelected, boolean cellHasFocus) {
    JLabel monLabel;
        monLabel = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
    if (isSelected) {
                    monLabel.setForeground(Color.red);
                }
    if(value instanceof Utilisateur)
    {
        Utilisateur actualUsers = (Utilisateur) value;
        
        try {
            monLabel.setText(index + 1 + " - " + actualUsers.getNom() + " "+actualUsers.getPrenom()+"");
        } catch (SQLException ex) {
            Logger.getLogger(MaListeUserPerso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return monLabel;
  }
    
}
