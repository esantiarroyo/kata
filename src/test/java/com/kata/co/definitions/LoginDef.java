package com.kata.co.definitions;

import com.kata.co.steps.login.LoginStep;
import com.kata.co.steps.validations.ValidationStep;
import com.kata.co.utilities.website.WebSite;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginDef {

    @Steps(shared = true)
    WebSite url;

    @Steps(shared = true)
    LoginStep login;

    @Steps(shared = true)
    ValidationStep validate;

    @Given("el usuario navega al sitio web")
    public void userNavigateTo(){
        url.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("ingrese credenciales invalidas")
    public void userLoginWithInvalidCredentials(){
        login.typeUsername("develop");
        login.typePassword("123456");
        login.clickLogin();
    }

    @Then("la aplicacion deberia mostrar un mensaje de \"Invalid credentials\"")
    public void systemErrorMessage(){
        Assert.assertTrue(validate.errorMessageIsDisplayed());
    }

    @When("deja el campo \"username\" vacio")
    public void userNotGetIntoUsername(){
        login.typeUsername("");
        login.typePassword("admin123");
        login.clickLogin();
    }

    @Then("la aplicacion deberia mostrar un mensaje de \"Required\" en username")
    public void usernameRequiredMessage(){
        Assert.assertTrue(validate.requiredMessageIsDisplayed());
    }

    @When("deja los campos \"username\" y \"password\" vacios")
    public void userNotGetIntoCredentials(){
        login.typeUsername("");
        login.typePassword("");
        login.clickLogin();
    }

    @Then("debería ver el mensaje de \"Required\" en el campo de username")
    public void usernameRequiredMessages(){
        Assert.assertTrue(validate.requiredMessageIsDisplayed());
    }

    @Then("debería ver el mensaje de \"Required\" en el campo de password")
    public void passwordRequiredMessage(){
        Assert.assertTrue(validate.requiredPasswordMessageIsDisplayed());
    }

    @When("ingresa credenciales validas")
    public void userLoginWithValidCredentials(){
        login.typeUsername("Admin");
        login.typePassword("admin123");
        login.clickLogin();
    }

    @Then("la aplicacion deberia mostrar el dashboard")
    public void systemShowDashboardModule(){
        Assert.assertTrue(validate.titleIsVisible());
    }

}
