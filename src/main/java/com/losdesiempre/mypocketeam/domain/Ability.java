package com.losdesiempre.mypocketeam.domain;

public class Ability {

	public String name;
	public boolean isHidden;
	public Integer slot;

	public Ability(int slot, String name, boolean isHidden) {
		this.name = name;
		this.isHidden = isHidden;
		this.slot = slot;
	}

	public Integer getSlot() {
		return slot;
	}

	public String getName() {
		return name;
	}

	public Boolean getIsHidden() {
		return isHidden;
	}

}
