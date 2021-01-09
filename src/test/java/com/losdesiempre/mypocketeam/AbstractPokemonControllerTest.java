package com.losdesiempre.mypocketeam;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losdesiempre.mypocketeam.controller.PokemonController;
import com.losdesiempre.mypocketeam.domain.Ability;
import com.losdesiempre.mypocketeam.domain.Pokemon;
import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.domain.PokemonType;
import com.losdesiempre.mypocketeam.domain.Stat;
import com.losdesiempre.mypocketeam.service.PokemonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AbstractPokemonControllerTest {
    
    private MockMvc mockMvc;

    @Mock
    private PokemonService pokemonService;

    private JacksonTester<Pokemon> jsonPokemon;

    @InjectMocks
    PokemonController pokemonController;

    @BeforeEach
    void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(pokemonController).build();
    }
    

    @Test
    void siSeCreaUnPokemonConUnPokemonBaseCorrectoDeberiaRetornarElPokemonCreado() throws Exception {
        //Given
        Pokemon pokemonCreado = new Pokemon();
        PokemonBase pokemonBase = new PokemonBase();
        List<PokemonType> types = new ArrayList<>();
        List<Ability> abilities = new ArrayList<>();

        pokemonBase.setId(1);
        pokemonBase.setName("Bulbasaur");
        types.add(new PokemonType(1, "Grass"));
        types.add(new PokemonType(2, "Poison"));
        pokemonBase.setTypes(types);
        abilities.add(new Ability(1, "Overgrow", false));
        abilities.add(new Ability(3, "Chlorophyll", true));
        pokemonBase.setAbility(abilities);
        pokemonBase.setHeight(0.7);
        pokemonBase.setWeight(6.9);
        pokemonBase.setStats(new Stat(45, 49, 49, 65, 65, 45, 318));

        pokemonCreado = new Pokemon();
        pokemonCreado.setId(1);
        pokemonCreado.setName(pokemonBase.name);
        pokemonCreado.setLevel("45");
        pokemonCreado.setAbility(pokemonBase.abilities.get(1));
        pokemonCreado.setMoves();
        pokemonCreado.setIVs(new Stat(31, 31, 31, 31, 31, 31, 186));
        pokemonCreado.setEVs(new Stat(252, 0, 0, 128, 128, 0, 508));

        given(pokemonService.crearPokemon(pokemonBase.getName())).willReturn(pokemonCreado);

        //When
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/pocketo/pokemonCreado/post")
            .accept(MediaType.APPLICATION_JSON).content(pokemonBase.getName()).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        //Then
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals(jsonPokemon.write(pokemonCreado).getJson(), response.getContentAsString());

    }

    @Test
    void siSeCreaUnPokemonConUnPokemonBaseNoValidoDeberiaArrojarError404() throws Exception {
        //Given
        Pokemon pokemonCreado = new Pokemon();
        PokemonBase pokemonBase = new PokemonBase();
        List<PokemonType> types = new ArrayList<>();
        List<Ability> abilities = new ArrayList<>();

        pokemonBase.setId(1);
        pokemonBase.setName("aaaaaaaaa");
        types.add(new PokemonType(1, "Grass"));
        types.add(new PokemonType(2, "Poison"));
        pokemonBase.setTypes(types);
        abilities.add(new Ability(1, "Overgrow", false));
        abilities.add(new Ability(3, "Chlorophyll", true));
        pokemonBase.setAbility(abilities);
        pokemonBase.setHeight(0.7);
        pokemonBase.setWeight(6.9);
        pokemonBase.setStats(new Stat(45, 49, 49, 65, 65, 45, 318));

        pokemonCreado = new Pokemon();
        pokemonCreado.setId(1);
        pokemonCreado.setName(pokemonBase.name);
        pokemonCreado.setLevel("45");
        pokemonCreado.setAbility(pokemonBase.abilities.get(1));
        pokemonCreado.setMoves();
        pokemonCreado.setIVs(new Stat(31, 31, 31, 31, 31, 31, 186));
        pokemonCreado.setEVs(new Stat(252, 0, 0, 128, 128, 0, 508));

        given(pokemonService.crearPokemon(pokemonBase.getName())).willReturn(null);

        //When
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/pocketo/pokemonCreado/post")
            .accept(MediaType.APPLICATION_JSON).content(pokemonBase.getName()).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        //Then
        assertEquals("", response.getContentAsString());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }
}
