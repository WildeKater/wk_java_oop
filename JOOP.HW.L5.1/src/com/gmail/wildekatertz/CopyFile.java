package com.gmail.wildekatertz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class CopyFile {

	public static void copyFile(File inFile, File outFile) {

		try (FileInputStream fis = new FileInputStream(inFile); FileOutputStream fos = new FileOutputStream(outFile)) {

			byte[] buffer = new byte[1024];
			int byteread = 0;
			for (; (byteread = fis.read(buffer)) > 0;) {
				fos.write(buffer, 0, byteread);
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
