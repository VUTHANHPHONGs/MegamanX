/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ManHinh;

import ManHinh.ManHinhLoadingSm;
import ManHinh.ManHinhLoadingSm_MULTI;
import ManHinh.Manhinh_batdau;
import com.mycompany.game.userinterface.GameFrame_Multi_Player_Mode;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class Menu_game extends javax.swing.JDialog {

    /**
     * Creates new form Menu_game
     */
    public Menu_game(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("MegaMan");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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

        jPanel1 = new javax.swing.JPanel();
        SingleButton = new javax.swing.JLabel();
        Mul = new javax.swing.JLabel();
        Map = new javax.swing.JLabel();
        misBt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        backgr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SingleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/Single 1.png"))); // NOI18N
        SingleButton.setText("jLabel1");
        SingleButton.setMaximumSize(new java.awt.Dimension(226, 107));
        SingleButton.setMinimumSize(new java.awt.Dimension(226, 107));
        SingleButton.setPreferredSize(new java.awt.Dimension(226, 107));
        SingleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SingleButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SingleButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SingleButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SingleButtonMousePressed(evt);
            }
        });
        jPanel1.add(SingleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 270, 110));

        Mul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/MulButton 1.png"))); // NOI18N
        Mul.setText("jLabel1");
        Mul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MulMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MulMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MulMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MulMousePressed(evt);
            }
        });
        jPanel1.add(Mul, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, 170, 110));

        Map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/Map 1.png"))); // NOI18N
        Map.setText("jLabel1");
        Map.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MapMouseExited(evt);
            }
        });
        jPanel1.add(Map, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 200, 90));

        misBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/Mission 1.png"))); // NOI18N
        misBt.setText("jLabel1");
        misBt.setMaximumSize(new java.awt.Dimension(224, 106));
        misBt.setMinimumSize(new java.awt.Dimension(224, 106));
        misBt.setPreferredSize(new java.awt.Dimension(224, 106));
        misBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                misBtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                misBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                misBtMouseExited(evt);
            }
        });
        jPanel1.add(misBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, -1, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/Equid 1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 150, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/Crter 1.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 140, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/Lap 1.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 450, 130, -1));

        backgr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/GDgame1 1.png"))); // NOI18N
        backgr.setText("jLabel1");
        jPanel1.add(backgr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 999, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new ImageIcon(this.getClass().getResource("Lap 1.png")));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new ImageIcon(this.getClass().getResource("Lap 1 1.png")));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new ImageIcon(this.getClass().getResource("Crter 1.png")));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new ImageIcon(this.getClass().getResource("Crter 1 1 (1).png")));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new ImageIcon(this.getClass().getResource("Equid 1.png")));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new ImageIcon(this.getClass().getResource("Equid 1 1.png")));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void misBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_misBtMouseExited
        misBt.setIcon(new ImageIcon(this.getClass().getResource("Mission 1.png")));    // TODO add your handling code here:
    }//GEN-LAST:event_misBtMouseExited

    private void misBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_misBtMouseEntered
        misBt.setIcon(new ImageIcon(this.getClass().getResource("Mission1_New.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_misBtMouseEntered

    private void MapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapMouseExited
        Map.setIcon(new ImageIcon(this.getClass().getResource("Map 1.png")));    // TODO add your handling code here:
    }//GEN-LAST:event_MapMouseExited

    private void MapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapMouseEntered
        Map.setIcon(new ImageIcon(this.getClass().getResource("Map 1 1.png")));    // TODO add your handling code here:
    }//GEN-LAST:event_MapMouseEntered

    private void MulMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MulMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MulMousePressed

    private void MulMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MulMouseExited
        Mul.setIcon(new ImageIcon(this.getClass().getResource("MulButton 1.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_MulMouseExited

    private void MulMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MulMouseEntered
        Mul.setIcon(new ImageIcon(this.getClass().getResource("MulButton 1 1.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_MulMouseEntered

    private void MulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MulMouseClicked
        dispose();
        new ManHinhLoadingSm_MULTI(null, true).setVisible(true);              // TODO add your handling code here:
    }//GEN-LAST:event_MulMouseClicked

    private void SingleButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SingleButtonMousePressed

    }//GEN-LAST:event_SingleButtonMousePressed

    private void SingleButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SingleButtonMouseExited
        SingleButton.setIcon(new ImageIcon(this.getClass().getResource("Single 1.png")));
        // TODO add your handling code here:
    }//GEN-LAST:event_SingleButtonMouseExited

    private void SingleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SingleButtonMouseEntered
        SingleButton.setIcon(new ImageIcon(this.getClass().getResource("SignleButtom_test.png")));
        // TODO add your handling code here:
    }//GEN-LAST:event_SingleButtonMouseEntered

    private void SingleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SingleButtonMouseClicked
        dispose();
        Thread thread1 = new Thread(() -> {
            // Lệnh thực hiện trong luồng thứ nhất
            try {
                new ManHinhLoadingSm(null, true).setVisible(true);

            } catch (Exception e) {
            }

        });
        thread1.start();

    }//GEN-LAST:event_SingleButtonMouseClicked

    private void misBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_misBtMouseClicked
        dispose();
        new SelectMission(null, true).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_misBtMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       dispose();
       new Charactor(null, true).setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    
    
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
            java.util.logging.Logger.getLogger(Menu_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manhinh_batdau(null,true).setVisible(true);
                Menu_game dialog = new Menu_game(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Map;
    private javax.swing.JLabel Mul;
    private javax.swing.JLabel SingleButton;
    private javax.swing.JLabel backgr;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel misBt;
    // End of variables declaration//GEN-END:variables
}
