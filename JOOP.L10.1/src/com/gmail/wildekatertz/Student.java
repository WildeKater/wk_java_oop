package com.gmail.wildekatertz;

import java.util.Comparator;
import java.util.Scanner;

public class Student extends Human implements java.io.Serializable, Comparable<Student> {

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
		System.out.println("¬ведите им€ студента");
		student.setName(sc.nextLine());
		System.out.println("¬ведите пол студента(MALE/FEMALE)");
		for (;;) {
			String stringGender = sc.nextLine();
			try {
				Genders gender = Genders.valueOf(stringGender.toUpperCase());
				student.setGender(gender);
				break;
			} catch (Exception e) {
				System.out.println("¬ведите корректное значение пола студента(MALE/FEMALE)");
			}
		}
		System.out.println("¬ведите возраст студента");
		student.setAge(sc.nextInt());
	}

	@Override
	public String toString() {
		return super.toString() + ", studentId=" + studentId + "]";

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if ((this.studentId != other.studentId) || (this.getAge() != other.getAge())
				|| (this.getGender() != other.getGender()) || (this.getName() != other.getName()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.studentId;
		result = prime * result + (this.getName() == null ? 0 : this.getName().hashCode());
		result = prime * result + this.getAge();
		result = prime * result + (this.getGender() == null ? 0 : this.getGender().hashCode());
		return result;
	}

	@Override
	public int compareTo(Student student) {
		if (student == null) {
			return -1;
		}
		return this.getName().compareToIgnoreCase(student.getName());
	}

	public static Comparator<Student> COMPARE_BY_NAME = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if (s1 == null) {
				return 1;
			}
			if (s2 == null) {
				return -1;
			}
			return s1.getName().compareTo(s2.getName());
		}

	};

	public static Comparator<Student> COMPARE_BY_AGE = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if (s1 == null) {
				return 1;
			}
			if (s2 == null) {
				return -1;
			}
			Integer age1 = s1.getAge();
			Integer age2 = s2.getAge();
			return age1.compareTo(age2);
		}

	};

	public static Comparator<Student> COMPARE_BY_GENDER = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if (s1 == null) {
				return 1;
			}
			if (s2 == null) {
				return -1;
			}
			return s1.getGender().compareTo(s2.getGender());
		}

	};

}
