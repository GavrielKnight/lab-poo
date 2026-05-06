package submenus;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente implements Serializable {
    // Atributos
    private int id;
    private String nombre;
    private List<Membresia> membresias = new ArrayList<>();
    
    // Constructor
    public Cliente(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    // Getters
    public void imprime(){
        System.out.println("[" + this.id + ", " + this.nombre + "]");
    }
    public int getId(){ return this.id; }
    public String getNombre(){ return this.nombre; }
    public List<Membresia> getMembresias() { return this.membresias; }
    
    // Methods
    public void asignarMembresia(String tipo, String fecha_inicio, String fecha_vencimiento){
        membresias.add(new Membresia(tipo, fecha_inicio, fecha_vencimiento));
    }
    public void renovarMembresia(int id){
        // Obten la nueva fecha de hoy
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaHoy = date.format(formatter);
        
        // Obten la nueva fecha de vencimiento
        date = date.plusDays(3);
        String fechaVencimiento = date.format(formatter);
        
        // Actualiza fechas de la membresia
        this.membresias.get(id).fechaInicio = fechaHoy;
        this.membresias.get(id).fechaVencimiento = fechaVencimiento;
    }
}
