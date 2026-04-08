package submenus;

import javafx.fxml.FXML;

public class IngresarMenu {

    @FXML
    private void botonIngresarPresionado(){
        System.out.println("Boton de ingresar presionado");
        
        // Obten los clientes guardados en el archivo serial (si existe)
        Main.leeClientes();
        
        // Carga el menu de registro
        Main.loadPage("registrarMenu.fxml");
    }
}
