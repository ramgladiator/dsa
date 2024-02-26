package com.kk.recursion.basic.subsetsubseuqnce.problems;

import java.util.ArrayList;

public class SkipLetterFromString2 {

	public static void main(String[] args) {

		String up = "baccad";
		String pr = "";

		ArrayList<String> returnVal = new ArrayList<>();
		skip(pr, up, 'a', returnVal);
		System.out.println("Return value " + returnVal);

	}

	private static void skip(String pr, String up, char skip, ArrayList<String> unSkipped) {

		if (up.isEmpty()) {

			unSkipped.add(pr);
			return;
		}

		char ch = up.charAt(0);
		if (ch == skip) {
			skip(pr, up.substring(1), skip, unSkipped);
		} else {
			skip(pr + ch, up.substring(1), skip, unSkipped);
		}

	}

}
