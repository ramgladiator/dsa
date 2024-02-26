package com.search.binarysearch.problems;

//****https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {

	public static void main(String[] args) {

		int[] nums = { 7, 2, 5, 10, 8 };
		int m = 2;

		int splitArray = splitArray(nums, m);
		System.out.println("Largest sum is " + splitArray);
	}

	public static int splitArray(int[] nums, int k) {

		int start = 0;
		int end = 0;

		for (int i = 0; i < nums.length; i++) {

			start = Math.max(start, nums[i]);
			// In the end the loop will contain the max item from array
			end = end + nums[i];
		}

		while (start < end) {
			int sum = 0;
			int pieces = 1;
			int mid = start + (end - start) / 2;
			for (int num : nums) {
				if (sum + num > mid) {

					sum = num;
					pieces++;
				} else {
					sum = sum + num;
					
				}

			}

			if (pieces > k) {
				start = mid + 1;
			} else {
				end = mid;
			}

		}

		return end;

	}

}
