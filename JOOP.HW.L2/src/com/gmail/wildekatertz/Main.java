package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		Point pointOne = new Point(1.4, 7.2);
		Point pointTwo = new Point(3.5, 6.7);

		Circle circleOne = new Circle(pointOne, pointTwo);
		System.out.println(circleOne);
		System.out.println("Perimeter = " + circleOne.getPerimeter());
		System.out.println("Area = " + circleOne.getArea());
		
		System.out.println();
		
		Point pointThree = new Point(0,0);
		Point pointFour = new Point(4,4);
		Point pointFive = new Point(8,0);
		
		Triangle triangleOne = new Triangle (pointThree,pointFour,pointFive);
		System.out.println(triangleOne);
		System.out.println("Perimeter = " + triangleOne.getPerimeter());
		System.out.println("Area = " + triangleOne.getArea());		
		
		Point pointSix = new Point(0,0);
		Point pointSeven = new Point(7,0);
		Point pointEight = new Point(7,4);
		Point pointNine = new Point(0,4);
	
		System.out.println();
		
		Rectangle rectangleOne = new Rectangle (pointSix,pointSeven,pointEight,pointNine);
		System.out.println(rectangleOne);
		System.out.println("Perimeter = " + rectangleOne.getPerimeter());
		System.out.println("Area = " + rectangleOne.getArea());	
		
		System.out.println();
		
		Board boardOne = new Board(circleOne,triangleOne,rectangleOne,null);
		System.out.println(boardOne);
		
		System.out.println();
		
		boardOne.setShapeOne(null);
		System.out.println(boardOne);
		
	}

}
