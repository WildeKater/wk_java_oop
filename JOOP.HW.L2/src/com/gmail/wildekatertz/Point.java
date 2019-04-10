package com.gmail.wildekatertz;

public class Point {

	private double x;
	private double y;

	public Point() {
		super();
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public static double pointDistanñe(Point pointOne, Point pointTwo) {
		double distance;
		distance = Math.sqrt(
				Math.pow((pointTwo.getX() - pointOne.getX()), 2) + Math.pow((pointTwo.getY() - pointOne.getY()), 2));
		return distance;
	}

}
