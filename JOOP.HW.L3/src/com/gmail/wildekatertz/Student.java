package com.gmail.wildekatertz;

public class Student extends Human implements java.io.Serializable{

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

	public int getStudentId() {
		return studentId;
	}

	@Override
	public String toString() {
		return super.toString() + ", studentId=" + studentId + "]";

	}

}
