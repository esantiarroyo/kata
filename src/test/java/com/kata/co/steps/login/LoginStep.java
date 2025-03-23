package com.kata.co.steps.login;

import com.kata.co.pages.login.LoginPage;
import net.thucydides.core.annotations.Step;

// Clase que define los pasos de interacción en la página de inicio de sesión.
// Hereda de LoginPage, lo que permite reutilizar los elementos WebElementFacade definidos en la página.
public class LoginStep extends LoginPage {

    // Ingresa el nombre de usuario en el campo correspondiente.
    @Step("Ingresar usuario")
    public void typeUsername(String username){
        txt_username.sendKeys(username);
    }

    // Ingresa la contraseña en el campo correspondiente.
    @Step("Ingresar contraseña")
    public void typePassword(String password){
        txt_password.sendKeys(password);
    }

    // Hace clic en el botón de inicio de sesión.
    @Step("Click en el boton login")
    public void clickLogin(){
        btn_login.click();
    }

}
