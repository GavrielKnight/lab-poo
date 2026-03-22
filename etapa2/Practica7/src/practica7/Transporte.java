package practica7;

public class Transporte {
    protected boolean encendido = false;
    
    public void listaMetodos(){
        System.out.println("--- Metodos de la clase Transporte ---");
        System.out.println("1. enciende()");
        System.out.println("2. apaga()");
        System.out.println("3. avanza(int gasolina)");
        System.out.println("4. frena()");
        System.out.println("5. daVuelta(String lado)");
        System.out.println("6. listaMetodos()");
    }
    public void enciende(){
        if (!this.encendido){
            System.out.println("Enciende");
            this.encendido = true;
        }
        else System.out.println("Ya esta encendido");
    }
    public void apaga(){
        if (this.encendido){
            System.out.println("Apaga");
            this.encendido = false;
        }
        else
            System.out.println("Ya esta apagado");
    }
    public void avanza(int gasolina){
        if (this.encendido) 
            System.out.println("Avanza");
        else System.out.println("No avanza en estado apagado");
    }
    public void frena(){
        if (this.encendido)
            System.out.println("Frena");
        else
            System.out.println("No frena en estado apagado");
    }
    public void daVuelta(String lado){
        if (this.encendido)
            System.out.println("Vuelta " + lado);
        else
            System.out.println("No da vuelta en estado apagado");
    }
}
