package com.gmail.wildekatertz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Vocabulary {

	HashMap<String, String> vocabulary = new HashMap<String, String>();
	String vocabularyPath;

	public Vocabulary() {
		super();
	}

	public Vocabulary(String vocabularyPath) {
		super();
		this.vocabularyPath = vocabularyPath;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(this.vocabularyPath)))) {
			String rd = "";
			for (; (rd = br.readLine()) != null;) {
				String[] tmpStr = rd.split(",");
				this.vocabulary.put(tmpStr[0].toLowerCase(), tmpStr[1].toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getVocabularyPath() {
		return vocabularyPath;
	}

	public HashMap<String, String> getVocabulary() {
		return vocabulary;
	}

	public void addWord(String englishWord, String translateWord) {

		if (!this.vocabulary.containsKey(englishWord.toLowerCase())) {
			this.vocabulary.put(englishWord.toLowerCase(), translateWord.toLowerCase());
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(this.vocabularyPath), true))) {
				bw.write(System.lineSeparator() + englishWord.toLowerCase() + "," + translateWord.toLowerCase());
				System.out.println("Слово " + englishWord.toLowerCase() + " добавлено в словарь");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Слово " + englishWord.toLowerCase() + " уже есть в словаре");
		}

	}

}
