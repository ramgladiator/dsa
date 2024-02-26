package com.kk.recursion.basic.level1.questions;

public class ReverseNumberWithoutUsingThirdVariable {

	public static void main(String[] args) {

		int reverse = reverse(12343);
		System.out.println("Revers of an number" + reverse);

	}

	private static int reverse(int n) {

		int digits = (int) (Math.log10(n)) + 1;

		return helper(n, digits);

	}

	private static int helper(int n, int digits) {

		if (n % 10 == n) {
			return n;
		}

		int rem = n % 10;
		return (int) (rem * Math.pow(10, digits - 1) + helper(n / 10, digits - 1));
	}

}
