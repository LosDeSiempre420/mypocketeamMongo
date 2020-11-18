package com.losdesiempre.mypocketeam.repository;


import com.losdesiempre.mypocketeam.domain.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon,Integer> {

    Pokemon findByNombre(@Param("nombre") String nombre);
    Pokemon getByElid(@Param("elid") int elid);

}