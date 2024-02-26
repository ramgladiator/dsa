package com.kk.recursion.basic.level1.questions;

public class PrintNumbers1toN {
	public static void main(String[] args) {
		print(5);
	}

	private static void print(int n) {

		if (n ==0) {
			return;
		}

		print(n-1);
		System.out.println("printinf numbers "+n);

	}

}
