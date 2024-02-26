package com.kk.recursion.basic.interview.maze.backtracking.problems;

//Stack Overflow exception
public class MazeAllPathsMarkAsVisited {

	public static void main(String[] args) {

		boolean[][] board = { { true, true, true }, { true, false, true }, { true, true, true } };

		allPaths("", board, 0, 0);
	}

	private static void allPaths(String processed, boolean[][] maze, int row, int col) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {

			System.out.println(processed);
			return;
		}

		if (!maze[row][col]) {
			return;
		}
		// just marking visited cells with false but it will create problem for future
		// recursion calls since we are modifying original array
		maze[row][col] = false;

		if (row < maze.length - 1) {
			allPaths(processed + "D", maze, row + 1, col);
		}

		if (col < maze[0].length - 1) {
			allPaths(processed + "R", maze, row, col + 1);
		}
		if (row > 0) {
			allPaths(processed + "U", maze, row - 1, col);

		}
		if (col > 0) {
			allPaths(processed + "L", maze, row, col - 1);

		}

	}

}
