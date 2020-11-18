package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> listAll();
    Pokemon save(Pokemon pokemon);
    Pokemon findById(int id);
    void delete(int id);
    Pokemon findbyNombre(String nombre);

}
