package com.winterlee.fruityloops.models;

public class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		setName(name);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		this.price = price;
	}
	
}
