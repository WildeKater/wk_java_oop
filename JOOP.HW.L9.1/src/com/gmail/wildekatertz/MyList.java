package com.gmail.wildekatertz;

import java.util.*;

public class MyList {

	public static void createList() {
		List<Integer> newList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			newList.add(new Random().nextInt(100));
		}

		System.out.println("��������� ������");
		System.out.println(newList);

		newList.remove(0);
		newList.remove(0);
		newList.remove(newList.size() - 1);

		System.out.println("������ ����� �������� ������ ���� � ���������� ���������");
		System.out.println(newList);

	}

}
