package com.gmail.wildekatertz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {

		int[] arr = new int[13];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -20 + new Random().nextInt(40);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
		System.out.println(find(arr));

	}

	private static OptionalInt find(int[] arr) {

		OptionalInt findNum = Arrays.stream(arr)
				.min();
				


		return findNum;
	}
}
