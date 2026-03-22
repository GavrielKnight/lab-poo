package practica7;

public class Practica7 {
    public static void main(String[] args) {
        // Muestra lista de metodos de la clase Automovil
        Transporte tr = new Automovil("Acura", "Acura ADX 2025", "Blanco", 939900);
        tr.listaMetodos();
        
        // Crea un arreglo de autos
        Automovil[] autos = new Automovil[5];
        autos[0] = new Automovil("Acura", "Acura ADX 2025", "Blanco", 939900);
        autos[1] = new Automovil("Acura", "Acura Integra 2025", "Blanco", 920900);
        autos[2] = new Automovil("Acura", "Acura Integra Type S 2025", "Gris", 1633900);
        autos[3] = new Automovil("Volkswagen", "Volkswagen Virtus 2025", "Negro", 349990);
        autos[4] = new Automovil("Nissan", "Nissan Versa 2025", "Naranja", 302900);
        
        // Cambia color a algunos carros
        autos[2].setColor("Rojo");
        autos[4].setColor("Rosa");
        
        // Prueba todos los metodos de la clase Automovil
        for (Automovil auto : autos){
            auto.imprimeInfo();
            auto.enciende();
            auto.avanza(50);
            auto.daVuelta("izquierda");
            auto.frena();
            auto.apaga();
        }
    }
}
