package com.kata.co.pages.login;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(name = "username")
    protected WebElementFacade txt_username;

    @FindBy(name = "password")
    protected WebElementFacade txt_password;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    protected WebElementFacade btn_login;

}
