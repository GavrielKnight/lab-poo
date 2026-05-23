package submenus;

import java.io.Serializable;

public class Equipo implements Serializable {
    // Atributos
    private int id;
    private String nombre;
    private String estado;
    
    // Constructor
    public Equipo(int id, String nombre, String estado){
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    // Getters
    public int getId(){ return this.id; }
    public String getNombre(){ return this.nombre; }
    public String getEstado() { return this.estado; }
}