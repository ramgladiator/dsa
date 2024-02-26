package com.search.binarysearch.practice.problems;

//https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/627921/Java-or-C%2B%2B-or-Python3-or-Easy-explanation-or-O(logn)-or-O(1)
public class SingleElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		int[] arr1 = {3,3,7,7,10,11,11};
		System.out.println(search(arr1));

	}

	static int search(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		return findSingleElement(arr, start, end);
	}

	static int findSingleElement(int[] nums, int start, int end) {
        while(start < end){
            int mid = (start + end)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
	}

}
