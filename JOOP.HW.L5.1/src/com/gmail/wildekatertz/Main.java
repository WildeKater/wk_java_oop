package com.gmail.wildekatertz;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		String pathFromDir = ".\\testDirFrom";
		String pathToDir = ".\\testDirTo";
		String fileFilter = "docx";

		try {
			CopyDir.copyDir(pathFromDir, pathToDir, fileFilter);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
