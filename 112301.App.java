package com.pnb;

import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while (true) {
			int num=scanner.nextInt();
			if (num==1) {
				System.out.println((int)(Math.random()*100)+","+(int)(Math.random()*100));
			}
		}

	}

}
