package practica5;
import java.util.Arrays;

public class Practica5 {
    public static void main(String[] args) {
        mi_clase obj = new mi_clase();
        
        // Obten longitud de una cadena
        String str = "reconocer";
        int longitud = obj.longitud_str(str);
        System.out.println("Longitud de la cadena: " + longitud);
        
        // Determina si dos cadenas son iguales
        String s1 = "conocer";
        String s2 = "reconocer";
        if (obj.son_iguales(s1, s2)){
            System.out.println("Las cadenas son iguales");
        }
        else { System.out.println("Las cadenas son distintas"); }
        
        // Ordena un arreglo de cadenas
        String[] arr = {"casa", "arbol", "Castillo", "banco"};
        obj.ordenar(arr);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
        
        // Obten el mayor de dos numeros
        int[] arr1 = {5, 2};
        int mayor = obj.obten_mayor(arr1);
        System.out.println("Elemento mayor: " + mayor);
        
        // Obten el mayor de tres numeros
        int[] arr2 = {3, 7, 6};
        mayor = obj.obten_mayor(arr2);
        System.out.println("Elemento mayor: " + mayor);
        
        // Calcula el IVA dados la cantidad y el precio de un producto
        float iva = obj.calcula_iva(10, (float)20.0);
        System.out.println("IVA calculado: " + iva);
        
        // Divide una cadena en subcadenas
        String s3 = "hola mundo";
        String[] subs = obj.divide_str(s3, ' ');
        System.out.println("Subcadenas: " + Arrays.toString(subs));
        
        // Checa si un string contiene otro string
        String s4 = "mundo";
        if (obj.contiene_substr(s3, s4)){ 
            System.out.println("La cadena si contiene a la otra cadena");
        }
        else{
            System.out.println("La cadena no contiene a la otra cadena");
        }
    }
}
