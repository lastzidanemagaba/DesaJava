/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

/**
 *
 * @author Imul
 */
public class User extends javax.swing.JFrame {

    private int role;

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
    }
    
    public User(int role){
        initComponents();
        this.role = role;
        if (role > 0) {
            jPanel10.setVisible(false);
        }
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
        Psamping = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblFuzzy = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblEvaluasi = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblHistory = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblStruktur = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblProfilDesa = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblStruktur1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        Psamping.setBackground(new java.awt.Color(0, 204, 204));
        Psamping.setPreferredSize(new java.awt.Dimension(160, 650));
        Psamping.setLayout(new javax.swing.BoxLayout(Psamping, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.setLayout(new java.awt.GridLayout(1, 1));

        lblHome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("Home");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        jPanel5.add(lblHome);

        Psamping.add(jPanel5);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.setPreferredSize(new java.awt.Dimension(72, 31));
        jPanel4.setLayout(new java.awt.GridLayout(1, 1));

        lblFuzzy.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblFuzzy.setForeground(new java.awt.Color(52, 17, 9));
        lblFuzzy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFuzzy.setText("Fuzzy");
        lblFuzzy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFuzzyMouseClicked(evt);
            }
        });
        jPanel4.add(lblFuzzy);

        Psamping.add(jPanel4);

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel6.setPreferredSize(new java.awt.Dimension(72, 31));
        jPanel6.setLayout(new java.awt.GridLayout(1, 1));

        lblEvaluasi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblEvaluasi.setForeground(new java.awt.Color(52, 17, 9));
        lblEvaluasi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEvaluasi.setText("Evaluasi");
        lblEvaluasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvaluasiMouseClicked(evt);
            }
        });
        jPanel6.add(lblEvaluasi);

        Psamping.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel7.setPreferredSize(new java.awt.Dimension(72, 31));
        jPanel7.setLayout(new java.awt.GridLayout(1, 1));

        lblHistory.setBackground(new java.awt.Color(0, 204, 204));
        lblHistory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHistory.setText("History");
        jPanel7.add(lblHistory);

        Psamping.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel8.setPreferredSize(new java.awt.Dimension(72, 31));
        jPanel8.setLayout(new java.awt.GridLayout(1, 1));

        lblStruktur.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStruktur.setForeground(new java.awt.Color(52, 17, 9));
        lblStruktur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStruktur.setText("Struktur Desa");
        lblStruktur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStrukturMouseClicked(evt);
            }
        });
        jPanel8.add(lblStruktur);

        Psamping.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel9.setPreferredSize(new java.awt.Dimension(72, 31));
        jPanel9.setLayout(new java.awt.GridLayout(1, 1));

        lblProfilDesa.setBackground(new java.awt.Color(0, 204, 204));
        lblProfilDesa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblProfilDesa.setForeground(new java.awt.Color(52, 17, 9));
        lblProfilDesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfilDesa.setText("Profil Desa");
        lblProfilDesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProfilDesaMouseClicked(evt);
            }
        });
        jPanel9.add(lblProfilDesa);

        Psamping.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel10.setPreferredSize(new java.awt.Dimension(72, 31));
        jPanel10.setLayout(new java.awt.GridLayout(1, 1));

        lblStruktur1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblStruktur1.setForeground(new java.awt.Color(52, 17, 9));
        lblStruktur1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStruktur1.setText("User");
        lblStruktur1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStruktur1MouseClicked(evt);
            }
        });
        jPanel10.add(lblStruktur1);

        Psamping.add(jPanel10);

        jPanel1.add(Psamping);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        // TODO add your handling code here:
        //        this.setVisible(false);
        //        new FormSuplier().setVisible(true);
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblFuzzyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFuzzyMouseClicked
        // TODO add your handling code here:
        //        this.setVisible(false);
        //        new FormBarang().setVisible(true);
    }//GEN-LAST:event_lblFuzzyMouseClicked

    private void lblEvaluasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvaluasiMouseClicked
        // TODO add your handling code here:
        //        this.setVisible(false);
        //        new FormJadwal().setVisible(true);
    }//GEN-LAST:event_lblEvaluasiMouseClicked

    private void lblStrukturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStrukturMouseClicked
        // TODO add your handling code here:
        //        this.setVisible(false);
        //        new FormLaporan().setVisible(true);
    }//GEN-LAST:event_lblStrukturMouseClicked

    private void lblProfilDesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfilDesaMouseClicked
        // TODO add your handling code here:
        //        this.setVisible(false);
        //        new FormAnggota().setVisible(true);
    }//GEN-LAST:event_lblProfilDesaMouseClicked

    private void lblStruktur1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStruktur1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblStruktur1MouseClicked

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Psamping;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblEvaluasi;
    private javax.swing.JLabel lblFuzzy;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblProfilDesa;
    private javax.swing.JLabel lblStruktur;
    private javax.swing.JLabel lblStruktur1;
    // End of variables declaration//GEN-END:variables
}
