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
	
	public void newOrder() {
		System.out.println("Please enter customer name for new order:");
		String name = System.console().readLine();
		Order order = new Order(name);
		displayMenu();
		System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
		
        while(!itemNumber.equals("q")) {
        	int itemIndex = Integer.parseInt(itemNumber);
        	int orderCount = 0;
        	for (Item item: menu) {
        		if (item.getIndexNum() == itemIndex) {
        			order.addItem(item);
        			orderCount++;
        		}
        	}
        	if (orderCount == 0) {
        		System.out.println("Please enter valid number.");
        	}
        	System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();	
        }
	}
		
}
