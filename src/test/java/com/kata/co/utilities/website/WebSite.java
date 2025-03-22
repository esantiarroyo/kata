package com.kata.co.utilities.website;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class WebSite {

    @Steps(shared = true)
    PageObject kata;

    @Step("Navegar al sitio web")
    public void navigateTo(String url){

        kata.setDefaultBaseUrl(url);
        kata.open();
    }
}
