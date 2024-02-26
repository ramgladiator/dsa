package com.kk.recursion.basic.interview.combinations.problems;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/?tab=Submission
public class LetterCombinationsOfaPhoneNumber {

	public static void main(String[] args) {
     
		letterCombinations("23");
		
	}

	public static void letterCombinations(String digits) {

		phonePad("", digits);
	}

	private static void phonePad(String processed, String unProcessed) {

		if (unProcessed.isEmpty()) {

			System.out.println(processed);
			return;
		}
		int digit = unProcessed.charAt(0) - '0';

		for (int i = (digit - 1) * 3; i < digit * 3; i++) {

			char ch = (char) ('a' + i);
			phonePad(processed+ch, unProcessed.substring(1));
		}

	}
}
