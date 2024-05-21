package com.ik.graph.interview.problems;

import java.util.ArrayList;

public class IsGraphValidTreeOptimized {
	
	  public static void main(String[] args) {

	        int n = 5;
	        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};

	        // Try with adjacency list
	        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

	        for (int i = 0; i < n; i++) {
	            adjacencyList.add(new ArrayList<>());
	        }

	        for (int[] edge : edges) {
	            int u = edge[0]; // No need to adjust index, assuming vertices are 0-based
	            int v = edge[1]; // No need to adjust index, assuming vertices are 0-based

	            adjacencyList.get(u).add(v);
	            adjacencyList.get(v).add(u);
	        }

	        boolean[] visited = new boolean[n];

	        int counter = 0;
	        boolean isCycle = false;

	        for (int i = 0; i < n; i++) {
	            if (!visited[i]) {
	                if (dfsTraversal(adjacencyList, visited, -1, i)) {
	                    isCycle = true;
	                    break;
	                }
	                counter++;
	            }
	        }

	        if (counter == 1 && !isCycle) {
	            System.out.println("The given graph is a valid tree");
	        } else {
	            System.out.println("The given graph is not a valid tree");
	        }
	    }

	    public static boolean dfsTraversal(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int parent, int sourceNode) {
	        visited[sourceNode] = true;

	        for (int ngb : adjacencyList.get(sourceNode)) {
	            if (!visited[ngb]) {
	                if (dfsTraversal(adjacencyList, visited, sourceNode, ngb)) {
	                    return true; // Cycle detected
	                }
	            } else if (ngb != parent) {
	                return true; // Cycle detected
	            }
	        }
	        return false;
	    }

}
