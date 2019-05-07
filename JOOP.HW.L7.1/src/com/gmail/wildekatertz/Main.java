package com.gmail.wildekatertz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		ExecutorService dock = Executors.newFixedThreadPool(2);
		dock.execute(new Ship("ShipOne", 10));
		dock.execute(new Ship("ShipTwo", 10));
		dock.execute(new Ship("ShipThree", 10));
		dock.shutdown();

	}

}
