@Login #Etiqueta la cual al momento de llamarla en el Runner.java permite correr los 4 scenarios de forma simultanea
#Este es el caso de prueba
Feature: CP01 - Validar inicio de sesion

  Background: Validar el inicio de sesion con credenciales validas, invalidas y sin credenciales colocadas

    Given el usuario navega al sitio web

    @InvalidCredentials #Etiqueta la cual al momento de llamarla en el Runner.java permite correr el primer scenario donde las credenciales son incorrectas
    Scenario:  1 - Validar con credenciales incorrectas
      When ingrese credenciales invalidas
      Then la aplicacion deberia mostrar un mensaje de "Invalid credentials"

    @RequiredUsername #Etiqueta la cual al momento de llamarla en el Runner.java permite correr el segundo scenario donde el username se deja vacio
    Scenario: 2 - Validacion de mensaje Required en username
      When deja el campo "username" vacio
      Then la aplicacion deberia mostrar un mensaje de "Required" en username

    @RequiredUsernameAndPassword #Etiqueta la cual al momento de llamarla en el Runner.java permite correr el tercer scenario donde ambas credenciales se dejan vacias
    Scenario: 3 - Validacion de mensajes Required en username y password
      When deja los campos "username" y "password" vacios
      Then debería ver el mensaje de "Required" en el campo de username
      And debería ver el mensaje de "Required" en el campo de password

    @ValidCredentials #Etiqueta la cual al momento de llamarla en el Runner.java permite correr el cuarto scenario donde las credenciales son validas
    Scenario: 4 - Validar con credenciales correctas
      When ingresa credenciales validas
      Then la aplicacion deberia mostrar el dashboard