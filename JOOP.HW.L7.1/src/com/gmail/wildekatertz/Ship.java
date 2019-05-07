package com.gmail.wildekatertz;

public class Ship implements Runnable {

	private String shipName;
	private int cargo;

	public Ship() {
		super();
	}

	public Ship(String shipName, int cargo) {
		super();
		this.shipName = shipName;
		this.cargo = cargo;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	@Override
	public void run() {
		System.out.println("��������� ������� " + this.shipName + " ��������");
		for (int i = 0; i < this.cargo; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�� ������� " + this.shipName + " �������� ���������� " + (this.cargo - i) + " ������");
		}
		System.out.println("��������� ������� " + this.shipName + " ��������");
	}

	@Override
	public String toString() {
		return "Ship [shipName=" + shipName + ", cargo=" + cargo + "]";
	}

}
