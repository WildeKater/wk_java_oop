package com.gmail.wildekatertz;

import java.io.File;
import java.io.IOException;

public class SingleFileCopy implements Runnable {
	private File[] array;
	private int begin;
	private int end;
	private Thread thr;
	private File fromDir;
	private File toDir;

	public SingleFileCopy() {
		super();
	}

	public SingleFileCopy(File[] array, int begin, int end, File fromDir, File toDir) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		this.fromDir = fromDir;
		this.toDir = toDir;
		thr = new Thread(this);
		thr.start();
	}

	public Thread getThr() {
		return thr;
	}

	@Override
	public void run() {
		for (int i = begin; i < end; i++) {
			String newPath = array[i].getPath().replace(fromDir.getPath(), toDir.getPath());
			try {
				IOStream.fileCopy(array[i], new File(newPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(array[i].getPath() + " copy to " + newPath + " size " + array[i].length() + " B");
		}
	}
}
