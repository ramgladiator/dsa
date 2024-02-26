package com.kk.recursion.basic.array.questions;

public class LinerSearchUisngRecursion {

	public static void main(String[] args) {

		int[] arr = { 7, 19, 21, 29, 32, 57, 89, 101 };
		int findElement = findElement(arr, 57, 0);
		System.out.println("Index location is " + findElement);

	}

	private static int findElement(int[] arr, int target, int index) {

		if (index == arr.length - 1) {
			return -1;
		}
		if (arr[index] == target) {
			return index;
		}

		return findElement(arr, target, index + 1);

	}

}
