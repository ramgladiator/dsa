package com.search.binarysearch;

public class BinarySearchRecursive {

	public static void main(String[] args) {

		int[] arr = { 1, 9, 18, 32, 52, 71, 89 };
		int start = 0;
		int end = arr.length - 1;
		int search = binarySearch(arr, 52, start, end);

		System.out.println("Search result found is " + search);
	}

	private static int binarySearch(int[] arr, int x, int start, int end) {

		
		if(start<=end) {
			
		int mid = start + (end - start) / 2;

		//base condition
		if (arr[mid] == x) {
			return mid;
		} 
		
		
		if (arr[mid] < x) {
			return binarySearch(arr, x, mid+1, end);
		} 

		
		
		return binarySearch(arr, x, start, mid - 1);
		
	
		}
		return -1;

	}
	

}
