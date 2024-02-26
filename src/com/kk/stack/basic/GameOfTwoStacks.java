package com.kk.stack.basic;

import java.util.Arrays;

public class GameOfTwoStacks {
	
	
	public static void main(String[] args) {
		
		int[] a = {4,2,4,6,1};
		int[] b = {2,1,8,5};
		int x = 10;
		int result = twoStacks(x,a, b);
		
		System.out.println("result finally is here "+ result);
		
	}
	
	static int twoStacks(int x,int[] a,int[]b) {
		
		return twoStacks(x,a,b,0,0)-1;//we will copnsider the elements before the condition breaks ex: at 5 element the sum became 10 then we have
		//consider before that so 4
		
	}
	
	public static int twoStacks(int x,int[] a,int[] b,int sum,int count) {
		
	   
		if(sum>x) {
			return count;
		}
		
		if(a.length == 0 || b.length == 0) {
			return count;
		}
		
		int ans1 = twoStacks(x,Arrays.copyOfRange(a, 1, a.length), b, sum+a[0], count+1);
		int ans2 = twoStacks(x,a, Arrays.copyOfRange(b, 1, b.length), sum+a[0], count+1);
		
		return Math.max(ans1, ans2);
	}

}
