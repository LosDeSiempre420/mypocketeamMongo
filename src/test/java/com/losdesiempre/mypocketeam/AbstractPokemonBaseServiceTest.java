package com.losdesiempre.mypocketeam;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.losdesiempre.mypocketeam.domain.Ability;
import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.domain.PokemonType;
import com.losdesiempre.mypocketeam.domain.Stat;
import com.losdesiempre.mypocketeam.repository.PokemonBaseRepository;
import com.losdesiempre.mypocketeam.service.PokemonBaseServiceImplementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AbstractPokemonBaseServiceTest {

    @Autowired
    private PokemonBaseServiceImplementation pokemonBaseService;

    @MockBean
    private PokemonBaseRepository pokemonBaseRepository;

    private List<PokemonBase> pokemonBaseList;

    @BeforeEach
    void initPokemonBaseList() {
        pokemonBaseList = new ArrayList<>();
        List<PokemonType> types = new ArrayList<>();
        List<Ability> abilities = new ArrayList<>();

        PokemonBase pokemon = new PokemonBase();

        // Primer PokemonBase de la BDD
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
        pokemonBaseList.add(pokemon);

        // PokemonBase que esta al medio de la BDD
        pokemon = new PokemonBase();
        pokemon.setId(20);
        pokemon.setName("Raticate");
        types = new ArrayList<>();
        types.add(new PokemonType(1, "Normal"));
        pokemon.setTypes(types);
        abilities = new ArrayList<>();
        abilities.add(new Ability(1, "Run Away", false));
        abilities.add(new Ability(2, "Guts", false));
        abilities.add(new Ability(3, "Hustle", true));
        pokemon.setAbility(abilities);
        pokemon.setHeight(0.7);
        pokemon.setWeight(18.5);
        pokemon.setStats(new Stat(55, 81, 60, 50, 70, 97, 413));
        pokemonBaseList.add(pokemon);

        // Ultimo PokemonBase de la BDD
        pokemon = new PokemonBase();
        pokemon.setId(40);
        pokemon.setName("Wigglytuff");
        types = new ArrayList<>();
        types.add(new PokemonType(1, "Normal"));
        types.add(new PokemonType(2, "Fairy"));
        pokemon.setTypes(types);
        abilities = new ArrayList<>();
        abilities.add(new Ability(1, "Cute Charm", false));
        abilities.add(new Ability(2, "Competitive", false));
        abilities.add(new Ability(3, "Friend Guard", true));
        pokemon.setAbility(abilities);
        pokemon.setHeight(1.0);
        pokemon.setWeight(12.0);
        pokemon.setStats(new Stat(140, 70, 45, 85, 50, 45, 435));
        pokemonBaseList.add(pokemon);
    }

    /* ----- ListarPokemonBase ----- */
    @Test
    public void deberiaEntregarUnaListaConTodosLosPokemonBase() {
        // Arrange
        when(pokemonBaseRepository.findAll()).thenReturn(pokemonBaseList);

        // Act
        List<PokemonBase> all = pokemonBaseService.listAll();

        // Assert
        assertNotNull(all);
        assertEquals(all.size(), pokemonBaseList.size());
        assertAll(() -> assertEquals(1, all.get(0).id), () -> assertEquals("Bulbasaur", all.get(0).name),
                () -> assertEquals("Grass", all.get(0).types.get(0).name),
                () -> assertEquals(2, all.get(0).abilities.size()), () -> assertEquals(0.7, all.get(0).height),
                () -> assertEquals(49, all.get(0).stats.getAtk()),

                () -> assertEquals(20, all.get(1).id), () -> assertEquals("Raticate", all.get(1).name),
                () -> assertEquals(1, all.get(1).types.size()),
                () -> assertEquals("Guts", all.get(1).abilities.get(1).name),
                () -> assertEquals(18.5, all.get(1).weight), () -> assertEquals(97, all.get(1).stats.getSpd()),

                () -> assertEquals(40, all.get(2).id), () -> assertEquals("Wigglytuff", all.get(2).name),
                () -> assertEquals("Fairy", all.get(2).types.get(1).name),
                () -> assertTrue(all.get(2).abilities.get(2).isHidden),
                () -> assertEquals(12.0, all.get(2).weight), () -> assertEquals(435, all.get(2).stats.getTotal()));
    }

    @Test
    public void deberiaMostrarTodosDetallesPokemonBase() {
        // arrenge
        when(pokemonBaseRepository.findById(20)).thenReturn(pokemonBaseList.get(1));
        // act
        PokemonBase pokemon = pokemonBaseService.findById(20);
        // assert
        assertNotNull(pokemon);
        assertAll(() -> assertEquals(20, pokemon.id), () -> assertEquals("Raticate", pokemon.name),
                () -> assertEquals(1, pokemon.types.get(0).slot),
                () -> assertEquals("Normal", pokemon.types.get(0).name),

                () -> assertEquals(1, pokemon.abilities.get(0).getSlot()),
                () -> assertEquals("Run Away", pokemon.abilities.get(0).getName()),
                () -> assertFalse(pokemon.abilities.get(0).getIsHidden()),
                () -> assertEquals(2, pokemon.abilities.get(1).getSlot()),
                () -> assertEquals("Guts", pokemon.abilities.get(1).getName()),
                () -> assertFalse(pokemon.abilities.get(1).getIsHidden()),
                () -> assertEquals(3, pokemon.abilities.get(2).getSlot()),
                () -> assertEquals("Hustle", pokemon.abilities.get(2).getName()),
                () -> assertTrue(pokemon.abilities.get(2).getIsHidden()),

                () -> assertEquals(0.7, pokemon.height), () -> assertEquals(18.5, pokemon.weight),

                () -> assertEquals(55, pokemon.stats.getHp()), () -> assertEquals(81, pokemon.stats.getAtk()),
                () -> assertEquals(60, pokemon.stats.getDef()), () -> assertEquals(50, pokemon.stats.getSpAtk()),
                () -> assertEquals(70, pokemon.stats.getSpDef()), () -> assertEquals(97, pokemon.stats.getSpd()),
                () -> assertEquals(413, pokemon.stats.getTotal()));
    }
}