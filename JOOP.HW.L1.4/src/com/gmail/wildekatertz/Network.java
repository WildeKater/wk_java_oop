package com.gmail.wildekatertz;

public class Network {
	private int[] phones;

	public Network() {
		super();
		this.phones = new int[10000];
	}

	public void connect(int number) {
		for (int i = 0; i < phones.length; i++) {
			if (phones[i] == 0) {
				phones[i] = number;
				break;
			}
		}
	}

	public void disconnect(int number) {
		for (int i = 0; i < phones.length; i++) {
			if (phones[i] == number) {
				phones[i] = 0;
			}
		}
	}

	public boolean checkPhone(int number) {
		for (int i = 0; i < phones.length; i++) {
			if (phones[i] == number) {
				return true;
			}
		}
		return false;
	}

}
