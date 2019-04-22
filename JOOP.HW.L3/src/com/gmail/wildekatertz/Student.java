package com.gmail.wildekatertz;

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

	public int getStudentId() {
		return studentId;
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
	public String toString() {
		return super.toString() + ", studentId=" + studentId + "]";

	}

}
