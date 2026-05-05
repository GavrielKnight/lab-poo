package submenus;

public class Membresia {
    // Atributos
    private String tipo;
    private String fechaInicio;
    private String fechaVencimiento;
    
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
