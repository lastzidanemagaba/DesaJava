/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author Imul
 */
public class Evaluasi extends javax.swing.JFrame {

    DbConnection dc = new DbConnection("penerimaan_desa");
    private int role;
    private double akurasi;
    private String[][] allData;
    private String[] selData;
    private TableRowSorter<TableModel> rowSorter;
    /**
     * Creates new form Evaluasi
     */
    public Evaluasi() {
        initComponents();
    }
    
    public Evaluasi(int role){
        initComponents();
        this.role = role;
        if (role > 0) {
            navUser.setVisible(false);
        }
        setTable();
        rowSorter=new TableRowSorter<>(tblHistory.getModel());   
    }
    
    public int countRowRs(ResultSet rs) throws SQLException{
        rs.last();
        int count=rs.getRow();
        rs.beforeFirst();
        return count;
    }
    
    public void getData(){
        String[][] member;
        try{
            Statement st = dc.con.createStatement();
            ResultSet rs=st.executeQuery("select * from data_evaluasi");
            allData =new String[countRowRs(rs)][10];
            for(int i=0;rs.next();i++){
                allData[i][0]= rs.getString("data_evaluasi_id");
                allData[i][1]=rs.getString("rumah");
                allData[i][2]=rs.getString("jenis_dinding");
                allData[i][3]=rs.getString("jumlah_tanggungan_keluarga");
                allData[i][4]=rs.getString("pekerjaan");
                allData[i][5]=rs.getString("pendapatan");       
                allData[i][6]=rs.getString("tabungan");       
                allData[i][7]=rs.getString("kendaraan");       
                allData[i][8]=rs.getString("kesimpulan");
                allData[i][9]=rs.getString("prediksi_kesimpulan");
            }            
        }catch(SQLException e){
            System.out.println("Error : "+e);
            allData=new String[0][0];
        }
    }
    
    public void processData(){
        Fuzzification f = new Fuzzification();
        Statement st;
        double right =0 ;
        for (String[] data : allData) {
            double hasil = f.calculation(data[1], data[2], Double.parseDouble(data[3]), data[4], Double.parseDouble(data[5]), data[6], data[7]);
            String layak = hasil > 50 ? "Layak":"Tidak Layak";
            if(layak.toLowerCase().equals(data[8])) right = right+1;
            try {
                String query = "UPDATE `data_evaluasi` SET `prediksi_kesimpulan`='"+layak+"' WHERE data_evaluasi_id="+data[0];
                System.out.println(query);
                st = dc.con.createStatement();
                st.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        akurasi = right/allData.length;
        txtAkurasi.setText(String.valueOf(akurasi)+" %");
    }
    
    public void setColumnTable(DefaultTableModel model){        
        model.addColumn ("No");
        model.addColumn ("Rumah");
        model.addColumn ("Jenis Dinding");
        model.addColumn ("Jumlah Tanggungan Keluarga");
        model.addColumn ("Pekerjaan");
        model.addColumn ("Pendapatan");
        model.addColumn ("Tabungan");
        model.addColumn ("Kendaraan");
        model.addColumn ("Kesimpulan");
        model.addColumn ("Prediksi Kesimpulan");
    }
    
    public void setColumnModel(TableColumnModel columnModel){        
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);
        columnModel.getColumn(9).setPreferredWidth(100);
    }
    public void setTable(){
        getData();
        String[][] data = allData;
        DefaultTableModel table= new DefaultTableModel();
        setColumnTable(table);
        tblHistory.setModel(table);        
        TableColumnModel columnModel=tblHistory.getColumnModel();
        setColumnModel(columnModel);        
        tblHistory.setColumnModel(columnModel);  
        int i =1;
        for (String[] data1 : data) {            
            table.addRow(new Object[]{i, data1[1], data1[2], data1[3], data1[4],data1[5], data1[6], data1[7], data1[8], data1[9]});
            i++;
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
        jPanel7 = new javax.swing.JPanel();
        lblHistory = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblStruktur = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblProfilDesa = new javax.swing.JLabel();
        navUser = new javax.swing.JPanel();
        jPnlUser = new javax.swing.JLabel();
        pContent = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        btnClearAll = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        txtCari = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        btnProcess = new javax.swing.JButton();
        txtAkurasi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel7.setPreferredSize(new java.awt.Dimension(72, 31));
        jPanel7.setLayout(new java.awt.GridLayout(1, 1));

        lblHistory.setBackground(new java.awt.Color(0, 204, 204));
        lblHistory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHistory.setText("History");
        lblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistoryMouseClicked(evt);
            }
        });
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

        btnClearAll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearAll.setText("Clear All");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });
        pContent.add(btnClearAll);
        btnClearAll.setBounds(680, 210, 110, 60);

        btnImport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        pContent.add(btnImport);
        btnImport.setBounds(680, 70, 110, 60);

        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistory);

        pContent.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 650, 570);

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCari.setText("Cari :");
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });
        pContent.add(txtCari);
        txtCari.setBounds(460, 40, 27, 15);

        txtKeyWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyWordKeyReleased(evt);
            }
        });
        pContent.add(txtKeyWord);
        txtKeyWord.setBounds(500, 40, 160, 20);

        btnProcess.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProcess.setText("Proses");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        pContent.add(btnProcess);
        btnProcess.setBounds(680, 140, 110, 60);

        txtAkurasi.setEditable(false);
        txtAkurasi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtAkurasi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pContent.add(txtAkurasi);
        txtAkurasi.setBounds(680, 330, 110, 70);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Akurasi");
        pContent.add(jLabel7);
        jLabel7.setBounds(670, 290, 90, 40);

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

    private void lblStrukturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStrukturMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new StrukturDesa(this.role).setVisible(true);
    }//GEN-LAST:event_lblStrukturMouseClicked

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

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        // TODO add your handling code here:
        Statement st;
        try {
            String query = "truncate data_evaluasi";
            System.out.println(query);
            st = dc.con.createStatement();
            st.executeUpdate(query);
            setTable();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClearAllActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal== JFileChooser.APPROVE_OPTION){
//            File file = chooser.getSelectedFile();
            try {
                Workbook workbook = WorkbookFactory.create(chooser.getSelectedFile());
                System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
                Sheet sheet = workbook.getSheetAt(0);
                DataFormatter dataFormatter = new DataFormatter();
                int i = 0;
                for (Row row : sheet) {
                    if(i == 0){
                        i++;
                    }else{
                        String rumah = dataFormatter.formatCellValue(row.getCell(1));
                        String jenisDinding = dataFormatter.formatCellValue(row.getCell(2));
                        String jumlahTanggunganKeluarga = dataFormatter.formatCellValue(row.getCell(3));
                        String pekerjaan = dataFormatter.formatCellValue(row.getCell(4));
                        String pendapatan = dataFormatter.formatCellValue(row.getCell(5));
                        String tabungan = dataFormatter.formatCellValue(row.getCell(6));
                        String kendaraan = dataFormatter.formatCellValue(row.getCell(7));
                        String kesimpulan = dataFormatter.formatCellValue(row.getCell(8));
                        Statement st;
                        try {
                            String query = "INSERT INTO `data_evaluasi` (`data_evaluasi_id`, `rumah`, `jenis_dinding`, `jumlah_tanggungan_keluarga`, `pekerjaan`, `pendapatan`, `tabungan`, `kendaraan`, `kesimpulan`) VALUES (NULL, '"+rumah+"', '"+jenisDinding+"', "+jumlahTanggunganKeluarga+", '"+pekerjaan+"', "+pendapatan+", '"+tabungan+"', '"+kendaraan+"', '"+kesimpulan+"')";
                            System.out.println(query);
                            st = dc.con.createStatement();
                            st.executeUpdate(query);
                        } catch (SQLException ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                setTable();
            } catch (IOException ex) {
                Logger.getLogger(Evaluasi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncryptedDocumentException ex) {
                Logger.getLogger(Evaluasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnImportActionPerformed

    private void tblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryMouseClicked
        //        String selId=tblMember.getValueAt(tblMember.getSelectedRow(),0).toString();
        //        selData=mbr.getMember(allData,Integer.parseInt(selId));
    }//GEN-LAST:event_tblHistoryMouseClicked

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariMouseClicked

    private void txtKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyReleased
        if(txtKeyWord.getText().equals("")) tblHistory.setRowSorter(null);
        else{
            System.out.println(txtKeyWord.getText());
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtKeyWord.getText()));
            tblHistory.setRowSorter(rowSorter);
        }
    }//GEN-LAST:event_txtKeyWordKeyReleased

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        processData();
        setTable();
    }//GEN-LAST:event_btnProcessActionPerformed

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
            java.util.logging.Logger.getLogger(Evaluasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Evaluasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Evaluasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Evaluasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Evaluasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Psamping;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jPnlUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFuzzy;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblProfilDesa;
    private javax.swing.JLabel lblStruktur;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel navUser;
    private javax.swing.JPanel pContent;
    private javax.swing.JTable tblHistory;
    private javax.swing.JTextField txtAkurasi;
    private javax.swing.JLabel txtCari;
    private javax.swing.JTextField txtKeyWord;
    // End of variables declaration//GEN-END:variables
}
