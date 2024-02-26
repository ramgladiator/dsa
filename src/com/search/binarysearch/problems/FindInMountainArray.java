package com.search.binarysearch.problems;

//https://leetcode.com/problems/find-in-mountain-array/
public class FindInMountainArray {

	public static void main(String[] args) {

		int[] nums = { 1, 5, 2 };
		int findElement = findElement(nums, 2);
		System.out.println("Found element in mountain array " + findElement);

	}

	// Approach first: find the peak element and then serach in left side and right
	// side
	public static int findElement(int[] nums, int target) {

		int findPeakElement = findPeakElement(nums);

		int findIndex = -1;

		findIndex = OrderAgnosticBS(nums, target, 0, findPeakElement);

		if (findIndex == -1) {
			findIndex = OrderAgnosticBS(nums, target, findPeakElement, nums.length - 1);

		}

		return findIndex;

	}

	public static int findPeakElement(int[] nums) {

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] > nums[mid + 1]) {

				end = mid;
			} else {
				start = mid + 1;
			}

		}
		return end;// we can return either start/end

	}

	public static int OrderAgnosticBS(int[] nums, int target, int start, int end) {

		boolean isAsc = nums[start] < nums[end];
		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				return mid;
			}
 
			if (isAsc) {
				if (target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target > nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

		}
		return -1;
	}

}
