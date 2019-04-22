package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		String pathFromDir = ".\\testDirFrom";
		String pathToDir = ".\\testDirTo";
		String fileFilter = "docx";

		CopyDir.copyDir(pathFromDir, pathToDir, fileFilter);

	}

}
