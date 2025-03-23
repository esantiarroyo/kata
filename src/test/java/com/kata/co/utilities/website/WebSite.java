package com.kata.co.utilities.website;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

// Clase que maneja la navegación a la página web.
// Permite abrir la aplicación en la URL especificada.
public class WebSite {

    // Instancia de PageObject utilizada para gestionar la navegación dentro de Serenity BDD.
    @Steps(shared = true)
    PageObject kata;

    // Método que configura la URL base y abre el navegador en la dirección especificada.
    @Step("Navegar al sitio web")
    public void navigateTo(String url){
        // Establece la URL base del sitio en la instancia de PageObject.
        kata.setDefaultBaseUrl(url);
        // Abre el navegador y carga la URL establecida.
        kata.open();
    }
}
