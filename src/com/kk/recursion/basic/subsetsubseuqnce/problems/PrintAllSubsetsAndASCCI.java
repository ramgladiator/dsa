package com.kk.recursion.basic.subsetsubseuqnce.problems;

public class PrintAllSubsetsAndASCCI {

	public static void main(String[] args) {
		
		printAscii("abc", "");

	}

	private static void printAscii(String unprocessed, String processed) {

		if (unprocessed.isEmpty()) {
			System.out.println(processed);
			return;
		}

		char ch = unprocessed.charAt(0);
		printAscii(unprocessed.substring(1), processed + ch);
		printAscii(unprocessed.substring(1), processed);
		printAscii(unprocessed.substring(1), processed + (ch + 0));
	}

}
