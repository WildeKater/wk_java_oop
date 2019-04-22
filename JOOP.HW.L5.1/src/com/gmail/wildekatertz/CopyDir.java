package com.gmail.wildekatertz;

import java.io.File;

public class CopyDir {

	public static void copyDir(String pathFromDir, String pathToDir, String fileFilter) {

		File fromDir = new File(pathFromDir);
		File toDir = new File(pathToDir);
		MyFileFilter mFF = new MyFileFilter(fileFilter);

		if (!(fromDir.isDirectory())) {
			System.out.println("Каталог " + fromDir + " не существует");
		} else if (!(toDir.isDirectory())) {
			System.out.println("Каталог " + fromDir + " не существует");
		} else {
			File[] filelist = fromDir.listFiles(mFF);
			for (int i = 0; i < filelist.length; i++) {
				String newPath = filelist[i].getPath().replace(fromDir.getPath(), toDir.getPath());
				CopyFile.copyFile(filelist[i], new File(newPath));
				System.out.println(
						filelist[i].getPath() + " copy to " + newPath + " size " + filelist[i].length() + " B");
			}
		}
	}

}
