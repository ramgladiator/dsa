package com.ik.graph.basic;

public class DFSTraversalUsingAdjacencyMatrix {

	// Perform DFS traversal recursively
	public static void dfs(int[][] adjacencyMatrix, int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");

		// Iterate through the vertices in the adjacency matrix
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
				dfs(adjacencyMatrix, i, visited);
			}
		}
	}

	public static void main(String[] args) {
		int[][] adjacencyMatrix = { { 0, 1, 1, 0, 0 },
				                    { 1, 0, 0, 1, 0 },
				                    { 1, 0, 0, 1, 0 },
				                    { 0, 1, 1, 0, 1 },
				                    { 0, 0, 0, 1, 0 } 
				                  };

		int numVertices = adjacencyMatrix.length;
		boolean[] visited = new boolean[numVertices];

		System.out.println("DFS Traversal:");
		for (int i = 0; i < numVertices; i++) {
			if (!visited[i]) {
				dfs(adjacencyMatrix, i, visited);
			}
		}
	}

}
