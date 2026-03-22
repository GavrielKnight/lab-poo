package practica8_1;

public class Automovil {
    // Atributos
    protected String marca;
    protected String modelo;
    protected float precio;
    protected boolean encendido = false;
    protected int gasolina = 5;
    
    // Constructor
    public Automovil(String marca, String modelo, float precio){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    
    // Funciones getter
    public boolean estaEncendido(){
        return this.encendido;
    }
    public void imprimeInfo(){
        System.out.println("**** Automovil " + this.marca + " ****");
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Precio: " + this.precio + "$");
        System.out.println("****");
    }
    
    // Metodos
    public void enciende(){
        if (this.encendido){
            System.out.println("Auto ya encendido");
            return;
        }
        if (this.gasolina <= 0){
            System.out.println("No enciende, gasolina agotada");
            return;
        }
        this.encendido = true;
        System.out.println("Enciende");
    }
    public void movimiento(String mov){
        if (!this.encendido){
            System.out.println("No se mueve, auto apagado");
            return;
        }
        if (this.gasolina <= 0){
            System.out.println("No se mueve, gasolina agotada");
            return;
        }
        System.out.println("Muevete: " + mov);
        --this.gasolina;
        if (this.gasolina <= 0){
            this.encendido = false;
            System.out.println("Gasolina agotada, auto apagado");
        }
    }
    public void apaga(){
        if (!this.encendido){
            System.out.println("Auto ya apagado");
            return;
        }
        this.encendido = false;
        System.out.println("Apaga");
    }
}
