package com.search.binarysearch.problems;

public class FindFirstLastPositionwithCompleteBS {
	
	//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/

	public static void main(String[] args) {

		int[] nums = {5,7,7,8,8,10};
		int[] searchRange = searchRange(nums, 8);
		System.out.println("indexes are "+ searchRange[0]+"-"+searchRange[1]);
	}

	public static int[] searchRange(int[] nums, int target) {

		int[] ans = new int[2];

		int startPos = findPosition(nums, target, true);
		int endPos = findPosition(nums, target, false);

		ans[0] = startPos;
		ans[1] = endPos;

		return ans;
	}

	public static int findPosition(int[] nums, int target, boolean position) {

		int start = 0, end = nums.length - 1;
		
		int ans = -1;
		while (start <= end) {

			int mid = start + (end - start) / 2;
			if (target == nums[mid]) {

				ans = mid;
				if (position) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}

			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return ans;

	}

}
