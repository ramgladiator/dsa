package com.kk.recursion.basic.level1.questions;

public class CountZeros {

	public static void main(String[] args) {
		int count = 0;
		int countZeros = countZeros(808801, count);
		System.out.println("Total zeros " + countZeros);

	}

	private static int countZeros(int n, int count) {

		return helper(n, count);

	}

	private static int helper(int n, int count) {

		if (n % 10 == n) {
			return count;
		}
		if (n % 10 == 0) {
			return countZeros(n / 10, count + 1);
		} else {
			return countZeros(n / 10, count);
		}
	}

}
