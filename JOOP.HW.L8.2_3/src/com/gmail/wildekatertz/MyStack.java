package com.gmail.wildekatertz;

import java.util.Arrays;

public class MyStack {

	private Object[] stackArray;
	private StackBlackList stackBlackList;

	private int stackSize = 2;
	private int stackLoad = -1;

	public MyStack() {
		super();
		this.stackArray = new Object[stackSize];
		this.stackBlackList = new StackBlackList();
	}

	public void stackPush(Object obj) {
		if (!stackBlackList.checkBlackList(obj)) {
			stackLoad++;
			stackResize();
			stackArray[stackLoad] = obj;
			System.out.println("������� " + obj + " ��������");
		} else {
			System.out.println("����� " + obj.getClass() + " ������� " + obj + " � ������ ������");
		}
	}

	public Object stackPop() {
		if (stackLoad != -1) {
			Object popEl = stackArray[stackLoad];
			stackArray[stackLoad] = null;
			stackLoad--;
			System.out.println("������� " + popEl + " ��������");
			return popEl;
		} else {
			System.out.println("���� ������");
			return null;
		}
	}

	public Object stackLook() {
		if (stackLoad != -1) {
			System.out.println("������� ������� ����� " + stackArray[stackLoad]);
			return stackArray[stackLoad];
		} else {
			System.out.println("���� ������");
			return null;
		}
	}

	private void stackResize() {
		if (stackLoad == stackSize) {
			stackSize *= 1.5;
			Object[] newStackArray = Arrays.copyOf(stackArray, stackSize);
			this.stackArray = newStackArray;
		}
	}

	public int getStackSize() {
		return stackSize;
	}

	public int getStackLoad() {
		return stackLoad + 1;
	}

	@Override
	public String toString() {
		String stackString = "";
		stackString = stackString + "MyStack" + System.lineSeparator();
		stackString = stackString + "Stack size = " + this.stackSize + System.lineSeparator();
		stackString = stackString + "Stack load = " + (this.stackLoad + 1) + System.lineSeparator();
		if (stackLoad != -1) {
			for (int i = 0; i <= stackLoad; i++) {
				stackString = stackString + "������� " + (i + 1) + " " + stackArray[i] + System.lineSeparator();
			}
		}
		return stackString;
	}

	public void addToBlackList(Class<?> clasName) {
		stackBlackList.addToBlackList(clasName);
		System.out.println("����� " + clasName + " �������� � ������ ������");
	}

}
