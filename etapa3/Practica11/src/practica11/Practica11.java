package practica11;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Practica11 {
    
    public static List<Contacto> cargaArchivo(String dir){
        // Crea una lista de contactos vacia
        List<Contacto> contactos = new ArrayList<>();
        
        try{
            // Crea escaner para leer archivo
            Scanner sc = new Scanner(new FileReader(dir)).useDelimiter("\n");
            
            // Lee archivo para guardar contactos en la lista
            while(sc.hasNext()){
                // Obten registro de contacto 
                String[] chunks = sc.next().split(" ");
                
                // Agrega contacto leido a la lista
                String nombre = chunks[0];
                String telefono = chunks[1];
                String correo = chunks[2];
                contactos.add(new Contacto(nombre, telefono, correo));
            }
            
            System.out.println("Se han cargado los contactos");

        } catch(IOException e){
            System.out.println("Ha ocurrido un error");
        }
        
        return contactos;
    }
    
    public static void escribeArchivo(String dir, List<Contacto> contactos){
        try{
            // Crea un objeto filewriter para escribir en un archivo
            FileWriter fw = new FileWriter(dir);

            // Escribe los contactos en el archivo
            for (Contacto c : contactos){
                String linea = c.obtenNombre() + " " + c.obtenTelefono() + " " + c.obtenEmail() + "\n";
                fw.write(linea);
            }

            // Cierra filewriter
            fw.close();
            System.out.println("Se han agregado los nuevos contactos en el archivo");
        
        } catch(IOException e){
            System.out.println("Ha ocurrido un error");
        }
    }

    public static void main(String[] args) {
        // Guarda la direccion del archivo de texto
        String dir = "contactos.txt";
        
        // Carga los contactos desde el archivo de texto (si existe)
        List<Contacto> contactos = new ArrayList<>();
        File file = new File(dir);
        if (file.exists()){
            contactos = cargaArchivo(dir);
  
            // Muestra los contactos cargados
            System.out.println("==== CONTACTOS GUARDADOS ====");
            for (Contacto c : contactos){
                System.out.println(c.obtenNombre() + " " + c.obtenTelefono() + " " + c.obtenEmail());
            }
        }
        
        // Crea un escaner para leer entradas
        Scanner scanner = new Scanner(System.in);
        
        // Lee el numero de nuevos contactos a agregar
        System.out.print("Ingrese el numero de nuevos contactos a agregar: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        // Lee y guarde los nuevos contactos en la lista de contactos
        for(int i = 0; i < n; i++){
            System.out.println("=== Leyendo informacion del contacto " + (i+1) + " ===");
            
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el telefono: ");
            String telefono = scanner.nextLine();
            System.out.print("Ingrese el correo: ");
            String correo = scanner.nextLine();
            
            contactos.add(new Contacto(nombre, telefono, correo));
        }
        
        // Actualice archivo con los nuevos contactos (si no existe, crea una)
        escribeArchivo(dir, contactos);
    }
}
