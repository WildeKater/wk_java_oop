package com.gmail.wildekatertz;

import java.util.Scanner;

public class Student extends Human implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int studentNumber = 0;
	private int studentId;

	public Student() {
		super();
		studentNumber++;
		this.studentId = studentNumber;
	}

	public Student(String name, Genders gender, int age) {
		super(name, gender, age);
		studentNumber++;
		this.studentId = studentNumber;
	}

	public void interactiveAdd(Student student) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������� ��� ��������");
		student.setName(sc.nextLine());
		System.out.println("������� ��� ��������(MALE/FEMALE)");
		for (;;) {
			Genders gender = null;
			String stringGender = sc.nextLine();
			try {
				gender = gender.valueOf(stringGender.toUpperCase());
				student.setGender(gender);
				break;
			} catch (Exception e) {
				System.out.println("������� ���������� �������� ���� ��������(MALE/FEMALE)");
			}
		}
		System.out.println("������� ������� ��������");
		student.setAge(sc.nextInt());
	}

	public int getStudentId() {
		return studentId;
	}

	@Override
	public String toString() {
		return super.toString() + ", studentId=" + studentId + "]";

	}

}
