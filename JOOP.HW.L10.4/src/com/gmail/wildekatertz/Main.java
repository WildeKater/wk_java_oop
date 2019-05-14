package com.gmail.wildekatertz;

import java.io.IOException;
import java.nio.file.*;

public class Main {

	public static void main(String[] args) {

		try {
			int max = Files.lines(Paths.get("nums.txt"))
					.map(n -> Integer.valueOf(n))
					.max(Integer::compare)
					.get();
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
