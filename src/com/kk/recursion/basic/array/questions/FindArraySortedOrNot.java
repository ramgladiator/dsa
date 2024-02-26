package com.kk.recursion.basic.array.questions;

public class FindArraySortedOrNot {

	public static void main(String[] args) {

		int[] arr = {7,9,1,88,109};
		boolean arraySorted = isArraySorted(arr);
		if(arraySorted) {
			System.out.println("Array is sorted");
		}else {
			System.out.println("Array is not sorted");

		}
	}

	private static boolean isArraySorted(int[] arr) {

		return helper(arr, 0);

	}

	private static boolean helper(int[] arr, int index) {
		
		if(index == arr.length-1) {
			return true;
		}
		
		return arr[index]<arr[index+1] && helper(arr, index+1);

	}

}
