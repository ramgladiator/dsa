package com.kk.recursion.basic.level1.questions;

public class DigitsProduct {

	public static void main(String[] args) {

		int digitsProduct = digitsProduct(1234);
		System.out.println("Digits product " + digitsProduct);

	}

	private static int digitsProduct(int n) {

		if (n % 10 == n) {
			return n;
		}

		return n % 10 + digitsProduct(n / 10);

	}

}
