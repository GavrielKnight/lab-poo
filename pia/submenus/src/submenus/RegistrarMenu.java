package submenus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrarMenu {
    
    @FXML
    private TextField nombreCampo;
    @FXML
    private TextField idCampo;
    @FXML
    private Label label;
    
    @FXML 
    private void botonRegistrarPresionado(){
        System.out.println("Boton de registrar presionado");
        
        // Obten y verifica que el id ingresado sea un numero
        int id = Main.validaCampoNumerico(idCampo, label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Verifica que el id ingresado no exista
        if (Main.idExiste(id) != -1){
            label.setText("Ya existe cliente con esa matricula");
            return;
        }
        
        // Obten y valida el nombre escrito en el campo
        String nombre = nombreCampo.getText().trim();
        if (nombre == ""){
            label.setText("El campo del nombre no debe estar vacio");
            return;
        }

        // Adjunta nuevo cliente a la lista
        Main.clientes.add(new Cliente(id, nombre));
        
        // Guarda los datos de los clientes en el archivo serial
        Main.guardaClientes();
        
        // Notificar al usuario que el cliente se ha registrado
        System.out.println("Se ha registrado un cliente");
        for (Cliente c : Main.clientes) c.imprime();
        label.setText("Se ha registrado un cliente");
    }
}
