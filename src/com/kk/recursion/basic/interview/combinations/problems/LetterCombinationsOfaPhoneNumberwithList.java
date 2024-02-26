package com.kk.recursion.basic.interview.combinations.problems;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/?tab=Submission
public class LetterCombinationsOfaPhoneNumberwithList {

	public static void main(String[] args) {

		List<String> letterCombinations = letterCombinations("23");
		for(String s:letterCombinations) {
			System.out.println(s);
		}

	}

	public static List<String> letterCombinations(String digits) {

		return phonePad("", digits);
	}

	private static List<String> phonePad(String processed, String unProcessed) {

		if (unProcessed.isEmpty()) {

			List<String> list = new ArrayList<>();
			list.add(processed);
			return list;
		}
		int digit = unProcessed.charAt(0) - '0';//to convert string num to integer
		List<String> ans = new ArrayList<>();

		for (int i = (digit - 1) * 3; i < digit * 3; i++) {

			char ch = (char) ('a' + i);
			ans.addAll(phonePad(processed + ch, unProcessed.substring(1)));
		}

		return ans;
	}
}
