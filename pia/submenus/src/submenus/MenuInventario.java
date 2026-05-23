package submenus;

import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuInventario {
    private static List<String> estados = Arrays.asList("Activo", "Fuera de servicio");
    
    private void refrescarTabla(){
        ObservableList<Equipo> datos = FXCollections.observableArrayList(Main.equipo);
        tablaEquipo.setItems(datos);
    }
    
    @FXML private TextField campoId;
    @FXML private TextField campoNombre;
    @FXML private ChoiceBox<String> choicerEstado;
    @FXML private Label etiqueta;
    
    @FXML private TableView tablaEquipo;
    @FXML private TableColumn colNombre;
    @FXML private TableColumn colId;
    @FXML private TableColumn colEstado;
    
    @FXML private void initialize(){
        // Configura el selector
        choicerEstado.getItems().addAll(estados);
        choicerEstado.setValue(estados.get(0));

        // Vincula las columnas de la tabla con las propiedades del Equipo
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Llena la tabla
        refrescarTabla();
    }
    
    @FXML private void agregarBotonPresionado() {
        // Valida que el ID ingresado sea un entero
        int id = Main.validaCampoNumerico(campoId, etiqueta, "El ID debe ser un numero entero");
        if (id == -1) return;
        
        // Checa que el ID ingresado no exista
        if (Main.equipoExiste(id) != -1){
            Main.etiquetaRoja(etiqueta, "Ya existe un equipo con ese ID");
            return;
        }
        
        // Checa que el nombre escrito en el campo no este vacio
        String nombre = campoNombre.getText().trim();
        if (nombre.isEmpty()){
            Main.etiquetaRoja(etiqueta, "El campo del nombre no debe estar vacio");
            return;
        }
        
        // Obten el estado del equipo
        String estado = choicerEstado.getValue();

        // Guarda el nuevo equipo
        Main.equipo.add(new Equipo(id, nombre, estado));
        Main.guardaEquipo();
        Main.etiquetaVerde(etiqueta, "Se ha registrado un nuevo equipo exitosamente");
        
        // Actualiza tabla
        refrescarTabla();
    }
    
    @FXML private void eliminarBotonPresionado() {
        // Checa que el ID ingresado sea un entero
        int id = Main.validaCampoNumerico(campoId, etiqueta, "El ID debe ser un numero entero");
        if (id == -1) return;
        
        // Checa que el ID ingresado exista
        int i = Main.equipoExiste(id);
        if (i == -1){ Main.etiquetaRoja(etiqueta, "No existe equipo con ese ID"); return; }
        
        // Elimina el equipo de la lista
        Main.equipo.remove(i);
        Main.etiquetaVerde(etiqueta, "Se ha eliminado el equipo con exito");
        
        // Actualiza tabla
        refrescarTabla();
    }
    
    @FXML private void modificarBotonPresionado() {
        // Checa que el ID escrito en el campo sea un entero
        int id = Main.validaCampoNumerico(campoId, etiqueta, "El ID debe ser un numero entero");
        if (id == -1) return;
        
        // Checa que el ID escrito en el campo exista
        int i = Main.equipoExiste(id);
        if (i == -1){ Main.etiquetaRoja(etiqueta, "No existe un equipo con ese ID"); return; }
        
        // Checa que el nombre escrito en el campo no este vacio
        String nuevoNombre = campoNombre.getText().trim();
        if (nuevoNombre.isEmpty()){ Main.etiquetaRoja(etiqueta, "El campo del nombre no debe estar vacio"); return; }
        
        // Obten el estado del equipo
        String estado = choicerEstado.getValue();
        
        // Modifica los datos del equipo
        Main.equipo.set(i, new Equipo(id, nuevoNombre, estado));
        Main.etiquetaVerde(etiqueta, "Se ha modificado el equipo exitosamente");
        
        // Actualiza tabla
        refrescarTabla();
    }
}