package practica6;

public class Telefono extends Dispositivo {
    protected float precio;
    protected boolean enLlamada = false;
    
    Telefono(String marca, String modelo, float precio){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
      
    public void imprimirInfo(){
        System.out.print("Telefono (Marca: " + this.marca);
        System.out.print("; Modelo: " + this.modelo + ")\n");
    }
    
    public void iniciarLlamada(Contacto contacto){
        if (!this.encendido){
            System.out.println("No puede iniciar llamada porque el telefono esta apagado");
        }
        else if(!this.conectado_a_internet){
            System.out.println("No puede iniciar llamada porque el telefono no esta conectado a Internet");
        }
        else if(this.enLlamada){
            System.out.println("No puede iniciar llamada porque el telefono esta en otra llamada");
        }
        else{
            System.out.print("Llamada iniciada con exito al contacto: ");
            contacto.imprimir();
            this.enLlamada = true;
        }
    }
    
    public void finalizarLlamada(){
        if (!this.encendido){
            System.out.println("No puede finalizar una llamada porque el telefono esta apagado");
        }
        else if(!this.enLlamada){
            System.out.println("No hay llamada que finalizar");
        }
        else{
            System.out.println("Llamada finalizada");
            this.enLlamada = false;
        }
    }
}
