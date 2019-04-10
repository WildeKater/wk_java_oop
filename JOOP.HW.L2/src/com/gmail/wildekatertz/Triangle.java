package com.gmail.wildekatertz;

public class Triangle extends Shape {

	private Point pointOne;
	private Point pointTwo;
	private Point pointThree;

	public Triangle() {
		super();
	}

	public Triangle(Point pointOne, Point pointTwo, Point pointThree) {
		super();
		this.pointOne = pointOne;
		this.pointTwo = pointTwo;
		this.pointThree = pointThree;
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

	@Override
	public double getPerimeter() {
		double perimeter;
		perimeter = Point.pointDistan�e(pointOne, pointTwo) + Point.pointDistan�e(pointTwo, pointThree)
				+ Point.pointDistan�e(pointThree, pointOne);
		return perimeter;
	}

	@Override
	public double getArea() {
		double area;
		double p = (Point.pointDistan�e(pointOne, pointTwo) + Point.pointDistan�e(pointTwo, pointThree)
				+ Point.pointDistan�e(pointThree, pointOne)) / 2;
		area = Math.sqrt(p * (p - Point.pointDistan�e(pointOne, pointTwo))
				* (p - Point.pointDistan�e(pointTwo, pointThree)) * (p - Point.pointDistan�e(pointThree, pointOne)));
		return area;
	}

	@Override
	public String toString() {
		return "Triangle [pointOne=" + pointOne + ", pointTwo=" + pointTwo + ", pointThree=" + pointThree + "]";
	}



}
