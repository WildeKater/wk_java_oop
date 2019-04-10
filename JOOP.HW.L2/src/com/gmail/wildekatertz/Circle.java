package com.gmail.wildekatertz;

public class Circle extends Shape {

	private Point pointOne;
	private Point pointTwo;

	public Circle() {
		super();
	}

	public Circle(Point pointOne, Point pointTwo) {
		super();
		this.pointOne = pointOne;
		this.pointTwo = pointTwo;
	}

	public Point getPointOne() {
		return pointOne;
	}

	public void setPointOne(Point pointOne) {
		this.pointOne = pointOne;
	}

	public Point getPointTwo() {
		return pointTwo;
	}

	public void setPointTwo(Point pointTwo) {
		this.pointTwo = pointTwo;
	}

	@Override
	public double getPerimeter() {
		double perimeter;
		perimeter = 2 * Math.PI * Point.pointDistanñe(pointOne, pointTwo);
		return perimeter;
	}

	@Override
	public double getArea() {
		double area;
		area = Math.PI * Math.pow(Point.pointDistanñe(pointOne, pointTwo), 2);
		return area;
	}

	@Override
	public String toString() {
		return "Circle [pointOne=" + pointOne + ", pointTwo=" + pointTwo + "]";
	}

}
