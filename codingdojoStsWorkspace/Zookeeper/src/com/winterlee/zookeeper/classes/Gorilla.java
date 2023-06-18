package com.winterlee.zookeeper.classes;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		this.energyLevel -= 5;
		System.out.println("The gorilla is throwing something. Its energy level has been decreased by 5.");
	}
	
	public void eatBananas() {
		this.energyLevel += 10;
		System.out.println("The gorilla is eating bananas. Its energy level has been increased by 10.");
	}
	
	public void climb() {
		this.energyLevel -= 10;
		System.out.println("The gorilla is climbing. Its energy level has been decreased by 10.");
	}
	
}
