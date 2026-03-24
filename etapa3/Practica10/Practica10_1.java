import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Practica10_1 {
    public static void main(String args[]) {
        try{
            // Crea un objeto Scanner para leer entradas
            Scanner scanner = new Scanner(System.in);
            
            // Solicita al usuario el texto a escribir en el archivo
            System.out.println("Ingrese el texto que desea escribir en el archivo: ");
            String texto = scanner.nextLine();
                    
            // Crea un objeto FileWriter
            FileWriter fw = new FileWriter("archivo.txt");
            
            // Escribe el texto en el archivo
            fw.write(texto);
            
            // Cierra
            fw.close();
            System.out.println("Se ha sobreescrito el archivo exitosamente");
            
        } catch(IOException e){
            System.out.println("Ha ocurrido un error al tratar de abrir el archivo");
        }
    }
}
