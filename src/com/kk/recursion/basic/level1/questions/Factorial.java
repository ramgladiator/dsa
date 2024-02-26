package com.kk.recursion.basic.level1.questions;

public class Factorial {

	public static void main(String[] args) {

		int findFactorial = findFactorial(5);
		System.out.println("facttorial of number" + findFactorial);
	}

	private static int findFactorial(int n) {

		if (n == 1) {
			return n;
		}

		return n * findFactorial(n - 1);

	}

}
