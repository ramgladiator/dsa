package com.kk.recursion.basic.interview.combinations.problems;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/?tab=Submission
public class LetterCombinationsOfaPhoneNumberCount {

	public static void main(String[] args) {

		int letterCombinations = letterCombinations("23");
		System.out.println("Count is " + letterCombinations);
	}

	public static int letterCombinations(String digits) {

		return phonePad("", digits);
	}

	private static int phonePad(String processed, String unProcessed) {

		if (unProcessed.isEmpty()) {
          System.out.println(processed);
			return 1;
		}
		int digit = unProcessed.charAt(0) - '0';// to convert string num to integer
		int count = 0;

		for (int i = (digit - 1) * 3; i < digit * 3; i++) {

			char ch = (char) ('a' + i);
			count += phonePad(processed + ch, unProcessed.substring(1));
		}

		return count;
	}
}
