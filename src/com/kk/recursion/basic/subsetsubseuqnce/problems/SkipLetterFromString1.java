package com.kk.recursion.basic.subsetsubseuqnce.problems;

import java.util.ArrayList;

public class SkipLetterFromString1 {

	public static void main(String[] args) {

		String up = "baccad";
		String pr = "";

		ArrayList<String> skip = skip(pr, up, 'a');

		System.out.println("skip atrinf is " + skip);

	}

	private static ArrayList<String> skip(String processed, String unProcessed, char skip) {

		if (unProcessed.isEmpty()) {

			ArrayList<String> up = new ArrayList<String>();
			up.add(processed);

			return up;

		}

		// ArrayList<String> pr = new ArrayList<String>();

		char ch = unProcessed.charAt(0);

		if (ch == skip) {

			return skip(processed, unProcessed.substring(1), skip);
		} else {
			return skip(processed + ch, unProcessed.substring(1), skip);
		}

	}

}
