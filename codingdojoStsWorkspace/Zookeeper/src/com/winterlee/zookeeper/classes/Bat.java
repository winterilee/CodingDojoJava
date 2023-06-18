package com.winterlee.zookeeper.classes;

public class Bat extends Mammal {
	
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("*flutter* The bat took off and is flying. Its energy level has been decreased by 50.");
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("*crack* The bat is eating humans. Its energy level has been increased by 25");
	}
	
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("*thrash* The bat is attacking a town. Its energy level has been decreased by 100");
	}
	
}
