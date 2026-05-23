package submenus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuClientes {
    
    private void actualizarTablaClientes(){
        ObservableList<Cliente> datos = FXCollections.observableArrayList(Main.clientes);
        tablaClientes.setItems(datos);
    }
    
    @FXML private TextField campoId;
    @FXML private TextField campoNombre;
    @FXML private TextField campoEmail;
    @FXML private Label etiqueta;
    
    @FXML private TableView tablaClientes;
    @FXML private TableColumn colNombre;
    @FXML private TableColumn colId;
    @FXML private TableColumn colEmail;
    
    @FXML private void botonCrearPresionado() {
        // Valida que el ID ingresado sea un entero
        int id = Main.validaCampoNumerico(campoId, etiqueta, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Checa que el ID ingresado no exista
        if (Main.clienteExiste(id) != -1){
            Main.etiquetaRoja(etiqueta, "Ya existe cliente con esa matricula");
            return;
        }
        
        // Valida el nombre escrito en el campo
        String nombre = campoNombre.getText().trim();
        if (nombre.isEmpty()){
            Main.etiquetaRoja(etiqueta, "El campo del nombre no debe estar vacio");
            return;
        }
        
        // Valida el email escrito en el campo
        String email = campoEmail.getText().trim();
        if (email.isEmpty()){
            Main.etiquetaRoja(etiqueta, "El campo del correo electronico no debe estar vacio");
            return;
        }

        // Guarda nuevo cliente
        Main.clientes.add(new Cliente(id, nombre, email));
        Main.guardaClientes();
        
        // Notificar operacion exitosa
        Main.etiquetaVerde(etiqueta, "Se ha registrado un cliente");
        
        // Actualiza tabla
        actualizarTablaClientes();
    }
    
    @FXML private void botonEliminarPresionado() {
        // Checa que el ID ingresado sea un entero
        int id = Main.validaCampoNumerico(campoId, etiqueta, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Checa que el ID ingresado exista
        int i = Main.clienteExiste(id);
        if (i == -1){
            Main.etiquetaRoja(etiqueta, "No existe cliente con esa matricula");
            return;
        }
        
        // Elimina el cliente de la lista
        Main.clientes.remove(i);
        Main.etiquetaVerde(etiqueta, "Se ha eliminado el cliente con matricula " + id);
        
        // Actualiza tabla
        actualizarTablaClientes();
    }
    
    @FXML private void botonModificarPresionado() {
        // Checa que el ID escrito en el campo sea un entero
        int id = Main.validaCampoNumerico(campoId, etiqueta, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Checa que el ID escrito en el campo exista
        int i = Main.clienteExiste(id);
        if (i == -1){
            Main.etiquetaRoja(etiqueta, "No existe cliente con esa matricula");
            return;
        }
        
        // Checa que el nombre escrito en el campo no este vacio
        String nuevoNombre = campoNombre.getText().trim();
        if (nuevoNombre.isEmpty()){
            Main.etiquetaRoja(etiqueta, "El campo del nombre no debe estar vacio");
            return;
        }
        
        // Checa que el email escrito en el campo no este vacio
        String nuevoEmail = campoEmail.getText().trim();
        if (nuevoEmail.isEmpty()){
            Main.etiquetaRoja(etiqueta, "El campo del correo electronico no debe estar vacio");
            return;
        }
        
        // Modifica los datos del cliente
        Main.clientes.set(i, new Cliente(id, nuevoNombre, nuevoEmail));
        
        // Notifica operacion exitosa
        Main.etiquetaVerde(etiqueta, "Se ha modificado el cliente con matricula " + id);
        
        // Actualiza tabla
        actualizarTablaClientes();
    }
    
    @FXML private void initialize() {
        // Relaciona las columnas de la tabla con los atributos del cliente
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        // Llena la tabla con los datos de los clientes
        actualizarTablaClientes();
    }
}