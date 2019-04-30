package com.gmail.wildekatertz;

public class MultiThreadArraySum {

	static int sum(int[] array, int threadNumber) {

		SingleArraySum[] threadarray = new SingleArraySum[threadNumber];

		for (int i = 0; i < threadarray.length; i++) {
			int size = array.length / threadNumber;
			int begin = size * i;
			int end = (i + 1) * size;
			if ((array.length - end) < size) {
				end = array.length;
			}
			threadarray[i] = new SingleArraySum(array, begin, end);
		}

		for (int i = 0; i < threadarray.length; i++) {
			try {
				threadarray[i].getThr().join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

		return sumArrays(threadarray);
	}

	private static int sumArrays(SingleArraySum[] threadarray) {
		int arrSum = 0;
		for (int i = 0; i < threadarray.length; i++) {
			arrSum += threadarray[i].getSumm();
		}
		return arrSum;
	}

}
