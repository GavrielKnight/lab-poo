package submenus;

import java.io.Serializable;

public class Cliente implements Serializable {
    // Atributos
    private int id;
    private String nombre;
    private String email;
    private Membresia membresia;
    
    // Constructor
    public Cliente(int id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    
    // Getters
    public int getId(){ return this.id; }
    public String getNombre(){ return this.nombre; }
    public String getEmail() { return this.email; }
    public Membresia getMembresia() { return this.membresia; }
    
    // Setters
    public void setMembresia(String tipo, String fechaInicio, int duracionDias) {
        this.membresia = new Membresia(tipo, fechaInicio, duracionDias);
    }
    
    // --- MÉTODOS ENVOLVENTES PARA EL LLENADO DE LA TABLA ---
    
    public String getTipoMembresia() {
        return (membresia != null) ? membresia.getTipo() : "N/A";
    }
    
    public String getInicioMembresia() {
        return (membresia != null) ? membresia.getFechaInicio() : "N/A";
    }
    
    public String getFinMembresia() {
        return (membresia != null) ? membresia.getFechaFin() : "N/A";
    }
    
    public String getEstadoMembresia() {
        return (membresia != null) ? membresia.getEstadoActual() : "Sin Membresia";
    }
}