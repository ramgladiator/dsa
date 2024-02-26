package com.kk.recursion.basic.permutations;

import java.util.ArrayList;
import java.util.List;

public class RearrangeString {

	public static void main(String[] args) {
		
		permutations("", "abc");
		
		//Another way suggested by chatgpt
		
		String str = "abc";
        List<String> permutations = generatePermutations(str);
        
        System.out.println("Permutations of " + str + ":");
        for (String perm : permutations) {
            System.out.println(perm);
        }
        
        //Certainly! The line remaining.substring(0, i) + remaining.substring(i+1, n) is used to generate the remaining string for the next recursive call. Let's break it down:

      //  remaining.substring(0, i) extracts the substring from index 0 to index i-1 from the remaining string. This part of the string contains all the characters before the character at index i.
       // remaining.substring(i+1, n) extracts the substring from index i+1 to the end of the remaining string. This part of the string contains all the characters after the character at index i.
       // So essentially, remaining.substring(0, i) + remaining.substring(i+1, n) removes the character at index i from the remaining string and generates a new string without that character. This is necessary for generating permutations because we're trying all possible combinations of characters, and in each iteration, we want to exclude the character we've already used.






	}

	public static void permutations(String p, String up) {

		if (up.isEmpty()) {

			System.out.println(p);
			return;
		}

		char ch = up.charAt(0);
		for (int i = 0; i <= p.length(); i++) {

			String f = p.substring(0, i);
			String s = p.substring(i, p.length());
			permutations(f + ch + s, up.substring(1));
		}

	}
	
	
    public static List<String> generatePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper("", str, permutations);
        return permutations;
    }
    
    private static void generatePermutationsHelper(String prefix, String remaining, List<String> permutations) {
        int n = remaining.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutationsHelper(prefix + remaining.charAt(i), 
                                           remaining.substring(0, i) + remaining.substring(i+1, n),
                                           permutations);
            }
        }
    }

}
