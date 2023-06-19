package com.winterlee.caranddriver.classes;

public class Car {
	protected int gas;
	
	public Car() {
		this.setGas(10);
	}
	
	public void display() {
		int gasLevel = this.getGas();
		System.out.printf("Gas remaining: %s/10\n", gasLevel);
	}

	public int getGas() {
		return gas;
	}

	private void setGas(int gas) {
		this.gas = gas;
	}
	
}
