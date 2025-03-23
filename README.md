# Kata
Prueba tecnica desarrollada en Intellij IDEA con el patron de diseño "POM",
junto con las herramientas Selenium, Serenity BDD, Junit, Cucumber y Gherkin
en lenguaje Java. Para utilizar esas herramientas se agregaron los plugins y
dependencies necesarias en el archivo "pom.xml", al momento de colocarlas 
todas se sincronizo con el proyecto para poderlas implementar en el momento
que fuera requerido.


# Proceso de Automatizacion

1) Dentro del proyecto "kata" se creo un nuevo archivo con el nombre
"serenity.properties" donde se programo lo siguiente:
    - Nombrar el proyecto en los reportes de Serenity.
    - Buscar la raíz de los paquetes donde Serenity buscara las pruebas.
    - Configurar el WebDriver para usar Microsoft Edge como navegador predeterminado.
    - Permitir que Serenity descargue automaticamente el controlador (driver) adecuado
   para el navegador.
    - Maximizar la ventana del navegador al iniciar las pruebas.
    - Permitir reutilizar el mismo navegador en multiples escenarios.
    - Reiniciar el navegador en cada escenario para garantizar independencia entre pruebas.

2) Dentro de la carpeta "src/test" se creo un nuevo directorio con el
nombre "resources", dentro de este directorio se creo un nuevo directorio
con el nombre "feature", dentro de este directorio se creo un nuevo
archivo con el nombre "1 - login.feature" en el cual se escribieron los
casos de prueba en lenguaje Gherkin donde presentan lo siguiente:
    - Feature: Define el caso de prueba para validar el inicio de sesión en la aplicación.
    - Background: Define antecedentes comunes para todos los escenarios.
    - Given: Define que el usuario navega al sitio web antes de cada escenario.
    - Scenario: Enumera y define los escenarios, en el caso de este proyecto presenta
   cuatro escenarios por lo tanto pueden variar.
    - When: Define la accion que realiza el usuario al momento de ingresar
   las credenciales, pueden ser credenciales invalidas, no ingresar credenciales
   o colocar las credenciales validas, dependiendo del escenario.
    - Then: Define que deberia suceder dependiendo de la accion del usuario
   definida en el When que se presente anteriormente.

3) Dentro de la carpeta "src/test/java" se creo un nuevo paquete como el sigueinte,
"com.kata.co.pages.login", despues se creo una clase java con el nombre "LoginPage"
y en el se programo lo siguiente:
    - Clase que representa al pagina de inicio de sesion en la aplicacion, donde hereda
   de "PageObject", lo que permite utilizar las funciones de Serenity para interactuar
   con la UI.
    - Dentro de la clase permite localizar el campo de entrada para el nombre del usuario
   y la contraseña mediante su atributo "name".
    - Tambien dentro de esta clase permite localizar el boton de inicio de sesion mediante
   su clase Css.

4) Dentro de la carpeta "src/test/java" y los paquetes "com.kata.co" se creo un nuevo
paquete con el nombre "steps.login" y dentro del paquete se creo una clase java con el
nombre "LoginStep" en la cual se programo lo siguiente:
    - Clase que define los pasos de interacion en la pagina de inicio de sesion, donde
   hereda de LoginPage, lo que permite reutilizar los elementos WebElementFacade definidos
   en la pagina.
    - Dentro de la clase permite ingresar el nombre del usuario y la contraseña en el 
   campo correspondiente.
    - Tambien dentro de esta clase permite hacer clic en el boton de inicio de sesion.

5) Dentro de la carpeta "src/test/java" y los paquetes "com.kata.co" se creo un nuevo
   paquete con el nombre "utilities.website" y dentro del paquete se creo una clase java
con el nombre "WebSite" donde se programo lo siguiente:
    - Clase que maneja la navegacion a la pagina web que permite abrir la aplicacion en la
   URL especifica.
    - Dentro de esta clase permite la instancia de "PageObject" utilizada para gestionar la
   navegacion dentro de Serenity BDD.
    - Tambien dentro de esta clase define el metodo que configura la URL base y abre el navegador
   en la direccion especificada.
   
6) Dentro de la carpeta "src/test/java" y los paquetes "com.kata.co.pages.login" se creo un
nuevo paquete con el nombre "validations" y dentro de este paquete se creo una nueva clase
java con el nombre "ValidationPage" en la cual se programo lo siguiente:
    - Clase que representa la pagina de validacion en la aplicacion, donde hereda de "PageObject"
   lo que permite usar WebDriver y funciones de Serenity.
    - Dentro de esta clase permite localizar los mensajes de error y el titulo del dashboard que 
   deberian presentarse en los diferentes escenarios.
   
7) Dentro de la carpeta "src/test/java" y los paquetes "com.kata.co.steps" se creo un
   nuevo paquete con el nombre "validations" y dentro de este paquete se creo una nueva clase
   java con el nombre "ValidationStep" en la cual se programo lo siguiente:
    - Clase que define los pasos de validacion en la aplicacion, donde hereda de "ValidationPage",
   lo que permite reutilizar los elementos WebElemetFacade definidos en la pagina.
    - Dentro de esta clase permite verificar si los mensajes de error en los diferentes escenarios
   son visibles en la pantalla.
    - Tambien dentro de esta clase permite obtener el texto del titulo del modulo Dashboard para
   validar que se ha ingresado correctamente.
   
8) Dentro de la carpeta "src/test/java" y los paquetes "com.kata.co." se creo un nuevo paquete con
el nombre "definitios" y dentro de este paquete se creo una nueva clase java con el nombre "LoginDef"
en la cual se programo lo siguiente:
    - Se usa la anotación @Steps para compartir instancias de clases de Serenity en el mismo test.
      Esto permite que los objetos se mantengan a lo largo del flujo de ejecución y evita la duplicación de instancias.
    - Se llama la instancia del sitio web, donde se manejan las interacciones con la URL base.
    - Se llaman los pasos relacionados con el proceso de inicio de sesión (Login).
    - Se llaman los pasos de validación dentro de las pruebas.
    - Se programa el Given para que el usuario abra el navegador.
    - Se programan los When para asignarle las credenciales que se utilizaran en cada uno de los escenarios.
    - Se programan los Then donde se valida que se muestren los respectivos mensajes.

9) Dentro de la carpeta "src/test/java" y los paquetes "com.kata.co." se creo una nueva clase java con el
nombre "ExcelReader" en el cual se programo lo siguiente:
    - Ruta para buscar un archivo excel que contiene los datos de prueba.
    - Metodo para obtener un dato especifico de una celda en el archivo excel.
   
10) Se modifico la clase java "LoginDef" para que en el primer escenario donde se ingresan credenciales invalidas
en lugar de colocarlas manual en el codigo se extraigan de un archivo en excel ubicado dentro de la carpeta
"src/test/resources/data/credentials.xlsx"

11) Dentro de la carpeta "src/test/java" y los paquetes "com.kata.co." se creo una nueva clase java con el
    nombre "Runner" en la cual se programo lo siguiente:
    - Clase encargada de ejecutar las pruebas de Cucumber con Serenity BDD y ademas se configura con las
    opciones necesarias para encontrar las caracteristicas y los step definitions.
    - Se configura donde se encuentran los archivos .feature de Gherkin.
    - Se configura donde se encuentran las definiciones de los pasos (step definitions).
    - Se filtra la ejecución para que solo corran los escenarios con esta etiquetan.

12) Como ultimo paso se pone a correr el proyecto para garantizar que se realizan los casos de prueba correctamente.

# Visualización de Resultados

Puede visualizarse al momento de correr el programa ya que se abren las ventanas y se ingresan las credenciales paso
a paso permitiendo corroborar de manera visual que se ejecuta correctamente, sin embargo hay otras dos maneras:
1) Dentro de la terminal se pueden presenciar las acciones que va realizando la automatizacion y al finalizar
cuales se realizaron de manera correcta.
2) Dentro de la interfaz de intelliJ en la parte derecha hay un icono con la letra "m" donde al momento de seleccionar
abre una pequeña ventana que permite diversas acciones, sin embargo al precionar el boton "Execute Maven Goals" abre una
pequeña pestaña que permite escribir algunas consultas maven, pero para que nos muestre una interfaz grafica de los resultados
de la automatizacion debemos escribir el siguiente comando "serenity:aggregate", esto nos mostrara in vinculo al cual podremos
acceder a un index donde nos mostrara los resultados de manera grafica y mucha infomacion mas.
