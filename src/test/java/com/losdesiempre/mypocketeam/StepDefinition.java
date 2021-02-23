package com.losdesiempre.mypocketeam;
import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.repository.MovementRepository;
import com.losdesiempre.mypocketeam.repository.TeamRepository;
import com.losdesiempre.mypocketeam.service.TeamServiceImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.losdesiempre.mypocketeam.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StepDefinition {

    //@Autowired
    TeamServiceImplementation teamServiceImplementation;

    //@MockBean
    TeamRepository teamRepository;


    List<PokemonBase> pokemon= new ArrayList<>();
    Team team=new Team(1,"Equipo 1",pokemon);
    Team check=new Team(0,"",pokemon);


    @Given("un equipo con nombre {string}")
    public void un_equipo_con_nombre(String name) {
        List<PokemonBase> pokemon= new ArrayList<>();
        team.setName(name);
    }

    @When("busco un equipo por el nombre de {string}")
    public void busco_un_equipo_por_el_nombre_de(String name) {
        when(this.teamRepository.findByName(name)).thenReturn(team);
        check = teamServiceImplementation.findByName(name);
    }

    @Then("me retorna el equipo con el nombre {string}")
    public void me_retorna_el_equipo_con_el_nombre(String name) {
        assertNotNull(check);
    }


}
