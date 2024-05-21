package com.ik.graph.interview.problems.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestStringTransformationUsingDictionary {

	public static int shortestTransformation(String start, String end, Set<String> dictionary) {
		Map<String, List<String>> graph = constructGraph(dictionary);
		return shortestPathLength(start, end, graph);
	}

	private static Map<String, List<String>> constructGraph(Set<String> dictionary) {
		Map<String, List<String>> graph = new HashMap<>();

		// Add nodes to the graph
		for (String word : dictionary) {
			graph.put(word, new ArrayList<>());
		}

		// Add edges to the graph
		for (String word1 : dictionary) {
			for (String word2 : dictionary) {
				if (canTransform(word1, word2)) {
					graph.get(word1).add(word2);
				}
			}
		}

		return graph;
	}

	private static boolean canTransform(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}dtjrdsz
		int diffCount = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				diffCount++;
			}
		}
		return diffCount == 1; // Only one character difference allowed for transformation
	}

	private static int shortestPathLength(String start, String end, Map<String, List<String>> graph) {
		Queue<String> queue = new LinkedList<>();
		Map<String, Integer> distances = new HashMap<>();
		queue.offer(start);
		distances.put(start, 0);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			if (current.equals(end)) {
				return distances.get(current);
			}
			for (String neighbor : graph.get(current)) {
				if (!distances.containsKey(neighbor)) {
					distances.put(neighbor, distances.get(current) + 1);
					queue.offer(neighbor);
				}
			}
		}

		return -1; // No transformation sequence found
	}

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dictionary = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		int shortest = shortestTransformation(start, end, dictionary);
		System.out.println("Shortest transformation sequence length: " + shortest);
	}

}
