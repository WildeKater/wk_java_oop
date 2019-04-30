package com.gmail.wildekatertz;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		String pathFromDir = ".\\testDirFrom";
		String pathToDir = ".\\testDirTo";

		long tstart = System.currentTimeMillis();
		try {
			MultiThreadCopyDir.dirCopy(pathFromDir, pathToDir, 2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - MultiThread metod copy");

		tstart = System.currentTimeMillis();
		try {
			CopyDir.copyDir(pathFromDir, pathToDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - SingleThread metod copy");

	}

}
