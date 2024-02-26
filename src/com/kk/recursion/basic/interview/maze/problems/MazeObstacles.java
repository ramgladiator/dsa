package com.kk.recursion.basic.interview.maze.problems;

import java.util.ArrayList;
import java.util.List;

public class MazeObstacles {

	public static void main(String[] args) {

		boolean[][] board = { { true, true, true }, { true, false, true }, { true, true, true } };

		mazeObstacles("", board, 0, 0);
	}

	private static void mazeObstacles(String processed, boolean[][] maze, int row, int col) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {

			System.out.println(processed);
			return;
		}

		if (!maze[row][col]) {
			return;
		}

		if (row < maze.length - 1) {
			mazeObstacles(processed + "D", maze, row + 1, col);
		}

		if (col < maze[0].length - 1) {
			mazeObstacles(processed + "R", maze, row, col + 1);
		}

	}

}
