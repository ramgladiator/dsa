package com.kk.recursion.basic.interview.maze.problems;

import java.util.ArrayList;
import java.util.List;

public class ReturnMazePathsWithlist {

	public static void main(String[] args) {
		
		List<String> paths = paths("", 3, 3);
		for(String path:paths) {
			System.out.println(path);
		}

	}

	private static List<String> paths(String processed, int row, int col) {

		if (row == 1 && col == 1) {

			ArrayList<String> list = new ArrayList<>();
			list.add(processed);
			return list;

		}

		List<String> list = new ArrayList<>();

		if (row > 1) {
			list.addAll(paths(processed + "D", row - 1, col));

		}

		if (col > 1) {
			list.addAll(paths(processed + "R", row, col - 1));
		}

		return list;
	}

}
