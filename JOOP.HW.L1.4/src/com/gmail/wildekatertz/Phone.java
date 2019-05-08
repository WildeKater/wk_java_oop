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
		System.out.println("Телефон "+number+" зарегистрирован в сети");
	}

	public void disconnect() {
		network.disconnect(number);
		System.out.println("Телефон "+number+" отключился от сети");
	}

	public void call(int number) {
		if (network.checkPhone(number)) {
			System.out.println("Звонок на номер " + number + " инициирован");
		} else {
			System.out.println("Звонок не инициирован. Телефон " + number + " не зарегистрирован в сети");
		}

	}

}
