package com.search.binarysearch.problems;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		// Tends problem is similar to ceiling problem

		char[] arr = { 'c', 'f', 'j','k' };
		char result = nextGreatestLetter(arr, 'a');
		System.out.println("smallest letter is " + result);

	}

	public static char nextGreatestLetter(char[] a, char x) {
		
        int n = a.length;

        //end starts at 'n' rather than the usual 'n - 1'. 
        //It is because the terminal condition is 'start < end' and if end starts from 'n - 1', 
        //we can never consider value at index 'n - 1'
        int start = 0, end = n;

        //Terminal condition is 'start < end', to avoid infinite loop when target is smaller than the first element
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] > x)     end = mid;
            else    start = mid + 1;                 //a[mid] <= x
        }
 
        //Because start can end up pointing to index 'n', in which case we return the first element
        return a[start % n];
    }
}
