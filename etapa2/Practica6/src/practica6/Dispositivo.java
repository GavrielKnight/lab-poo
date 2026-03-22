package practica6;

public class Dispositivo {
    protected String marca;
    protected String modelo;
    protected boolean encendido;
    protected boolean conectado_a_internet;

    public void encender(){
        this.encendido = true;
        System.out.println("Telefono encendido");
    }
    public void apagar(){
        this.encendido = false;
        System.out.println("Telefono apagado");
    }
    public void conectar_a_internet(){
        this.conectado_a_internet = true;
        System.out.println("Telefono conectado a Internet");
    }
}
