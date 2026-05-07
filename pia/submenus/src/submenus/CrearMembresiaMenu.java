package submenus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CrearMembresiaMenu {
    
    String[] membresias = {"Básico", "Premium"};
    
    @FXML private ChoiceBox<String> membresiaChoicer;
    @FXML private TextField idCampo;
    
    @FXML private Label labelDuracion;
    @FXML private Label labelCosto;
    @FXML private Label labelFechaInicio;
    
    @FXML private Label label;
    
    private void actualizarInfoMembresia(String seleccion) {
        if (seleccion.equals("Básico")) {
            labelDuracion.setText("Duración: 30 días");
            labelCosto.setText("Costo: $350.00 MXN");
        } else if (seleccion.equals("Premium")) {
            labelDuracion.setText("Duración: 365 días");
            labelCosto.setText("Costo: $3,200.00 MXN");
        }
        labelFechaInicio.setText("Fecha de inicio: " + Main.strFecha(LocalDate.now()));
    }
    
    @FXML private void initialize(){
        // Configura el selector de membresia
        membresiaChoicer.getItems().addAll(membresias);
        String tipo = membresias[0];
        membresiaChoicer.setValue(tipo);
        
        // Muestra informacion de la membresia por defecto
        actualizarInfoMembresia(tipo);
        
        // Agrega un listener para detectar cambios en el choicebox y actualizar informacion de la membresia
        membresiaChoicer.valueProperty().addListener((observable, oldValue, newValue) -> {
            actualizarInfoMembresia(newValue);
        });
    }
    
    @FXML private void crearBotonPresionado(){
        // Obten y verifica que el id ingresado sea un numero
        int id = Main.validaCampoNumerico(idCampo, label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Checa que el usuario con ese id exista
        int indice = Main.idExiste(id);
        if (indice == -1){
            Main.etiquetaRoja(label, "No existe usuario con esa matricula");
            return;
        }
        
        // Obten la membresia seleccionada
        String tipoMembresia = membresiaChoicer.getValue();
        
        // Obten la fecha de hoy
        String fechaHoy = Main.strFecha(LocalDate.now());
        
        // Obten la fecha de vencimiento
        String fechaVencimiento = Main.strFecha(LocalDate.now().plusDays(2));
        
        // Adjunta nueva membresia
        Main.clientes.get(indice).asignarMembresia(tipoMembresia, fechaHoy, fechaVencimiento);
        
        // Guarda los cambios
        Main.guardaClientes();
        
        // Notifica operacion exitosa
        Main.etiquetaVerde(label, "Se ha agregado una nueva membresia al usuario");
        
        // Imprime para corroborar
        Cliente c = Main.clientes.get(indice);
        for (Membresia m : c.getMembresias()){
            System.out.println("[" + m.getTipo() + ", " + m.getFechaInicio() + ", " + m.getFechaVencimiento() + "]");
        }
    }
}
