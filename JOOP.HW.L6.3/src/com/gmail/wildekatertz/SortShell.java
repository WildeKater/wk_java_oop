package com.gmail.wildekatertz;

public class SortShell {

	public static void sortShell(int[] array) {
		for (int increment = array.length / 3; increment >= 1; increment = increment / 3) {
			for (int startIndex = 0; startIndex < increment; startIndex++) {
				insertSort(array, startIndex, increment);
			}
		}
	}

	private static void insertSort(int[] array, int startIndex, int increment) {
		for (int i = startIndex; i < array.length; i = i + increment) {
			for (int j = Math.min(i + increment, array.length - 1); j - increment >= 0; j = j - increment) {
				if (array[j - increment] > array[j]) {
					int temp = array[j];
					array[j] = array[j - increment];
					array[j - increment] = temp;
				} else {
					break;
				}
			}
		}
	}

}
