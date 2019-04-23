package com.gmail.wildekatertz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepeatWords {

	private static String[] unicWords(String[] str1, String[] str2) {

		List<String> uWordsList = new ArrayList<String>();

		for (String i : str1) {
			for (String j : str2) {
				if (i.equals(j)) {
					if (!uWordsList.contains(i)) {
						uWordsList.add(i);
					}
				}
			}
		}

		String[] unicWordsList = uWordsList.toArray(new String[uWordsList.size()]);

		return unicWordsList;
	}

	public static void unicWords(String firstFile, String secondFile, String fileOut) {

		String[] str1 = FileWords.wordsInFile(firstFile);
		String[] str2 = FileWords.wordsInFile(secondFile);

		String[] outp = unicWords(str1, str2);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut))) {
			for (String i : outp) {
				bw.write(i);
				bw.newLine();
			}
			System.out.println("Найдено " + outp.length + " повторяющихся слов");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
