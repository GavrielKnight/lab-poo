package practica4;

public class Dispositivo {
    // Miembros
    protected String marca;
    protected String modelo;
    protected boolean encendido;
    
    // Constructor
    public Dispositivo(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }
    
    // Funciones
    public void enciende() {
        encendido = true;
        System.out.println("Dispositivo Enciende");
    }
    public void apaga() {
        encendido = false;
        System.out.println("Dispositivo Apagado");
    }
    public void imprimeInfo() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
    }
}
