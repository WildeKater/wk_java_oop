package com.gmail.wildekatertz;

import java.util.*;

public class MyList {

	public static void createList() {
		List<Integer> newList = new ArrayList();

		Random rn = new Random();

		for (int i = 0; i < 10; i++) {
			newList.add(rn.nextInt(100));
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
