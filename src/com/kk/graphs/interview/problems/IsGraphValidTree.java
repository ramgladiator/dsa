package com.ik.graph.interview.problems;

import java.util.ArrayList;

public class IsGraphValidTree {

	// Graph s valid when number of connected components should be one and there
	// should not be a cycle exists.

	public static void main(String[] args) {

		int n = 5;
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 } };

		// Try with adjacency list
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			int u = edge[0] - 1; // Adjust index for zero-based indexing
			int v = edge[1] - 1; // Adjust index for zero-based indexing

			adjacencyList.get(u).add(v);
			adjacencyList.get(v).add(u);
		}

		System.out.println(adjacencyList);

		boolean[] visited = new boolean[n];
		int[] parent = new int[n];

		int counter = 0;

		for (int i = 0; i < n; i++) {

			if (!visited[i]) {
				dfsTraversal(adjacencyList, visited, n, i);
				counter++;
			}

		}

		System.out.println("Number of connected components are : " + counter);

		boolean isCycle = false;
		boolean[] visited1 = new boolean[n];

		for (int i = 0; i < n; i++) {

			if (!visited1[i]) {
				isCycle = isCycle(adjacencyList, visited1, parent, i);
				if (isCycle) {
					break;
				}
			}
		}

		if (counter == 1 && !isCycle) {

			System.out.println("The given graph is a valid tree");
		} else {
			System.out.println("The given graph is not a valid tree");

		}

	}

	public static void dfsTraversal(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int n,
			int sourceNode) {

		visited[sourceNode] = true;

		for (int ngb : adjacencyList.get(sourceNode)) {

			if (!visited[ngb]) {

				dfsTraversal(adjacencyList, visited, n, ngb);
			}
		}

	}

	public static boolean isCycle(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int[] parent,
			int sourceNode) {

		visited[sourceNode] = true;

		for (int ngb : adjacencyList.get(sourceNode)) {

			if (!visited[ngb]) {
				parent[ngb] = sourceNode;
				if (isCycle(adjacencyList, visited, parent, ngb)) {
					return true;// cycle detected
				}
			} else {
				if (parent[sourceNode] != ngb) {
					return true;// cycle detected
				}
			}

		}

		return false;// No cycle detected

	}

}
