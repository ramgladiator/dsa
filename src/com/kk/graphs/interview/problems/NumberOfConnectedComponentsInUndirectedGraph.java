package com.ik.graph.interview.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsInUndirectedGraph {

	public static void main(String[] args) {
		int vertices = 5;
		int counter = 0;
		List<int[]> edgeList = new ArrayList<>();

		edgeList.add(new int[] { 0, 1 });
		edgeList.add(new int[] { 1, 2 });
		edgeList.add(new int[] { 3, 4 });

		Map<Integer, List<Integer>> adjacencyList = convertEdgeListToAdjacencyList(edgeList);
		System.out.println(adjacencyList);

		boolean[] visited = new boolean[vertices];

		System.out.println("DFS traversal : ");
		for (int i = 0; i < vertices; i++) {

			if (!visited[i]) {
				counter++;
				dfs(i, adjacencyList, visited);
			}
		}
		System.out.println("The number of connected components are  : "+ counter);
	}

	public static void dfs(int sourceNode, Map<Integer, List<Integer>> adjacencyList, boolean[] visited) {

		visited[sourceNode] = true;
		System.out.print(sourceNode + " -> ");

		for (int i = 0; i < adjacencyList.get(sourceNode).size(); i++) {

			int ngb = adjacencyList.get(sourceNode).get(i);
			if (!visited[ngb])
				dfs(ngb, adjacencyList, visited);

		}

	}

	public static Map<Integer, List<Integer>> convertEdgeListToAdjacencyList(List<int[]> edgeList) {

		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

		for (int[] edge : edgeList) {

			int u = edge[0];
			int v = edge[1];

			if (!adjacencyList.containsKey(u)) {

				adjacencyList.put(u, new ArrayList<>());

			}

			adjacencyList.get(u).add(v);

			if (!adjacencyList.containsKey(v)) {

				adjacencyList.put(v, new ArrayList<>());
			}

			adjacencyList.get(v).add(u);

		}

		return adjacencyList;

	}

}
