package com.search.binarysearch.problems;

public class FindFirstLastPosition {

	public static void main(String[] args) {

		//int[] nums = { 5, 7, 7, 7, 7, 8, 8, 10 };
		int[] nums = { 5, 7,7, 8, 8, 10 };

		int[] searchRange = searchRange(nums, 6);

		System.out.println("first and last position of elements are " + searchRange[0] + " - " + searchRange[1]);
	}

	public static int[] searchRange(int[] nums, int target) {

		int start = 0, end = nums.length - 1;
		int[] result = {-1,-1};

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				int temp = mid;

				while (temp >= start && nums[temp] == target) {
					result[0] = temp;
					temp = temp - 1;
				}

				temp = mid;
				while (temp <= nums.length - 1 && nums[temp] == target) {
					result[1] = temp;
					temp = temp + 1;
				}

				return result;

			}

			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return result;

	}

}
