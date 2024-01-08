/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ManHinh;

/**
 *
 * @author Admin
 */
public class Manhinh_batdau extends javax.swing.JDialog {

    /**
     * Creates new form Manhinh_batdau
     */
    public Manhinh_batdau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        lbStatus = new javax.swing.JLabel();
        newProgressBarCustom1 = new ManHinh.NewProgressBarCustom();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(667, 400));
        setMinimumSize(new java.awt.Dimension(667, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbStatus.setFont(new java.awt.Font("UTM Nokia", 0, 12)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatus.setText("STATUS");
        getContentPane().add(lbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 180, -1));

        newProgressBarCustom1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(newProgressBarCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 480, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManHinh/StartImg 2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 667, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      new Thread(new Runnable() {
          @Override
          public void run() {
              try {
                    doTask("Connect To Database ...", 10);
                    doTask("Task 1 ...", 20);
                    doTask("Task 2 ...", 30);
                    doTask("Task 3 ...", 40);
                    doTask("Task 4 ...", 50);
                    doTask("Task 5 ...", 60);
                    doTask("Task 6 ...", 70);
                    doTask("Task 7 ...", 80);
                    doTask("Task 8 ...", 90);
                    doTask("Task 9 ...", 100);
                    doTask("Done ...", 100);
                    dispose();
              } catch (Exception e) {
              }
//              throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          }
      }).start();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    private void doTask(String name,int progress) throws Exception{
        lbStatus.setText(name);
        Thread.sleep( 500);
        newProgressBarCustom1.setValue(progress);
        
    }
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
            java.util.logging.Logger.getLogger(Manhinh_batdau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manhinh_batdau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manhinh_batdau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manhinh_batdau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Manhinh_batdau dialog = new Manhinh_batdau(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbStatus;
    private ManHinh.NewProgressBarCustom newProgressBarCustom1;
    // End of variables declaration//GEN-END:variables
}
