package com.losdesiempre.mypocketeam.controller;

import com.losdesiempre.mypocketeam.domain.Pokemon;
import com.losdesiempre.mypocketeam.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pocketo/pokemonCreado")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping(value = "/post")
    public ResponseEntity<Pokemon> crearPokemon(@RequestBody String nombrePokemonBase) {
        Pokemon pokemonCreado = pokemonService.crearPokemon(nombrePokemonBase);

        if(pokemonCreado == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pokemonCreado, HttpStatus.CREATED);
    }
}
