package com.kk.recursion.basic.array.questions;

import java.util.ArrayList;

public class LinerSearchUisngRecursion2 {

	public static void main(String[] args) {

		int[] arr = { 7, 19, 21, 29, 32, 57, 57, 101 };
		findElement(arr, 57, 0);
		System.out.println("Index location is " + list);

	}
	
	static ArrayList<Integer> list = new ArrayList<>();

	private static void findElement(int[] arr, int target, int index) {

		if (index >= arr.length - 1) {
			 return;
		}
		if (arr[index] == target) {
			 list.add(index);
		}

		 findElement(arr, target, index + 1);

	}

}
