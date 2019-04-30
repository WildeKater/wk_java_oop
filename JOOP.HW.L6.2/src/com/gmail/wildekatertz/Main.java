package com.gmail.wildekatertz;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		int[] array = new int[2000000];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		int[] array2 = array.clone();
		int[] array3 = array.clone();

		long tstart = System.currentTimeMillis();
		System.out.println("Sum = " + MultiThreadArraySum.sum(array, 13));
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - MultiThread metod sum");

		tstart = System.currentTimeMillis();
		System.out.println("Sum = " + singleSum(array2));
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - Static metod sum");

		tstart = System.currentTimeMillis();
		System.out.println("Sum = " + MultiThreadArraySum.sum(array3, Runtime.getRuntime().availableProcessors()));
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - MultiThread metod sum with core autodetected");
	}

	public static int singleSum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

}
