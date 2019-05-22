package com.gmail.wildekatertz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ParseLink {

	public static void parseLink(String url) throws IOException {
		URL urlCon = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) urlCon.openConnection();
		System.out.println("Содержащиеся сссылки:");
		try (InputStream is = connection.getInputStream()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String temp = "";
			for (; (temp = br.readLine()) != null;) {
				if (findURL(temp) != null) {
//					System.out.println(temp);
					System.out.println(findURL(temp));
				}
			}
		} catch (IOException e) {
			throw e;
		}
	}

	private static String findURL(String str) {
		String url = null;
		if (str.lastIndexOf("href=" + '"'+"http") != -1) {
			String tmp = str.substring(str.lastIndexOf("href=" + '"') + 6, str.length());
			tmp = tmp.substring(0, tmp.indexOf('"'));
			url = tmp;
		}
		return url;

	}

}
