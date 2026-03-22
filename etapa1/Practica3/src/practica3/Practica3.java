package practica3;

import java.util.Scanner;

public class Practica3 {
    
    public static void main(String[] args) {
        
        // Lee dos numeros
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el primer numero: ");
        float a = scanner.nextFloat();
        
        System.out.print("Ingrese el segundo numero: ");
        float b = scanner.nextFloat();
        
        // Realice operaciones aritmeticas basicas y guarde los resultados
        float suma = a + b;
        float resta = a - b;
        float multiplicacion = a*b;
        
        float division = 0;
        if (b != 0) division = a/b;
        
        // Imprime los resultados
        System.out.println("=== RESULTADOS ===");
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicacion: " + multiplicacion);
        
        System.out.print("Division: ");
        if (b != 0) System.out.println(division);
        else System.out.println("indeterminado (division entre 0)");
    }
}
