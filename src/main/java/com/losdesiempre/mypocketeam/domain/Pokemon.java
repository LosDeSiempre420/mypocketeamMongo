package com.losdesiempre.mypocketeam.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pokemon {

    @Id private String elid;

    String nombre;

    public Pokemon(String elid, String nombre) {
        this.elid = elid;
        this.nombre = nombre;
    }

    public Pokemon() {
    }

    public String getElid() {
        return elid;
    }

    public void setElid(String elid) {
        this.elid = elid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
