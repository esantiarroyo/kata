package com.kata.co.steps.validations;

import com.kata.co.pages.login.validations.ValidationPage;
import net.thucydides.core.annotations.Step;

public class ValidationStep extends ValidationPage {

    @Step("Validar visualizacion del mensaje error")
    public Boolean errorMessageIsDisplayed(){
        return lbl_error.isDisplayed();
    }

    @Step("Validar visualizacion del mensaje Required en username")
    public Boolean requiredMessageIsDisplayed(){
        return lbl_required.isDisplayed();
    }

    @Step("Validar visualizacion del mensaje Required en password")
    public Boolean requiredPasswordMessageIsDisplayed(){
        return lbl_requiredPassword.isDisplayed();
    }

    @Step("Validar visualizacion del modulo Dashboard")
    public Boolean titleIsVisible(){
        return lbl_dashboard.isDisplayed();
    }

}
