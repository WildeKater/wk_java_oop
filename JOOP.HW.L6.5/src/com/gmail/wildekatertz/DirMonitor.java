package com.gmail.wildekatertz;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DirMonitor implements Runnable {

	private File[] fileList;
	private String path;
	private Thread thr;

	public DirMonitor() {
		super();
	}

	public DirMonitor(String path) {
		super();
		this.path = path;
		thr = new Thread(this);
		fileList = new File(path).listFiles();
		// thr.start();
		setFileList(new File(path).listFiles());
	}

	public void setFileList(File[] fileList) {
		this.fileList = fileList;
	}

	public Thread getThr() {
		return thr;
	}

	@Override
	public void run() {
		for (;;) {
			List<File> oldList = new ArrayList<File>(Arrays.asList(fileList));
			List<File> newList = new ArrayList<File>(Arrays.asList(new File(path).listFiles()));
			for (File i : oldList) {
				if ((!newList.contains(i)) && (i != null)) {
					System.out.println(logDateTime()+" file " + i.getPath() + " delete");
				}
			}
			for (File i : newList) {
				if (!oldList.contains(i)) {
					System.out.println(logDateTime()+" file " + i.getPath() + " add");
				}
			}
			setFileList(newList.toArray(fileList));
			try {
				thr.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private String logDateTime() {
		Date nDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		return sdf.format(nDate);
	}

}
