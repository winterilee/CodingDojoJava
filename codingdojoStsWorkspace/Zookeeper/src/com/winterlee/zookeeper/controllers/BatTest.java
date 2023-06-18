package com.winterlee.zookeeper.controllers;

import com.winterlee.zookeeper.classes.Bat;

public class BatTest {

	public static void main(String[] args) {
		Bat bat1 = new Bat();
		bat1.displayEnergy();
		for (int i = 0; i < 3; i++) {
			bat1.attackTown();
		}
		for (int i = 0; i < 2; i++) {
			bat1.eatHumans();
		}
		for (int i = 0; i < 2; i++) {
			bat1.fly();
		}
		bat1.displayEnergy();

	}

}
