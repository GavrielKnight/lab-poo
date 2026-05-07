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
    private String email;
    private List<Membresia> membresias = new ArrayList<>();
    
    // Constructor
    public Cliente(int id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    
    // Getters
    public void imprime(){
        System.out.println("[" + this.id + ", " + this.nombre + "]");
    }
    public int getId(){ return this.id; }
    public String getNombre(){ return this.nombre; }
    public String getEmail() { return this.email; }
    public List<Membresia> getMembresias() { return this.membresias; }
    
    // Methods
    public void asignarMembresia(String tipo, String fecha_inicio, String fecha_vencimiento){
        membresias.add(new Membresia(tipo, fecha_inicio, fecha_vencimiento));
    }
    public void renovarMembresia(int id){
        // Obten la nueva fecha de hoy
        String fechaHoy = Main.strFecha(LocalDate.now());
        
        // Obten la nueva fecha de vencimiento
        String fechaVencimiento = Main.strFecha(LocalDate.now().plusDays(3));
        
        // Actualiza fechas de la membresia
        this.membresias.get(id).fechaInicio = fechaHoy;
        this.membresias.get(id).fechaVencimiento = fechaVencimiento;
    }
}
