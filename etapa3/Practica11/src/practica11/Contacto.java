package practica11;

public class Contacto {
    // Atributos
    private String nombre;
    private String telefono;
    private String email;
    
    // Constructor
    public Contacto(String nombre, String telefono, String email){
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    // Getters
    public String obtenNombre() {
        return this.nombre;
    }
    public String obtenTelefono(){
        return this.telefono;
    }
    public String obtenEmail(){
        return this.email;
    }
}
