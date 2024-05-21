package com.ik.graph.interview.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDetection {
	
	
	public static void main(String[] args) {
		int vertices = 5;
		int counter = 0;
		List<int[]> edgeList = new ArrayList<>();

		edgeList.add(new int[] { 0, 1 });
		edgeList.add(new int[] { 0, 2 });
		edgeList.add(new int[] { 1, 2 });	
		

		Map<Integer, List<Integer>> adjacencyList = convertEdgeListToAdjacencyList(edgeList);
		System.out.println(adjacencyList);

		boolean[] visited = new boolean[vertices];
		int[] parent = new int[vertices];


		System.out.println("DFS traversal : ");
		for (int i = 0; i < vertices; i++) {

			if (!visited[i]) {
				counter++;
				if(dfs(i, adjacencyList, visited,parent)) {
					System.out.println("Cycle present");
					break;
				}
			}
		}
		System.out.println("The number of connected components are  : "+ counter);
	}

	public static boolean dfs(int sourceNode, Map<Integer, List<Integer>> adjacencyList, boolean[] visited,int[] parent) {

		visited[sourceNode] = true;
		System.out.print(sourceNode + " -> ");

		for (int i = 0; i < adjacencyList.get(sourceNode).size(); i++) {

			int ngb = adjacencyList.get(sourceNode).get(i);
			if (!visited[ngb]) {
				parent[ngb] = sourceNode;
				dfs(ngb, adjacencyList, visited,parent);
			}
			
			else {
				if(ngb != parent[sourceNode]) {
					return true;
				}
			}

		}
		
		return false;

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
