/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author Imul
 */
public class PengujianPanel extends javax.swing.JPanel {

    DbConnection dc = new DbConnection("penerimaan_desa");
    private int role;
    private double akurasi;
    private String[][] allData;
    private String[] selData;
    private TableRowSorter<TableModel> rowSorter;

    /**
     * Creates new form EvaluationPanel
     */
    public PengujianPanel() {
        initComponents();
        setTable();
        rowSorter=new TableRowSorter<>(tblEvaluation.getModel());   
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
            allData =new String[countRowRs(rs)][12];
            for(int i=0;rs.next();i++){
                allData[i][0]= rs.getString("data_evaluasi_id");
                allData[i][1]=rs.getString("nama");
                allData[i][2]=rs.getString("nomor");
                allData[i][3]=rs.getString("rt_rw");
                allData[i][4]=rs.getString("desa");
                allData[i][5]=rs.getString("kecamatan");
                allData[i][6]=rs.getString("luas_lahan");
                allData[i][7]=rs.getString("jumlah_tanggungan_keluarga");
                allData[i][8]=rs.getString("pekerjaan");
                allData[i][9]=rs.getString("pendapatan");      
                allData[i][10]=rs.getString("kesimpulan");
                allData[i][11]=rs.getString("prediksi_kesimpulan");
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
            double hasil = f.calculation(Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[9]));
            String layak = hasil > 50 ? "Layak":"Tidak Layak";
            if(layak.toLowerCase().equals(data[10].toLowerCase())) right = right+1;
            try {
                String query = "UPDATE `data_evaluasi` SET `prediksi_kesimpulan`='"+layak+"' WHERE data_evaluasi_id="+data[0];
                System.out.println(query);
                st = dc.con.createStatement();
                st.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(PengujianPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        akurasi = (right/allData.length)*100;
        txtAkurasi.setText(String.valueOf(akurasi)+" %");
        this.setTable();
    }
    
    public void setColumnTable(DefaultTableModel model){        
        model.addColumn ("No");
        model.addColumn ("Nama Kepala Rumah Tangga");
        model.addColumn ("Nomor Identitas");
        model.addColumn ("RT/RW");
        model.addColumn ("Desa");
        model.addColumn ("Kecamatan");
        model.addColumn ("Luas Lahan");
        model.addColumn ("Jumlah Tanggungan Keluarga");
        model.addColumn ("Pekerjaan");
        model.addColumn ("Pendapatan");
        model.addColumn ("Kesimpulan");
        model.addColumn ("Prediksi Kesimpulan");
    }
    
    public void setColumnModel(TableColumnModel columnModel){     
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(150);
        columnModel.getColumn(7).setPreferredWidth(200);
        columnModel.getColumn(8).setPreferredWidth(100);
        columnModel.getColumn(9).setPreferredWidth(100);
        columnModel.getColumn(10).setPreferredWidth(100);
        columnModel.getColumn(11).setPreferredWidth(100);
    }
    public void setTable(){
        getData();
        String[][] data = allData;
        DefaultTableModel table= new DefaultTableModel();
        setColumnTable(table);
        tblEvaluation.setModel(table);        
        TableColumnModel columnModel=tblEvaluation.getColumnModel();
        setColumnModel(columnModel);        
        tblEvaluation.setColumnModel(columnModel);  
        int i =1;
        for (String[] data1 : data) {            
            table.addRow(new Object[]{i, data1[1], data1[2], data1[3], data1[4],data1[5], data1[6], data1[7], data1[8], data1[9], data1[10], data1[11]});
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

        jToolBar1 = new javax.swing.JToolBar();
        jPanel12 = new javax.swing.JPanel();
        btnImport = new javax.swing.JButton();
        btnProses = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        txtCari1 = new javax.swing.JLabel();
        txtAkurasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvaluation = new javax.swing.JTable();
        txtCari = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus Semua");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        txtCari1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCari1.setText("Akurasi");
        txtCari1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCari1MouseClicked(evt);
            }
        });

        txtAkurasi.setEditable(false);
        txtAkurasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAkurasiKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(btnImport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(txtCari1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAkurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAkurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari1))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnProses)
                        .addComponent(btnImport)
                        .addComponent(btnHapus)
                        .addComponent(btnCetak)))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel12);

        tblEvaluation.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEvaluation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEvaluationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEvaluation);

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCari.setText("Cari :");
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });

        txtKeyWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyWordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal== JFileChooser.APPROVE_OPTION){
            try {
                Workbook workbook = WorkbookFactory.create(chooser.getSelectedFile());
                System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
                Sheet sheet = workbook.getSheetAt(0);
                DataFormatter dataFormatter = new DataFormatter();
                int i = 0;
                for (Row row : sheet) {
                    if(i <= 2){
                        i++;
                    }else{
                        String nama = dataFormatter.formatCellValue(row.getCell(1));
                        String nomor = dataFormatter.formatCellValue(row.getCell(2));
                        String rtrw = dataFormatter.formatCellValue(row.getCell(3));
                        String desa = dataFormatter.formatCellValue(row.getCell(4));
                        String kecamatan = dataFormatter.formatCellValue(row.getCell(5));
                        String luasLahan = dataFormatter.formatCellValue(row.getCell(6));
                        String jumlahTanggunganKeluarga = dataFormatter.formatCellValue(row.getCell(7));
                        String pekerjaan = dataFormatter.formatCellValue(row.getCell(8));
                        String pendapatan = dataFormatter.formatCellValue(row.getCell(9));
                        String kesimpulan = dataFormatter.formatCellValue(row.getCell(10));
                        Statement st;
                        try {
                            String query = "INSERT INTO `data_evaluasi` (`data_evaluasi_id`, `nama`, `nomor`, `rt_rw`, `desa`, `kecamatan`, `luas_lahan`, `jumlah_tanggungan_keluarga`, `pekerjaan`, `pendapatan`, `kesimpulan`) VALUES (NULL, '"+nama+"', '"+nomor+"', '"+rtrw+"', '"+desa+"', '"+kecamatan+"', "+luasLahan+", "+jumlahTanggunganKeluarga+", '"+pekerjaan+"', "+pendapatan+", '"+kesimpulan+"')";
                            System.out.println(query);
                            st = dc.con.createStatement();
                            st.executeUpdate(query);
                        } catch (SQLException ex) {
                            Logger.getLogger(PengujianPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                setTable();
            } catch (IOException ex) {
                Logger.getLogger(PengujianPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncryptedDocumentException ex) {
                Logger.getLogger(PengujianPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        processData();
        setTable();
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        Statement st;
        try {
            String query = "truncate data_evaluasi";
            System.out.println(query);
            st = dc.con.createStatement();
            st.executeUpdate(query);
            setTable();
        } catch (SQLException ex) {
            Logger.getLogger(PengujianPanel.class.getName()).log(Level.SEVERE, null, ex);
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
        sheet.addMergedRegion(new CellRangeAddress(0,1,0,11));
        
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
        
        Cell cellRtRw = rowStart.createCell(3);
        cellRtRw.setCellValue("RT/RW");
        cellRtRw.setCellStyle(headerCellStyle);
        
        Cell cellDesa = rowStart.createCell(4);
        cellDesa.setCellValue("Desa");
        cellDesa.setCellStyle(headerCellStyle);
        
        Cell cellKecamatan = rowStart.createCell(5);
        cellKecamatan.setCellValue("Kecamatan");
        cellKecamatan.setCellStyle(headerCellStyle);
        
        Cell cellLuasLahan = rowStart.createCell(6);
        cellLuasLahan.setCellValue("Luas Lahan");
        cellLuasLahan.setCellStyle(headerCellStyle);
        
        Cell cellJumlahTanggunganKeluarga = rowStart.createCell(7);
        cellJumlahTanggunganKeluarga.setCellValue("Jumlah Tanggungan Keluarga");
        cellJumlahTanggunganKeluarga.setCellStyle(headerCellStyle);
        
        Cell cellPekerjaan = rowStart.createCell(8);
        cellPekerjaan.setCellValue("Pekerjaan");
        cellPekerjaan.setCellStyle(headerCellStyle);
        
        Cell cellPenapatan = rowStart.createCell(9);
        cellPenapatan.setCellValue("Pendapatan");
        cellPenapatan.setCellStyle(headerCellStyle);
        
        Cell cellKesimpulan = rowStart.createCell(10);
        cellKesimpulan.setCellValue("Kesimpulan");
        cellKesimpulan.setCellStyle(headerCellStyle);
        
        Cell cellPrediksiKesimpulan = rowStart.createCell(11);
        cellPrediksiKesimpulan.setCellValue("Prediksi Kesimpulan");
        cellPrediksiKesimpulan.setCellStyle(headerCellStyle);
        
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
                if(cellnum < 12){
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
                Logger.getLogger(PengujianPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PengujianPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void tblEvaluationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEvaluationMouseClicked
        
    }//GEN-LAST:event_tblEvaluationMouseClicked

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariMouseClicked

    private void txtKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyReleased
        if(txtKeyWord.getText().equals("")) tblEvaluation.setRowSorter(null);
        else{
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtKeyWord.getText()));
            tblEvaluation.setRowSorter(rowSorter);
        }
    }//GEN-LAST:event_txtKeyWordKeyReleased

    private void txtCari1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCari1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCari1MouseClicked

    private void txtAkurasiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAkurasiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAkurasiKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnProses;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblEvaluation;
    private javax.swing.JTextField txtAkurasi;
    private javax.swing.JLabel txtCari;
    private javax.swing.JLabel txtCari1;
    private javax.swing.JTextField txtKeyWord;
    // End of variables declaration//GEN-END:variables
}
