package com.kk.stack.practice.problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//https://leetcode.com/problems/simplify-path/
public class SimplifyPath {

	public static void main(String[] args) {

		//String path = "/home//foo/";
		String path = "/../";

		String simplifyPath = simplifyPath(path);
		System.out.println("Simplify path is " + simplifyPath);

	}

	public static String simplifyPath(String path) {
		Deque<String> stack = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (!skip.contains(dir))
				stack.push(dir);
		}
		String res = "";
		for (String dir : stack)
			res = "/" + dir + res;
		return res.isEmpty() ? "/" : res;
	}

}
