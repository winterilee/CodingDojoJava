package com.winterlee.ordersanditems.controllers;

import com.winterlee.ordersanditems.classes.Item;
import com.winterlee.ordersanditems.classes.Order;

public class TestOrders {

	public static void main(String[] args) {
		Item item1 = new Item();
		item1.name = "drip Coffee";
		item1.price = 3.5;
		
		Item item2 = new Item();
		item2.name = "latte";
		item2.price = 4.75;
		
		Item item3 = new Item();
		item3.name = "mocha";
		item3.price = 5.5;
		
		Item item4 = new Item();
		item4.name = "cappuccino";
		item4.price = 5.75;
		
		Order order1 = new Order();
		order1.name = "Cindhuri";
		order1.total = item2.price;
		order1.ready = false;
		order1.items.add(item2);
		
		Order order2 = new Order();
		order2.name = "Jimmy";
		order2.total = item3.price;
		order2.ready = false;
		order2.items.add(item3);

		Order order3 = new Order();
		order3.name = "Noah";
		order3.total = item1.price;
		order3.ready = false;
		order3.items.add(item1);
		
		Order order4 = new Order();
		order4.name = "Sam";
		order4.total = item4.price;
		order4.ready = false;
		order4.items.add(item4);
		
		System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: $%.2f\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: $%.2f\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: $%.2f\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: $%.2f\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
        
		order2.total += item1.price;
		order2.items.add(item1);
		
		order3.total += item4.price;
		order3.items.add(item4);
		
		order4.total += item2.price;
		order4.items.add(item2);
		
		order1.ready = true;
		
		order4.total += ((item2.price)*2);
		order4.items.add(item2);
		order4.items.add(item2);
		
		order2.ready = true;
		
		System.out.println("---------------");
		System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: $%.2f\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: $%.2f\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: $%.2f\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: $%.2f\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
        
	}
	

}
