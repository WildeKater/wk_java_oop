package com.gmail.wildekatertz;

public class Main {

	public static void main(String[] args) {

		Vocabulary myVocabulary = new Vocabulary("vocabulary.txt");
		System.out.println(myVocabulary.getVocabularyPath());
		System.out.println(myVocabulary.getVocabulary());

		myVocabulary.addWord("Winter", "зима");
		myVocabulary.addWord("Winter", "зима");
		System.out.println(myVocabulary.getVocabulary());
		
		System.out.println();
		
		Translation.translate(myVocabulary);
	}

}
