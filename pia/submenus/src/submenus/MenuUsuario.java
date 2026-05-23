package submenus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuUsuario {
    @FXML Label labelNombre;
    @FXML Label labelId;
    
    @FXML private void initialize(){
        // Muestra el nombre y matrícula del usuario actual
        labelNombre.setText("Nombre: " + Main.usuarios.get(Main.indiceUsuario).getNombre());
        labelId.setText("Matrícula: " + Main.usuarios.get(Main.indiceUsuario).getId());
    }
    
    @FXML private void logoutPresionado(){
        // Indica que el usuario salió de su cuenta
        Main.indiceUsuario = -1;
        
        // Vuelve al menu de login
        Main.loadPage("menuLogin.fxml");
    }
}
