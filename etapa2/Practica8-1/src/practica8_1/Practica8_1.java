package practica8_1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Practica8_1 {
    public static void main(String[] args) {
        // Crea un objeto de escaner para leer datos de entrada
        Scanner scanner = new Scanner(System.in);
        
        // Crea un objeto auto
        Automovil carro = new Automovil("Nissan", "Versa", 362900);
        
        // Prueba todas las propiedades del auto (antes del encendido)
        System.out.println("---- Probando todas las propiedades del auto (antes del encendido) ----");
        carro.movimiento("adelante");
        carro.apaga();
        
        // Prueba todas las propiedades del auto (despues del encendido)
        System.out.println("---- Probando todas las propiedades del auto (despues del encendido) ----");
        carro.enciende();
        carro.enciende();
        carro.movimiento("adelante");
        carro.apaga();
        
        // Prueba todas las propiedades del auto (hasta agotar gasolina)
        System.out.println("---- Probando todas las propiedades del auto (hasta agotar gasolina) ----");
        carro.enciende();
        while (carro.estaEncendido()){
            carro.movimiento("adelante");
        }
        carro.apaga();
        
        // Crea una lista de autos
        List<Automovil> autos = new ArrayList<>();
        
        // Agrega 10 autos a la lista
        autos.add(new Automovil("Hyundai", "Grand i10 HB", 282700));
        autos.add(new Automovil("Volkswagen", "Virtus", 349990));
        autos.add(new Automovil("Nissan", "Kicks", 561900));
        autos.add(new Automovil("Nissan", "March", 291900));
        autos.add(new Automovil("Nissan", "NP300", 499900));
        autos.add(new Automovil("Nissan", "Versa", 362900));
        autos.add(new Automovil("Mazda", "2 HB", 331900));
        autos.add(new Automovil("Mazda", "CX-30", 451900));
        autos.add(new Automovil("Kia", "K3 HB", 353500));
        autos.add(new Automovil("Chevrolet", "Aveo HB", 307400));
        
        // Prueba todas las propiedades de cada auto
        System.out.println("==== Probando todas las propiedades de los 10 autos ====");
        for(Automovil auto : autos){
            // Muestra informacion del auto
            auto.imprimeInfo();
            
            // Enciende auto
            auto.enciende();
            
            // Solicita al usuario el lado al que quiere mover el auto (izquierda/derecha)
            System.out.print("Lado a moverse (izquierda/derecha/adelante/atras): ");
            String lado = scanner.nextLine();
            
            // Mueve auto
            auto.movimiento(lado);
            
            // Apaga auto
            auto.apaga();
        }
    }
}
