package com.search.binarysearch;

public class BurteForce1 {
	
	public static void main(String[] args) {
		
		
		int[] arr = {1,9,17,28,42,39,61,75};
		
		int search = search(arr, 61);
		System.out.println("index of search element is "+ search);
		
		
		
	}

	
	private static int search(int[] arr, int se) {
		
		
		int index = 0;
		for(int x:arr) {
			
			if(x==se) {
				return index;
			}
			index++;
		}
		
		
		return 0;
	}
}
