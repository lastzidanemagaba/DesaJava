/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imul
 */
public class HistoryEdit extends javax.swing.JFrame {

    private int role;
    String[] history;
    String idHistory;
    DbConnection dc = new DbConnection("penerimaan_desa");
    /**
     * Creates new form HistoryEdit
     */
    public HistoryEdit() {
        initComponents();
    }
    public HistoryEdit(int role, String[] history){
        initComponents();
        this.history = history;
        txtNama.setText(history[1]);
        txtNomor.setText(history[2]);
        txtLuasLahan.setText(history[3]);
        txtJumlahTanggunganKeluarga.setText(history[4]);
        cbxPekerjaan.setSelectedItem(history[5]);
        txtPendapatan.setText(history[6]);
        idHistory = history[8];
        
        this.role = role;
        if (role > 0) {
            navUser.setVisible(false);
            navHistory.setVisible(false);
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
        navHistory = new javax.swing.JPanel();
        lblHistory = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblProfilDesa = new javax.swing.JLabel();
        navUser = new javax.swing.JPanel();
        jPnlUser = new javax.swing.JLabel();
        pContent = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        logout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxPekerjaan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPendapatan = new javax.swing.JTextField();
        txtJumlahTanggunganKeluarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblLogo1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLuasLahan = new javax.swing.JTextField();

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

        navHistory.setBackground(new java.awt.Color(0, 204, 204));
        navHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        navHistory.setPreferredSize(new java.awt.Dimension(72, 31));
        navHistory.setLayout(new java.awt.GridLayout(1, 1));

        lblHistory.setBackground(new java.awt.Color(0, 204, 204));
        lblHistory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHistory.setText("History");
        lblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistoryMouseClicked(evt);
            }
        });
        navHistory.add(lblHistory);

        Psamping.add(navHistory);

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

        navUser.setBackground(new java.awt.Color(0, 204, 204));
        navUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        navUser.setPreferredSize(new java.awt.Dimension(72, 31));
        navUser.setLayout(new java.awt.GridLayout(1, 1));

        jPnlUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPnlUser.setForeground(new java.awt.Color(52, 17, 9));
        jPnlUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPnlUser.setText("User");
        jPnlUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPnlUserMouseClicked(evt);
            }
        });
        navUser.add(jPnlUser);

        Psamping.add(navUser);

        jPanel1.add(Psamping);

        pContent.setBackground(new java.awt.Color(255, 255, 255));
        pContent.setPreferredSize(new java.awt.Dimension(800, 0));
        pContent.setLayout(null);

        btnSubmit.setText("Update");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        pContent.add(btnSubmit);
        btnSubmit.setBounds(210, 430, 280, 23);

        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        pContent.add(logout);
        logout.setBounds(724, 10, 60, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nomor Identitas");
        pContent.add(jLabel1);
        jLabel1.setBounds(130, 220, 180, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Luas Lahan");
        pContent.add(jLabel2);
        jLabel2.setBounds(130, 260, 90, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Jumlah Tanggungan Keluarga");
        pContent.add(jLabel3);
        jLabel3.setBounds(130, 300, 190, 20);
        pContent.add(txtNomor);
        txtNomor.setBounds(330, 220, 290, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Pekerjaan");
        pContent.add(jLabel4);
        jLabel4.setBounds(130, 340, 90, 20);

        cbxPekerjaan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buruh", "Petani", "Wiraswasta" }));
        pContent.add(cbxPekerjaan);
        cbxPekerjaan.setBounds(330, 340, 290, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Pendapatan");
        pContent.add(jLabel5);
        jLabel5.setBounds(130, 380, 190, 20);
        pContent.add(txtPendapatan);
        txtPendapatan.setBounds(330, 380, 290, 20);
        pContent.add(txtJumlahTanggunganKeluarga);
        txtJumlahTanggunganKeluarga.setBounds(330, 300, 290, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nama Kepala Rumah Tangga");
        pContent.add(jLabel8);
        jLabel8.setBounds(130, 180, 180, 20);
        pContent.add(txtNama);
        txtNama.setBounds(330, 180, 290, 20);

        lblLogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penerimaan/desa/image/LogoDesa.jpg"))); // NOI18N
        pContent.add(lblLogo1);
        lblLogo1.setBounds(20, 10, 100, 126);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Update History");
        pContent.add(jLabel6);
        jLabel6.setBounds(260, 130, 160, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Kantor Kepala Desa Kasreman");
        pContent.add(jLabel7);
        jLabel7.setBounds(130, 10, 510, 100);
        pContent.add(txtLuasLahan);
        txtLuasLahan.setBounds(330, 260, 290, 20);

        jPanel1.add(pContent);

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
        this.dispose();
        new Home(this.role).setVisible(true);
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblFuzzyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFuzzyMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Fuzzy(this.role).setVisible(true);
    }//GEN-LAST:event_lblFuzzyMouseClicked

    private void lblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoryMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new History(this.role).setVisible(true);
    }//GEN-LAST:event_lblHistoryMouseClicked

    private void lblProfilDesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfilDesaMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new ProfilDesa(this.role).setVisible(true);
    }//GEN-LAST:event_lblProfilDesaMouseClicked

    private void jPnlUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPnlUserMouseClicked
        // TODO add your handling code here:
        if (this.role == 0) {
            this.dispose();
            new User(this.role).setVisible(true);
        }
    }//GEN-LAST:event_jPnlUserMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String nama = txtNama.getText();
        String nomor = txtNomor.getText();
        double luasLahan = Double.parseDouble(txtLuasLahan.getText());
        double jumlahTanggunganKeluarga = Double.parseDouble(txtJumlahTanggunganKeluarga.getText());
        String pekerjaan = cbxPekerjaan.getSelectedItem().toString();
        double pendapatan = Double.parseDouble(txtPendapatan.getText());
        Fuzzification f = new Fuzzification();
        double hasil = f.calculation(luasLahan, jumlahTanggunganKeluarga, pekerjaan, pendapatan);
        String layak = hasil > 50 ? "Layak":"Tidak Layak";
        Statement st;
        try {
            st = dc.con.createStatement();
            st.executeUpdate("UPDATE `history` SET `nama` = '"+nama+"', `nomor` = '"+nomor+"', `luas_lahan` = '"+luasLahan+"', `jumlah_tanggungan_keluarga` = '"+jumlahTanggunganKeluarga+"', `pekerjaan` = '"+pekerjaan+"', `pendapatan` = '"+pendapatan+"', `kesimpulan` = '"+layak+"' WHERE `history`.`id` = "+this.idHistory);
            new History(this.role).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(HistoryEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoryEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Psamping;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbxPekerjaan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jPnlUser;
    private javax.swing.JLabel lblFuzzy;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblProfilDesa;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel navHistory;
    private javax.swing.JPanel navUser;
    private javax.swing.JPanel pContent;
    private javax.swing.JTextField txtJumlahTanggunganKeluarga;
    private javax.swing.JTextField txtLuasLahan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNomor;
    private javax.swing.JTextField txtPendapatan;
    // End of variables declaration//GEN-END:variables
}
