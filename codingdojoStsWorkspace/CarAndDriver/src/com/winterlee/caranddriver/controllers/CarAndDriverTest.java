package com.winterlee.caranddriver.controllers;

import com.winterlee.caranddriver.classes.Driver;

public class CarAndDriverTest {

	public static void main(String[] args) {
		Driver driver1 = new Driver();
		
		for (int i = 0; i < 4; i++) {
			driver1.drive();
		}
		
		driver1.boosters();
		
		for (int i = 0; i < 3; i++) {
			driver1.addGas();
		}

	}

}
