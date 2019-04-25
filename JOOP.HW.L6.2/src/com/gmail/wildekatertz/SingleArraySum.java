package com.gmail.wildekatertz;

import java.math.BigInteger;

public class SingleArraySum implements Runnable {

	private int[] array;
	private int begin;
	private int end;
	private Thread thr;
	private int summ;

	public SingleArraySum() {
		super();
	}

	public SingleArraySum(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thr = new Thread(this);
		thr.start();
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
		for (int i = begin; i < end; i++) {
			summ = summ + array[i];
		}
		if (thr.isInterrupted()) {
			System.out.println(thr.getName() + " interrupted!");
			return;
		}

	}

}
