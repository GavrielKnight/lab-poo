package submenus;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class RenovarMembresia {

    @FXML private TextField campoIdCliente;
    @FXML private TextField campoIdMembresia;
    
    @FXML private TableView tablaMembresias;
    @FXML private TableColumn colId;
    @FXML private TableColumn colTipo;
    @FXML private TableColumn colInicio;
    @FXML private TableColumn colFin;
    @FXML private TableColumn colVencida;
    
    @FXML private Label label;
    
    private void actualizarTabla(String idCliente){
        if (idCliente == null || idCliente.isEmpty()) {
            tablaMembresias.getItems().clear();
            return;
        }

        try {
            int matricula = Integer.parseInt(idCliente);

            // Buscar al cliente en tu lista (usando Stream para mayor elegancia)
            Optional<Cliente> clienteEncontrado = Main.clientes.stream()
                    .filter(c -> c.getId() == matricula)
                    .findFirst();

            if (clienteEncontrado.isPresent()) {
                // Convertir el ArrayList del cliente a una ObservableList para la tabla
                ObservableList<Membresia> items = FXCollections.observableArrayList(
                    clienteEncontrado.get().getMembresias()
                );
                tablaMembresias.setItems(items);
            } else {
                tablaMembresias.getItems().clear();
            }
        } catch (NumberFormatException e) {
            // Manejo silencioso si el usuario escribe letras en un campo numérico
            tablaMembresias.getItems().clear();
        }
    }
    
    @FXML private void initialize(){
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colFin.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
    
        // Añadir el Listener al campo de ID del cliente
        campoIdCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            actualizarTabla(newValue);
        });
    }
    
    @FXML private void renovarBotonPresionado() {
        // Obten y valida la matricula del cliente escrita en el campo
        int idCliente = Main.validaCampoNumerico(campoIdCliente, label, "La matricula del cliente debe ser un numero");
        if (idCliente == -1) return;
        
        // Checa que la matricula exista
        int indiceCliente = Main.clienteExiste(idCliente);
        if (indiceCliente == -1){
            Main.etiquetaRoja(label, "No existe usuario con esa matricula");
            return;
        }
        
        // Obten y valida el indice de la membresia escrita en el campo
        int idMembresia = Main.validaCampoNumerico(campoIdMembresia, label, "El ID de la membresia debe ser un numero");
        if (idMembresia == -1) return;
        
        // Checa que el indice de la membresia exista
        int indiceMembresia = idMembresia - 1;
        if (indiceMembresia < 0 || indiceMembresia >= Main.clientes.get(indiceCliente).getMembresias().size()){
            Main.etiquetaRoja(label, "No existe membresía con ese ID");
            return;
        }
  
        // Actualiza membresia
        Main.clientes.get(indiceCliente).renovarMembresia(indiceMembresia);
        
        // Notifica operacion exitosa
        Main.etiquetaVerde(label, "Se ha renovado la membresia con ID " + idMembresia + " del cliente con matricula " + idCliente);
    }
}
