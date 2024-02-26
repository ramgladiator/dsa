package com.search.binarysearch;

public class BinarySearchIterrative {
	
	public static void main(String[] args) {
		
		int[] arr = {1,9,18,32,52,71,89};
		int search = search(arr, 52);
		
		System.out.println("Search result found is "+ search);
	}
	
	
	private static int search(int[] arr,int x) {
		
		int start = 0, end = arr.length-1;
		
		while(start<=end) {
			
			int mid = start + (end-start)/2;
			
			if(arr[mid]==x) {
				return mid;
			}
			
			if(arr[mid]<x) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}		
			
		}	
		
		
		return -1;	
		
	}

}
