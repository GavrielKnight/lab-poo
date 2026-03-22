import java.util.Scanner;

public class prog3 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();

            System.out.print("Ingrese su telefono: ");
            scanner.nextLine();
            String telefono = scanner.nextLine();

            System.out.println("Hola " + nombre + ", tu edad es " + edad +
                    " y telefono es: " + telefono);
    }
}
