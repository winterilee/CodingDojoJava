package com.winterlee.coffeedore64.classes;

import java.util.ArrayList;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		Order order = new Order(name);
		displayMenu();
		System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = sc.nextLine();
		
        while(!itemNumber.equals("q")) {
        	int itemIndex = Integer.parseInt(itemNumber);
        	boolean itemExist = false;
        	for (Item item: menu) {
        		if (item.getIndexNum() == itemIndex) {
        			order.addItem(item);
        			itemExist = true;
        		}
        	}
        	if (itemExist == false) {
        		System.out.println("Invalid item.");
        	}
        	System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = sc.nextLine();	
        }
        
        System.out.println("Customer Name: " + order.getName());
        System.out.println("Orders:");
        double totalAmount = 0d;
        for(Item item: order.getItems()) {
        	System.out.printf("%s -- $%.2f\n", item.getName(), item.getPrice());
        	totalAmount += item.getPrice();
        }
        System.out.printf("Total: $%.2f\n", totalAmount);
        
	}
		
}
