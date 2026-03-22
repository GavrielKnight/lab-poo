package practica6;

public class Practica6 {

    public static void main(String[] args) {
        // Crea un arreglo de 5 telefonos
        Telefono[] telefonos = new Telefono[5];
        telefonos[0] = new Telefono("Xiaomi", "Xiaomi 16 Pro", 2000);
        telefonos[1] = new Telefono("¡Phone", "¡Phone 17 Pro Max", 2500);
        telefonos[2] = new Telefono("Samsung", "Samsung Galaxy S26 Ultra", 2200);
        telefonos[3] = new Telefono("Google", "Google Pixel 10", 1900);
        telefonos[4] = new Telefono("OnePlus", "OnePlus 13/15", 2100);
        
        // Crea un arreglo de 5 contactos
        Contacto[] contactos = new Contacto[5];
        contactos[0] = new Contacto("Juan", "555-555", "juan@sample");
        contactos[1] = new Contacto("Maria", "888-888", "maria@sample");
        contactos[2] = new Contacto("Luis", "222-222", "luis@sample");
        contactos[3] = new Contacto("Marco", "222-000", "marco@sample");
        contactos[4] = new Contacto("Sofia", "333-000", "sofia@sample");
        
        // Prueba todas las funciones de cada telefono y por contacto
        for (int i = 0; i < telefonos.length; i++){
            System.out.println("=== TELEFONO " + (i+1) + " ===");
            
            Telefono telefono = telefonos[i];
            
            telefono.imprimirInfo();
            
            // Enciende telefono
            telefono.encender();
            
            // Conecta el telefono a internet
            telefono.conectar_a_internet();
            
            // Inicializa y finalice llamada por cada contacto
            for (Contacto contacto : contactos){
                telefono.iniciarLlamada(contacto);
                telefono.finalizarLlamada();
            }
            
            // Apaga telefono
            telefono.apagar();
        }
    }
}
