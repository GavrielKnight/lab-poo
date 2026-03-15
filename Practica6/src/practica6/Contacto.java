package practica6;

public class Contacto {
    protected String nombre;
    protected String telefono;
    protected String email;
    
    public Contacto(String nombre, String telefono, String email){
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    public void imprimir(){
        System.out.print("[Nombre: " + this.nombre);
        System.out.print("; Telefono: " + this.telefono);
        System.out.print("; Email: " + this.email + "]\n");
    }
}
