package com.gmail.wildekatertz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Integer[] arr = new Integer[13];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -20 + new Random().nextInt(40);
		}

		System.out.println(Arrays.toString(arr));

		System.out.println("min = " + find(arr));

	}

	private static int find(Integer[] arr) {

		int findNum = Arrays.asList(arr).stream()
				.min((p1, p2) -> (Math.abs(p1) - Math.abs(p2)) == 0 ? ((Math.abs(p1) - Math.abs(p2)) * -1)
						: (Math.abs(p1) - Math.abs(p2)))
				.get();

		return findNum;
	}
}
