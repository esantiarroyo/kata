package com.kata.co;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// Clase encargada de ejecutar las pruebas de Cucumber con Serenity BDD.
// Se configura con las opciones necesarias para encontrar las características y los step definitions.
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features", // Ruta donde se encuentran los archivos .feature de Gherkin.
        glue = "com.kata.co.definitions", // Paquete donde se encuentran las definiciones de los pasos (step definitions).
        tags = "@InvalidCredentials" // Filtra la ejecución para que solo corran los escenarios con esta etiqueta.
)

public class Runner {
}
