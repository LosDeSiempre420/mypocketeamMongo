package com.losdesiempre.mypocketeam.repository;

import com.losdesiempre.mypocketeam.domain.PokemonBase;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonBaseRepository extends MongoRepository<PokemonBase, Integer> {

    PokemonBase findById(int id);


    /*
     * Pokemon findByNombre(@Param("nombre") String nombre); Pokemon
     * getByElid(@Param("elid") int elid);
     */

}