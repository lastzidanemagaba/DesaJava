
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Imul
 */
public class History extends javax.swing.JFrame {

    DbConnection dc = new DbConnection("penerimaan_desa");
    private int role;
    private String[][] allData;
    private String[] selData;
    private TableRowSorter<TableModel> rowSorter;

    /**
     * Creates new form History
     */
    public History() {
        initComponents();
        setTable();
        rowSorter=new TableRowSorter<>(tblHistory.getModel());
    }
    
    public History(int role){
        initComponents();
        setTable();
        rowSorter=new TableRowSorter<>(tblHistory.getModel());
        this.role = role;
        if (role > 0) {
            navUser.setVisible(false);
            navHistory.setVisible(false);
        }
        
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
            ResultSet rs=st.executeQuery("select * from history");
            allData =new String[countRowRs(rs)][9];
            for(int i=0;rs.next();i++){
                allData[i][0]= Integer.toString(i+1);
                allData[i][1]=rs.getString("nama");
                allData[i][2]=rs.getString("nomor");
                allData[i][3]=rs.getString("jenis_dinding");
                allData[i][4]=rs.getString("jumlah_tanggungan_keluarga");
                allData[i][5]=rs.getString("pekerjaan");
                allData[i][6]=rs.getString("pendapatan");      
                allData[i][7]=rs.getString("kesimpulan");      
                allData[i][8]=rs.getString("id");
            }            
        }catch(SQLException e){
            System.out.println("Error : "+e);
            allData=new String[0][0];
        }
    }
    public String[] getHistory(String[][] mData, int id){
        String[] member= new String[4];
        for(String[] item:mData){
            if(Integer.parseInt(item[8])==id){
                member=item;
                break;
            }
        }
        return member;
    }
    
    public void setColumnTable(DefaultTableModel model){        
        model.addColumn ("No");
        model.addColumn ("Nama Kepala Rumah Tangga");
        model.addColumn ("Nomor Identitas");
        model.addColumn ("Jenis Dinding");
        model.addColumn ("Jumlah Tanggungan Keluarga");
        model.addColumn ("Pekerjaan");
        model.addColumn ("Pendapatan");
        model.addColumn ("Kesimpulan");
        model.addColumn ("id");
    }
    public void setColumnModel(TableColumnModel columnModel){        
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(0);
        columnModel.getColumn(8).setMinWidth(0);
        columnModel.getColumn(8).setMaxWidth(0);
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
        for (String[] data1 : data) {            
            table.addRow(new Object[]{data1[0], data1[1], data1[2], data1[3], data1[4],data1[5], data1[6], data1[7], data1[8]});
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
        logout = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        txtCari = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

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

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        pContent.add(btnHapus);
        btnHapus.setBounds(670, 210, 110, 60);

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        pContent.add(btnCetak);
        btnCetak.setBounds(670, 70, 110, 60);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

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
        tblHistory.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
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

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Evaluasi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pContent.add(jButton2);
        jButton2.setBounds(670, 140, 110, 60);

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        pContent.add(btnEdit);
        btnEdit.setBounds(670, 280, 110, 60);

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

    private void lblStruktur1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStruktur1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblStruktur1MouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code her
        if(this.selData == null){
            JOptionPane.showMessageDialog(this, "Tidak ada history yang dipilih.", "Alert", JOptionPane.WARNING_MESSAGE);
        }else{
            Statement st;
            try {
                st = dc.con.createStatement();
                st.executeUpdate("DELETE FROM `history` WHERE `history`.`id` = "+this.selData[8]+"");
                setTable();
                rowSorter=new TableRowSorter<>(tblHistory.getModel());
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        XSSFSheet sheet = workbook.createSheet("History");
        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);

        Row rowTitle = sheet.createRow(0);
        
        Cell cellTitle = rowTitle.createCell(0);
        cellTitle.setCellValue("Kantor Kepala Desa Kasreman");
        CellStyle styleTitle = workbook.createCellStyle();
        Font titleFont = workbook.createFont();
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short) 16);
        styleTitle.setFont(titleFont);
        styleTitle.setAlignment(HorizontalAlignment.CENTER);
        styleTitle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellTitle.setCellStyle(styleTitle);
        sheet.addMergedRegion(new CellRangeAddress(0,1,0,7));
        
        Row rowStart = sheet.createRow(2);
        
        Cell cellNo = rowStart.createCell(0);
        cellNo.setCellValue("No");
        cellNo.setCellStyle(headerCellStyle);
        
        Cell cellRumah = rowStart.createCell(1);
        cellRumah.setCellValue("Nama Kepala Rumah Tangga");
        cellRumah.setCellStyle(headerCellStyle);
        
        Cell cellTabungan = rowStart.createCell(2);
        cellTabungan.setCellValue("Nomor Identitas");
        cellTabungan.setCellStyle(headerCellStyle);
        
        Cell cellJenisDinding = rowStart.createCell(3);
        cellJenisDinding.setCellValue("Jenis Dinding");
        cellJenisDinding.setCellStyle(headerCellStyle);
        
        Cell cellJumlahTanggunganKeluarga = rowStart.createCell(4);
        cellJumlahTanggunganKeluarga.setCellValue("Jumlah Tanggungan Keluarga");
        cellJumlahTanggunganKeluarga.setCellStyle(headerCellStyle);
        
        Cell cellPekerjaan = rowStart.createCell(5);
        cellPekerjaan.setCellValue("Pekerjaan");
        cellPekerjaan.setCellStyle(headerCellStyle);
        
        Cell cellPenapatan = rowStart.createCell(6);
        cellPenapatan.setCellValue("Pendapatan");
        cellPenapatan.setCellStyle(headerCellStyle);
        
        Cell cellKesimpulan = rowStart.createCell(7);
        cellKesimpulan.setCellValue("Kesimpulan");
        cellKesimpulan.setCellStyle(headerCellStyle);
        
        int rownum = 3;
        
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        for (String[] data : allData) {
            Row row = sheet.createRow(rownum);
            int cellnum = 0;
            for (String value : data) {
                if(cellnum < 8){
                    Cell cell = row.createCell(cellnum++);
                    cell.setCellValue((String) value);
                    cell.setCellStyle(cellStyle);
                }
            }
            rownum++;
        }
        
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showSaveDialog(this);
        if(returnVal== JFileChooser.APPROVE_OPTION){
            try {
                FileOutputStream fileOut;
                if(chooser.getSelectedFile().getName().endsWith(".xlsx")){
                    fileOut = new FileOutputStream(chooser.getSelectedFile());
                }else{
                    fileOut = new FileOutputStream(chooser.getSelectedFile()+".xlsx");
                }
                workbook.write(fileOut);
                fileOut.close();
                // Closing the workbook
                workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void tblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryMouseClicked
        String selId=tblHistory.getValueAt(tblHistory.getSelectedRow(),8).toString();
        selData=getHistory(allData,Integer.parseInt(selId));
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Evaluasi(this.role).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(this.selData == null){
            JOptionPane.showMessageDialog(this, "Tidak ada history yang dipilih.", "Alert", JOptionPane.WARNING_MESSAGE);
        }else{
            new HistoryEdit(this.role, this.selData).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new History().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Psamping;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jPnlUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFuzzy;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblProfilDesa;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel navHistory;
    private javax.swing.JPanel navUser;
    private javax.swing.JPanel pContent;
    private javax.swing.JTable tblHistory;
    private javax.swing.JLabel txtCari;
    private javax.swing.JTextField txtKeyWord;
    // End of variables declaration//GEN-END:variables
}
