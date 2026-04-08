package submenus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    // Atributos
    public static List<Cliente> clientes = new ArrayList<>();
    
    private static BorderPane mainLayout;
    
    // Funciones de arranque
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        // Carga la vista principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainLayout.fxml"));
        mainLayout = loader.load();
        
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setTitle("GymPOS");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Carga la pagina
        loadPage("ingresarMenu.fxml");
    }
        
    // Metodos
    public static void loadPage(String fxmlFile){
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlFile));
            mainLayout.setCenter(loader.load());
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void guardaClientes(){
        try {
            // Obten acceso al archivo donde se guardan los clientes
            FileOutputStream fileOut = new FileOutputStream("clientes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Escribe los datos de los clientes en el archivo serial
            out.writeObject(clientes);

            // Cierra archivo
            out.close();
            fileOut.close();
            
        } catch(IOException e){
            System.out.println("Ha ocurrido un error. No se pudo guardar los clientes");
        }
    }
    
    public static void leeClientes(){
        
        // Verifica que el archivo serial exista
        File file = new File("clientes.ser");
        if (!file.exists()){
            System.out.println("El archivo no existe");
            return;
        }
        
        try {
            // Accede al archivo serial
            FileInputStream fileIn = new FileInputStream("clientes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            // Guarda clientes escritos en el archivo en la lista
            clientes = (List<Cliente>) in.readObject();
            
            // Cierra archivo
            in.close();
            fileIn.close();
            
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Ha ocurrido un error. No se pudo leer los clientes");  
        }
    }
    
    public static int idExiste(int id){
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    
    public static int validaCampoNumerico(TextField campo, Label label, String errorMsg){
        // Obten y verifica que el valor escrito en el campo sea un numero
        int val;
        try{
            val = Integer.parseInt(campo.getText().trim());
        } catch (NumberFormatException e){
            label.setText(errorMsg);
            return -1; // Indica que el campo tiene un valor no numerico
        }
        return val;
    }
}
