import java.io.*;
import java.util.Scanner;

public class Practica10_2 {

    public static void main(String args[]) {
        // Crea un escaner para leer entradas
        Scanner scanner = new Scanner(System.in);
        
        // Lee el directorio del archivo
        System.out.print("Ingrese el directorio del archivo a leer: ");
        String dir = scanner.nextLine();
        
        try{
            // Crea un objeto file
            File file = new File(dir);

            // Crea un escaner para leer el archivo
            Scanner sc = new Scanner(file);

            // Imprime el contenido del archivo
            System.out.println("--- Contenido del archivo de texto ---");
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
            
        } catch (IOException e){
            System.out.println("Ha ocurrido un error en la busqueda del archivo");
        }
    }
}
