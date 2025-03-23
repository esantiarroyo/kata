package com.kata.co.pages.login;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

// Clase que representa la página de inicio de sesión en la aplicación.
// Hereda de PageObject, lo que permite utilizar las funciones de Serenity para interactuar con la UI.
public class LoginPage extends PageObject {

    // Localiza el campo de entrada para el nombre de usuario mediante su atributo "name".
    @FindBy(name = "username")
    protected WebElementFacade txt_username;

    // Localiza el campo de entrada para la contraseña mediante su atributo "name".
    @FindBy(name = "password")
    protected WebElementFacade txt_password;

    // Localiza el botón de inicio de sesión mediante su clase CSS.
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    protected WebElementFacade btn_login;

}
