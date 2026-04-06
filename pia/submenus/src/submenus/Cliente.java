package submenus;

import java.io.Serializable;

public class Cliente implements Serializable {
    // Atributos
    private int id;
    private String nombre;
    
    // Constructor
    public Cliente(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    // Getters
    public void imprime(){
        System.out.println("[" + this.id + ", " + this.nombre + "]");
    }
    public int obtenId(){
        return this.id;
    }
    public String obtenNombre(){
        return this.nombre;
    }
    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
}
