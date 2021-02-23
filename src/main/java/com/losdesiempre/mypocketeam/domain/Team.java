package com.losdesiempre.mypocketeam.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "equipos")
public class Team {
    //Variables
    public int id;
    public String name;
    public List<PokemonBase> pokemon;


    public Team(int id, String name, List<PokemonBase> pokemon) {
        this.id=id;
        this.name=name;
        this.pokemon=pokemon;
    }

    public void setName(String nombre) {
        this.name=nombre;
    }

    public String getName() {
        return name;
    }
}
