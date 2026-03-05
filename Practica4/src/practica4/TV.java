package practica4;

public class TV extends Dispositivo {
    private String color;
    private int canal = 1;
    private int volumen = 0;
    
    private int NUM_CANALES = 4;
    private int MAX_VOLUMEN = 30;
    
    public TV(String marca, String modelo, String color){
        super(marca, modelo);
        this.color = color;
    }
    
    @Override
    public void imprimeInfo(){
        System.out.println("=== Informacion de la television ===");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Color: " + this.color);
        System.out.println();
    }
    
    public void cambiaCanal(int canal){
        if (this.encendido) {
            if (canal > 0 && canal <= NUM_CANALES) {
                this.canal = canal;
                System.out.println("Cambia de canal (a canal " + this.canal + ")");
            }
            else{
                System.out.println("No se pudo cambiar de canal. El canal " + canal + " no existe");
            } 
        }
        else {
            System.out.println("No se pudo cambiar de canal. La TV esta apagada");
        }
    }
    
    public void cambiaVolumen(int volumen){
        if (this.encendido) {
            this.volumen = volumen;
            
            if (volumen >= 0 && volumen <= MAX_VOLUMEN) {
                this.volumen = volumen;
                System.out.println("Cambia el volumen (a " + this.volumen + ")"); 
            }
            else {
                System.out.println("No se pudo cambiar el volumen. El numero " + volumen + " es invalido");
            }
        }
        else {
            System.out.println("No se pudo cambiar el volumen. La TV esta apagada");
        }
    }
}