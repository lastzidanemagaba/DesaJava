/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Imul
 */
public class Fuzzification {
    private String name;
    private HashMap<String, FuzzyValue> fuzzyRumah = new HashMap<String, FuzzyValue>();
    private HashMap<String, FuzzyValue> fuzzyJenisDinding = new HashMap<String, FuzzyValue>();
    private HashMap<String, FuzzyValue> fuzzyJumlahTanggunganKeluarga = new HashMap<String, FuzzyValue>();
    private HashMap<String, FuzzyValue> fuzzyPekerjaan = new HashMap<String, FuzzyValue>();
    private HashMap<String, FuzzyValue> fuzzyPendapatan = new HashMap<String, FuzzyValue>();
    private HashMap<String, FuzzyValue> fuzzyTabungan = new HashMap<String, FuzzyValue>();
    private HashMap<String, FuzzyValue> fuzzyKendaraan = new HashMap<String, FuzzyValue>();
    
    private class FuzzyValue{
        private String label;
        private float[] tresshold;
        private int[] model;

        public FuzzyValue(String label, float[] tresshold, int[] model) {
            this.label = label;
            this.tresshold = tresshold;
            this.model = model;
        }
        
        public String getLabel(){
            return this.label;
        }
        private float convertValuePoint(float v, int a, float at, int b, float bt){
            if (a == b) {
                return a;
            }else if(a < b){
                return (v-at)*(bt-at);
            }else{
                return (bt-v)*(bt-at);
            }
        }
        public float convertValue(float v){
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
    }
    
    private class FuzzyRule{
        String[] label;
        
    }

    public Fuzzification() {
        
    }
    
}
