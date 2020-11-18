package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.Pokemon;
import com.losdesiempre.mypocketeam.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImplementation implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> listAll(){
        return pokemonRepository.findAll();
    }

    public Pokemon save(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon findById(int id){
        return pokemonRepository.getByElid(id);
    }

    public void delete(int id){
        pokemonRepository.deleteById(id);
    }

    @Override
    public Pokemon findbyNombre(String nombre) {
        return pokemonRepository.findByNombre(nombre);
    }
}
