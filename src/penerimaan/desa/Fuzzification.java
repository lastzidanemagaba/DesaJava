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
public class Fuzzification {
//    private FuzzyValue[] fuzzyRumah = new FuzzyValue[2];
//    private FuzzyValue[] fuzzyJenisDinding = new FuzzyValue[3];
    private FuzzyValue[] fuzzyJumlahTanggunganKeluarga = new FuzzyValue[3];
//    private FuzzyValue[] fuzzyPekerjaan = new FuzzyValue[3];
    private FuzzyValue[] fuzzyPendapatan = new FuzzyValue[3];
//    private FuzzyValue[] fuzzyTabungan = new FuzzyValue[3];
//    private FuzzyValue[] fuzzyKendaraan = new FuzzyValue[3];
    private FuzzyValue[] fuzzyConclusion = new FuzzyValue[2];
    private FuzzyRule[] rules = new FuzzyRule[2];
    
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
                return  (v * (this.tresshold[1] - this.tresshold[0])) + this.tresshold[1];
            }
        }
    }
    
    private class FuzzyRule{
        protected final String rumah;
        protected final String jenisDinding;
        protected final String jumlahTanggunganKeluarga;
        protected final String pekerjaan;
        protected final String pendapatan;
        protected final String tabungan;
        protected final String kendaraan;
        protected final String conclusion;

        public FuzzyRule(String rumah, String jenisDinding, String jumlahTanggunganKeluarga, String pekerjaan, String pendapatan, String tabungan, String kendaraan, String conclusion) {
            this.rumah = rumah;
            this.jenisDinding = jenisDinding;
            this.jumlahTanggunganKeluarga = jumlahTanggunganKeluarga;
            this.pekerjaan = pekerjaan;
            this.pendapatan = pendapatan;
            this.tabungan = tabungan;
            this.kendaraan = kendaraan;
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
        fuzzyJumlahTanggunganKeluarga[0] = new FuzzyValue("sedikit", new double[]{2,3}, new int[]{1,0});
        fuzzyJumlahTanggunganKeluarga[1] = new FuzzyValue("sedang", new double[]{2,3,4,7}, new int[]{0,1,1,0});
        fuzzyJumlahTanggunganKeluarga[2] = new FuzzyValue("banyak", new double[]{4,7}, new int[]{0,1});
        
        fuzzyPendapatan[0] = new FuzzyValue("sedikit", new double[]{450000,500000}, new int[]{1,0});
        fuzzyPendapatan[1] = new FuzzyValue("sedang", new double[]{450000,500000,950000,1000000}, new int[]{0,1,1,0});
        fuzzyPendapatan[2] = new FuzzyValue("banyak", new double[]{950000,1000000}, new int[]{0,1});
        
        fuzzyConclusion[0] = new FuzzyValue("tidak layak", new double[]{0,100}, new int[]{1,0});
        fuzzyConclusion[1] = new FuzzyValue("layak", new double[]{0,100}, new int[]{0,1});
    }
    
    private void initRule(){
        rules[0] = new FuzzyRule("milik sendiri", "tembok", "sedikit", "buruh", "sedikit", "punya", "tidak punya", "layak");
        rules[1] = new FuzzyRule("sewa", "tembok", "banyak", "wiraswasta", "banyak", "punya", "punya", "tidak layak");
    }
    
    public double getFuzzyRumah(String label, String value){
        return label.equals(value) ? 1:0;
    }
    
    public double getFuzzyJenisDinding(String label, String value){
        return label.equals(value) ? 1:0;
    }
    
    public double getFuzzyPekerjaan(String label, String value){
        return label.equals(value) ? 1:0;
    }
    
    public double getFuzzyTabungan(String label, String value){
        return label.equals(value) ? 1:0;
    }
    
    public double getFuzzyKendaraan(String label, String value){
        return label.equals(value) ? 1:0;
    }
    
    public double getFuzzyJumlahTanggungan(String label, double value){
        FuzzyValue found = new FuzzyValue("", new double[]{0}, new int[]{0});
        for (FuzzyValue fuzzyJumlahTanggunganKeluarga1 : fuzzyJumlahTanggunganKeluarga) {
            if (fuzzyJumlahTanggunganKeluarga1.label.equals(label)) {
                found = fuzzyJumlahTanggunganKeluarga1;
                break;
            }
        }
        return found.convertValue(value);
    }
    
    public double getFuzzyPendapatan(String label, double value){
        FuzzyValue found = new FuzzyValue("", new double[]{0}, new int[]{0});
        for (FuzzyValue fuzzyPendapatan1 : fuzzyPendapatan) {
            if (fuzzyPendapatan1.label.equals(label)) {
                found = fuzzyPendapatan1;
                break;
            }
        }
        return found.convertValue(value);
    }
    
    public double getDefuzzyConclusion(String label, double value){
        FuzzyValue found = new FuzzyValue("", new double[]{0}, new int[]{0});
        for (FuzzyValue fuzzyConclusion1 : fuzzyConclusion) {
            if (fuzzyConclusion1.label.equals(label)) {
                found = fuzzyConclusion1;
                break;
            }
        }
        return found.conclusionValue(value);
    }
    
    public double calculation(String rumah, String jenisDinding, double jumlahTanggunganKeluarga, String pekerjaan, double pendapatan, String tabungan, String kendaraan, String conclusion){
        double alfa = 0;
        double alfaxz = 0;
        for(FuzzyRule rule : this.rules){
            double alfaRule = Math.min(getFuzzyRumah(rule.rumah, rumah), getFuzzyJenisDinding(rule.jenisDinding, jenisDinding));
            alfaRule = Math.min(alfaRule, getFuzzyJumlahTanggungan(rule.jumlahTanggunganKeluarga, jumlahTanggunganKeluarga));
            alfaRule = Math.min(alfaRule, getFuzzyPekerjaan(rule.pekerjaan, pekerjaan));
            alfaRule = Math.min(alfaRule, getFuzzyPendapatan(rule.pendapatan, pendapatan));
            alfaRule = Math.min(alfaRule, getFuzzyTabungan(rule.tabungan, tabungan));
            alfaRule = Math.min(alfaRule, getFuzzyKendaraan(rule.kendaraan, kendaraan));
            
            double z = getDefuzzyConclusion(rule.conclusion, alfaRule);
            alfa = alfa + alfaRule;
            alfaxz = alfaxz + (alfaRule * z);
        }
        return alfaxz / alfa;
    }
    
}
