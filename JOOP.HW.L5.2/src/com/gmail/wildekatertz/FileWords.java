package com.gmail.wildekatertz;

import java.io.*;

public class FileWords {

	public static String[] wordsInFile(String fileIn) {
		String str = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
			String hStr = "";
			for (; (hStr = br.readLine()) != null;) {
				str += " " + hStr;
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return clearString(str).split(" ");
	}

	private static String clearString(String str) {
		String cs = str;
		cs = str.toLowerCase();
		cs = cs.trim();
		char[] ch = cs.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (((ch[i] >= 'a') && (ch[i] <= 'ÿ')) || ((ch[i] >= 'a') && (ch[i] <= 'z'))) {

			} else {
				ch[i] = ' ';
			}
		}

		cs = String.copyValueOf(ch);

		for (;;) {
			if (cs.indexOf("  ") != -1) {
				cs = cs.replaceAll("  ", " ");
			} else {
				break;
			}
		}
		return cs;
	}

}
