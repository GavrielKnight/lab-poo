package submenus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class ModificarMenu {
    
    private void fillTable(){
        // Adjunta los datos de los clientes en la tabla
        ObservableList<Cliente> datos = FXCollections.observableArrayList(Main.clientes);
        tablaClientes.setItems(datos);
    }
    
    @FXML private TableView tablaClientes;
    @FXML private TableColumn colNombre;
    @FXML private TableColumn colMatricula;
    @FXML private TableColumn colEmail;
    
    @FXML private TextField idCampo;
    @FXML private TextField campoNombre;
    @FXML private TextField campoEmail;
    
    @FXML private Label label;
    
    @FXML
    private void initialize(){
        // Relaciona las columnas de la tabla con los atributos del cliente
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        // Llena la tabla con los datos de los clientes
        fillTable();
    }
     
    @FXML
    private void botonActualizarPresionado(){ fillTable(); }
    
    @FXML
    private void botonModificarPresionado(){
        // Obten y verifica que el id ingresado sea un numero
        int id = Main.validaCampoNumerico(idCampo, label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Muestra un mensaje si el cliente que se quiere eliminar no existe
        int indice = Main.idExiste(id);
        if (indice == -1){
            Main.etiquetaRoja(label, "No existe cliente con esa matricula");
            return;
        }
        
        // Obten y valida el nombre escrito en el campo
        String nuevoNombre = campoNombre.getText().trim();
        if (nuevoNombre == ""){
            Main.etiquetaRoja(label, "El campo del nombre no debe estar vacio");
            return;
        }
        
        // Obten y valida el email escrito en el campo
        String nuevoEmail = campoEmail.getText().trim();
        if (nuevoEmail == ""){
            Main.etiquetaRoja(label, "El campo del correo electronico no debe estar vacio");
            return;
        }
        
        // Modifica los datos del cliente
        Main.clientes.set(indice, new Cliente(id, nuevoNombre, nuevoEmail));
        
        // Notifica operacion exitosa
        Main.etiquetaVerde(label, "Se ha modificado el cliente con matricula " + id);
    }
}
