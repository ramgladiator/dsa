package com.kk.recursion.basic.level1.questions;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class CountNumberOfSteps {

	public static void main(String[] args) {

		int numberOfSteps = numberOfSteps(14);
		System.out.println("Number of steps is needed " + numberOfSteps);

	}

	public static int numberOfSteps(int num) {

		return countSteps(num);

	}

	private static int countSteps(int n) {

		int count = 0;

		return helper(n, count);

	}

	private static int helper(int n, int count) {

		if (n == 0) {
			return count;
		}

		if (n % 2 == 0) {
			return helper(n / 2, count + 1);
		} else {
			return helper(n - 1, count + 1);
		}

	}

}
