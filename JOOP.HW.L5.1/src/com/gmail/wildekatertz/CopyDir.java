package com.gmail.wildekatertz;

import java.io.File;
import java.io.IOException;

public class CopyDir {

	public static void copyDir(String pathFromDir, String pathToDir, String fileFilter) throws IOException {

		File fromDir = new File(pathFromDir);
		File toDir = new File(pathToDir);
		MyFileFilter mFF = new MyFileFilter(fileFilter);

		if (fromDir == null || toDir == null) {
			throw new IllegalArgumentException();
		}

		File[] filelist = fromDir.listFiles(mFF);
		for (int i = 0; i < filelist.length; i++) {
			String newPath = filelist[i].getPath().replace(fromDir.getPath(), toDir.getPath());
			IOStream.fileCopy(filelist[i], new File(newPath));
			System.out.println(filelist[i].getPath() + " copy to " + newPath + " size " + filelist[i].length() + " B");
		}

	}

}
