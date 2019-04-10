package com.gmail.wildekatertz;

public class Rectangle extends Shape {

	private Point pointOne;
	private Point pointTwo;
	private Point pointThree;
	private Point pointFour;

	public Rectangle() {
		super();
	}

	public Rectangle(Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
		super();
		this.pointOne = pointOne;
		this.pointTwo = pointTwo;
		this.pointThree = pointThree;
		this.pointFour = pointFour;
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

	public Point getPointThree() {
		return pointThree;
	}

	public void setPointThree(Point pointThree) {
		this.pointThree = pointThree;
	}

	public Point getPointFour() {
		return pointFour;
	}

	public void setPointFour(Point pointFour) {
		this.pointFour = pointFour;
	}

	@Override
	public double getPerimeter() {
		double perimeter;
		perimeter = 2 * (Point.pointDistanñe(pointOne, pointTwo) + Point.pointDistanñe(pointTwo, pointThree));
		return perimeter;
	}

	@Override
	public double getArea() {
		double area;
		area = Point.pointDistanñe(pointOne, pointTwo) * Point.pointDistanñe(pointTwo, pointThree);
		return area;
	}

	@Override
	public String toString() {
		return "Rectangle [pointOne=" + pointOne + ", pointTwo=" + pointTwo + ", pointThree=" + pointThree
				+ ", pointFour=" + pointFour + "]";
	}

}
