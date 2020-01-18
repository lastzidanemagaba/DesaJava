/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Imul
 */
public class UserEdit extends javax.swing.JFrame {
    
    DbConnection dc = new DbConnection("penerimaan_desa");
    private int role;
    private String[] user;

    /**
     * Creates new form EditUser
     */
    public UserEdit(String[] user) {
        initComponents();
        this.user = user;
        txtUsername.setText(user[1]);
        txtPassword.setText(user[2]);
        cbxRole.setSelectedIndex(Integer.parseInt(user[3]));
        this.setVisible(true);
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
        lblTambKaryawan1 = new javax.swing.JLabel();
        lblUsername1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnEdit = new javax.swing.JToggleButton();
        btnreset = new javax.swing.JToggleButton();
        cbxRole = new javax.swing.JComboBox<>();
        lblPassword3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        lblTambKaryawan1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTambKaryawan1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTambKaryawan1.setText("Edit User");
        jPanel1.add(lblTambKaryawan1);
        lblTambKaryawan1.setBounds(10, 10, 310, 44);

        lblUsername1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername1.setText("Username");
        jPanel1.add(lblUsername1);
        lblUsername1.setBounds(40, 80, 100, 22);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtUsername);
        txtUsername.setBounds(290, 80, 250, 28);

        lblPassword2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword2.setText("Password");
        jPanel1.add(lblPassword2);
        lblPassword2.setBounds(40, 110, 90, 22);

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtPassword);
        txtPassword.setBounds(290, 110, 250, 28);

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(290, 190, 115, 31);

        btnreset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnreset.setText("Reset");
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresetMouseClicked(evt);
            }
        });
        jPanel1.add(btnreset);
        btnreset.setBounds(420, 190, 115, 31);

        cbxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        jPanel1.add(cbxRole);
        cbxRole.setBounds(290, 140, 250, 30);

        lblPassword3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword3.setText("Role");
        jPanel1.add(lblPassword3);
        lblPassword3.setBounds(40, 140, 90, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        if(txtUsername.getText().equals("") || txtPassword.getText().equals("")) JOptionPane.showMessageDialog(this, "Username dan Passsword Wajib diisi.");
        else{
            try{
                Statement st = dc.con.createStatement();
                st.executeUpdate("UPDATE `users` SET `username` = '"+txtUsername.getText()+"', `password` = '"+txtPassword.getText()+"', `role` = '"+cbxRole.getSelectedIndex()+"' WHERE `users`.`user_id` = "+this.user[0]);
                this.dispose();
            }catch(SQLException e){
                System.out.println("Error : "+e);
            }
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnresetMouseClicked

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
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new UserEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEdit;
    private javax.swing.JToggleButton btnreset;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JLabel lblPassword3;
    private javax.swing.JLabel lblTambKaryawan1;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
