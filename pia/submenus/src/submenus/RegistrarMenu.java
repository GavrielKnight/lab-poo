package submenus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrarMenu {
    
    String[] membresias = {"Básico", "Premium"};
    
    @FXML private TextField nombreCampo;
    @FXML private TextField idCampo;
    @FXML private TextField campoEmail;
    @FXML private Label label;
    
    @FXML 
    private void botonRegistrarPresionado(){
        System.out.println("Boton de registrar presionado");
        
        // Obten y verifica que el id ingresado sea un numero
        int id = Main.validaCampoNumerico(idCampo, label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Verifica que el id ingresado no exista
        if (Main.idExiste(id) != -1){
            Main.etiquetaRoja(label, "Ya existe cliente con esa matricula");
            return;
        }
        
        // Obten y valida el nombre escrito en el campo
        String nombre = nombreCampo.getText().trim();
        if (nombre == ""){
            Main.etiquetaRoja(label, "El campo del nombre no debe estar vacio");
            return;
        }
        
        // Obten y valida el email escrito en el campo
        String email = campoEmail.getText().trim();
        if (email == ""){
            Main.etiquetaRoja(label, "El campo del correo electronico no debe estar vacio");
            return;
        }

        // Adjunta nuevo cliente a la lista
        Main.clientes.add(new Cliente(id, nombre, email));
        
        // Guarda los datos de los clientes en el archivo serial
        Main.guardaClientes();
        
        // Notificar al usuario que el cliente se ha registrado
        System.out.println("Se ha registrado un cliente");
        for (Cliente c : Main.clientes) c.imprime();
        Main.etiquetaVerde(label, "Se ha registrado un cliente");
    }
}
