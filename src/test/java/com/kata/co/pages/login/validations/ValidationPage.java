package com.kata.co.pages.login.validations;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ValidationPage extends PageObject {

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text' and text()='Invalid credentials']")
    protected WebElementFacade lbl_error;

    @FindBy(xpath = "//div[.//label[text()='Username']]//span[contains(@class, 'oxd-input-field-error-message')]")
    protected WebElementFacade lbl_required;

    @FindBy(xpath = "//div[.//label[text()='Password']]//span[contains(@class, 'oxd-input-field-error-message')]")
    protected WebElementFacade lbl_requiredPassword;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    protected WebElementFacade lbl_dashboard;

}
