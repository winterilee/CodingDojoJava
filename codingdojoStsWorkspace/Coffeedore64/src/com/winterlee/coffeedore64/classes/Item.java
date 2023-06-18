package com.winterlee.coffeedore64.classes;

public class Item {
	private String name;
	private double price;
	private int indexNum;
	
	public Item(String name, double price) {
		this.setName(name);
		this.setPrice(price);
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
	public int getIndexNum() {
		return indexNum;
	}
	public void setIndexNum(int index) {
		this.indexNum = index;
	}
}
