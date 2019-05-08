package com.gmail.wildekatertz;

public class Phone {
	private int number;
	private Network network;

	public Phone() {
		super();
	}

	public Phone(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void connect(Network network) {
		this.network = network;
		network.connect(number);
		System.out.println("������� "+number+" ��������������� � ����");
	}

	public void disconnect() {
		network.disconnect(number);
		System.out.println("������� "+number+" ���������� �� ����");
	}

	public void call(int number) {
		if (network.checkPhone(number)) {
			System.out.println("������ �� ����� " + number + " �����������");
		} else {
			System.out.println("������ �� �����������. ������� " + number + " �� ��������������� � ����");
		}

	}

}
