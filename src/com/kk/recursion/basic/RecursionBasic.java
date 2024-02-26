package com.kk.recursion.basic;

public class RecursionBasic {

	
	public static void main(String[] args) {
		
		
		printNumbers(1);
	}
	
	private static void printNumbers(int initialNumber) {
		
		if(initialNumber == 5) {
			System.out.println("print number"+5);
			return;			
		}
		
		System.out.println("print number"+ initialNumber);
		printNumbers(++initialNumber);
		
		
	}
}
