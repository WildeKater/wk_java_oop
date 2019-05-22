package com.gmail.wildekatertz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinksCheck {

	public static void checkLinks(String fileName) {
		File file = new File(fileName);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String link = null;
			for (; (link = br.readLine()) != null;) {
				System.out.println(linkStatus(link));
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	private static String linkStatus(String link) throws IOException {
		String status;
		URL urlCon = new URL(link);
		HttpURLConnection connection = (HttpURLConnection) urlCon.openConnection();
		if ( connection.getResponseCode() == 200) {
			status = "ok";
		} else {
			status = "not ok";
		}
		return link + " => " + status + " code[" + connection.getResponseCode() + "]";
	}

}
