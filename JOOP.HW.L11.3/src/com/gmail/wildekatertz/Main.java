package com.gmail.wildekatertz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Integer[] arr = new Integer[23];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(10);
		}

		System.out.println(Arrays.toString(arr));

		HashMap<Integer, Integer> mapArr = getCalcRepeat(arr);


		System.out.println(mapArr);

	}

	public static HashMap<Integer, Integer> getCalcRepeat(Integer[] arr) {
		HashMap<Integer, Integer> mapArr = new HashMap<Integer, Integer>();
		for (Integer i : arr) {
			Integer tmp = mapArr.get(i);
			if (tmp == null) {
				mapArr.put(i, 1);
			} else {
				mapArr.put(i, tmp + 1);
			}
		}
		return mapArr;
	}

}
