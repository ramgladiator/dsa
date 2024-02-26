package com.kk.recursion.basic.permutations;

import java.util.ArrayList;
import java.util.List;

public class RearrangeStringwithList {

	public static void main(String[] args) {

		List<String> permutations = permutations("", "abc");
		for (String s : permutations) {
			System.out.println(s);
		}

	}

	static List<String> permutations(String p, String up) {

		if (up.isEmpty()) {

			List<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}

		List<String> ans = new ArrayList<>();
		char ch = up.charAt(0);
		for (int i = 0; i <= p.length(); i++) {

			String f = p.substring(0, i);
			String s = p.substring(i , p.length());
			ans.addAll(permutations(f + ch + s, up.substring(1)));
		}

		return ans;
	}

}
