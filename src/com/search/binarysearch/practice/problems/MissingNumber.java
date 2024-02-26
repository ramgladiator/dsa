package com.search.binarysearch.practice.problems;

import java.util.Arrays;

public class MissingNumber {
	public static void main(String[] args) {
		int[] nums = { 3,0,1};
		//int missingNumber = missingNumber(nums);
		//System.out.println("Missing Number " + missingNumber);
		
		int missingNumbe1r = missingNumber1(nums);
		System.out.println("Missing Number1 " + missingNumbe1r);
	}

	public static int missingNumber(int[] nums) { // binary search
		Arrays.sort(nums);
		int left = 0, right = nums.length, mid ;
		while (left < right) {
			mid = (left + right) / 2;
			if (nums[mid] > mid)
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}
	
	//different solution using sum
	public static int missingNumber1(int[] nums) { //sum
	    int len = nums.length;
	    int sum = (0+len)*(len+1)/2;
	    for(int i=0; i<len; i++)
	        sum-=nums[i];
	    return sum;
	}
	
	
	public static int findSum(int[] arr) {
        // Calculate the number of elements in the array
        int n = arr.length;
        
        // Calculate the sum using the formula for sum of first n natural numbers
        int sum = n * (n + 1) / 2;

        // Adjust the sum by subtracting the sum of indices from the sum of elements
        for (int i = 0; i < n; i++) {
            sum -=arr[ i];
        }
        
        return sum;
    }

}
