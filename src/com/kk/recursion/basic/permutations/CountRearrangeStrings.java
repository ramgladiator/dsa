package com.kk.recursion.basic.permutations;

public class CountRearrangeStrings {
	
	
	
	public static void main(String[] args) {
		
		int permutations = permutations("", "abc");
		System.out.println("No of permutatiosn "+ permutations);
	}
	
	
	
	public static int permutations(String p, String up) {

		if (up.isEmpty()) {

			//System.out.println(p);
			return 1;
		}

		int count = 0;
		char ch = up.charAt(0);
		for (int i = 0; i <= p.length(); i++) {

			String f = p.substring(0, i);
			String s = p.substring(i, p.length());
			count+=permutations(f + ch + s, up.substring(1));
		}

		return count;
	}

}
