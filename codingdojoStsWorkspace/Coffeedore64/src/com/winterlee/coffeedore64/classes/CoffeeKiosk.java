package com.winterlee.coffeedore64.classes;

import java.util.ArrayList;

public class CoffeeKiosk {
	private ArrayList<Item> menu;
	private ArrayList<Order> orders;
	
	public CoffeeKiosk() {		
		this.menu = new ArrayList<Item>();
		this.orders = new ArrayList<Order>();
	}

	public ArrayList<Item> getMenu() {
		return menu;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public void addMenuItem(String name, double price) {
		Item newItem = new Item(name, price);
		newItem.setIndexNum(menu.size());
		menu.add(newItem);
	}
	
	public void displayMenu() {
		for (Item item: menu) {
			System.out.printf("%s %s -- $%.2f\n", item.getIndexNum(), item.getName(), item.getPrice());
		}		
	}
	
	
	
}
