package com.gmail.wildekatertz;

public class Cat implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4376964522204400576L;
	private String name;
	private String color;
	private String bread;
	private int age;
	private boolean vaccination;

	public Cat() {

	}

	public Cat(String name, String color, String bread, int age, boolean vaccination) {
		this.name = name;
		this.color = color;
		this.bread = bread;
		this.age = age;
		this.vaccination = vaccination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public String getBread() {
		return bread;
	}

	public void setBread(String bread) {
		this.bread = bread;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isVaccination() {
		return vaccination;
	}

	public void setVaccination(boolean vaccination) {
		this.vaccination = vaccination;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", color=" + color + ", bread=" + bread + ", age=" + age + ", vaccination="
				+ vaccination + "]";
	}

}
