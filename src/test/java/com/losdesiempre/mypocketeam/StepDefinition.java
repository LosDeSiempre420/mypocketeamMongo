package com.losdesiempre.mypocketeam;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

    @Given("un nombre {string}")
    public void un_nombre(String nombre) {
        Team = new Team(nombre, <>);
    }

    @When("solicito crear un equipo con el nombre {string}")
    public void solicito_crear_un_equipo_con_el_nombre(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("se agrega un equipo vacio con el nombre de {string}")
    public void se_agrega_un_equipo_vacio_con_el_nombre_de(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
