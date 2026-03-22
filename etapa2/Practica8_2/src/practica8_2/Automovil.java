package practica8_2;

public class Automovil extends TransporteTerrestre {
    // Atributos
    private float precio;
    
    // Constructor
    public Automovil(String marca, String modelo, float precio){
        super(marca, modelo);
        this.precio = precio;
    }
    
    // Getter
    public void listaAtributos(){
        System.out.println("=== Atributos de la clase 'Automovil' ===");
        System.out.println("1. String marca");
        System.out.println("2. String modelo");
        System.out.println("3. float precio");
    }
    public void listaMetodos(){
        System.out.println("=== Metodos de la clase 'Automovil' ===");
        System.out.println("1. enciende() @Override");
        System.out.println("2. apaga() @Override");
        System.out.println("3. avanza()");
    }
    
    // Metodos
    @Override
    public void enciende(){
        System.out.println("Auto encendido");
    }
    @Override
    public void apaga(){
        System.out.println("Auto apagado");
    }
    public void avanza(){
        System.out.println("Avanza");
    }
}
