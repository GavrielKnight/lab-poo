package submenus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        
        // Carga el layout base
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainLayout.fxml"));
        BorderPane root = loader.load();
        
        // Inicializa las variables estaticas del controlador
        Controller.setMainLayout(root);
        Controller.setStage(stage);
        
        // Carga menu inicial en el centro del BorderPane
        Controller.setCenterContent("ingresoMenu.fxml");
        
        // Muestra la escena con el root
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
