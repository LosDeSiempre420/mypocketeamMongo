package com.losdesiempre.mypocketeam.controller;

import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.service.PokemonBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pocketo/pokemonbase")
public class PokemonBaseController {

    @Autowired
    private PokemonBaseService pokemonBaseService;
    
    @GetMapping(value = "/{name}")
    public ResponseEntity<PokemonBase> getPokemonByName(@PathVariable("name") String name) {
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        PokemonBase pokemon = pokemonBaseService.findByName(name);

        if(pokemon != null) {
            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
