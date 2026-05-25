# Bitácora IA — Proyecto ActiveLife (Sistema de Punto de Venta para Gimnasio)

## Información General

- Proyecto: ActiveLife
- Tipo: Sistema de Punto de Venta para Gimnasio
- Tecnologías: Java, JavaFX, FXML, CSS
- IDE: NetBeans (Ant)
- Arquitectura: MVC (Modelo-Vista-Controlador)

---

# 1. Llenado/actualización automática de la tabla de clientes

## Prompt enviado a la IA

> "Quiero hacer que la tabla se llene con los datos de todas las membresías
de un cliente especificado con el campo Matrícula del Cliente,
y que se actualice automáticamente cuando una matrícula diferente es escrita en el campo"

## Resumen de la respuesta de la IA

1) Se necesita implementar un Listener para que ejecute una acción
cuando ocurra cualquier cambio en la en la propiedad de texto del TextField.
2) Para que una tabla contenga datos de un objeto, primero hay que usar PropertyValueFactory
para relacionar las columnas de la tabla con las propiedades del objeto.
3) Definicion funciones getters para el objeto, por medio de los cuales PropertyValueFactory
obtiene acceso a sus atributos.

## Qué partes del código se adaptaron o corrigieron

En MenuClientes.java, se agregó lo siguiente:
- Configuración de las columnas de la tabla
- Listener al campo de texto
- Función actualizarTabla()

## Qué se aprendió
- Las columnas de una tabla se configuran con PropertyValueFactory.
- Para que PropertyValueFactory obtenga acceso a los atributos de una clase,
define sus funciones getters con nombre 'getAtributo'.
- Los Listeners sirven para que el sistema ejecute automáticamente acciones cuando ocurre cambios.
- Es buena idea crear funciones para los Listeners por modularidad.

---

# 2. Integración del CSS stylesheet

## Prompt enviado a la IA

"Este es el codigo Main del proyecto, ¿cómo puedo agregar la línea de código
el cual agrega el stylesheet?"

## Resumen de la respuesta de la IA

La IA sugiere modificar el método start() de la clase Main.java,
agregando una línea para agregar el stylesheet.

## Qué partes del código se adaptaron o corrigieron

Se agregó:
- Una línea en Main.java que agrega el stylesheet.

## Qué se aprendió

- Usa la funcion scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
para agregar estilo a la escena.
- Para que getClass().getResource("style.css") encuentre el archivo, este debe estar
en la misma carpeta que la clase Main.java.
- Aplicando estilo al Scene en el Main, todos los submenús que se carguen después mediante
mainLayout.setCenter() heredarán automáticamente ese estilo.

---

# 3. Integración de PropertyValueFactory

## Prompt enviado a la IA

> “En el output de Netbeans me dice que no puede obtener las propiedades 'finMembresia' y 'estadoMembresia' en PropertyValueFactory.”

## Resumen de la respuesta de la IA

La IA explicó que PropertyValueFactory necesita métodos getter públicos compatibles con el nombre de las columnas.

## Qué partes del código se adaptaron o corrigieron

Se agregaron métodos:
- getFinMembresia()
- getEstadoMembresia()

en Cliente.java.

## Qué se aprendió

- Cómo funciona PropertyValueFactory
- Cómo JavaFX llena tablas automáticamente usando getters

---

# 4. Creación del Calendario de Clases

## Prompt enviado

> “¿Puedes crear un archivo fxml simple para un calendario estático de clases grupales?”

## Respuesta

La IA generó un layout FXML usando GridPane, VBox y Labels para organizar actividades semanales.

## Adaptaciones realizadas

Se modificaron tamaños, espaciados y estilos para integrarlo al diseño del proyecto.

## Aprendizajes

- Uso de GridPane
- Organización visual en JavaFX
- Separación entre estructura y estilos

---

# 5. Generación del Archivo JAR

## Prompt enviado

> “¿Cómo puedo generar un archivo jar con todas sus dependencias?”

## Respuesta

La IA explicó:
- carpeta dist
- JavaFX SDK
- archivos .bat
- jpackage

## Adaptaciones realizadas

Se creó ejecutar.bat para ejecutar el programa con JavaFX.

## Aprendizajes

- Distribución de aplicaciones JavaFX
- Uso de --module-path

---

# 6. Persistencia de Inventario

## Prompt enviado

> “Mi aplicación no guarda los equipos cuando salgo y vuelvo a la aplicación.”

## Respuesta

La IA detectó que faltaban funciones de serialización para equipos.

## Código agregado

- guardaEquipos()
- leeEquipos()

y Serializable en Equipo.java.

## Aprendizajes

- Persistencia mediante serialización
- Uso de archivos .ser

---

# 7. Generación de Tablas de Datos

## Prompt enviado

> “¿Puedes crear una tabla con 25 registros para clientes e inventario?”

## Respuesta

La IA generó datos de prueba para clientes e inventario.

## Adaptaciones realizadas

Se reutilizaron registros para pruebas del sistema.

## Aprendizajes

- Uso de datos de prueba
- Importancia del testing visual
