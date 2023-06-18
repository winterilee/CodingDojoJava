package com.winterlee.zookeeper.classes;

public class Mammal {
	protected int energyLevel = 100;
	
	public Mammal() {
	}
	
	public int displayEnergy() {
		System.out.println("Energy Level: " + energyLevel);
		return energyLevel;
	}
	
}
