package com.kk.recursion.basic.interview.maze.problems;

public class ReturnMazepaths {

	public static void main(String[] args) {

		printPaths("", 3, 3);

	}

	private static void printPaths(String processed, int row, int col) {

		if (row == 1 && col == 1) {

			System.out.println(processed);
			return;
		}
		
		if (col > 1)
			printPaths(processed + "R", row, col - 1);


		if (row > 1)
			printPaths(processed + "D", row - 1, col);

		
	}

}
