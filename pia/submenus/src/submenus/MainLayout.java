package submenus;

import javafx.fxml.FXML;

public class MainLayout {
    
    @FXML
    private void menuRegistrar(){
        System.out.println("Boton de abrir menu de registrar presionado");
        Main.loadPage("registrarMenu.fxml");
    }
    @FXML
    private void menuEliminar(){
        System.out.println("Boton de abrir menu de eliminar presionado");
        Main.loadPage("eliminarMenu.fxml");
    }
    @FXML
    private void menuModificar(){
        System.out.println("Boton de abrir menu de modificar presionado");
        Main.loadPage("modificarMenu.fxml");
    }
}
