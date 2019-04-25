package com.gmail.wildekatertz;

import java.math.BigInteger;

public class FactorialTask implements Runnable {

	private int number;

	public FactorialTask() {
		super();
	}

	public FactorialTask(int number) {
		super();
		this.number = number;
	}

	public BigInteger calculateFactorial(int n) {
		BigInteger factor = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			factor = factor.multiply(new BigInteger(Integer.toString(i)));
		}
		return factor;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		System.out.println(thr.getName() + " " + number + " ! =" + calculateFactorial(number));
		if (thr.isInterrupted()) {
			System.out.println(thr.getName() + " interrupted!");
			return;
		}

	}

}
