package com.ik.graph.interview.problems.shortestpath;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadderGameBasic {

	private static final int WINNING_POSITION = 100;
	private static final int MAX_DICE_VALUE = 6;

	private Map<Integer, Integer> snakesAndLadders;

	private int currentPlayerPosition;

	private Random random;

	public SnakeAndLadderGameBasic() {
		snakesAndLadders = new HashMap<>();
		// Adding snakes and ladders on the board
		snakesAndLadders.put(14, 7);
		snakesAndLadders.put(19, 2);
		snakesAndLadders.put(22, 18);
		snakesAndLadders.put(43, 23);
		snakesAndLadders.put(55, 47);
		snakesAndLadders.put(65, 36);
		snakesAndLadders.put(72, 54);
		snakesAndLadders.put(88, 63);
		snakesAndLadders.put(95, 74);
		snakesAndLadders.put(98, 79);

		currentPlayerPosition = 0;
		random = new Random();
	}

	private int rollDice() {
		return random.nextInt(MAX_DICE_VALUE) + 1;
	}

	private void movePlayer(int steps) {
		currentPlayerPosition += steps;
		if (currentPlayerPosition > WINNING_POSITION) {
			currentPlayerPosition = WINNING_POSITION - (currentPlayerPosition - WINNING_POSITION);
		}
		if (snakesAndLadders.containsKey(currentPlayerPosition)) {
			int newPosition = snakesAndLadders.get(currentPlayerPosition);
			System.out.println("Oops, you encountered a snake/ladder! Moving to position: " + newPosition);
			currentPlayerPosition = newPosition;
		}
		System.out.println("You are now at position: " + currentPlayerPosition);
	}

	private boolean hasWon() {
		return currentPlayerPosition == WINNING_POSITION;
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Snakes and Ladders!");
		System.out.println("Press enter to roll the dice.");
		while (!hasWon()) {
			System.out.print("Press enter to roll: ");
			scanner.nextLine();
			int diceValue = rollDice();
			System.out.println("You rolled a " + diceValue);
			movePlayer(diceValue);
		}
		System.out.println("Congratulations! You won!");
		scanner.close();
	}

	public static void main(String[] args) {
		SnakeAndLadderGameBasic game = new SnakeAndLadderGameBasic();
		game.play();
	}

}
