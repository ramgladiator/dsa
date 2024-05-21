package com.ik.graph.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EdgeListToAdjacencyMatrix {

	public static int[][] convertEdgeListToAdjacencyMatrix(List<int[]> edgeList, int numVertices) {
		int[][] adjacencyMatrix = new int[numVertices][numVertices];

		// Iterate through each edge and update the adjacency matrix
		for (int[] edge : edgeList) {
			int u = edge[0];
			int v = edge[1];
			adjacencyMatrix[u][v] = 1; // Assuming unweighted graph, set 1 to indicate the presence of an edge
			adjacencyMatrix[v][u] = 1; // Assuming undirected graph, set 1 in both directions
		}

		return adjacencyMatrix;
	}

	public static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				System.out.print(adjacencyMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		List<int[]> edgeList = new ArrayList<>();
		edgeList.add(new int[] { 0, 1 });
		edgeList.add(new int[] { 0, 2 });
		edgeList.add(new int[] { 1, 3 });
		edgeList.add(new int[] { 2, 3 });
		edgeList.add(new int[] { 3, 4 });

		int numVertices = 5; // Assuming vertices are numbered from 0 to 4

		int[][] adjacencyMatrix = convertEdgeListToAdjacencyMatrix(edgeList, numVertices);

		printAdjacencyMatrix(adjacencyMatrix);
	}

}
