/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import java.io.IOException;
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
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Imul
 */
public class WargaPanel extends javax.swing.JPanel {

    DbConnection dc = new DbConnection("penerimaan_desa");
    private String[][] allData;
    private String[] selData;
    private TableRowSorter<TableModel> rowSorter;

    /**
     * Creates new form WargaPanel
     */
    public WargaPanel() {
        initComponents();
        setTable();
        rowSorter=new TableRowSorter<>(tblWarga.getModel());
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
            allData =new String[countRowRs(rs)][11];
            for(int i=0;rs.next();i++){
                allData[i][0]=rs.getString("id");
                allData[i][1]= Integer.toString(i+1);
                allData[i][2]=rs.getString("nama");
                allData[i][3]=rs.getString("nomor");
                allData[i][4]=rs.getString("rt_rw");
                allData[i][5]=rs.getString("desa");
                allData[i][6]=rs.getString("kecamatan");
                allData[i][7]=rs.getString("luas_lahan");
                allData[i][8]=rs.getString("jumlah_tanggungan_keluarga");
                allData[i][9]=rs.getString("pekerjaan");
                allData[i][10]=rs.getString("pendapatan");
            }            
        }catch(SQLException e){
            System.out.println("Error : "+e);
            allData=new String[0][0];
        }
    }
    public String[] getHistory(String[][] mData, int id){
        String[] member= new String[4];
        for(String[] item:mData){
            if(Integer.parseInt(item[0])==id){
                member=item;
                break;
            }
        }
        return member;
    }
    
    public void setColumnTable(DefaultTableModel model){ 
        model.addColumn ("id");       
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
    }
    public void setColumnModel(TableColumnModel columnModel){  
        columnModel.getColumn(0).setPreferredWidth(0);
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);      
        columnModel.getColumn(1).setPreferredWidth(30);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(150);
        columnModel.getColumn(7).setPreferredWidth(150);
        columnModel.getColumn(8).setPreferredWidth(200);
        columnModel.getColumn(9).setPreferredWidth(100);
        columnModel.getColumn(10).setPreferredWidth(100);
    }
    public void setTable(){
        getData();
        String[][] data = allData;
        DefaultTableModel table= new DefaultTableModel();
        setColumnTable(table);
        tblWarga.setModel(table);        
        TableColumnModel columnModel=tblWarga.getColumnModel();
        setColumnModel(columnModel);        
        tblWarga.setColumnModel(columnModel);  
        for (String[] data1 : data) {            
            table.addRow(new Object[]{data1[0], data1[1], data1[2], data1[3], data1[4],data1[5], data1[6], data1[7], data1[8], data1[9], data1[10]});
        }
    }
    
    public void cleanAction(){
        this.txtDesa.setText("");
        this.txtJumlahTanggunganKeluarga.setText("");
        this.txtKecamatan.setText("");
        this.txtKeyWord.setText("");
        this.txtLuasLahan.setText("");
        this.txtNama.setText("");
        this.txtNomor.setText("");
        this.txtPendapatan.setText("");
        this.txtRtRw.setText("");
        this.cbxPekerjaan.setSelectedIndex(0);
        this.selData = null;
    }
    
    private boolean checkKosong(){
        boolean check = false;
        
        check = check || this.txtDesa.getText().equals("");
        check = check || this.txtJumlahTanggunganKeluarga.getText().equals("");
        check = check || this.txtKecamatan.getText().equals("");
        check = check || this.txtLuasLahan.getText().equals("");
        check = check || this.txtNama.getText().equals("");
        check = check || this.txtNomor.getText().equals("");
        check = check || this.txtPendapatan.getText().equals("");
        check = check || this.txtRtRw.getText().equals("");
        
        return check;
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
        btnsimpan = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnimport = new javax.swing.JButton();
        btnhapussemua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWarga = new javax.swing.JTable();
        txtCari = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNomor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLuasLahan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtJumlahTanggunganKeluarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxPekerjaan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPendapatan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRtRw = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDesa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtKecamatan = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        btnsimpan.setText("Tambah");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnimport.setText("Import");
        btnimport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimportActionPerformed(evt);
            }
        });

        btnhapussemua.setText("Hapus semua");
        btnhapussemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapussemuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(btnsimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnubah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbatal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnimport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhapussemua)
                .addGap(0, 203, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnubah)
                    .addComponent(btnhapus)
                    .addComponent(btnbatal)
                    .addComponent(btnimport)
                    .addComponent(btnhapussemua)))
        );

        jToolBar1.add(jPanel12);

        tblWarga.setModel(new javax.swing.table.DefaultTableModel(
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
        tblWarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWargaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblWarga);

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nama Kepala Rumah Tangga");

        txtNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nomor Identitas");

        txtNomor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Luas Lahan");

        txtLuasLahan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Jumlah Tanggungan Keluarga");

        txtJumlahTanggunganKeluarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Pekerjaan");

        cbxPekerjaan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pertanian Tanaman Padi dan Palawija", "Hortikultural", "Perkebunan", "Perikanan Tangkap", "Perikanan Budi Daya", "Pertenakan", "Kehutanan dan Pertanian lainnya", "Pertambangan atau Penggalian", "Industri Pengolahan", "Listrik dan Gas", "Bangunan/Konstruksi", "Perdagangan", "Hotel dan Rumah Makan", "Transportasi dan Pergudangan", "Informasi dan Komunikasi", "Keuangan dan Asuransi", "Jasa Pendidikan", "Jasa Kesehatan", "Jasa Kemasyarakatan, Pemerintah, dan Perorangan", "Pemulung", "Lainnya" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Pendapatan");

        txtPendapatan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("RT/RW");

        txtRtRw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Desa");

        txtDesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Kecamatan");

        txtKecamatan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLuasLahan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJumlahTanggunganKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRtRw, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(txtDesa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(cbxPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJumlahTanggunganKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRtRw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLuasLahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        if(this.checkKosong()) JOptionPane.showMessageDialog(this, "Silahkan isi data yang kosong.");
        else{
            String nama = txtNama.getText();
            String nomor = txtNomor.getText();
            double luasLahan = Double.parseDouble(txtLuasLahan.getText());
            double jumlahTanggunganKeluarga = Double.parseDouble(txtJumlahTanggunganKeluarga.getText());
            String pekerjaan = cbxPekerjaan.getSelectedItem().toString();
            double pendapatan = Double.parseDouble(txtPendapatan.getText());
            String kecamatan = this.txtKecamatan.getText();
            String desa = this.txtDesa.getText();
            String rtRw = this.txtRtRw.getText();
            try{
                Statement st = dc.con.createStatement();
                st.executeUpdate("INSERT INTO `history` (`id`, `nama` ,`nomor`, `kecamatan`, `desa`, `rt_rw`, `luas_lahan`, `jumlah_tanggungan_keluarga`, `pekerjaan`, `pendapatan`, `kesimpulan`) VALUES (NULL, '"+nama+"', '"+nomor+"', '"+kecamatan+"', '"+desa+"', '"+rtRw+"', '"+luasLahan+"', '"+jumlahTanggunganKeluarga+"', '"+pekerjaan+"', '"+pendapatan+"', NULL)");
                this.setTable();
                this.cleanAction();
            }catch(SQLException e){
                System.out.println("Error : "+e);
            }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
        if(selData!=null){
            if(this.checkKosong()) JOptionPane.showMessageDialog(this, "Silahkan isi data yang kosong.");
            else{
                String nama = txtNama.getText();
                String nomor = txtNomor.getText();
                double luasLahan = Double.parseDouble(txtLuasLahan.getText());
                double jumlahTanggunganKeluarga = Double.parseDouble(txtJumlahTanggunganKeluarga.getText());
                String pekerjaan = cbxPekerjaan.getSelectedItem().toString();
                double pendapatan = Double.parseDouble(txtPendapatan.getText());
                String kecamatan = this.txtKecamatan.getText();
                String desa = this.txtDesa.getText();
                String rtRw = this.txtRtRw.getText();
                try{
                    Statement st = dc.con.createStatement();
                    st.executeUpdate("UPDATE `history` SET `nama` = '"+nama+"', `nomor` = '"+nomor+"', `kecamatan` = '"+kecamatan+"', `desa` = '"+desa+"', `rt_rw` = '"+rtRw+"', `luas_lahan` = '"+luasLahan+"', `jumlah_tanggungan_keluarga` = '"+jumlahTanggunganKeluarga+"', `pekerjaan` = '"+pekerjaan+"', `pendapatan` = '"+pendapatan+"' WHERE `history`.`id` = "+selData[0]);
                    this.setTable();
                    this.cleanAction();
                }catch(SQLException e){
                    System.out.println("Error : "+e);
                }
            }
        }
        else JOptionPane.showMessageDialog(this, "Tidak ada data yang dipilih.", "Alert", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        if(selData!=null){
            try{
                Statement st = dc.con.createStatement();
                st.executeUpdate("DELETE FROM `history` WHERE `id` = '"+selData[0]+"'");
                this.setTable();
                this.cleanAction();
            }catch(SQLException e){
                System.out.println("Error : "+e);
            }
        }
        else JOptionPane.showMessageDialog(this, "Tidak ada data yang dipilih.", "Alert", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        this.cleanAction();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariMouseClicked

    private void txtKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyReleased
        if(txtKeyWord.getText().equals("")) tblWarga.setRowSorter(null);
        else{
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtKeyWord.getText()));
            tblWarga.setRowSorter(rowSorter);
        }
    }//GEN-LAST:event_txtKeyWordKeyReleased

    private void tblWargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWargaMouseClicked
        String selId=tblWarga.getValueAt(tblWarga.getSelectedRow(),0).toString();
        selData=getHistory(allData,Integer.parseInt(selId));
        this.txtNama.setText(selData[2]);
        this.txtNomor.setText(selData[3]);
        this.txtRtRw.setText(selData[4]);
        this.txtDesa.setText(selData[5]);
        this.txtKecamatan.setText(selData[6]);
        this.txtLuasLahan.setText(selData[7]);
        this.txtJumlahTanggunganKeluarga.setText(selData[8]);
        this.cbxPekerjaan.setSelectedItem(selData[9]);
        this.txtPendapatan.setText(selData[10]);
    }//GEN-LAST:event_tblWargaMouseClicked

    private void btnimportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimportActionPerformed
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
                  //    String kesimpulan = dataFormatter.formatCellValue(row.getCell(10));
                        Statement st;
                        try {
                            String query = "INSERT INTO `history` (`id`, `nama`, `nomor`, `rt_rw`, `desa`, `kecamatan`, `luas_lahan`, `jumlah_tanggungan_keluarga`, `pekerjaan`, `pendapatan`) VALUES (NULL, '"+nama+"', '"+nomor+"', '"+rtrw+"', '"+desa+"', '"+kecamatan+"', "+luasLahan+", "+jumlahTanggunganKeluarga+", '"+pekerjaan+"', "+pendapatan+")";
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
    }//GEN-LAST:event_btnimportActionPerformed

    private void btnhapussemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapussemuaActionPerformed
        // TODO add your handling code here:
        Statement st;
        try {
            String query = "truncate history";
            System.out.println(query);
            st = dc.con.createStatement();
            st.executeUpdate(query);
            setTable();
        } catch (SQLException ex) {
            Logger.getLogger(PengujianPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnhapussemuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhapussemua;
    private javax.swing.JButton btnimport;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox<String> cbxPekerjaan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblWarga;
    private javax.swing.JLabel txtCari;
    private javax.swing.JTextField txtDesa;
    private javax.swing.JTextField txtJumlahTanggunganKeluarga;
    private javax.swing.JTextField txtKecamatan;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JTextField txtLuasLahan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNomor;
    private javax.swing.JTextField txtPendapatan;
    private javax.swing.JTextField txtRtRw;
    // End of variables declaration//GEN-END:variables
}
