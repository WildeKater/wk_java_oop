package com.gmail.wildekatertz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TextAnalysis {

	public static void analyze(String filename) {

		char[] fileChar = getLettersArray(filename);

		List<Letter> letterList = getLettersList(fileChar);

		letterList = sortListLetters(letterList);

		for (Letter i : letterList) {
			System.out.println(i.getName() + " " + i.getNumber());
		}

	}

	private static char[] getLettersArray(String filename) {
		String fileString = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String text = null;
			for (; (text = br.readLine()) != null;) {
				fileString += " " + text;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		fileString = fileString.toLowerCase();
		char[] fileChar = fileString.toCharArray();

		return fileChar;
	}

	private static List<Letter> getLettersList(char[] fileChar) {
		List<Letter> letterList = new ArrayList();
		for (char i : fileChar) {
			if (i >= 'a' && i <= 'z') {
				Letter tmp = new Letter(String.valueOf(i), 0);
				if (!letterList.contains(tmp)) {
					letterList.add(tmp);
				}
			}
		}

		for (Letter i : letterList) {
			for (char j : fileChar) {
				if (i.getName().equals(String.valueOf(j))) {
					i.setNumber(i.getNumber() + 1);
				}
			}
		}
		return letterList;
	}

	private static List<Letter> sortListLetters(List<Letter> letterList) {
		Collections.sort(letterList, new Comparator<Letter>() {
			public int compare(Letter l1, Letter l2) {
				return l2.getNumber() - l1.getNumber();
			}
		});
		return letterList;
	}

}
