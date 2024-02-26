package com.kk.recursion.basic.level1.questions;

public class PrintNto1Numbers {
	
	public static void main(String[] args) {
		print(5);
	}
	
	
	
	public static void print(int n) {
		
		if(n==0) {
			return;
		}
		System.out.println("printing the numbers "+ n);
		print(n-1);
	}

}
