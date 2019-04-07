package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		Cat catOne = new Cat();

		catOne.setName("Барсик");
		catOne.setColor("Black");
		catOne.setBread("Persian");
		catOne.setAge(7);
		catOne.setVaccination(false);

		System.out.println("Name = " + catOne.getName());
		System.out.println("Color = " + catOne.getColor());
		System.out.println("Bread = " + catOne.getBread());
		System.out.println("Age = " + catOne.getAge());
		System.out.println("Vaccination is " + catOne.isVaccination());

		System.out.println();

		Cat catTwo = new Cat("Мурзик", "White", "Siamese", 5, true);
		System.out.println(catTwo);

	}

}
