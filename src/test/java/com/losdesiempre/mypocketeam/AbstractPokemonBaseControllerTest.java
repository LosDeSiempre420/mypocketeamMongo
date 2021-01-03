package com.losdesiempre.mypocketeam;

import com.losdesiempre.mypocketeam.service.PokemonBaseService;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losdesiempre.mypocketeam.controller.PokemonBaseController;
import com.losdesiempre.mypocketeam.domain.Ability;
import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.domain.PokemonType;
import com.losdesiempre.mypocketeam.domain.Stat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AbstractPokemonBaseControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PokemonBaseService pokemonBaseService;

    private JacksonTester<PokemonBase> jsonPokemonBase;

    @InjectMocks
    PokemonBaseController pokemonBaseController;

    @Test
    void siSeLlamaAGetByNombreYElNombreExisteDebeRetornarElPokemonBase() throws Exception {
        // Given
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(pokemonBaseController).build();

        PokemonBase pokemon = new PokemonBase();
        List<PokemonType> types = new ArrayList<>();
        List<Ability> abilities = new ArrayList<>();

        pokemon.setId(1);
        pokemon.setName("Bulbasaur");
        types.add(new PokemonType(1, "Grass"));
        types.add(new PokemonType(2, "Poison"));
        pokemon.setTypes(types);
        abilities.add(new Ability(1, "Overgrow", false));
        abilities.add(new Ability(3, "Chlorophyll", true));
        pokemon.setAbility(abilities);
        pokemon.setHeight(0.7);
        pokemon.setWeight(6.9);
        pokemon.setStats(new Stat(45, 49, 49, 65, 65, 45, 318));

        given(pokemonBaseService.findByName("Bulbasaur")).willReturn(pokemon);

        // When
        MockHttpServletResponse response = mockMvc.perform(get("/api/pocketo/pokemonbase/Bulbasaur")
            .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
            jsonPokemonBase.write(pokemon).getJson()
        );

    }

    @Test
    void siSeLlamaAGetByNombreYElNombreNoExisteDebeRetornar404() throws Exception {
        // Given
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(pokemonBaseController).build();

        given(pokemonBaseService.findByName("Chayanne")).willReturn(null);

        // When
        MockHttpServletResponse response = mockMvc.perform(get("/api/pocketo/pokemonbase/Chayanne")
            .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(404);
    }

}
