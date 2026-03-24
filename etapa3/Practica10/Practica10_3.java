import java.io.*;
import java.util.Scanner;

public class Practica10_3 {
    
    public static void main(String args[]){
        try{
            // Crea un objeto Scanner para leer entradas
            Scanner scanner = new Scanner(System.in);
            
            // Lee el directorio del archivo a crear
            System.out.print("Ingrese el directorio del nuevo archivo de texto: ");
            String dir = scanner.nextLine();
            
            // Lee el texto a escribir en el archivo
            System.out.println("Ingrese el texto que desea escribir en el archivo: ");
            String texto = scanner.nextLine();
                    
            // Crea un objeto filewriter para escribir en un archivo
            FileWriter fw = new FileWriter(dir);
            
            // Escribe el texto en el archivo
            fw.write(texto);
            
            // Cierra filewriter
            fw.close();
            System.out.println("Se ha escrito en el archivo exitosamente");
            
            // Crea un escaner para leer el archivo creado
            File file = new File(dir);
            Scanner sc = new Scanner(file);

            // Imprime el contenido del archivo
            System.out.println("--- Contenido del archivo de texto ---");
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
            
        } catch(IOException e){
            System.out.println("Ha ocurrido un error");
        }
    }
}
