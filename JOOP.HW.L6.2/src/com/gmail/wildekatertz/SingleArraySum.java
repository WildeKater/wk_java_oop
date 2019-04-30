package com.gmail.wildekatertz;

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

	public Thread getThr() {
		return thr;
	}

	public int getSumm() {
		return summ;
	}

	@Override
	public void run() {
		for (int i = begin; i < end; i++) {
			summ = summ + array[i];
		}
	}
	

}
