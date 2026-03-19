package practica7;

public class Automovil extends Transporte {
    protected String marca;
    protected String modelo;
    protected String color;
    protected float precio;
    
    public Automovil(String marca, String modelo, String color, float precio){
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }
    
    @Override
    public void listaMetodos(){
        System.out.println("--- Metodos de la clase Automovil ---");
        System.out.println("1. enciende()");
        System.out.println("2. apaga()");
        System.out.println("3. avanza(int gasolina)");
        System.out.println("4. frena()");
        System.out.println("5. daVuelta(String lado)");
        System.out.println("6. listaMetodos()");
        System.out.println("7. imprimeInfo()");
        System.out.println("8. setColor(String color)");
    }

    public void imprimeInfo(){
        System.out.println("***** Automovil " + this.marca + " *****");
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Color: " + this.color);
        System.out.println("Precio: " + this.precio);
    }
    
    public void setColor(String color){
        this.color = color;
    }
}
