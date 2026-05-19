package submenus;

import javafx.fxml.FXML;

public class MainLayout {
    
    @FXML private void menuRegistrar(){ if (Main.usuarioIngresado) Main.loadPage("registrarCliente.fxml"); }
    
    @FXML private void menuEliminar(){ if (Main.usuarioIngresado) Main.loadPage("eliminarMenu.fxml"); }
    
    @FXML private void menuModificar(){ if (Main.usuarioIngresado) Main.loadPage("modificarCliente.fxml"); }
    
    @FXML private void menuCrearMembresia(){ if (Main.usuarioIngresado) Main.loadPage("crearMembresiaMenu.fxml"); }
    
    @FXML private void menuRenovarMembresia() { if (Main.usuarioIngresado) Main.loadPage("renovarMembresia.fxml"); }
}
