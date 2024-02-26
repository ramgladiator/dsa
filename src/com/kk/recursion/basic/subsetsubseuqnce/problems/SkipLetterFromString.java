package com.kk.recursion.basic.subsetsubseuqnce.problems;

public class SkipLetterFromString {

	public static void main(String[] args) {

		String processed = "";
		String unProcessed = "baccad";

		skip(processed, unProcessed, 'a');
		System.out.println("Processed string is " + processed);
	}

	private static void skip(String processed, String unProcessed, char skipLetter) {

		if (unProcessed.isEmpty()) {
			System.out.println(processed);
			return;
		}

		char ch = unProcessed.charAt(0);

		skip((ch == skipLetter) ? processed : processed + ch, unProcessed.substring(1), skipLetter);

		/*
		 * if(ch == skipLetter) skip(processed, unProcessed.substring(1), skipLetter);
		 * else skip(processed+ch, unProcessed.substring(1), skipLetter);
		 */

	}

}
