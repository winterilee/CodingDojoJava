package com.winterlee.baristaschallenge.classes;

import java.util.ArrayList;

public class Order {
	private String name;
	private boolean ready;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Order() {
		this.setName("Guest");
	}
	public Order(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void getStatusMessage() {
		if (this.ready) {
			System.out.println("Your order is ready.");
		}
		else {
			System.out.println("Thank you for waiting. Your order will be ready soon.");
		}
	}
	
	public double getOrderTotal() {
		double total = 0d;
		for (Item item: this.items) {
			total += item.getPrice();
		}
		return total;
	}
	
	public void display() {
		System.out.println("Customer Name: " + this.name);
		for (Item item: this.items) {
			System.out.println(item.getName() + " - $" + item.getPrice());
		}
		System.out.println("Total: $" + this.getOrderTotal());
		this.getStatusMessage();
		System.out.println("--------------------");
	}
	
}
