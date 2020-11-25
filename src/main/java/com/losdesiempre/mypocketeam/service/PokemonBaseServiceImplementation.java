package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.repository.PokemonBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonBaseServiceImplementation implements PokemonBaseService {

    @Autowired
    private PokemonBaseRepository pokemonBaseRepository;

    public List<PokemonBase> listAll() {
        return pokemonBaseRepository.findAll();
    }

    public PokemonBase findById(int id) {
        return pokemonBaseRepository.findById(id);
    }

    /*
     * public Pokemon save(Pokemon pokemon) { return
     * pokemonRepository.save(pokemon); }
     * 
     * public Pokemon findById(int id){ return pokemonRepository.getByElid(id); }
     * 
     * public void delete(int id){ pokemonRepository.deleteById(id); }
     * 
     * @Override public Pokemon findbyNombre(String nombre) { return
     * pokemonRepository.findByNombre(nombre); }
     */
}
