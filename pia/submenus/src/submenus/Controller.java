package submenus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {
    
    private static List<Cliente> clientes = new ArrayList<>();
   
    private static BorderPane mainLayout;
    private static Stage stage;
    
    public static void setMainLayout(BorderPane layout){
        mainLayout = layout;
    }
    public static void setStage(Stage stg){
        stage = stg;
    }
    public static void setCenterContent(String fxmlFile){
        try {
            // Carga el nuevo archivo FXML
            Parent node = FXMLLoader.load(Controller.class.getResource(fxmlFile));
            
            // Coloca el contenido en el centro del layout principal
            mainLayout.setCenter(node);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
      
    public void guardaClientes(){
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
    
    public void leeClientes(){
        
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
    
    public int idExiste(int id){
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).obtenId() == id){
                return i;
            }
        }
        return -1;
    }
    
    public int validaCampoNumerico(TextField campo, Label label, String errorMsg){
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
    
    @FXML
    private TableView tablaClientes;
    @FXML
    private TableColumn tablaClientes_colNombre;
    @FXML
    private TableColumn tablaClientes_colMatricula;
    @FXML
    private TextField menuRegistrar_nombreCampo;
    @FXML
    private TextField menuRegistrar_idCampo;
    @FXML
    private Label menuRegistrar_label;
    @FXML
    private TextField menuEliminar_idCampo;
    @FXML
    private Label menuEliminar_label;
    @FXML
    private Label menuModificar_label;
    @FXML
    private TextField menuModificar_idCampo;
    @FXML
    private TextField menuModificar_nombreCampo;
    
    @FXML
    private void menuRegistrar(){
        System.out.println("Boton de abrir menu de registrar presionado");
        setCenterContent("registrarMenu.fxml");
    }
    @FXML
    private void menuEliminar(){
        System.out.println("Boton de abrir menu de eliminar presionado");
        setCenterContent("eliminarMenu.fxml");
    }
    @FXML
    private void menuModificar(){
        System.out.println("Boton de abrir menu de modificar presionado");
        setCenterContent("modificarMenu.fxml");
    }
    
    @FXML
    private void botonIngresarPresionado(){
        System.out.println("Boton de ingresar presionado");
        
        // Obten los clientes guardados en el archivo serial (si existe)
        leeClientes();
        
        // Carga el menu de registro
        setCenterContent("registrarMenu.fxml");
    }
    
    @FXML 
    private void botonRegistrarPresionado(){
        System.out.println("Boton de registrar presionado");
        
        // Obten y verifica que el id ingresado sea un numero
        int id = validaCampoNumerico(menuRegistrar_idCampo, menuRegistrar_label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Verifica que el id ingresado no exista
        if (idExiste(id) != -1){
            menuRegistrar_label.setText("Ya existe cliente con esa matricula");
            return;
        }
        
        // Obten y valida el nombre escrito en el campo
        String nombre = menuRegistrar_nombreCampo.getText().trim();
        if (nombre == ""){
            menuRegistrar_label.setText("El campo del nombre no debe estar vacio");
            return;
        }

        // Adjunta nuevo cliente a la lista
        clientes.add(new Cliente(id, nombre));
        
        // Guarda los datos de los clientes en el archivo serial
        guardaClientes();
        
        // Notificar al usuario que el cliente se ha registrado
        System.out.println("Se ha registrado un cliente");
        for (Cliente c : clientes) c.imprime();
        menuRegistrar_label.setText("Se ha registrado un cliente");
    }
    
    @FXML
    private void botonEliminarPresionado(){
        // Obten y verifica que el id ingresado sea un numero
        int id = validaCampoNumerico(menuEliminar_idCampo, menuEliminar_label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Muestra un mensaje si el cliente que se quiere eliminar no existe
        int indiceEliminar = idExiste(id);
        if (indiceEliminar == -1){
            menuEliminar_label.setText("No existe cliente con esa matricula");
            return;
        }
        
        // Elimina el cliente de la lista
        clientes.remove(indiceEliminar);
        menuEliminar_label.setText("Se ha eliminado el cliente con matricula " + id);
    }
    
    @FXML
    private void botonActualizarPresionado(){

        // Relaciona las columnas de la tabla con los atributos del cliente
        tablaClientes_colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaClientes_colMatricula.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        // Adjunta los datos de los clientes en la tabla
        ObservableList<Cliente> datos = FXCollections.observableArrayList(clientes);
        tablaClientes.setItems(datos);
    }
    
    @FXML
    private void botonModificarPresionado(){
        // Obten y verifica que el id ingresado sea un numero
        int id = validaCampoNumerico(menuModificar_idCampo, menuModificar_label, "La matricula debe ser un numero");
        if (id == -1) return;
        
        // Muestra un mensaje si el cliente que se quiere eliminar no existe
        int indice = idExiste(id);
        if (indice == -1){
            menuModificar_label.setText("No existe cliente con esa matricula");
            return;
        }
        
        // Obten y valida el nombre escrito en el campo
        String nuevoNombre = menuModificar_nombreCampo.getText().trim();
        if (nuevoNombre == ""){
            menuModificar_label.setText("El campo del nombre no debe estar vacio");
            return;
        }
        
        // Modifica los datos del cliente
        clientes.set(indice, new Cliente(id, nuevoNombre));
        menuModificar_label.setText("Se ha modificado el cliente con matricula " + id);
    }
}
