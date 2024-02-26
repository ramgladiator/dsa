package com.search.binarysearch.problems;

//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class FindPositionInInfiniteSortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int ans = findPosition(arr, 10);

		if (ans == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at index " + ans);
	}

	public static int findPosition(int[] arr, int target) {

		int start = 0, end = 0;

		while (arr[end] < target) {

			int temp = end + 1;
			end = end + (end - start + 1) * 2;
			start = temp;
		}

		return binarySearch(arr, target, start, end);
	}

	private static int binarySearch(int[] arr, int target, int start, int end) {
		
		while(start<=end) {
			
			int mid= start +(end-start)/2;
			
			if(target == arr[mid]) {
				return mid;
			}else if(target >arr[mid]) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return -1;

	}

}
