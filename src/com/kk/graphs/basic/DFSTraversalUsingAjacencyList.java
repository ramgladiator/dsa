package com.ik.graph.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSTraversalUsingAjacencyList {

	// Perform DFS traversal recursively
    public static void dfs(Map<Integer, List<Integer>> adjacencyList, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        //getOrDefault(vertex, new ArrayList<>()): This method call retrieves the value corresponding to the given key vertex from the map adjacencyList. If the key is present in the map, it returns the associated list of adjacent vertices. If the key is not present, it returns a new ArrayList<>() (an empty list).
        // Iterate through the adjacent vertices of the current vertex
        for (int neighbor : adjacencyList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, neighbor, visited);
            }
        }
    }

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
                dfs(adjacencyList, i, visited);
            }
        }
    }


}
