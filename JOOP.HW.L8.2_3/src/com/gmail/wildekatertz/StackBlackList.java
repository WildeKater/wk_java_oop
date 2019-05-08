package com.gmail.wildekatertz;

import java.util.Arrays;

public class StackBlackList {

	private Class<?>[] blackListArray;

	private int blackListSize = 2;
	private int blackListLoad = -1;

	public StackBlackList() {
		super();
		this.blackListArray = new Class<?>[blackListSize];
	}

	public void addToBlackList(Class<?> clasName) {
		blackListLoad++;
		blackListResize();
		blackListArray[blackListLoad] = clasName;
	}

	private void blackListResize() {
		if (blackListLoad == blackListSize) {
			blackListSize *= 1.5;
			Class<?>[] newBlackListArray = Arrays.copyOf(blackListArray, blackListSize);
			this.blackListArray = newBlackListArray;
		}
	}

	public boolean checkBlackList(Object obj) {
		if (blackListLoad == -1) {
			return false;
		}
		for (int i = 0; i <= blackListLoad; i++) {
			if (blackListArray[i].equals(obj.getClass())) {
				return true;
			}
		}
		return false;
	}
	
}
