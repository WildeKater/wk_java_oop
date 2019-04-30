package com.gmail.wildekatertz;

import java.io.File;
import java.io.IOException;

public class MultiThreadCopyDir {

	static void dirCopy(String pathFromDir, String pathToDir, int threadNumber) throws IOException {

		SingleFileCopy[] threadarray = new SingleFileCopy[threadNumber];

		File fromDir = new File(pathFromDir);
		File toDir = new File(pathToDir);

		if (fromDir == null || toDir == null) {
			throw new IllegalArgumentException();
		}

		File[] filelist = fromDir.listFiles();

		for (int i = 0; i < threadarray.length; i++) {
			int size = filelist.length / threadNumber;
			int begin = size * i;
			int end = (i + 1) * size;
			if ((filelist.length - end) < size) {
				end = filelist.length;
			}
			threadarray[i] = new SingleFileCopy(filelist, begin, end, fromDir, toDir);
		}

		for (int i = 0; i < threadarray.length; i++) {
			try {
				threadarray[i].getThr().join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

	}

}
