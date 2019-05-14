package com.gmail.wildekatertz;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Введите строку текста");
		String str = sc.nextLine();

		int[] ascii = str.chars().toArray();

		System.out.println("Массив ASCII кодов символов строки:");
		System.out.println(Arrays.toString(ascii));

	}

}
