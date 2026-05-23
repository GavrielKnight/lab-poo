package submenus;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class MenuLogin {
    
    @FXML private TextField campoId;
    @FXML private TextField campoContraseña;
    @FXML private Label etiqueta;

    @FXML private void botonIngresarPresionado(){
        // Obten y verifica que el id ingresado sea un numero
        int id = Main.validaCampoNumerico(campoId, etiqueta, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Checa que el id ingresado exista
        Main.indiceUsuario = Main.usuarioExiste(id);
        if (Main.indiceUsuario == -1){
            Main.etiquetaRoja(etiqueta, "No existe usuario con esa matrícula");
            return;
        }
        
        // Obten la contraseña ingresada en el campo
        String contraseña = campoContraseña.getText().trim();
        
        // Checa que la contraseña ingresada no esta vacia y sea correcta
        if (contraseña.isEmpty()){
            Main.etiquetaRoja(etiqueta, "El campo de la contraseña no debe estar vacio");
            return;
        }
        else if (!contraseña.equals(Main.usuarios.get(Main.indiceUsuario).getContraseña())){
            Main.etiquetaRoja(etiqueta, "La contraseña es incorrecta");
            return;
        }
        
        // Obten los clientes guardados en el archivo serial (si existe)
        Main.leeClientes();
        
        // Carga el menu de registro
        Main.loadPage("menuClientes.fxml");
    }
}
