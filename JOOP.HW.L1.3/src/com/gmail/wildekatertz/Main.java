package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		Vector3d a = new Vector3d(1, 2, 3);
		Vector3d b = new Vector3d(2, 4, 6);

		System.out.println("Первый вектор");
		System.out.println(a.toString());
		System.out.println("Второй вектор");
		System.out.println(b.toString());

		Vector3d c = new Vector3d();
		c = c.sumVector3d(a, b);
		System.out.println("Сумма векторов");
		System.out.println(c.toString());
		System.out.println("Скалярное произведение векторов");
		System.out.println(Vector3d.scalarProductVector3d(a, b));
		System.out.println("Векторное произведение векторов");
		c = c.vectorProductVector3d(a, b);
		System.out.println(c.toString());
	}

}
