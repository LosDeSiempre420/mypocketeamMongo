package com.losdesiempre.mypocketeam.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document( collection = "pokemon")
public class PokemonBase {

	public Integer id;
	public String name;
	public List<PokemonType> types;
	public List<Ability> abilities;
	public Double height;
	public Double weight;
	public Stat stats;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTypes(List<PokemonType> types) {
		this.types = types;
	}

	public void setAbility(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setStats(Stat stats) {
		this.stats = stats;
	}

}
