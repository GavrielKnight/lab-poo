package submenus;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuMembresias {
    
    // Estructura para almacenar la configuración de las membresías
    public static class Plan {
        int duracion;
        double precio;
        public Plan(int duracion, double precio) {
            this.duracion = duracion;
            this.precio = precio;
        }
    }

    // Diccionario para guardar los planes
    private final Map<String, Plan> planes = new HashMap<>();
    
    private void refrescarTabla() {
        ObservableList<Cliente> datos = FXCollections.observableArrayList(Main.clientes);
        tablaMembresias.setItems(datos);
        tablaMembresias.refresh();
    }
    
    @FXML private TextField campoIdCliente;
    @FXML private ChoiceBox<String> choicerTipo;
    @FXML private Label etiqueta;
    
    @FXML private TableView<Cliente> tablaMembresias;
    @FXML private TableColumn<Cliente, Integer> colIdCliente;
    @FXML private TableColumn<Cliente, String> colNombreCliente;
    @FXML private TableColumn<Cliente, String> colTipo;
    @FXML private TableColumn<Cliente, String> colInicio;
    @FXML private TableColumn<Cliente, String> colFin;
    @FXML private TableColumn<Cliente, String> colEstado;
    
    @FXML private void initialize(){
        // Inicializa el diccionario de los planes
        planes.put("Básico", new Plan(10, 500.00));
        planes.put("Premium", new Plan(10, 1000.00));

        // Configura el selector
        choicerTipo.getItems().addAll(planes.keySet());
        choicerTipo.setValue("Básico");

        // Vincula las columnas de la tabla con las propiedades del Cliente
        colIdCliente.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoMembresia"));
        colInicio.setCellValueFactory(new PropertyValueFactory<>("inicioMembresia"));
        colFin.setCellValueFactory(new PropertyValueFactory<>("finMembresia"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoMembresia"));

        // Llena la tabla
        refrescarTabla();
    }
    
    @FXML private void asignarBotonPresionado() {
        // Checa que el ID ingresado sea un entero
        int idCliente = Main.validaCampoNumerico(campoIdCliente, etiqueta, "La matricula debe ser un numero");
        if (idCliente == -1) return;
        
        // Checa que el ID ingresado exista
        int i = Main.clienteExiste(idCliente);
        if (i == -1){
            Main.etiquetaRoja(etiqueta, "No existe usuario con esa matricula");
            return;
        }
        
        // Obten los datos del tipo de membresia seleccionada
        String tipo = choicerTipo.getValue();
        int duracion = planes.get(tipo).duracion;
        String fechaHoy = Main.strFecha(LocalDate.now());
        
        // Asigna membresia
        Main.clientes.get(i).setMembresia(tipo, fechaHoy, duracion);
        
        // Guarda los cambios
        Main.guardaClientes();
        
        // Notifica operacion exitosa
        Main.etiquetaVerde(etiqueta, "Se ha agregado una nueva membresia al usuario");
        
        // Actualiza tabla
        refrescarTabla();
    }
    
    @FXML private void renovarBotonPresionado() {
        // Checa que el ID escrito en el campo sea un entero
        int idCliente = Main.validaCampoNumerico(campoIdCliente, etiqueta, "La matricula del cliente debe ser un numero");
        if (idCliente == -1) return;
        
        // Checa que el ID escrito en el campo exista
        int i = Main.clienteExiste(idCliente);
        if (i == -1){
            Main.etiquetaRoja(etiqueta, "No existe usuario con esa matricula");
            return;
        }
  
        // Checa que el cliente tiene asignado una membresia
        Cliente cliente = Main.clientes.get(i);
        if (cliente.getMembresia() == null) {
            Main.etiquetaRoja(etiqueta, "El cliente no tiene una membresía previa asignada para renovar.");
            return;
        }
        
        // Obten los datos de la membresia actual del cliente (con nueva fecha de inicio)
        String tipo = cliente.getMembresia().getTipo();
        int duracion = planes.get(tipo).duracion;
        String nuevaFechaInicio = LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Renueva membresia
        cliente.setMembresia(tipo, nuevaFechaInicio, duracion);
        
        // Guarda cambios
        Main.guardaClientes();
        
        // Notifica operacion exitosa
        Main.etiquetaVerde(etiqueta, "Membresía renovada con éxito");

        refrescarTabla();
    }
}
