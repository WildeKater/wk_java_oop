package com.gmail.wildekatertz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println();

		List<String> queue = new ArrayList<String>();
		queue.add("Шеллдон");
		queue.add("Леонард");
		queue.add("Воловиц");
		queue.add("Кутрапалли");
		queue.add("Пенни");

		Scanner sc = new Scanner(System.in);
		int drink = sc.nextInt();

		queue = calcQueue(queue, drink);

		System.out.println(queue);

	}

	private static List<String> calcQueue(List<String> queue, int drink) {
		for (int i = 0; i < drink; i++) {
			String tmp = queue.get(0);
			queue.remove(0);
			queue.add(queue.size(), tmp);
			queue.add(queue.size(), tmp);
		}
		return queue;
	}

}
