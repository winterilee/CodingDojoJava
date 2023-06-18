package com.winterlee.coffeedore64.controllers;

import com.winterlee.coffeedore64.classes.CoffeeKiosk;

public class TestCoffeeKiosk {

	public static void main(String[] args) {
		CoffeeKiosk cKiosk = new CoffeeKiosk();
		
		cKiosk.addMenuItem("drip coffee", 3.5);
		cKiosk.addMenuItem("latte", 4.75);
		cKiosk.addMenuItem("mocha", 5.5);
		cKiosk.addMenuItem("cappuccino", 5.75);
		cKiosk.addMenuItem("muffin", 4.5);
		cKiosk.addMenuItem("waffle", 6.25);
		cKiosk.addMenuItem("french toast", 7);
		
		
		
	}

}
