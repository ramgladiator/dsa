package com.kk.recursion.basic.subsetsubseuqnce.problems;

import java.util.ArrayList;

public class SubsetOrCombinationsWithArraylist {

	public static void main(String[] args) {

		ArrayList<String> subset = subset("abc", "");

		System.out.println(subset);

	}

	private static ArrayList<String> subset(String unProcessed, String processed) {

		if (unProcessed.isEmpty()) {

			ArrayList<String> list = new ArrayList<String>();
			list.add(processed);
			return list;
		}

		char ch = unProcessed.charAt(0);
		ArrayList<String> list1 = subset(unProcessed.substring(1), processed + ch);
		list1.addAll(subset(unProcessed.substring(1), processed));

		return list1;

	}

}
