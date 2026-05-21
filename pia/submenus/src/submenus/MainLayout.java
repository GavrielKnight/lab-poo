package submenus;

import javafx.fxml.FXML;

public class MainLayout {
    
    @FXML private void menuRegistrar(){ if (Main.indiceUsuario >= 0) Main.loadPage("registrarCliente.fxml"); }
    
    @FXML private void menuEliminar(){ if (Main.indiceUsuario >= 0) Main.loadPage("eliminarMenu.fxml"); }
    
    @FXML private void menuModificar(){ if (Main.indiceUsuario >= 0) Main.loadPage("modificarCliente.fxml"); }
    
    @FXML private void menuCrearMembresia(){ if (Main.indiceUsuario >= 0) Main.loadPage("crearMembresiaMenu.fxml"); }
    
    @FXML private void menuRenovarMembresia() { if (Main.indiceUsuario >= 0) Main.loadPage("renovarMembresia.fxml"); }
    
    @FXML private void menuInfoUsuario() { if (Main.indiceUsuario >= 0) Main.loadPage("infoUsuario.fxml"); }
}
