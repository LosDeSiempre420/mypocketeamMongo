package com.losdesiempre.mypocketeam.domain;

public class Pokemon {

	public String name;
    public Ability ability;
    public Stat iv;
    public Stat ev;
    public Movement[] movimientos = new Movement[4];
    public int id;
    public String level;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Ability getAbility() {
        return this.ability;
    }

    public Stat getIV() {
        return this.iv;
    }

    public Stat getEV() {
        return this.ev;
    }

    public Movement[] getMovements() {
        return this.movimientos;
    }

    public String getLevel() {
        return this.level;
    }

    public void setId(int i) {
        // por implementar
    }

    public void setName(String name) {
        // por implementar
    }

    public void setLevel(String string) {
        // por implementar
    }

    public void setAbility(Ability ability) {
        // por implementar
    }

    public void setMoves() {
        // por implementar
    }

    public void setIVs(Stat stat) {
        // por implementar
    }

    public void setEVs(Stat stat) {
        // por implementar
    }

}
