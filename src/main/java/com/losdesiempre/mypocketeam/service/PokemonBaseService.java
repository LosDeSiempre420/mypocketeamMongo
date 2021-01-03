package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.PokemonBase;

import java.util.List;

public interface PokemonBaseService {

    List<PokemonBase> listAll();
    PokemonBase findById(int id);
	PokemonBase findByName(String string);

    /*
     * Pokemon save(Pokemon pokemon); Pokemon findById(int id); void delete(int id);
     * Pokemon findbyNombre(String nombre);
     */

}
