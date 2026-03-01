package practica3.pkg1;

import java.util.Scanner;

public class Calculadora {

    public float suma(float a, float b) {
        return a + b;
    }

    public float resta(float a, float b) {
        return a - b;
    }

    public float multiplicacion(float a, float b) {
        return a * b;
    }

    public float division(float a, float b) {
        return a / b;
    }

    public static void main(String[] args) {

        // Lee dos numeros
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        float a = scanner.nextFloat();

        System.out.print("Ingrese el segundo numero: ");
        float b = scanner.nextFloat();

        // Realice operaciones aritmeticas basicas y guarde los resultados
        Calculadora calc = new Calculadora();
        float suma = calc.suma(a, b);
        float resta = calc.resta(a, b);
        float multiplicacion = calc.multiplicacion(a, b);
        float division = calc.division(a, b);

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