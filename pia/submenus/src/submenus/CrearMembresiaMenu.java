package submenus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CrearMembresiaMenu {
    
    String[] membresias = {"Básico", "Premium"};
    
    @FXML
    private ChoiceBox<String> membresiaChoicer;
    @FXML
    private TextField idCampo;
    @FXML
    private Label label;
    
    @FXML
    private void initialize(){
        // Configura el selector de membresia
        membresiaChoicer.getItems().addAll(membresias);
        membresiaChoicer.setValue(membresias[0]);
    }
    @FXML
    private void crearBotonPresionado(){
        // Obten y verifica que el id ingresado sea un numero
        int id = Main.validaCampoNumerico(idCampo, label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Checa que el usuario con ese id exista
        int indice = Main.idExiste(id);
        if (indice == -1){
            label.setText("No existe usuario con esa matricula");
            return;
        }
        
        // Obten la membresia seleccionada
        String tipoMembresia = membresiaChoicer.getValue();
        
        // Obten la fecha de hoy
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaHoy = date.format(formatter);
        
        // Obten la fecha de vencimiento
        date = date.plusDays(2);
        String fechaVencimiento = date.format(formatter);
        
        // Adjunta nueva membresia
        Main.clientes.get(indice).asignarMembresia(tipoMembresia, fechaHoy, fechaVencimiento);
        
        // Notifica operacion exitosa
        label.setText("Se ha agregado una nueva membresia al usuario");
        
        // Imprime para corroborar
        Cliente c = Main.clientes.get(indice);
        for (Membresia m : c.getMembresias()){
            System.out.println("[" + m.getTipo() + ", " + m.getFechaInicio() + ", " + m.getFechaVencimiento() + "]");
        }
    }
}
