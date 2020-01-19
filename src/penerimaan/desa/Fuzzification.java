/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Imul
 */
public class Fuzzification {
    
    DbConnection dc = new DbConnection("penerimaan_desa");
    
    private FuzzyValue[] fuzzyLuasLahan;
    private FuzzyValue[] fuzzyJumlahTanggunganKeluarga;
    private FuzzyValue[] fuzzyPendapatan;
    private FuzzyValue[] fuzzyConclusion;
    public FuzzyRule[] rules;
    
    private class FuzzyValue{
        private final String label; // label nama
        private final double[] tresshold; // nilai titik batas
        private final int[] model; // isi 0 untuk titik batas bawah, 1 untuk titik batas atas

        public FuzzyValue(String label,  double[] tresshold, int[] model) {
            this.label = label;
            this.tresshold = tresshold;
            this.model = model;
        }
        
        public String getLabel(){
            return this.label;
        }
        private double convertValuePoint(double v, int modelA, double tressholdA, int modelB, double tressholdB){
            if (modelA == modelB){
                return modelA;
            }else if(modelA < modelB){
                return (v - tressholdA)/(tressholdB - tressholdA);
            }else{
                return (tressholdB - v)/(tressholdB - tressholdA);
            }
        }
        public double convertValue(double v){
            for(int i=0; i < tresshold.length; i++){
                if(i==0){
                    if(v <= tresshold[i]){
                        return convertValuePoint(v, model[i], tresshold[i], model[i], tresshold[i]);
                    }else if(tresshold[i] <= v && v <= tresshold[i+1]){
                        return convertValuePoint(v, model[i], tresshold[i], model[i+1], tresshold[i+1]);
                    }
                }else if(i == tresshold.length-1){
                    if(v >= tresshold[i]){
                        return convertValuePoint(v, model[i], tresshold[i], model[i], tresshold[i]);
                    }
                }else{
                    if(tresshold[i] <= v && v <= tresshold[i+1]){
                        return convertValuePoint(v, model[i], tresshold[i], model[i+1], tresshold[i+1]);
                    }
                }
            }
            return -1;
        }
        
        public double conclusionValue(double v){
            if(this.model[0] == 0 && this.model[1] == 1){
                return (v *(this.tresshold[1] - this.tresshold[0])) + this.tresshold[0];
            }else{
                return  this.tresshold[1] - (v * (this.tresshold[1] - this.tresshold[0]));
            }
        }
    }
    
    public class FuzzyRule{
        public final String luasLahan;
        public final String jumlahTanggunganKeluarga;
        public final String pendapatan;
        public final String conclusion;

        public FuzzyRule(String luasLahan, String jumlahTanggunganKeluarga, String pendapatan, String conclusion) {
            
            this.luasLahan = luasLahan;
            this.jumlahTanggunganKeluarga = jumlahTanggunganKeluarga;
            this.pendapatan = pendapatan;
            this.conclusion = conclusion;
        }        
    }

    public Fuzzification() {
        //inisialisasi fuzzifikasi
        initFuzzyValue();
        
        //inisialisasi rule
        initRule();
        
    }
    
    private void initFuzzyValue(){

        fuzzyLuasLahan = new FuzzyValue[3];
        fuzzyLuasLahan[0] = new FuzzyValue("rendah", new double[]{200,250}, new int[]{1,0});
        fuzzyLuasLahan[1] = new FuzzyValue("sedang", new double[]{200,250,450,500}, new int[]{0,1,1,0});
        fuzzyLuasLahan[2] = new FuzzyValue("tinggi", new double[]{450,500}, new int[]{0,1});
        
        fuzzyJumlahTanggunganKeluarga = new FuzzyValue[3];
        fuzzyJumlahTanggunganKeluarga[0] = new FuzzyValue("rendah", new double[]{2,3}, new int[]{1,0});
        fuzzyJumlahTanggunganKeluarga[1] = new FuzzyValue("sedang", new double[]{2,3,4}, new int[]{0,1,0});
        fuzzyJumlahTanggunganKeluarga[2] = new FuzzyValue("tinggi", new double[]{3,4}, new int[]{0,1});
        
        fuzzyPendapatan = new FuzzyValue[3];
        fuzzyPendapatan[0] = new FuzzyValue("rendah", new double[]{2000000,2250000}, new int[]{1,0});
        fuzzyPendapatan[1] = new FuzzyValue("sedang", new double[]{2000000,2250000,2750000,3000000}, new int[]{0,1,1,0});
        fuzzyPendapatan[2] = new FuzzyValue("tinggi", new double[]{2750000,3000000}, new int[]{0,1});
        
        fuzzyConclusion = new FuzzyValue[2];
        fuzzyConclusion[0] = new FuzzyValue("Tidak Layak", new double[]{0,100}, new int[]{1,0});
        fuzzyConclusion[1] = new FuzzyValue("Layak", new double[]{0,100}, new int[]{0,1});
    }
    
    
    public int countRowRs(ResultSet rs) throws SQLException{
        rs.last();
        int count=rs.getRow();
        rs.beforeFirst();
        return count;
    }
    
    public void initRule(){
        try{
            Statement st = dc.con.createStatement();
            ResultSet rs=st.executeQuery("select * from rule");
            rules = new FuzzyRule[countRowRs(rs)];
            for(int i=0;rs.next();i++){
                rules[i]= new FuzzyRule(rs.getString("luas_lahan"), rs.getString("tanggungan"), rs.getString("pendapatan"), rs.getString("keputusan"));
            }            
        }catch(SQLException e){
            System.out.println("Error : "+e);
            rules=new FuzzyRule[0];
        }
    }
    
    public double getFuzzyRumah(String label, String value){
        return label.toLowerCase().equals(value.toLowerCase()) ? 1:0;
    }
    
    public double getFuzzyLuasLahan(String label, double value){
        FuzzyValue found = new FuzzyValue("", new double[]{0}, new int[]{0});
        for (FuzzyValue fuzzyLuasLahan1 : fuzzyLuasLahan) {
            if (fuzzyLuasLahan1.label.toLowerCase().equals(label.toLowerCase())) {
                found = fuzzyLuasLahan1;
                break;
            }
        }
        System.out.println(label.toLowerCase()+" "+found.label);
        return found.convertValue(value);
    }
    
    public double getFuzzyPekerjaan(String label, String value){
        return label.toLowerCase().equals(value.toLowerCase()) ? 1:0;
    }
    
    public double getFuzzyTabungan(String label, String value){
        return label.toLowerCase().equals(value.toLowerCase()) ? 1:0;
    }
    
    public double getFuzzyKendaraan(String label, String value){
        return label.toLowerCase().equals(value.toLowerCase()) ? 1:0;
    }
    
    public double getFuzzyJumlahTanggungan(String label, double value){
        FuzzyValue found = new FuzzyValue("", new double[]{0}, new int[]{0});
        for (FuzzyValue fuzzyJumlahTanggunganKeluarga1 : fuzzyJumlahTanggunganKeluarga) {
            if (fuzzyJumlahTanggunganKeluarga1.label.toLowerCase().equals(label.toLowerCase())) {
                found = fuzzyJumlahTanggunganKeluarga1;
                break;
            }
        }
        return found.convertValue(value);
    }
    
    public double getFuzzyPendapatan(String label, double value){
        FuzzyValue found = new FuzzyValue("", new double[]{0}, new int[]{0});
        for (FuzzyValue fuzzyPendapatan1 : fuzzyPendapatan) {
            if (fuzzyPendapatan1.label.toLowerCase().equals(label.toLowerCase())) {
                found = fuzzyPendapatan1;
                break;
            }
        }
        return found.convertValue(value);
    }
    
    public double getDefuzzyConclusion(String label, double value){
        FuzzyValue found = new FuzzyValue("", new double[]{0}, new int[]{0});
        for (FuzzyValue fuzzyConclusion1 : fuzzyConclusion) {
            if (fuzzyConclusion1.label.toLowerCase().equals(label.toLowerCase())) {
                found = fuzzyConclusion1;
                break;
            }
        }
        return found.conclusionValue(value);
    }
    
    public double calculation(double luasLahan, double jumlahTanggunganKeluarga, double pendapatan){
        double alfaxz = 0;
        double alfa = 0;
        for(FuzzyRule rule : this.rules){
            double alfaRule = Math.min(getFuzzyLuasLahan(rule.luasLahan, luasLahan), getFuzzyJumlahTanggungan(rule.jumlahTanggunganKeluarga, jumlahTanggunganKeluarga));
            alfaRule = Math.min(alfaRule, getFuzzyPendapatan(rule.pendapatan, pendapatan));
            
            double z = getDefuzzyConclusion(rule.conclusion, alfaRule);
            alfaxz = alfaxz + (alfaRule * z);
            alfa = alfa + alfaRule;
        }
        if(alfa == 0){
            return 0;
        }else{
            return alfaxz / alfa;
        }
    }
    
}
