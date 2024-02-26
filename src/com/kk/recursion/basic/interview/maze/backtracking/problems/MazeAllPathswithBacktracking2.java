package com.kk.recursion.basic.interview.maze.backtracking.problems;

import java.util.Arrays;

//Stack Overflow exception
public class MazeAllPathswithBacktracking2 {

	public static void main(String[] args) {

		boolean[][] board = { { true, true, true }, { true, true, true }, { true, true, true } };

		int[][] path = new int[board.length][board[0].length];

		allPaths("", board, 0, 0, path, 1);
	}

	private static void allPaths(String processed, boolean[][] maze, int row, int col, int[][] path, int step) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			path[row][col] = step ;
			for (int[] is : path) {
				System.out.println(Arrays.toString(is));
			}
			System.out.println(processed);
			System.out.println();
			return;
		}

		if (!maze[row][col]) {
			return;
		}
		// I am considering this block in my path
		maze[row][col] = false;
		path[row][col] = step;

		if (row < maze.length - 1) {
			allPaths(processed + "D", maze, row + 1, col, path, step + 1);
		}

		if (col < maze[0].length - 1) {
			allPaths(processed + "R", maze, row, col + 1, path, step + 1);
		}
		if (row > 0) {
			allPaths(processed + "U", maze, row - 1, col, path, step + 1);

		}
		if (col > 0) {
			allPaths(processed + "L", maze, row, col - 1, path, step + 1);

		}

		// this line is where the function call is over
		// so before the function gets removed,also remove the changes that were made by
		// that function.
		maze[row][col] = true;
		path[row][col] = 0;
	}

}
