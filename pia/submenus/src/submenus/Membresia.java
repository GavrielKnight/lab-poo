package submenus;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Membresia implements Serializable {
    // Atributos
    private String tipo;
    protected String fechaInicio;
    protected int duracionDias;
    
    // Constructor
    public Membresia(String tipo, String fechaInicio, int duracionDias){
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.duracionDias = duracionDias;
    }
    
    // Getters
    public String getTipo() { return this.tipo; }
    public String getFechaInicio() { return this.fechaInicio; }
    public int getDuracionDias() { return this.duracionDias; }
    
    public String getFechaFin() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.parse(this.fechaInicio, formatter);
        LocalDate fin = inicio.plusDays(this.duracionDias);
        return fin.format(formatter);
    }

    public String getEstadoActual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fin = LocalDate.parse(getFechaFin(), formatter);
        if (fin.isBefore(LocalDate.now())) { return "Vencido"; }
        return "Activo";
    }
}
