package com.kata.co.pages.login.validations;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

// Clase que representa la página de validación en la aplicación.
// Hereda de PageObject, lo que permite usar WebDriver y funciones de Serenity.
public class ValidationPage extends PageObject {

    // Localiza el mensaje de error que aparece cuando las credenciales son inválidas.
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text' and text()='Invalid credentials']")
    protected WebElementFacade lbl_error;

    // Localiza el mensaje "Required" asociado al campo de Username cuando está vacío.
    @FindBy(xpath = "//div[.//label[text()='Username']]//span[contains(@class, 'oxd-input-field-error-message')]")
    protected WebElementFacade lbl_required;

    // Localiza el mensaje "Required" asociado al campo de Password cuando está vacío.
    @FindBy(xpath = "//div[.//label[text()='Password']]//span[contains(@class, 'oxd-input-field-error-message')]")
    protected WebElementFacade lbl_requiredPassword;

    // Localiza el título del dashboard para verificar que la autenticación fue exitosa.
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    protected WebElementFacade lbl_dashboard;

}
