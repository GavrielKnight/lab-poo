package submenus;

import javafx.fxml.FXML;

public class MainLayout {
    @FXML private void clientesBotonPresionado(){ if (Main.indiceUsuario >= 0) Main.loadPage("menuClientes.fxml"); }
    @FXML private void membresiasBotonPresionado(){ if (Main.indiceUsuario >= 0) Main.loadPage("menuMembresias.fxml"); }
    @FXML private void inventarioBotonPresionado(){ if (Main.indiceUsuario >= 0) Main.loadPage("menuInventario.fxml"); }
    @FXML private void calendarioBotonPresionado(){ if (Main.indiceUsuario >= 0) Main.loadPage("menuCalendario.fxml"); }
    @FXML private void usuarioBotonPresionado(){ if (Main.indiceUsuario >= 0) Main.loadPage("menuUsuario.fxml"); }
}
