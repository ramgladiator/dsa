package com.kk.recursion.basic.subsetsubseuqnce.problems;

public class SubsetsorCombinations {

	public static void main(String[] args) {
		
		subset("abc", "");

	}

	private static void subset(String unprocessed, String processed) {

		if (unprocessed.isEmpty()) {

			System.out.println(processed);
			return;
		}

		char ch = unprocessed.charAt(0);

		subset(unprocessed.substring(1), processed + ch);
		subset(unprocessed.substring(1), processed);

	}

}
