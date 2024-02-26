package com.kk.recursion.basic.interview.maze.problems;

import java.util.ArrayList;
import java.util.List;

public class FindDiagonalPaths {

	public static void main(String[] args) {

		List<String> diagonalPaths = diagonalPaths("", 3, 3);
		for (String string : diagonalPaths) {
			System.out.println(string);
		}
	}

	private static List<String> diagonalPaths(String processed, int row, int col) {

		if (row == 1 && col == 1) {

			ArrayList<String> list = new ArrayList<>();
			list.add(processed);
			return list;
		}
		
		List<String> list = new ArrayList<>();
		if(row>1 && col>1) {
			list.addAll(diagonalPaths(processed+"D", row-1, col-1));

		}
		
		if(row>1) {
			list.addAll(diagonalPaths(processed+"V", row-1, col));
		}

		
		if(col>1) {
			list.addAll(diagonalPaths(processed+"H", row, col-1));
		}

		return list;

	}

}
