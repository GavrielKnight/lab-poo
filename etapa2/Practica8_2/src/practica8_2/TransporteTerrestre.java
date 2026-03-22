package practica8_2;

abstract class TransporteTerrestre {
    // Atributos
    private String marca;
    private String modelo;
    
    // Constructor
    public TransporteTerrestre(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }
    
    // Metodos abstractos
    public abstract void enciende();
    public abstract void apaga();
}
