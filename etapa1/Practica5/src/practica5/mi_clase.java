package practica5;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class mi_clase {
    public int longitud_str(String str){
        return str.length();
    }
    
    public boolean son_iguales(String s1, String s2){
        return s1 == s2;
    }
    
    public void ordenar(String[] arr){
        Arrays.sort(arr);
    }
    
    public int obten_mayor(int[] arr){
        int res = -1000;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > res) {
                res = arr[i];
            }
        }
        return res;
    }
    
    public float calcula_iva(int cantidad, float precio){
        float total = (float)cantidad * precio;
        return (float)0.16 * total;
    }
    
    public String[] divide_str(String str, char c){
        List<String> lst = new ArrayList<>();
        
        String sub = "";
        for (char ch : str.toCharArray()){
            if (ch == c){
                lst.add(sub);
                sub = "";
            }
            else { sub = sub + ch; }
        }
        lst.add(sub);
        
        return lst.toArray(new String[0]);
    }
    
    public boolean contiene_substr(String str, String sub){
        return str.contains(sub);
    }
}
