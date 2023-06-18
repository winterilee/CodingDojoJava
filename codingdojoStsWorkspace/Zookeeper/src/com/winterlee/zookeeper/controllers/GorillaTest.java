package com.winterlee.zookeeper.controllers;

import com.winterlee.zookeeper.classes.Gorilla;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla gorilla1 = new Gorilla();
		gorilla1.displayEnergy();
		for (int i = 0; i < 3; i++) {
			gorilla1.throwSomething();
		}
		for (int i = 0; i < 2; i++) {
			gorilla1.eatBananas();
		}
		gorilla1.climb();
		gorilla1.displayEnergy();

	}

}
