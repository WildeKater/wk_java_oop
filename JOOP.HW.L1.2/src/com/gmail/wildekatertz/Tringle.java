package com.gmail.wildekatertz;

public class Tringle implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8962027513062667252L;
	private double sideOne;
	private double sideTwo;
	private double sideThree;
	private double squere;

	public Tringle() {

	}

	public Tringle(double sideOne, double sideTwo, double sideThree) {
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;
	}

	public Tringle(double side) {
		this.sideOne = side;
		this.sideTwo = side;
		this.sideThree = side;
	}

	public double getSideOne() {
		return sideOne;
	}

	public void setSideOne(double sideOne) {
		this.sideOne = sideOne;
	}

	public double getSideTwo() {
		return sideTwo;
	}

	public void setSideTwo(double sideTwo) {
		this.sideTwo = sideTwo;
	}

	public double getSideThree() {
		return sideThree;
	}

	public void setSideThree(double sideThree) {
		this.sideThree = sideThree;
	}

	public double getSquere() {
		calcSquere();
		return squere;
	}

	private void calcSquere() {
		double p = (sideOne + sideTwo + sideThree) / 2;
		squere = Math.sqrt(p * (p - sideOne) * (p - sideTwo) * (p - sideThree));
	}

	@Override
	public String toString() {
		return "Tringle [sideOne=" + sideOne + ", sideTwo=" + sideTwo + ", sideThree=" + sideThree + "]";
	}

}
