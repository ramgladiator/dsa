package com.search.binarysearch.problems;

//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class FindRotatedCount {
	
	//Rotated count means: no of elements before pivot + 1
	public static void main(String[] args) {
		
		int[] nums = {15, 18, 2, 3, 6, 12};
		int findPivotWithDuplicates = findPivotWithDuplicates(nums)+1;
		System.out.println("No of times array rotated is "+ findPivotWithDuplicates);
	}
	
	// use this when arr contains duplicates
		static int findPivotWithDuplicates(int[] arr) {
			int start = 0;
			int end = arr.length - 1;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				// 4 cases over here
				if (mid < end && arr[mid] > arr[mid + 1]) {
					return mid;
				}
				if (mid > start && arr[mid] < arr[mid - 1]) {
					return mid - 1;
				}

				// if elements at middle, start, end are equal then just skip the duplicates
				if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
					// skip the duplicates
					// NOTE: what if these elements at start and end were the pivot??
					// check if start is pivot
					if (arr[start] > arr[start + 1]) {
						return start;
					}
					start++;

					// check whether end is pivot
					if (arr[end] < arr[end - 1]) {
						return end - 1;
					}
					end--;
				}
				// left side is sorted, so pivot should be in right
				else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			return -1;
		}

	
	

}
