package com.kk.recursion.basic.bubleorSelectionsort;

public class PrintStarsTrianglePattern {
	
	
	public static void main(String[] args) {
		printStars(4, 0);
	}
	
	
	private static void printStars(int row, int column) {

		if (row == 0) {

			return;

		}
		if (column < row) {
			printStars(row, column + 1);
			System.out.print("*");

		} else {
			printStars(row-1, 0);
			System.out.println("");

		}

	}

}
