package com.kk.recursion.basic.array.questions;

import java.util.ArrayList;

public class LinerSearchUisngRecursion3 {

	public static void main(String[] args) {

		int[] arr = { 7, 19, 21, 29, 32, 57, 57, 101 };
		ArrayList<Integer> findElement = findElement(arr, 57, 0);
		System.out.println("Index location is " + findElement);

	}
	

	private static ArrayList<Integer> findElement(int[] arr, int target, int index) {
		
		ArrayList<Integer> list = new ArrayList<>();


		if (index == arr.length ) {
			 return list;
		}
		if (arr[index] == target) {
			 list.add(index);
		}

		 ArrayList<Integer> newlist =  findElement(arr, target, index + 1);
		 list.addAll(newlist);
		 return list;
		 

	}

}
