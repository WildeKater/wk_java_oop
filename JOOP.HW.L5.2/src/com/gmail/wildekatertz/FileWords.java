package com.gmail.wildekatertz;

import java.io.*;

public class FileWords {

	public static String[] wordsInFile(String fileIn) {
		String[] wordsArray;
		String str2 = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
			String str = "";
			for (; (str = br.readLine()) != null;) {
				str2 += " " + str;
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		str2 = str2.toLowerCase();
		str2 = str2.trim();

		char[] ch = str2.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (((ch[i] >= 'a') && (ch[i] <= 'ÿ')) || ((ch[i] >= 'a') && (ch[i] <= 'z'))) {

			} else {
				ch[i] = ' ';
			}
		}

		str2 = String.copyValueOf(ch);

		for (;;) {
			if (str2.indexOf("  ") != -1) {
				str2 = str2.replaceAll("  ", " ");
			} else {
				break;
			}
		}

		wordsArray = str2.split(" ");
		return wordsArray;
	}

}
