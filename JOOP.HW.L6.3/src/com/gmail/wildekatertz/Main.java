package com.gmail.wildekatertz;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		int[] array = new int[200000];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		// int[] array2 = array.clone();
		int[] array3 = array.clone();

		long tstart = System.currentTimeMillis();
		SortShell.sortShell(array);
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - Static metod sort");

//		tstart = System.currentTimeMillis();
//		MultiThreadSorting.sort(array2, 13);
//		tend = System.currentTimeMillis();
//		System.out.println((tend-tstart)+" ms"+" - MultiThread sort");

		tstart = System.currentTimeMillis();
		Arrays.sort(array3);
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - ArraySort sort");
		System.out.println(Arrays.equals(array, array3));

	}

}
