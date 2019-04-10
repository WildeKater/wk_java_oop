package com.gmail.wildekatertz;

public class Board {

	private Shape shapeOne;
	private Shape shapeTwo;
	private Shape shapeThree;
	private Shape shapeFour;
	private Shape[] newBoard = new Shape[4];

	public Board() {
		super();
	}

	public Board(Shape shapeOne, Shape shapeTwo, Shape shapeThree, Shape shapeFour) {
		super();
		this.shapeOne = shapeOne;
		this.shapeTwo = shapeTwo;
		this.shapeThree = shapeThree;
		this.shapeFour = shapeFour;
	}

	public Shape getShapeOne() {
		return shapeOne;
	}

	public void setShapeOne(Shape shapeOne) {
		this.shapeOne = shapeOne;
	}

	public Shape getShapeTwo() {
		return shapeTwo;
	}

	public void setShapeTwo(Shape shapeTwo) {
		this.shapeTwo = shapeTwo;
	}

	public Shape getShapeThree() {
		return shapeThree;
	}

	public void setShapeThree(Shape shapeThree) {
		this.shapeThree = shapeThree;
	}

	public Shape getShapeFour() {
		return shapeFour;
	}

	public void setShapeFour(Shape shapeFour) {
		this.shapeFour = shapeFour;
	}

	private void filBoard() {
		newBoard[0] = shapeOne;
		newBoard[1] = shapeTwo;
		newBoard[2] = shapeThree;
		newBoard[3] = shapeFour;
	}

	public double areaBoard() {
		double boardArea = 0;
		filBoard();
		for (int i = 0; i < newBoard.length; i++) {
			if (newBoard[i] != null) {
				boardArea = boardArea + newBoard[i].getArea();
			}
		}
		return boardArea;
	}

	@Override
	public String toString() {
		filBoard();
		String s = "Board [ "+ "\n";
		for (int i = 0; i < newBoard.length; i++) {
			if (newBoard[i] != null) {
				s = s + newBoard[i].toString()+","+ "\n";
			}
		}

		s = s + "boardArea=" + areaBoard() + "]";
		return s;
	}
}
