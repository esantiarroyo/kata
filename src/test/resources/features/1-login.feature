@Login
Feature: CP01 - Validar inicio de sesion

  Background: Validar el inicio de sesion con credenciales validas, invalidas y sin credenciales colocadas

    Given el usuario navega al sitio web

    @InvalidCredentials
    Scenario:  1 - Validar con credenciales incorrectas
      When ingrese credenciales invalidas
      Then la aplicacion deberia mostrar un mensaje de "Invalid credentials"

    @RequiredUsername
    Scenario: 2 - Validacion de mensaje Required en username
      When deja el campo "username" vacio
      Then la aplicacion deberia mostrar un mensaje de "Required" en username

    @RequiredUsernameAndPassword
    Scenario: 3 - Validacion de mensajes Required en username y password
      When deja los campos "username" y "password" vacios
      Then debería ver el mensaje de "Required" en el campo de username
      And debería ver el mensaje de "Required" en el campo de password

    @ValidCredentials
    Scenario: 4 - Validar con credenciales correctas
      When ingresa credenciales validas
      Then la aplicacion deberia mostrar el dashboard