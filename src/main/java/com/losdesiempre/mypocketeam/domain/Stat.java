package com.losdesiempre.mypocketeam.domain;

public class Stat {

	int hp;
	int atk;
	int def;
	int sp_atk;
	int sp_def;
	int spd;
	int total;

	public Stat(int hp, int atk, int def, int sp_atk, int sp_def, int spd, int total) {
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.sp_atk = sp_atk;
		this.sp_def = sp_def;
		this.spd = spd;
		this.total = total;
	}

	public Integer getAtk() {
		return atk;
	}

	public Integer getSpd() {
		return spd;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getHp() {
		return hp;
	}

	public Integer getDef() {
		return def;
	}

	public Integer getSpAtk() {
		return sp_atk;
	}

	public Integer getSpDef() {
		return sp_def;
	}

}
