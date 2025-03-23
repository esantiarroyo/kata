package com.kata.co.steps.validations;

import com.kata.co.pages.login.validations.ValidationPage;
import net.thucydides.core.annotations.Step;

// Clase que define los pasos de validación en la aplicación.
// Hereda de ValidationPage, lo que permite reutilizar los elementos WebElementFacade definidos en la página.
public class ValidationStep extends ValidationPage {

    // Verifica si el mensaje de error por credenciales inválidas es visible en la pantalla.
    @Step("Validar visualizacion del mensaje error")
    public Boolean errorMessageIsDisplayed(){
        return lbl_error.isDisplayed();
    }

    // Obtiene el texto del mensaje "Required" asociado al campo de Username cuando está vacío.
    @Step("Validar visualizacion del mensaje Required en username")
    public String getRequiredMessageText(){
        return lbl_required.getText();
    }

    // Verifica si el mensaje "Required" en el campo de Password es visible en la pantalla.
    @Step("Validar visualizacion del mensaje Required en password")
    public Boolean requiredPasswordMessageIsDisplayed(){
        return lbl_requiredPassword.isDisplayed();
    }

    // Obtiene el texto del título del módulo Dashboard para validar que se ha ingresado correctamente.
    @Step("Validar visualizacion del modulo Dashboard")
    public String getDashboardTitleText() {
        // Verifica si el elemento lbl_dashboard no es nulo y está visible en la pantalla
        return (lbl_dashboard != null && lbl_dashboard.isDisplayed())
                ? lbl_dashboard.getText()
                // Si el elemento no está presente o no es visible, retorna una cadena vacía para evitar errores
                : "";
    }

}
