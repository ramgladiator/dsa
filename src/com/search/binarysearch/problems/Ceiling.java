package com.search.binarysearch.problems;

public class Ceiling {

	// what is ceiling and floor?
	// Given a sorted array and a value x, the ceiling of x is the smallest element
	// in an array greater than or equal to x, and the floor is the greatest element
	// smaller than or equal to x

	public static void main(String[] args) {

		int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
		int result = findCeiling(arr, 5);
		System.out.println("Ceiling of a number " + arr[result]);

	}

	private static int findCeiling(int[] arr, int target) {

		int start = 0, end = arr.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return start;
	}

}
