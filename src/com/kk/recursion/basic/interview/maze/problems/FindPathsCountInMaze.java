package com.kk.recursion.basic.interview.maze.problems;

public class FindPathsCountInMaze {

	public static void main(String[] args) {
		System.out.println(countPaths(3, 3));
	}

	private static int countPaths(int row, int col) {

		if (row == 1 || col == 1) {

			return 1;
		}

		int left = countPaths(row - 1, col);
		int right = countPaths(row, col - 1);

		return left + right;
	}

}
