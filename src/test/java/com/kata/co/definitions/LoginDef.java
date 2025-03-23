package com.kata.co.definitions;

import com.kata.co.ExcelReader;
import com.kata.co.steps.login.LoginStep;
import com.kata.co.steps.validations.ValidationStep;
import com.kata.co.utilities.website.WebSite;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginDef {
    // Se usa la anotación @Steps para compartir instancias de clases de Serenity en el mismo test.
    // Esto permite que los objetos se mantengan a lo largo del flujo de ejecución y evita la duplicación de instancias.

    @Steps(shared = true) // Representa la instancia del sitio web, donde se manejan las interacciones con la URL base.
    WebSite url;

    @Steps(shared = true)  // Representa los pasos relacionados con el proceso de inicio de sesión (Login).
    LoginStep login;

    @Steps(shared = true)  // Representa los pasos de validación dentro de las pruebas.
    ValidationStep validate;

    // Dado que el usuario navega al sitio web
    @Given("el usuario navega al sitio web")
    public void userNavigateTo(){
        // Se accede a la URL de la aplicación
        url.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // Cuando el usuario ingresa credenciales inválidas
    @When("ingrese credenciales invalidas")
    public void userLoginWithInvalidCredentials() {
        // Leer usuario y contraseña desde Excel
        String username = ExcelReader.getData(1, 0); // Fila 1, Columna 0
        String password = ExcelReader.getData(1, 1); // Fila 1, Columna 1

        // Ingresar las credenciales en el formulario
        login.typeUsername(username);
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
        login.typePassword(password);
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
        login.clickLogin();
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
    }

    // Entonces, la aplicación debería mostrar un mensaje de error "Invalid credentials"
    @Then("la aplicacion deberia mostrar un mensaje de \"Invalid credentials\"")
    public void systemErrorMessage(){
        // Se valida que el mensaje de error es mostrado en pantalla
        Assert.assertTrue(validate.errorMessageIsDisplayed());
    }

    // Cuando el usuario deja el campo "username" vacío
    @When("deja el campo \"username\" vacio")
    public void userNotGetIntoUsername(){
        // Se deja vacío el campo de usuario
        login.typeUsername("");
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
        // Se ingresa una contraseña válida
        login.typePassword("admin123");
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
        // Se intenta iniciar sesión
        login.clickLogin();
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
    }

    // Entonces, la aplicación debería mostrar un mensaje de "Required" en el campo de username
    @Then("la aplicacion deberia mostrar un mensaje de \"Required\" en username")
    public void usernameRequiredMessage() {
        // Se valida que el mensaje "Required" aparece en el campo username
        Assert.assertEquals("Required", validate.getRequiredMessageText());
    }

    // Cuando el usuario deja los campos "username" y "password" vacíos
    @When("deja los campos \"username\" y \"password\" vacios")
    public void userNotGetIntoCredentials(){
        // Se deja vacío el campo de usuario
        login.typeUsername("");
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
        // Se deja vacío el campo de contraseña
        login.typePassword("");
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
        // Se intenta iniciar sesión
        login.clickLogin();
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
    }

    // Entonces, debería ver el mensaje de "Required" en el campo de username
    @Then("debería ver el mensaje de \"Required\" en el campo de username")
    public void usernameRequiredMessages() {
        // Se valida que el mensaje "Required" aparece en el campo username
        Assert.assertEquals("Required", validate.getRequiredMessageText());
    }

    // Entonces, debería ver el mensaje de "Required" en el campo de password
    @Then("debería ver el mensaje de \"Required\" en el campo de password")
    public void passwordRequiredMessage(){
        // Se valida que el mensaje "Required" aparece en el campo password
        Assert.assertTrue(validate.requiredPasswordMessageIsDisplayed());
    }

    // Cuando el usuario ingresa credenciales válidas
    @When("ingresa credenciales validas")
    public void userLoginWithValidCredentials(){
        // Se ingresa un usuario correcto
        login.typeUsername("Admin");
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
        // Se ingresa una contraseña correcta
        login.typePassword("admin123");
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
        // Se intenta iniciar sesión
        login.clickLogin();
        login.waitFor(2).seconds(); // Tiempo de espera para lograr ver las credenciales ingresadas
    }

    // Entonces, la aplicación debería mostrar el dashboard
    @Then("la aplicacion deberia mostrar el dashboard")
    public void systemShowDashboardModule() {
        // Se valida que el título del dashboard es "Dashboard"
        Assert.assertEquals("Dashboard", validate.getDashboardTitleText());
    }

}
