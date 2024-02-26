package com.kk.recursion.basic.bubleorSelectionsort;

public class PrintStarsPattern {

	public static void main(String[] args) {

		printStars(4, 0);

	}

	private static void printStars(int row, int column) {

		if (row == 0) {

			return;

		}
		if (column < row) {
			System.out.print("*");
			printStars(row, column + 1);
		} else {
			System.out.println("");
			printStars(row-1, 0);
		}

	}

}
