package com.gmail.wildekatertz;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Deque<String> queue = new ArrayDeque<String>();
		queue.addLast("Шеллдон");
		queue.addLast("Леонард");
		queue.addLast("Воловиц");
		queue.addLast("Кутрапалли");
		queue.addLast("Пенни");

		Scanner sc = new Scanner(System.in);
		System.out.println("Введите кол-во стаканов двойной колы");
		int drink = sc.nextInt();

		queue = calcQueue(queue, drink);

		System.out.println(queue);

	}

	private static Deque<String> calcQueue(Deque<String> queue, int drink) {
		for (int i = 0; i < drink; i++) {
			String tmp = queue.pollFirst();
			queue.addLast(tmp);
			queue.addLast(tmp);
		}
		return queue;
	}

}
