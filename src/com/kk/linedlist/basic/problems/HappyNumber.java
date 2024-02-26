package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/happy-number/submissions/
public class HappyNumber {
	
	public static void main(String[] args) {
		
		int num =19;
		if(isHappy(num)) {
			System.out.println("Yes given number is happy number");
		}else {
			System.out.println("Yes given number is not happy number");

		}
		
	}
	
	private static boolean isHappy(int num) {
		
		int slow=num,fast=num;
		do {
			
			slow = findSqaure(slow);
			fast = findSqaure(findSqaure(fast));
			
		}while(slow != fast);
		
		return slow==1;
	}
	
	
	private  static int findSqaure(int num) {
		
		int sum = 0;
		
		while(num>0) {
			int digit = num%10;
			sum+=digit*digit;
			num/=10;
			
		}
		return sum;
	}

}
