package submenus;

import java.io.Serializable;

public class Membresia implements Serializable {
    // Atributos
    private String tipo;
    protected String fechaInicio;
    protected String fechaVencimiento;
    
    // Constructor
    public Membresia(String tipo, String fechaInicio, String fechaVencimiento){
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    // Getters
    public String getTipo() { return this.tipo; }
    public String getFechaInicio() { return this.fechaInicio; }
    public String getFechaVencimiento() { return this.fechaVencimiento; }
}
