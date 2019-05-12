package com.gmail.wildekatertz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Translation {

	public static void translate(Vocabulary myVocabulary) {
		String inputText = "";
		try (BufferedReader br = new BufferedReader(new FileReader(new File("English.in.txt")))) {
			String rd = "";
			for (; (rd = br.readLine()) != null;) {
				inputText = inputText + " " + rd;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arrInputText = inputText.trim().split(" ");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Ukrainian.out.txt")))) {
			for (int i = 0; i < arrInputText.length; i++) {
				if (myVocabulary.getVocabulary().containsKey(arrInputText[i].toLowerCase())) {
					bw.write(myVocabulary.getVocabulary().get(arrInputText[i]) + " ");
				} else {
					bw.write(arrInputText[i] + " ");
					System.out.println("C���� " + arrInputText[i] + " ����������� � �������");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
