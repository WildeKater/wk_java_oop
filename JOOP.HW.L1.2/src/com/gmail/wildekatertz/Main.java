package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		Tringle tringleOne = new Tringle(4);
		System.out.println(tringleOne.toString());
		System.out.println("Squere = " + tringleOne.getSquere());

		System.out.println();

		Tringle tringleTwo = new Tringle(3, 4, 5);
		System.out.println(tringleTwo);
		System.out.println("Squere = " + tringleTwo.getSquere());

	}

}
