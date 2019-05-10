package com.gmail.wildekatertz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		int[] arr = new int[23];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(10);
		}

		System.out.println(Arrays.toString(arr));

		HashMap<Integer, Integer> mapArr = getCalcRepeat(arr);

		for (Map.Entry<Integer, Integer> i : mapArr.entrySet()) {
			System.out
					.print("Число " + i.getKey() + " повторяется " + i.getValue() + " раз(а)" + System.lineSeparator());
		}

	}

	public static HashMap<Integer, Integer> getCalcRepeat(int[] arr) {
		HashMap<Integer, Integer> mapArr = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (!mapArr.containsKey(i)) {
				mapArr.put(i, 1);
			} else {
				int tmp = mapArr.get(i) + 1;
				mapArr.put(i, tmp);
			}
		}
		return mapArr;
	}

}
