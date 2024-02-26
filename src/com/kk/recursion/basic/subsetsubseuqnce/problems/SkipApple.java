package com.kk.recursion.basic.subsetsubseuqnce.problems;

public class SkipApple {

	public static void main(String[] args) {

		String str = "bcappleddef";
		String skip = "apple";

		String skip2 = skip(str, skip);
		System.out.println("After skip is " + skip2);

	}

	private static String skip(String up, String skip) {

		if (up.isEmpty()) {
			return up;
		}

		if (up.startsWith(skip)) {
			return skip(up.substring(skip.length()), skip);
		} else {
			return up.charAt(0) + skip(up.substring(1), skip);
		}

	}

}
