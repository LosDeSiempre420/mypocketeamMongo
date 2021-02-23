package com.losdesiempre.mypocketeam;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.losdesiempre.mypocketeam.controller.TeamController;
import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.repository.TeamRepository;
import com.losdesiempre.mypocketeam.service.TeamService;
import com.losdesiempre.mypocketeam.service.TeamServiceImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.losdesiempre.mypocketeam.domain.Team;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
public class StepDefinition {

    //private final TeamController controlador =  new TeamController();
    private List<PokemonBase> pokemon= new ArrayList<>();
    private Team team;
    private Team check;
    private boolean b;
    private MockHttpServletResponse response;

    private MockMvc mockMvc;
    private JacksonTester<Team> jsonTeam;

    @Mock
    TeamService teamService;

    @InjectMocks
    TeamController teamController;

    @BeforeEach
    void setup(){
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
    }


    @Given("un equipo con nombre {string}")
    public void un_equipo_con_nombre(String name) {
        team= new Team(1,name,pokemon);
    }

    @When("busco un equipo por el nombre de {string}")
    public void busco_un_equipo_por_el_nombre_de(String name) throws Exception{
        given(teamService.findByName(name)).willReturn(team);
        response = mockMvc.perform(get("/api/pocketo/teams/Equipo 1")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        //b= controlador.addTeam(name);
    }

    @Then("me retorna el equipo con el nombre {string}")
    public void me_retorna_el_equipo_con_el_nombre(String name) throws Exception{
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonTeam.write(team).getJson());
    }


}
