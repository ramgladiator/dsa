package com.ik.graph.interview.problems.shortestpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders {

	private static final int BOARD_SIZE = 10 * 10; // n x n board size
	private static final int MAX_DICE_VALUE = 6;

	private Map<Integer, List<Integer>> adjacencyList;

	public SnakesAndLadders() {
		adjacencyList = new HashMap<>();

		// Initialize the adjacency list
		for (int i = 1; i <= BOARD_SIZE; i++) {
			adjacencyList.put(i, new ArrayList<>());
		}

		// Adding snakes and ladders on the board
		Map<Integer, Integer> addSnakeOrLadder = new HashMap<>();
		addSnakeOrLadder.put(14, 7);
		addSnakeOrLadder.put(19, 2);
		addSnakeOrLadder.put(22, 18);
		addSnakeOrLadder.put(43, 23);
		addSnakeOrLadder.put(55, 47);
		addSnakeOrLadder.put(65, 36);
		addSnakeOrLadder.put(72, 54);
		addSnakeOrLadder.put(88, 63);
		addSnakeOrLadder.put(95, 74);
		addSnakeOrLadder.put(98, 79);

		// Adding ladders on the board
		addSnakeOrLadder.put(4, 18);
		addSnakeOrLadder.put(9, 31);
		addSnakeOrLadder.put(20, 38);
		addSnakeOrLadder.put(28, 84);
		addSnakeOrLadder.put(40, 59);
		addSnakeOrLadder.put(51, 67);
		addSnakeOrLadder.put(63, 81);
		addSnakeOrLadder.put(71, 91);
		addSnakeOrLadder.put(87, 94);
		addSnakeOrLadder.put(99, 100);

		for (int i = 1; i <= BOARD_SIZE; i++) {
			for (int dice = 1; dice <= MAX_DICE_VALUE; dice++) {
				int nextPos = i + dice;
				if (addSnakeOrLadder.containsKey(nextPos)) {
					adjacencyList.get(i).add(addSnakeOrLadder.get(nextPos));
				} else if (nextPos <= BOARD_SIZE) {
					adjacencyList.get(i).add(nextPos);
				}
			}
		}
	}

	private int shortestPath() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[BOARD_SIZE + 1];

		queue.offer(1); // Start at position 1
		visited[1] = true;

		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int currentPos = queue.poll();
				if (currentPos == BOARD_SIZE) {
					return steps;
				}

				// Explore possible moves from the current position
				for (int neighbor : adjacencyList.getOrDefault(currentPos, new ArrayList<>())) {
					if (!visited[neighbor]) {
						visited[neighbor] = true;
						queue.offer(neighbor);
					}
				}
			}
			steps++;
		}
		return -1; // No path found
	}

	public static void main(String[] args) {
		SnakesAndLadders game = new SnakesAndLadders();
		int steps = game.shortestPath();
		if (steps != -1) {
			System.out.println("Shortest path to win: " + steps);
		} else {
			System.out.println("No path found to win.");
		}
	}
}
