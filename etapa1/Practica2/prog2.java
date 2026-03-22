import java.util.Scanner;

public class prog2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un numero entero: ");
        int n = scanner.nextInt();
        
        System.out.print("Ingrese un float: ");
        float f = scanner.nextFloat();
        
        System.out.print("Ingrese un double: ");
        double dbl = scanner.nextDouble();
        
        System.out.print("Ingrese un long: ");
        long lng = scanner.nextLong();
        
        System.out.print("Ingrese un short: ");
        short sh = scanner.nextShort();
         
        System.out.print("Ingrese un valor booleano (true/false): ");
        boolean b = scanner.nextBoolean();
        
        System.out.print("Ingrese un byte (-128 a 127): ");
        byte by = scanner.nextByte();
        
        System.out.print("Ingrese una cadena: ");
        scanner.nextLine(); // Linea repetida para evitar omision de lectura
        String str = scanner.nextLine();
        
        System.out.println("=== DATOS INGRESADOS ===");
        System.out.println("Entero: " + n);
        System.out.println("Float: " + f);
        System.out.println("Double: " + dbl);
        System.out.println("Long: " + lng);
        System.out.println("Short: " + sh);
        System.out.println("Boolean: " + b);
        System.out.println("Byte: " + by);
        System.out.println("Cadena: " + str);
    }
}
