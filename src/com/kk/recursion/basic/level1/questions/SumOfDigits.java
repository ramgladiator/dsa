package com.kk.recursion.basic.level1.questions;

public class SumOfDigits {
	
	public static void main(String[] args) {
		int digitsSum = digitsSum(1352);
		System.out.println("Digits sum "+ digitsSum);
	}
	
	
	private static int digitsSum(int n) {
		if(n==0) {
			return n;
		}
		
		return n%10 + digitsSum(n/10);
		
	}

}
