package com.kk.recursion.basic.level1.questions;

public class SumOfNnumbers {
	
	public static void main(String[] args) {
		int sum = sum(5);
		System.out.println("Sum of n numbers "+ sum);
	}
	
	
	private static int sum(int n) {
		
		if(n==1) {
			return n;
		}
		
		return n+sum(n-1);
	}

}
