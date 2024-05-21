package com.ik.graph.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSTraversalUsingAdjacencylist {

	public static void main(String[] args) {
		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
		adjacencyList.put(0, Arrays.asList(1, 2));
		adjacencyList.put(1, Arrays.asList(3));
		adjacencyList.put(2, Arrays.asList(3));
		adjacencyList.put(3, Arrays.asList(4));
		adjacencyList.put(4, new ArrayList<>());

		int numVertices = 5; // Assuming vertices are numbered from 0 to 4
		boolean[] visited = new boolean[numVertices];

		System.out.println("DFS Traversal:");
		for (int i = 0; i < numVertices; i++) {
			if (!visited[i]) {
				bfs(adjacencyList, i, visited);
			}
		}
	}

	private static void bfs(Map<Integer, List<Integer>> adjacencyList, int i, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[i] = true;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);

		while (!queue.isEmpty()) {

			int ngb = queue.poll();

			for (int j = 0; j < adjacencyList.get(ngb).size(); i++) {

				if (!visited[ngb]) {

					queue.add(ngb);
					visited[ngb] = true;

				}

			}

		}

	}

}

