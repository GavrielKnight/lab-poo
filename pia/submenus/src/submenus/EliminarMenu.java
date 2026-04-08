package submenus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EliminarMenu {
    
    @FXML
    private TextField idCampo;
    @FXML
    private Label label;
    
    @FXML
    private void botonEliminarPresionado(){
        // Obten y verifica que el id ingresado sea un numero
        int id = Main.validaCampoNumerico(idCampo, label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Muestra un mensaje si el cliente que se quiere eliminar no existe
        int indiceEliminar = Main.idExiste(id);
        if (indiceEliminar == -1){
            label.setText("No existe cliente con esa matricula");
            return;
        }
        
        // Elimina el cliente de la lista
        Main.clientes.remove(indiceEliminar);
        label.setText("Se ha eliminado el cliente con matricula " + id);
    }
}
