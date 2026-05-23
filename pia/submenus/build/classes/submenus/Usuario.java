package submenus;

import java.io.Serializable;

public class Usuario implements Serializable {
    // Atributos
    private int id;
    private String nombre;
    private String contraseña;
    
    // Constructor
    public Usuario (int id, String nombre, String contraseña){
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    
    // Getters
    public int getId() { return this.id; }
    public String getNombre() { return this.nombre; }
    public String getContraseña() { return this.contraseña; }
}
