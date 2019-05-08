package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		Network networkOne = new Network();
		
		Phone phoneOne = new Phone(1111111);
		Phone phoneTwo = new Phone(2222222);
		Phone phonethree = new Phone(3333333);
		
		phoneOne.connect(networkOne);
		phoneTwo.connect(networkOne);
		phonethree.connect(networkOne);
		
		System.out.println();
		
		phoneTwo.disconnect();
		
		System.out.println();
		
		phoneOne.call(2222222);
		phoneOne.call(3333333);
		phoneOne.call(5555555);
		

	}

}
