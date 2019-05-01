package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {
		
		DirMonitor dm = new DirMonitor("test");
		dm.getThr().start();

	}

}
