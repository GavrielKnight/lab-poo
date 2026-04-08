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
    
    @FXML
    private TableView tablaClientes;
    @FXML
    private TableColumn tablaClientes_colNombre;
    @FXML
    private TableColumn tablaClientes_colMatricula;
    @FXML
    private Label label;
    @FXML
    private TextField idCampo;
    @FXML
    private TextField nombreCampo;
     
    @FXML
    private void botonActualizarPresionado(){

        // Relaciona las columnas de la tabla con los atributos del cliente
        tablaClientes_colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaClientes_colMatricula.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        // Adjunta los datos de los clientes en la tabla
        ObservableList<Cliente> datos = FXCollections.observableArrayList(Main.clientes);
        tablaClientes.setItems(datos);
    }
    
    @FXML
    private void botonModificarPresionado(){
        // Obten y verifica que el id ingresado sea un numero
        int id = Main.validaCampoNumerico(idCampo, label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Muestra un mensaje si el cliente que se quiere eliminar no existe
        int indice = Main.idExiste(id);
        if (indice == -1){
            label.setText("No existe cliente con esa matricula");
            return;
        }
        
        // Obten y valida el nombre escrito en el campo
        String nuevoNombre = nombreCampo.getText().trim();
        if (nuevoNombre == ""){
            label.setText("El campo del nombre no debe estar vacio");
            return;
        }
        
        // Modifica los datos del cliente
        Main.clientes.set(indice, new Cliente(id, nuevoNombre));
        label.setText("Se ha modificado el cliente con matricula " + id);
    }
}
