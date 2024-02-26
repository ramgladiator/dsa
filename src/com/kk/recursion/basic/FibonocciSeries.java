package com.kk.recursion.basic;

public class FibonocciSeries {

	public static void main(String[] args) {

		int findFibo = findFibo(4);
		System.out.println("Fibo 4 is -> " + findFibo);
	}

	private static int findFibo(int n) {

		if (n < 2) {
			return n;// if n=0 return 0 or if n=1 then return 1
		}

		return findFibo(n - 1) + findFibo(n - 2);

	}
}
