package com.kk.recursion.basic.level1.questions;

public class ReverseNumberUsingThirdVariable {

	public static void main(String[] args) {
		reverse(1283);
		System.out.println("Reverse a number is " + sum);
	}

	static int sum = 0;

	private static void reverse(int n) {

		if (n == 0) {
			return;
		}

		sum = sum * 10 + n % 10;

		reverse(n / 10);

	}

}
