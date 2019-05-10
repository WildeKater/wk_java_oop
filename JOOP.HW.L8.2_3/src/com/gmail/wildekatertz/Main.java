package com.gmail.wildekatertz;

import java.io.File;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {

		MyStack ms = new MyStack();
		System.out.println(ms);

		System.out.println();

		Integer int1 = 1;
		String str1 = "dddd";
		File fl1 = new File("test.txt");

		BigInteger bi = BigInteger.valueOf(12352);
		System.out.println(bi.getClass());
		ms.addToBlackList(bi.getClass());

		BigInteger bi2 = BigInteger.valueOf(67284023);

		ms.stackPush(int1);
		ms.stackPush(str1);
		ms.stackPush(bi2);
		ms.stackPush(fl1);

		System.out.println();
		System.out.println(ms);

		System.out.println(ms.stackLook());
		System.out.println(ms.stackPop());
		System.out.println(ms.stackLook());

		System.out.println();

		System.out.println(ms);
		
		MyStack ms2 = new MyStack();
		System.out.println(ms2.stackPop());
		System.out.println(ms2.stackLook());

	}

}
