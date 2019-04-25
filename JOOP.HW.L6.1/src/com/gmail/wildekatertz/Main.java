package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			FactorialTask ftask = new FactorialTask(i);
			Thread fthresd = new Thread(ftask);
			fthresd.start();
		}

	}

}
