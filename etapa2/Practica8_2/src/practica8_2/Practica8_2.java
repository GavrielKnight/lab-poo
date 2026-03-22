package practica8_2;

import java.util.ArrayList;
import java.util.List;

public class Practica8_2 {
    public static void main(String[] args) {
        // Crea una lista de 3 autos
        List<Automovil> autos = new ArrayList<>();
        autos.add(new Automovil("Hyundai", "Grand i10 HB", 282700));
        autos.add(new Automovil("Volkswagen", "Virtus", 349990));
        autos.add(new Automovil("Nissan", "Kicks", 561900));
        
        // Lista propiedades del auto
        autos.get(0).listaAtributos();
        autos.get(0).listaMetodos();
    }
}
