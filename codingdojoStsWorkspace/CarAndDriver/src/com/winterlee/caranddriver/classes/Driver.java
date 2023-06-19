package com.winterlee.caranddriver.classes;

public class Driver extends Car {
	
	public void drive() {
		this.gas -= 1;
		System.out.println("You drive the car.");
		this.display();
	}
	
	public void boosters() {
		this.gas -= 3;
		System.out.println("You used boosters.");
		this.display();
	}
	
	public void addGas() {
		this.gas += 2;
		System.out.println("You refueled the gas.");
		this.display();
	}
	
	
}
