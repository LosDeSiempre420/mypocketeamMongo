package com.losdesiempre.mypocketeam.controller;

import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.service.PokemonBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pocketo")
public class PokemonBaseController {

    /*@Autowired
    PokemonService pokemonService;

    @GetMapping("/{nombre}")
    public Pokemon findByNombre(@PathVariable(value = "nombre") String nombre){
        return pokemonService.findbyNombre(nombre);
    }

    @PostMapping("/")
    public Pokemon createPocketo(@RequestBody Pokemon pocketo){
        return pokemonService.save(pocketo);
    }*/

}
