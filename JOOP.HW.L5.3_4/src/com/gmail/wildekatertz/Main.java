package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		Student testStudent = new Student();
		testStudent.interactiveAdd(testStudent);

		Student humanOne = new Student("Alpha", Genders.MALE, 18);
		Student humanTwo = new Student("Beta", Genders.MALE, 16);
		Student humanThree = new Student("Gamma", Genders.FEMALE, 19);
		Student humanFour = new Student("Delta", Genders.FEMALE, 17);
		Student humanFive = new Student("Epsilon", Genders.MALE, 18);
		Student humanSix = new Student("Zeta", Genders.FEMALE, 20);
		Student humanSeven = new Student("Eta", Genders.FEMALE, 17);
		Student humanEight = new Student("Theta", Genders.MALE, 21);
		Student humanNine = new Student("Iota", Genders.MALE, 19);
		Student humanTen = new Student("Kappa", Genders.FEMALE, 19);
		Student humanEleven = new Student("Lambda", Genders.MALE, 20);

		System.out.println(humanOne);
		System.out.println(humanTwo);
		System.out.println(humanThree);
		System.out.println(humanFour);
		System.out.println(humanFive);
		System.out.println(humanSix);
		System.out.println(humanSeven);
		System.out.println(humanEight);
		System.out.println(humanNine);
		System.out.println(humanTen);
		System.out.println(humanEleven);

		System.out.println();

		Group gr = new Group(humanOne, humanTwo, humanThree, humanFour);
		gr.addStudent(testStudent);
		gr.addStudent(humanFive);
		gr.addStudent(humanSix);
		gr.addStudent(humanSeven);
		gr.addStudent(humanEight);
		gr.addStudent(humanOne);
		gr.addStudent(humanNine);
		gr.addStudent(humanTen);
		gr.addStudent(humanEleven);
		gr.removeStudent(humanEleven);
		gr.removeStudent(humanOne);

		System.out.println();

		System.out.println(gr.findStudent("Eta"));
		System.out.println(gr.findStudent("Alpha"));

		System.out.println();

		System.out.println(gr);

		Student[] armyList = gr.armyList();
		System.out.println("Призывники:");

		for (Student i : armyList) {
			System.out.println(i);
		}

		System.out.println();
		gr.sortGroupBy();

		IOGroup.groupSave(gr);

		Group gr2 = IOGroup.groupLoad("1.csv");

		System.out.println();
		
		System.out.println(gr2);

		IOGroup.groupSave(gr2);

	}

}
