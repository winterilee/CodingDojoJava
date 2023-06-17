package com.winterlee.baristaschallenge.controllers;

import com.winterlee.baristaschallenge.classes.Item;
import com.winterlee.baristaschallenge.classes.Order;

public class TestOrders {

	public static void main(String[] args) {
		Item item1 = new Item("drip Coffee", 3.5);
		Item item2 = new Item("latte", 4.75);
		Item item3 = new Item("mocha", 5.5);
		Item item4 = new Item("cappuccino", 5.75);
		
		Order order1 = new Order();
		order1.addItem(item3);
//		for (Item item: order1.getItems()) {
//			System.out.println(item.getName());			
//		}
		
		Order order2 = new Order();
		order2.addItem(item1);
		
		Order order3 = new Order("Nelly");
		order3.addItem(item2);
		
		Order order4 = new Order("Luke");
		order4.addItem(item4);
		
		Order order5 = new Order("Theo");
		order5.addItem(item1);
		
		order1.addItem(item2);
		order2.addItem(item3);
		order3.addItem(item4);
		order4.addItem(item2);
		order5.addItem(item1);
		
//		order2.getStatusMessage();
		order5.setReady(true);
//		order2.getStatusMessage();
		
		order2.setReady(true);
		order3.setReady(true);
		
		order1.display();
		order2.display();
		order3.display();
		order4.display();
		order5.display();
		
	}

}
